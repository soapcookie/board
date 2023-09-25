package com.example.board.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategoryEnum {
    notice("Notice", "공지사항"),
    qna("Q&A", "질문과 답변"),
    info("Info", "정보"),
    free("Free", "자유게시판");

    private final String key;
    private final String title;


}