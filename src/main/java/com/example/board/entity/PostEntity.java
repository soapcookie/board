package com.example.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; //게시물 아이디


    private String title; // 제목
    private String content; // 내용

    @CreatedDate
    private LocalDateTime regDate; // 등록 날짜

    private LocalDateTime update; // 수정 날짜

    private int viewCount; // 조회수
    private boolean delYn; // 삭제 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
