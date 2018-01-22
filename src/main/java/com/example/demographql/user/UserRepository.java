package com.example.demographql.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameIgnoreCase(String username);

    User findByUsernameIgnoreCaseAndPassword(String username, String password);
}
