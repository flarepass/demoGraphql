package com.example.demographql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQLBadRequestException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public GraphQLBadRequestException(String message, Map<String, String> extraMessage) {
        super(message);
        extraMessage.forEach((s, s2) -> extensions.put(s, s2));
        extensions.put("errorCode", HttpStatus.BAD_REQUEST.value());
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
