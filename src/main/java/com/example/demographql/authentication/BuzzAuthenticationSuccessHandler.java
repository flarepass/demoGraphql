package com.example.demographql.authentication;

import com.example.demographql.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.jdbc.JdbcOperationsSessionRepository;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static com.example.demographql.common.Constants.JSON_TYPE;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
@Service
@Slf4j
@EnableJdbcHttpSession
public class BuzzAuthenticationSuccessHandler
        extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private JdbcOperationsSessionRepository jdbcOperationsSessionRepository;

    @Value("${buzz.session.maxinactiveinterval:360}")
    private int maxInactiveInterval;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException,
            ServletException {
//        removeCurrentUserActiveLoginSession(authentication);
//        logSuccessForCurrentUser();
//        getLoginDetail();

        request.getSession().setMaxInactiveInterval(maxInactiveInterval);

//        getRedirectStrategy().sendRedirect(request, response, "/users/current");
        response.setContentType(JSON_TYPE);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(new Object());//// TODO: 1/18/18 login obj
        response.getWriter().print(jsonInString);
        response.getWriter().flush();
        response.getWriter().close();

    }

    private void logSuccessForCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        log.info("auth success for : " + user.toString());
    }

    private void getLoginDetail() {
        String source = "";
        try {
            AuthenticationDetail details = (AuthenticationDetail) SecurityContextHolder.getContext()
                    .getAuthentication().getDetails();
            source = details.getSource();
            log.info("AuthenticationDetail : " + details.toString());
        } catch (Exception e) {
            log.info("failed to cast AuthenticationDetail");
        }
    }

    private void removeCurrentUserActiveLoginSession(Authentication authentication) {
        Map sessions = jdbcOperationsSessionRepository.findByIndexNameAndIndexValue(
                FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, authentication
                        .getPrincipal().toString());
        Set<String> keys = sessions.keySet();
        for (String key : keys) {
            jdbcOperationsSessionRepository.delete(key);
        }
    }
}