package com.example.demographql;

import java.time.ZonedDateTime;

/**
 * Represents a vote cast by a user for a link
 */
public class Vote {
    private final String id;
    private final ZonedDateTime createdAt;
    private final String userId;
    private final String linkId;

    public Vote() {

        this.id = null;
        this.createdAt = null;
        this.userId = null;
        this.linkId = null;
    }

    public Vote(ZonedDateTime createdAt, String userId, String linkId) {
        this(null, createdAt, userId, linkId);
    }

    public Vote(String id, ZonedDateTime createdAt, String userId, String linkId) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.linkId = linkId;
    }

    public String getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getLinkId() {
        return linkId;
    }
}
