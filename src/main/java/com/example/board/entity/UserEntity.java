package com.example.board.entity;

import com.example.board.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id // 기본 키와 매핑될 필드에 지정
    @GeneratedValue
    private Long loginId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 12, nullable = false)
    private String pw;

    @Column(length = 20, nullable = false)
    private String username; // 유저의 실명 또는 닉네임

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<PostEntity> posts = new ArrayList<>();



    public void updateUser(String username, String email) {
        if (username != null) {
            this.username = username;
        }

        if (email != null) {
            this.email = email;
        }
    }

    public UserEntity(UserDto userDto){
        this.loginId=userDto.getLoginId();
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
        this.pw = userDto.getPw();
    }



}
