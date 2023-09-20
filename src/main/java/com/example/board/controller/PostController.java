package com.example.board.controller;

import com.example.board.dto.PostDto;
import com.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;

    }

    @PostMapping("/")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto createdPost = postService.createPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        PostDto post = postService.getPostById(postId);
        // HttpStatus.OK 상태 코드와 함께 조회된 게시물을 반환합니다.
        return ResponseEntity.status(HttpStatus.OK).body(post);

    }


    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long postId, @RequestBody PostDto postDto) {

        PostDto updatedPost = postService.updatePost(postId, postDto);
        // HttpStatus.OK 상태 코드와 함께 업데이트된 게시물을 반환합니다.
        return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        // HttpStatus.NO_CONTENT 상태 코드를 반환합니다.
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
