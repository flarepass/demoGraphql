package com.example.demographql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private final LinkRepository linkRepository;

    @Autowired
    public Query(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> allLinks(LinkFilter filter, Number skip, Number first) {
//        return linkRepository.findAll();
        return linkRepository.findByDescriptionContainingIgnoreCase(filter.getDescriptionContains());
    }
}
