package com.codeup.ovalleblog.dao;

import com.codeup.ovalleblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
