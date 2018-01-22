package com.example.demographql.authentication;

import com.example.demographql.test.MyHandlerExceptionResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
@Component
@Slf4j
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
    @Autowired
    LoginProvider loginProvider;

    public CustomAuthenticationProvider() {
        super();
    }

    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        super();
        setUserDetailsService(userDetailsService);
    }

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
//        printRequest();
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
//        try {
//            LoginDetail details = (LoginDetail) authentication.getDetails();
//        }
        Authentication auth = loginProvider.getAuthentication(username, password);
        if (auth == null) {
            throw new AuthenticationServiceException("Bad Credential");
        }
        return auth;
    }

    private void printRequest() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String requestURI = httpServletRequest.getRequestURI();
        log.info("auth from : " + requestURI);
        log.info(httpServletRequest.getSession().getId());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    @Bean
    HandlerExceptionResolver myHandlerExceptionResolver() {
        return new MyHandlerExceptionResolver();
    }
}