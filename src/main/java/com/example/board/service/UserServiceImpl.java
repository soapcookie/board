package com.example.board.service;

import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        // 사용자 생성 및 저장 로직
        UserEntity createdUser = userRepository.save(userEntity);
        return createdUser;
    }

    @Override
    public UserEntity getUserById(Long id) {
        // 사용자 조회 로직
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        // 사용자 업데이트 로직
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null; // 사용자가 존재하지 않을 경우 null 반환 또는 예외 처리
        }

        // 업데이트할 필드 설정
        existingUser.setEmail(userEntity.getEmail());
        existingUser.setPw(userEntity.getPw());
        existingUser.setUsername(userEntity.getUsername());

        return userRepository.save(existingUser); // 업데이트된 사용자 엔티티를 반환
    }

    @Override
    public void deleteUser(Long id) {
        // 사용자 삭제 로직
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userRepository.delete(userEntity); // 사용자가 존재할 경우 삭제
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        // 이메일로 사용자 조회 로직
        return userRepository.findByEmail(email);
    }
}
