package com.example.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostListDto {
    private List<PostDto> posts;
    private int totalPages;

    public PostListDto(List<PostDto> posts, int totalPages) {
        this.posts = posts;
        this.totalPages = totalPages;
    }
}
