package com.example.board.entity;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Enabled
@Getter
@NoArgsConstructor
@Entity
@Table(name="likes_entity")
public class LikeEntity {
    @Id
    @GeneratedValue
    @Column
    private Long likeId; // 좋아요 식별 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private PostEntity post; // 게시물


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="loginId")
    private UserEntity user; // 사용자


}
