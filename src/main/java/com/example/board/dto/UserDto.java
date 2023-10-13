package com.example.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long loginId;
    private String email;
    private String pw;
    private String username;
}
