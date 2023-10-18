package com.example.board.service;

import com.example.board.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostCreatRequestDto createPost(PostCreatRequestDto postCreateRequestDto);
    PostUpdateRequestDto updatePost(Long postId, PostUpdateRequestDto postUpdateRequestDto);


    PostResponseDto searchById(Long id);
    List<PostListResponseDto> searchAllDesc();
    void delete(Long id);

    Page<PostResponseDto> getPosts(int page);



}

