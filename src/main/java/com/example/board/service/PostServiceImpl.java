package com.example.board.service;

import com.example.board.dto.PostCreatRequestDto;
import com.example.board.dto.PostListResponseDto;
import com.example.board.dto.PostResponseDto;
import com.example.board.dto.PostUpdateRequestDto;
import com.example.board.entity.PostEntity;
import com.example.board.error.ErrorCode;
import com.example.board.error.exception.PostNotFoundException;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
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



    @Transactional(readOnly = true)
    public PostResponseDto searchById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return new PostResponseDto(postEntity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> searchAllDesc() {
        return postRepository.findAllByOrderByIdDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() ->
                new PostNotFoundException("해당 게시글이 존재하지 않습니다.",ErrorCode.POST_NOT_FOUND_EXCEPTION));
        postRepository.delete(postEntity);

    }
}
