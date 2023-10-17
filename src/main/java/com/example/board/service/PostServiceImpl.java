package com.example.board.service;

import com.example.board.dto.*;
import com.example.board.entity.PostEntity;
import com.example.board.error.ErrorCode;
import com.example.board.error.exception.PostNotFoundException;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    @Override
    public PostCreatRequestDto createPost(PostCreatRequestDto postCreateRequestDto) {
        PostEntity postEntity = new PostEntity(postCreateRequestDto);
        postRepository.save(postEntity);
        return postCreateRequestDto;
    }


    @Override
    public PostUpdateRequestDto updatePost(Long postId, PostUpdateRequestDto postUpdateRequestDto) {
        PostEntity existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("해당 게시글을 찾을 수 없습니다.", ErrorCode.POST_NOT_FOUND_EXCEPTION));
        existingPost.update(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());
        PostEntity postEntity = postRepository.save(existingPost);

        PostUpdateRequestDto postUpdateRequestDto1 = new PostUpdateRequestDto();
        postUpdateRequestDto1.setTitle(postEntity.getTitle());
        postUpdateRequestDto1.setContent(postEntity.getContent());

        return postUpdateRequestDto1;

    }



    @Override
    @Transactional(readOnly = true)
    public PostDto searchById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return new PostDto(postEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostListResponseDto> searchAllDesc() {
        return postRepository.findAllByOrderByIdDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void delete(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() ->
                new PostNotFoundException("해당 게시글이 존재하지 않습니다.",ErrorCode.POST_NOT_FOUND_EXCEPTION));
        postRepository.delete(postEntity);

    }

    @Override
    public PostListDto getPosts(Pageable pageable) {
        Page<PostEntity> postPage = postRepository.findAll(pageable);

        List<PostDto> postDtoList = postPage.map(post -> {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setRegDate(post.getRegDate());
            return postDto;
        }).getContent();

        PostListDto postListDto = new PostListDto(postDtoList, postPage.getTotalPages());

        return postListDto;
    }



    }


