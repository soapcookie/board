package com.example.board.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCreatRequestDto {
    private String username;
    private String title;
    private String content;

    public PostCreatRequestDto(String username, String title, String content){
        this.username=username;
        this.title=title;
        this.content=content;
    }

}
