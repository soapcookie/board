package com.example.board.controller;

import com.example.board.dto.UserDto;
import com.example.board.dto.UserUpdateDto;
import com.example.board.entity.UserEntity;
import com.example.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // 사용자 생성 엔드포인트
    @PostMapping("/")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto userDto) {
        UserEntity createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // 사용자 조회 엔드포인트
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity userEntity = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userEntity);
    }

    // 사용자 업데이트 엔드포인트
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        UserEntity updatedUser = userService.updateUser(id, userUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    // 사용자 삭제 엔드포인트
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
