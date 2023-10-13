package com.example.board.service;

import com.example.board.dto.UserDto;
import com.example.board.dto.UserUpdateDto;
import com.example.board.entity.UserEntity;


public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long loginId);
    UserUpdateDto updateUser(Long loginId, UserUpdateDto userUpdateDto);
    void deleteUser(Long id);
    UserDto findByEmail(String email);
}
