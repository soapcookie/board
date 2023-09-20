package com.example.board.service;

import com.example.board.dto.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(Long postId);
    PostDto updatePost(Long postId, PostDto postDto);
    void deletePost(Long postId);
}

