package com.example.board.entity;

import com.example.board.dto.PostCreatRequestDto;
import com.example.board.enums.CategoryEnum;
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

    private Long id;
    private String title; // 제목
    private String content; // 내용
    private String writer; //작성자

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

    private int viewCnt; // 조회수
    private boolean delYn; // 삭제 여부

    @Column(name = "like_cnt")
    private int likeCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId") // 외래 키 지정
    private UserEntity user;




    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public PostEntity(PostCreatRequestDto postCreatRequestDto){
        this.writer = postCreatRequestDto.getWriter();
        this.title = postCreatRequestDto.getTitle();
        this.content = postCreatRequestDto.getContent();
    }



}
