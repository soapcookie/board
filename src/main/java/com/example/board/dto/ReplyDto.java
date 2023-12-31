package com.example.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyDto {
    private Long replyId;
    private String writer;
    private String content;
}
