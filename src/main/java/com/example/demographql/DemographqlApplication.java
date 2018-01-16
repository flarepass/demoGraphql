package com.example.demographql;

import graphql.GraphQL;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemographqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemographqlApplication.class, args);
    }

    @Bean
    DataLoaderRegistry dataLoaderRegistry(List<DataLoader<?, ?>> loaderList) {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        for (DataLoader<?, ?> loader : loaderList) {
            registry.register(loader.getClass().getSimpleName(), loader);
        }
        return registry;
    }

    @Bean
    Instrumentation instrumentation(DataLoaderRegistry dataLoaderRegistry) {
        return new DataLoaderDispatcherInstrumentation(dataLoaderRegistry);
    }


    @Bean
    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return GraphQL.newGraphQL(graphQLSchema)
                .instrumentation(new TracingInstrumentation())
                .build();
    }


}
