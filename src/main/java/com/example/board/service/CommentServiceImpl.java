package com.example.board.service;

import com.example.board.entity.CommentEntity;
import com.example.board.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
            throw new IllegalArgumentException("상위 댓글이 존재하지 않습니다.");
        }

        CommentEntity reply = CommentEntity.builder()
                .content(replyContent)
                .parentComment(parentComment)
                .build();

        commentRepository.save(reply);
        commentRepository.save(reply);

        // 부모 댓글의 자식 댓글 목록에 새 댓글 추가
        parentComment.getReplies().add(reply);

        // 부모 댓글을 다시 데이터베이스에 저장
        commentRepository.save(parentComment);
    }

}