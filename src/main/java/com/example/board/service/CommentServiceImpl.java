package com.example.board.service;

import com.example.board.entity.CommentEntity;
import com.example.board.entity.ReplyEntity;
import com.example.board.repository.CommentRepository;
import com.example.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ReplyRepository replyRepository;

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

        ReplyEntity reply = ReplyEntity.builder()
                .content(replyContent)
                .parentComment(parentComment)
                .build();

        // 엔티티 저장
        replyRepository.save(reply);

        // 부모 댓글의 자식 댓글 목록에 새 댓글 추가
        parentComment.getReplies().add(reply);

        // 부모 댓글을 다시 데이터베이스에 저장
        commentRepository.save(parentComment);
    }

}