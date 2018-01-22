package com.example.demographql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demographql.exception.GraphQLAccessDeniedException;
import com.example.demographql.link.Link;
import com.example.demographql.link.LinkFilter;
import com.example.demographql.link.LinkQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Component
@Controller
@Slf4j
public class Query implements GraphQLQueryResolver {

    private final LinkQueryService linkQueryService;

    @Autowired
    public Query(LinkQueryService linkQueryService) {
        this.linkQueryService = linkQueryService;
    }

    public List<Link> allLinks(LinkFilter filter, Number skip, Number first) {
        try {
            return linkQueryService.allLinks(filter, skip, first);
        } catch (Exception ex) {
            if (ex instanceof AccessDeniedException) {
                throw new GraphQLAccessDeniedException("Access Denied", Collections.emptyMap());
            }
        }
        return Collections.emptyList();
    }

}
