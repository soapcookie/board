package com.example.board.dto;

import com.example.board.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long loginId;
    private String email;
    private String pw;
    private String username;

    public UserDto(UserEntity userEntity){
        this.loginId = userEntity.getLoginId();
        this.email = userEntity.getEmail();
        this.pw = userEntity.getPw();
        this.username = userEntity.getUsername();
    }
}
