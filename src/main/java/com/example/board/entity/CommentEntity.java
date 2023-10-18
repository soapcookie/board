package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Comments_entity")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId; // 댓글 식별 아이디

    @Column
    private String content; // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    private PostEntity post; // 게시물

    @Column
    private String writer;

    @Column
    private int likeCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    private CommentEntity parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<ReplyEntity> replies;


}
