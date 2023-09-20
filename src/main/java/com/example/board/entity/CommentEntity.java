package com.example.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long commentId; // 댓글 식별 아이디

    private String content; // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    private PostEntity post; // 게시물

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user; // 댓글 작성자


}
