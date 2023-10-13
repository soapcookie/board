package com.example.board.service;

import com.example.board.dto.PostCreatRequestDto;
import com.example.board.dto.PostListResponseDto;
import com.example.board.dto.PostResponseDto;
import com.example.board.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PostCreatRequestDto createPost(PostCreatRequestDto postCreateRequestDto);
    PostUpdateRequestDto updatePost(Long postId, PostUpdateRequestDto postUpdateRequestDto);


    PostResponseDto searchById(Long id);
    List<PostListResponseDto> searchAllDesc();
    void delete(Long id);
}

