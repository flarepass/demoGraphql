package com.example.demographql.audit;

import com.example.demographql.user.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
public class UserAuditorAware implements AuditorAware<Long> {

    @Override
    public Long getCurrentAuditor() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return ((User) securityContext.getAuthentication().getPrincipal()).getId();
    }
}
