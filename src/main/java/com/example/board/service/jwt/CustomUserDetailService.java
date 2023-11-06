package com.example.board.service.jwt;

import com.example.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImpl(userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("존재하지 않는 회원입니다.")));
    }

//    UserDetailsImpl 객체로 감싸서 반환하는 이유는 스프링 시큐리티에서 사용자의 상세 정보를 표현하기 위해서이고,
//    Optional은 값의 존재 여부를 표현하기 위한 클래스로 값이 없을 때 예외를 발생시키기 위해 .orElseThrow() 메서드를 사용

}
