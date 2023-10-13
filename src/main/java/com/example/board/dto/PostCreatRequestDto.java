package com.example.board.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCreatRequestDto {
    private String writer;
    private String title;
    private String content;

    public PostCreatRequestDto(String writer, String title, String content){
        this.writer=writer;
        this.title=title;
        this.content=content;
    }

}
