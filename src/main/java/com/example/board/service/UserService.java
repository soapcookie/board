package com.example.board.service;

import com.example.board.dto.UserDto;
import com.example.board.dto.UserUpdateDto;
import com.example.board.entity.UserEntity;

public interface UserService {
    UserEntity createUser(UserDto userDto);
    UserEntity getUserById(Long id);
    UserEntity updateUser(Long id, UserUpdateDto userUpdateDto);
    void deleteUser(Long id);
    UserEntity findByEmail(String email);
}
