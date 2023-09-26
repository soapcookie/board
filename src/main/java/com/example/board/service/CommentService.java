package com.example.board.service;

public interface CommentService {
    void addReply(Long parentId, String replyContent);
}
