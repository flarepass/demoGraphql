package com.example.demographql.link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wilyanto.salim
 * on 1/22/18.
 */
@Component
public class LinkQueryService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkQueryService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @PreAuthorize("!isAnonymous() and hasAuthority('read-Abc')")
    public List<Link> allLinks(LinkFilter filter, Number skip, Number first) {
        return linkRepository.findByDescriptionContainingIgnoreCase(filter.getDescriptionContains());
    }

}
