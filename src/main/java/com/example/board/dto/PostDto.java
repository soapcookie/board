package com.example.board.dto;

import com.example.board.entity.PostEntity;
import com.example.board.enums.CategoryEnum;
import com.example.board.entity.CommentEntity;
import com.example.board.entity.LikeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private List<CommentEntity> comments;
    private List<CategoryEnum> categories;
    private List<LikeEntity> likes;
    private int viewCnt;
    private boolean delYn;

    public PostDto(PostEntity postEntity){
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.writer = postEntity.getWriter();
        this.content = postEntity.getContent();
        this.updateDate = postEntity.getUpdateDate();
        this.categories = postEntity.getCategories();
        this.likes = postEntity.getLikes();
        this.viewCnt = postEntity.getViewCnt();
        this.delYn = postEntity.isDelYn();
        this.regDate = postEntity.getRegDate();

    }
}
