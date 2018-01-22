package com.example.demographql.link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, String> {
    List<Link> findByDescriptionContainingIgnoreCase(String description);
}
