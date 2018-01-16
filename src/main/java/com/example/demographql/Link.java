package com.example.demographql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Link {

    @Id
    private final String id;

    private final String url;
    private final String description;
    private final String userId;

    public Link() {

        this.id = null;
        this.userId = null;
        this.url = null;
        this.description = null;
    }

    public Link(String url, String description) {
        this.id = null;
        this.userId = null;
        this.url = url;
        this.description = description;
    }

    public Link(String url, String description, String userId) {
        this(null, url, description, userId);
    }

    public Link(String id, String url, String description, String userId) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }
}
