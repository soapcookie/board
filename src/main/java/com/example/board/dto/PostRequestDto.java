package com.example.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostRequestDto {
    private String writer;
    private String title;
    private String content;
}
