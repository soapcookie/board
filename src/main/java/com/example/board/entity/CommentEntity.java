package com.example.board.entity;

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
    private Integer likeCnt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private List<CommentEntity> parentComment; // 부모 댓글, List로 일대다 컨테이너 생성

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentEntity> getParentComment() {
        return parentComment;
    }

    public void setParentComment(List<CommentEntity> parentComment) {
        this.parentComment = parentComment;
    }
}