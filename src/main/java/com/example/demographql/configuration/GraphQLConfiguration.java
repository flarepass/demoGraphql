package com.example.demographql.configuration;

import com.example.demographql.exception.GraphQLErrorAdapter;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQL;
import graphql.GraphQLError;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import graphql.schema.GraphQLDirective;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.GraphQLType;
import graphql.servlet.GraphQLErrorHandler;
import graphql.servlet.InstrumentationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static graphql.Scalars.GraphQLString;

/**
 * Created by wilyanto.salim
 * on 1/17/18.
 */
@Configuration
public class GraphQLConfiguration {

    @Bean
    InstrumentationProvider instrumentationProvider() {
        return new GraphQLInstrumentationProvider();
    }

    @Bean
    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
        List<GraphQLDirective> directives = graphQLSchema.getDirectives();
        Set<GraphQLDirective> directiveSet = directives != null ? new HashSet<>(directives) : new
                HashSet<>();
        //try to create new graphql obj
        GraphQLObjectType fooType =
                GraphQLObjectType.newObject()
                        .name("Foo")
                        .field(GraphQLFieldDefinition.newFieldDefinition()
                                .name("bar")
                                .type(GraphQLString))
                        .build();
        //test add to existing types
        Set<GraphQLType> additionalTypes = graphQLSchema.getAdditionalTypes();
        additionalTypes.add(fooType);

        GraphQLSchema newSchema = new GraphQLSchema.Builder()
                .additionalTypes(additionalTypes)
                .additionalDirectives(directiveSet)
                .fieldVisibility(graphQLSchema.getFieldVisibility())
                .mutation(graphQLSchema.getMutationType())
                .query(graphQLSchema.getQueryType())
                .subscription(graphQLSchema.getSubscriptionType())
                .build();


        return GraphQL.newGraphQL(newSchema)
                .instrumentation(new TracingInstrumentation())
                .build();
    }

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new graphql.servlet.GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors =
                        errors.stream().filter(this::isClientError).collect(Collectors.toList());
                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());
                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }

}
