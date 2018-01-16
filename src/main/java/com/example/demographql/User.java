package com.example.demographql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private final String id;
    private final String name;
    private final String email;
    private final String password;

    public User() {
        this.id = null;
        this.name = null;
        this.email = null;
        this.password = null;
    }

    public User(String name, String email, String password) {
        this(null, name, email, password);
    }

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
