package com.example.board.dto;

import com.example.board.enums.CategoryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@NoArgsConstructor
@Repository
public class PostUpdateRequestDto {
        private String title;
        private String content;

        public PostUpdateRequestDto(String title, String content) {
                this.title = title;
                this.content = content;
        }
}