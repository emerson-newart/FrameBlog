package com.descomplica.FrameBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.descomplica.FrameBlog.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String login);
} 
