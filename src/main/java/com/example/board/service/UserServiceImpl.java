package com.example.board.service;

import com.example.board.dto.UserDto;
import com.example.board.dto.UserUpdateDto;
import com.example.board.entity.UserEntity;
import com.example.board.error.ErrorCode;
import com.example.board.error.exception.NotFoundException;
import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.toEntity(userDto);
        userRepository.save(userEntity);
    // save는 db가 return 안함
        return userDto;
    }


    @Override
    public UserDto getUserById(Long loginId) {
        // 사용자 조회 로직, 엔티티로 변환
        UserEntity userEntity = userRepository.findById(loginId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION, "사용자를 찾을 수 없습니다."));
        return new UserDto(userEntity);
    }



    @Override
    @Transactional
    public UserUpdateDto updateUser(Long loginId, UserUpdateDto updateDto) {
        UserEntity existingUser = userRepository.findById(loginId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION,"사용자를 찾을 수 없습니다."));
        existingUser.updateUser(updateDto.getUsername(), updateDto.getEmail());
        return new UserUpdateDto(existingUser);
    }


    @Override
    @Transactional
    public void deleteUser(Long loginId) {
        // 사용자 삭제 로직
        UserEntity userEntity = userRepository.findById(loginId).orElseThrow(() -> new NotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION,"사용자를 찾을 수 없습니다."));
        userRepository.delete(userEntity);
    }


    @Override
    public UserDto findByEmail(String email) {
        return null;
    }
}
