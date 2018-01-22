package com.example.demographql.authentication;

import com.example.demographql.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
public class LoginDetail implements UserDetails {
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    private String username;
    private String password;

    public LoginDetail(HttpServletRequest context) {
        username = setValue(context, KEY_USERNAME);
        password = setValue(context, KEY_PASSWORD);
    }

    public LoginDetail(User user) {
        username = user.getUsername();
        password = "";
    }

    private String setValue(HttpServletRequest context, String name) {
        try {
            String[] parameterValues = context.getParameterValues(name);
            if (name.equalsIgnoreCase(KEY_USERNAME)) {
                return parameterValues[0];
            }
            if (name.equalsIgnoreCase(KEY_PASSWORD)) {
                return parameterValues[0];
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public boolean isValidLoginDetail() {
        return username != null && password != null;
    }
}
