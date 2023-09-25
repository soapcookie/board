package com.example.board.dto;

import com.example.board.entity.CategoryEnum;
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
    private UserDto userName;
    private LocalDateTime createdDate;
    //dto로 받았어야했나..?
    private List<CommentEntity> comments; //댓글 리스트 추가
    private List<CategoryEnum> categories; //카테고리 표시
    private List<LikeEntity> likes; //좋아요 표시

    public void setId(Long id) {
        this.id = id;
    }

}
