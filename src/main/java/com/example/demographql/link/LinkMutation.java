package com.example.demographql.link;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demographql.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by wilyanto.salim
 * on 1/18/18.
 */
@Component
public class LinkMutation implements GraphQLMutationResolver {

    @Autowired
    LinkRepository linkRepository;

    //    @PreAuthorize("!isAnonymous() AND hasAuthority('read-Abc')")
    @PreAuthorize("!isAnonymous()")
    public Link createLink(String url, String description) {
        Link link = new Link();
        link.setUrl(url);
        link.setDescription(description);
        SecurityContext securityContext = SecurityContextHolder.getContext();

        User principal = (User) securityContext.getAuthentication().getPrincipal();
        link.setUser(principal);

        link = linkRepository.save(link);
        return link;
    }
}
