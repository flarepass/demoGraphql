package com.example.demographql.link;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demographql.user.User;
import com.example.demographql.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Contains Link sub-queries
 */
@Component
public class LinkResolver implements GraphQLResolver<Link> {
    @Autowired
    private final UserRepository userRepository;
//    @Autowired
//    private final UserDataLoader userDataLoader;

    LinkResolver(UserRepository userRepository
//            , UserDataLoader userDataLoader
    ) {
        this.userRepository = userRepository;
//        this.userDataLoader = userDataLoader;
    }


    public User postedBy(Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return link.getUser();
//        return userRepository.findOne(link.getUserId());
    }
}
