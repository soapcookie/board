package com.example.board.controller;

import com.example.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{parentId}/replies")
    public ResponseEntity<String> addReply(
            @PathVariable Long parentId,
            @RequestBody String replyContent) {

        commentService.addReply(parentId, replyContent);

        return ResponseEntity.ok("답글이 성공적으로 추가되었습니다.");
    }
}
