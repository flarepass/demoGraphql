package com.example.demographql.authentication;

import com.example.demographql.user.User;
import com.example.demographql.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
@Component
public class LoginProvider {
    @Autowired
    UserRepository userRepository;

    public Authentication getAuthentication(String username, String password) {
        User user = userRepository.findByUsernameIgnoreCaseAndPassword(username, password);
        if (user != null) {

            List<GrantedAuthority> authorities = new ArrayList<>();

            if (username.equalsIgnoreCase("1")) {
                System.out.println("equalsIgnoreCase 1");
                authorities.add(new SimpleGrantedAuthority("read-Abc"));
            } else {
                System.out.println("not equalsIgnoreCase 1");

            }
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(user, null, authorities);
            return auth;
        }
        return null;

    }
}
