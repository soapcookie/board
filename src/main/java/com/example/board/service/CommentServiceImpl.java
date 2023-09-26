package com.example.board.service;

import com.example.board.entity.CommentEntity;
import com.example.board.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addReply(Long parentId, String replyContent) {
        CommentEntity parentComment = commentRepository.findById(parentId).orElse(null);
        if (parentComment == null) {
            throw new IllegalArgumentException("부모 댓글이 존재하지 않습니다.");
        }

        CommentEntity reply = new CommentEntity();
        reply.setContent(replyContent);
        reply.setParentComment(parentComment);

        commentRepository.save(reply);
    }
}