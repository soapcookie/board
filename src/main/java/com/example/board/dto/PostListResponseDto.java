package com.example.board.dto;

import com.example.board.entity.PostEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostListResponseDto {
    private String title;
    private String writer;

    public PostListResponseDto(PostEntity postEntity){
        this.title = postEntity.getTitle();
        this.writer = postEntity.getWriter();
    }



}
