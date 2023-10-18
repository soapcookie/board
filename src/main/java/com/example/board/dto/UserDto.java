package com.example.board.dto;

import com.example.board.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String loginId;
    private String email;
    private String pw;
    private String username;

    public UserDto(UserEntity userEntity) {
        this.loginId = userEntity.getUserId(); // 변경 없음
        this.email = userEntity.getEmail();
        this.pw = userEntity.getPw();
        this.username = userEntity.getUsername();
    }

}
