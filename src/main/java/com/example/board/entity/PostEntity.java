package com.example.board.entity;

import com.example.board.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "post_entity")
@Getter
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시물 아이디

    private String title; // 제목
    private String content; // 내용

    @ElementCollection(targetClass = CategoryEnum.class)  // 열거형 리스트 설정
    @Enumerated(EnumType.STRING)
    private List<CategoryEnum> categories;  // 카테고리 리스트 필드

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) // CommentEntity와의 관계 설정
    private List<CommentEntity> comments; // 댓글 리스트 필드

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) // LikeEntity와의 관계 설정
    private List<LikeEntity> likes; // 좋아요 리스트 필드


    @CreatedDate
    private LocalDateTime regDate; // 등록 날짜

    private LocalDateTime updateDate; // 수정 날짜 추가

    private int viewCount; // 조회수
    private boolean delYn; // 삭제 여부

    @Column
    private int likeCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId") // 외래 키 지정
    private UserEntity user;

//    기본생성자
    public PostEntity(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.categories = postDto.getCategories();
        this.regDate = LocalDateTime.now();
        this.updateDate = null;
        this.viewCount = 0;
        this.delYn = false;
        this.likeCnt = 0;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
