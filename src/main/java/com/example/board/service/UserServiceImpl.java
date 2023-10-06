package com.example.board.service;

import com.example.board.dto.UserDto;
import com.example.board.dto.UserUpdateDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserDto userDto) {
        // 사용자 생성 및 저장 로직
        UserEntity userEntity = new UserEntity();


        UserEntity createdUser = userRepository.save(userEntity);
        return createdUser;
    }

    @Override
    public UserEntity getUserById(Long id) {
        // 사용자 조회 로직
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity updateUser(Long userId, UserUpdateDto userUpdateDto) {
        // userId로 사용자 조회
        UserEntity optionalUser = userRepository.findById(userId).orElseThrow("사용자를 찾을 수 없습니다.");
//        이거 다 바꾸기
//        if (optionalUser.isPresent()) {
//            UserEntity user = optionalUser.get();
//            // 업데이트할 필드 설정
//            if (userUpdateDto.getUsername() != null) {
//                user.setUsername(userUpdateDto.getUsername());
//            }
//            if (userUpdateDto.getEmail() != null) {
//                user.setEmail(userUpdateDto.getEmail());
//            }
        // 사용자 저장 및 반환
//            return userRepository.save(user);
//        } else {
//            throw new RuntimeException("사용자를 찾을 수 없습니다.");
//        }
    }




    @Override
    public void deleteUser(Long id) {
        // 사용자 삭제 로직
        UserEntity userEntity = userRepository.findById(id).orElseThrow(null);
//        예외처리 추가하기
        if (userEntity != null) {
            userRepository.delete(userEntity); // 사용자가 존재할 경우 삭제, 객체에서 삭제
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        // 이메일로 사용자 조회 로직
        return userRepository.findByEmail(email);
    }
}
