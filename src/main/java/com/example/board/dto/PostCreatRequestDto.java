package com.example.board.dto;


import com.example.board.entity.PostEntity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PostCreatRequestDto {
    private String writer;
    private String title;
    private String content;

    public PostCreatRequestDto(PostEntity postEntity){
       this.writer = postEntity.getWriter();
       this.title = postEntity.getTitle();
       this.content = postEntity.getContent();
    }

}
