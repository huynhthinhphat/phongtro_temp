package com.example.PHONGTROSPRING.service;

import com.example.PHONGTROSPRING.entities.BlogPost;

import com.example.PHONGTROSPRING.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogRepository blogPostRepository;

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }
}
