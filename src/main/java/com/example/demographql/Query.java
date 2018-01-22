package com.example.demographql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demographql.link.Link;
import com.example.demographql.link.LinkFilter;
import com.example.demographql.link.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
@Controller
public class Query implements GraphQLQueryResolver {

    private final LinkRepository linkRepository;

    @Autowired
    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @PreAuthorize("!isAnonymous() and hasAuthority('read-Abc')")
    public List<Link> allLinks(LinkFilter filter, Number skip, Number first) {
        return linkRepository.findByDescriptionContainingIgnoreCase(filter.getDescriptionContains());
    }

}
