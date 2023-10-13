package com.example.board.service;

import com.example.board.entity.CommentEntity;
import com.example.board.entity.ReplyEntity;
import com.example.board.repository.CommentRepository;
import com.example.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

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

        parentComment.getReplies().add(reply);

        commentRepository.save(parentComment);
    }
}
