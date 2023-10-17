package com.example.board.dto;

import com.example.board.entity.PostEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostListResponseDto {
    private Long id;
    private String title;
    private String writer;
    private LocalDateTime regDate;


    public PostListResponseDto(PostEntity postEntity){
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.writer = postEntity.getWriter();
        this.regDate = postEntity.getRegDate();
    }



}
