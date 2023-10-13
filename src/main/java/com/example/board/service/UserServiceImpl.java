package com.example.board.service;

import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


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
        @Transactional
        public UserUpdateDto updateUser(Long userId, UserUpdateDto updateDto) {
            // 사용자 업데이트를 위해 사용자 정보를 데이터베이스에서 가져옴
            UserEntity existingUser = userRepository.findById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));

            // UserUpdateDto에서 업데이트할 필드를 가져와서 User 엔터티의 updateUser 메소드를 호출
            existingUser.updateUser(updateDto.getUsername(), updateDto.getEmail());

            // 업데이트된 사용자를 저장하고 반환 근데 이건 jpa가 알아서 해주기때문에 걍 지워도됨
            return UserUpdateDto();
//            return new UserResponseDto(existingUser);
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
    public void deleteUser(Long id) {
        // 사용자 삭제 로직
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다."));
        userRepository.delete(userEntity); // 사용자가 존재할 경우 삭제, 객체에서 삭제
    }
}
