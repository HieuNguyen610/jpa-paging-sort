package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users u where u.username = :keyword or u.first_name like :keyword + '%' or u.last_name like :keyword + '%'", nativeQuery = true)
    List<User> findByKeyword(String keyword);
}
