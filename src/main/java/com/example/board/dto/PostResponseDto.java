package com.example.board.dto;

import com.example.board.enums.CategoryEnum;
import com.example.board.entity.CommentEntity;
import com.example.board.entity.LikeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PostResponseDto {
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdDate;
    private List<CommentEntity> comments;
    private List<CategoryEnum> categories;
    private List<LikeEntity> likes;

}
