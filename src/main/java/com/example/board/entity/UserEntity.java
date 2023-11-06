package com.example.board.entity;

import com.example.board.dto.UserDto;
import com.example.board.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
@Table
public class UserEntity {
    @Id
    @Column(name = "userId")
    private String userId;

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

    public void toEntity(UserDto userDto) {
        this.userId = String.valueOf(userDto.getLoginId()); // long 값을 String으로 변환
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
        this.pw = userDto.getPw();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;


}
