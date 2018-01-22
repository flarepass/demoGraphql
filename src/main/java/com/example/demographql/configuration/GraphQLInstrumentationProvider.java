package com.example.demographql.configuration;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import graphql.servlet.InstrumentationProvider;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
public class GraphQLInstrumentationProvider implements InstrumentationProvider {

    @Override
    public Instrumentation getInstrumentation() {
        return new TracingInstrumentation();
    }
}
