package com.example.demographql.test;

import graphql.GraphQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wilyanto.salim
 * on 1/22/18.
 */
@Component
@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler,
                                         Exception ex) {
        log.info("ModelAndView resolveException");
        if (ex instanceof AccessDeniedException) {
            AccessDeniedException ex1 = (AccessDeniedException) ex;
            log.info("ex GraphQLAccessDeniedException ");
        } else if (ex instanceof GraphQLException) {
            GraphQLException ex1 = (GraphQLException) ex;
            log.info("ex GraphQLException ");
        }
        return null;
    }
}
