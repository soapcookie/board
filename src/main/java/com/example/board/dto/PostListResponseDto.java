package com.example.board.dto;

import com.example.board.entity.PostEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostListResponseDto {
    private String username;
    private String title;

    public PostListResponseDto(String username, String title){
        this.username = username;
        this.title= title;
    }

}
