package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId; // 댓글 식별 아이디

    private String content; // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    private PostEntity post; // 게시물

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user; // 댓글 작성자

    @Column
    private int likeCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    private CommentEntity parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<ReplyEntity> replies;

    @Builder
    public CommentEntity(Long commentId, String content, PostEntity post, String username, int likeCnt, CommentEntity parentComment, List<ReplyEntity> replies) {
        this.commentId = commentId;
        this.content = content;
        this.post = post;
        this.user = user;
        this.likeCnt = likeCnt;
        this.parentComment = parentComment;
        this.replies = replies;
    }

}
