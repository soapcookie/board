package com.example.board.dto;

import com.example.board.entity.UserEntity;
import lombok.Data;
import lombok.Getter;

@Getter
public class UserUpdateDto {
    private String username;
    private String email;
    private String pw;

    public UserUpdateDto(UserEntity userEntity){
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.pw = userEntity.getPw();
    }
}
