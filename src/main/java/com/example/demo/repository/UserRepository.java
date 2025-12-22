package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            value = "SELECT * FROM users u " +
                    "WHERE u.username = :keyword " +
                    "OR u.first_name LIKE CONCAT(:keyword, '%') " +
                    "OR u.last_name LIKE CONCAT(:keyword, '%')",
            nativeQuery = true
    )
    List<User> findByKeyword(String keyword);
}
