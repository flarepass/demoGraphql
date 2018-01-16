package com.example.demographql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Contains Link sub-queries
 */
@Component
public class LinkResolver implements GraphQLResolver<Link> {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserDataLoader userDataLoader;

    LinkResolver(UserRepository userRepository, UserDataLoader userDataLoader) {
        this.userRepository = userRepository;
        this.userDataLoader = userDataLoader;
    }


    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userRepository.findOne(link.getUserId());
    }
}
