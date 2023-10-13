package com.example.board.controller;

import com.example.board.dto.UserDto;
import com.example.board.dto.UserUpdateDto;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // 사용자 조회 엔드포인트
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // 사용자 업데이트 엔드포인트
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        userService.updateUser(id, userUpdateDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // 사용자 삭제 엔드포인트
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
