package com.descomplica.FrameBlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.descomplica.FrameBlog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
