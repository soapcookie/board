package com.example.board.controller;

import com.example.board.dto.*;
import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/")
    public ResponseEntity<PostCreatRequestDto> createPost(@RequestBody PostCreatRequestDto postCreatRequestDto) {
        PostCreatRequestDto createdPost = postService.createPost(postCreatRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }


    @PutMapping("/{postId}")
    public ResponseEntity<PostUpdateRequestDto> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequestDto postUpdateRequestDto) {

        PostUpdateRequestDto updatedPost = postService.updatePost(postId, postUpdateRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id) {
        PostResponseDto responseDto = postService.searchById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostListResponseDto>> getAllPostsDesc() {
        List<PostListResponseDto> responseDtoList = postService.searchAllDesc();
        return ResponseEntity.ok(responseDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public Page<PostResponseDto> getPosts(@RequestParam int page) {
        return postService.getPosts(page);
    }


}
