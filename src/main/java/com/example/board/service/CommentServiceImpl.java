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

        CommentEntity reply = new CommentEntity();
        reply.setContent(replyContent);

        List<CommentEntity> parentCommentList = new ArrayList<>();
        parentCommentList.add(parentComment); // parentComment를 List에 추가

        reply.setParentComment(parentCommentList); // List를 전달
       

        commentRepository.save(reply);
    }
}