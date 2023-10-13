package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId; // 답글 식별 아이디

    private String content; // 답글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    private CommentEntity parentComment; // 상위 댓글

    @Column
    private String writer; // 답글 작성자

    @Builder
    public ReplyEntity(Long replyId, String content, CommentEntity parentComment, String writer) {
        this.replyId = replyId;
        this.content = content;
        this.parentComment = parentComment;
        this.writer = writer;
    }


}