package com.example.demographql.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
@Configuration
@EnableWebSecurity
public class AuthenticationProviderConfiguration {
    @Bean
    CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(myUserDetailsService());
    }

    @Bean
    MyUserDetailsService myUserDetailsService() {
        return new MyUserDetailsService();
    }
}
