package com.example.board.service;

import com.example.board.entity.UserEntity;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    UserEntity getUserById(Long id);
    UserEntity updateUser(Long id, UserEntity userEntity);
    void deleteUser(Long id);
    UserEntity findByEmail(String email);
}
