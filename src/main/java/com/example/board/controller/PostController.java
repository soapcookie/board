package com.example.board.controller;

import com.example.board.dto.PostCreatRequestDto;
import com.example.board.dto.PostListResponseDto;
import com.example.board.dto.PostResponseDto;
import com.example.board.dto.PostUpdateRequestDto;
import com.example.board.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }

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


}
