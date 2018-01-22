package com.example.demographql.authentication;

import com.example.demographql.exception.GraphQLAccessDeniedException;
import com.example.demographql.test.TestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wilyanto.salim
 * on 1/22/18.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(AccessDeniedException.class)
    public void handleEntityNotFound(AccessDeniedException exception) {
        System.out.println("aaaaa");
        throw new GraphQLAccessDeniedException("Access Denied", Collections.emptyMap());
    }

    @ExceptionHandler(TestException.class)
    public ResponseEntity<Map> handleAuxException(
            TestException exception) {

        final Map<String, Object> errorResponse = new LinkedHashMap<>();
        errorResponse.put("timestamp", new Date());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorResponse.put("message", "Bad Credentials");
        errorResponse.put("path", exception.getPath());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
