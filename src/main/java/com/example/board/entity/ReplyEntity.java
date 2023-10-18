package com.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="replys_entity")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId; // 답글 식별 아이디

    @Column
    private String content; // 답글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    private CommentEntity parentComment; // 상위 댓글

    @Column
    private String writer; // 답글 작성자

}