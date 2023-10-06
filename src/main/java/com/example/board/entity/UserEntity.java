package com.example.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id // 기본 키와 매핑될 필드에 지정
    @GeneratedValue // 식별자 자동 생성, column에 필요
    private Long loginId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 12, nullable = false)
    private String pw;

    @Column(length = 20, nullable = false)
    private String username; // 유저의 실명 또는 닉네임


}
