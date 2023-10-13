package com.example.board.service;

import com.example.board.dto.PostListResponseDto;
import com.example.board.dto.PostResponseDto;
import com.example.board.entity.PostEntity;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.board.dto.PostDto.convertToDto;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    @Override
    public PostDto createPost(PostDto postDto) {


        // PostDto를 Post 엔티티로 변환하고 저장합니다.
        PostEntity post = new PostEntity(postDto);

        // 게시물 저장 로직을 수행하고 저장된 게시물 엔티티를 반환합니다.
        PostEntity savedPost = postRepository.save(post);

        // 저장된 게시물 엔티티를 PostDto로 다시 변환하여 반환합니다.
        return postDto(savedPost);
    }

    @Override
    public PostDto getPostById(Long postId) {
        // postId를 사용하여 게시물을 조회합니다.
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다."));

        // 조회한 게시물 엔티티를 PostDto로 변환하여 반환합니다.
        return PostDto(post);
    }



    @Override
    public PostDto updatePost(Long postId, PostDto postDto) {
        // postId를 사용하여 업데이트할 게시물을 조회합니다.
        PostEntity existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다."));

        // 업데이트 메서드를 호출하여 필드를 업데이트합니다.
        existingPost.update(postDto.getTitle(), postDto.getContent());

        // 데이터베이스에 업데이트된 게시물을 저장하고 업데이트된 게시물 엔티티를 반환합니다.
        PostEntity updatedPost = postRepository.save(existingPost);

        // 업데이트된 게시물 엔티티를 PostDto로 다시 변환하여 반환합니다.
        return new PostDto(updatedPost);
    }


    @Override
    public void deletePost(Long postId) {
        // postId를 사용하여 삭제할 게시물을 조회합니다.
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다."));

        // 게시물을 삭제합니다.
        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public PostResponseDto searchById(Long id) {
        PostEntity postEntity= PostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        return new PostResponseDto(postEntity);
    }
    @Transactional(readOnly = true)
    public List<PostListResponseDto> searchAllDesc() {
        return PostRepository.findAllByOrderByIdDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long id) {
        PostEntity postEntity = PostRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        PostRepository.delete(postEntity);

}
