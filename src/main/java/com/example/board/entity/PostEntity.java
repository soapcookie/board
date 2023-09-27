package com.example.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "post_entity")
@Getter
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시물 아이디

    private String title; // 제목
    private String content; // 내용

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @CreatedDate
    private LocalDateTime regDate; // 등록 날짜

    private LocalDateTime updateDate; // 수정 날짜 추가

    private int viewCount; // 조회수
    private boolean delYn; // 삭제 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId") // 외래 키 지정
    private UserEntity user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getUpdate() {
        return updateDate;
    }

    public void setUpdate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public boolean isDelYn() {
        return delYn;
    }

    public void setDelYn(boolean delYn) {
        this.delYn = delYn;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
