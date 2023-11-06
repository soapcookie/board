package com.example.board.jwt;

import javax.naming.AuthenticationException;

public class JwtExpiredException extends AuthenticationException {
//    만료된 토큰 예외 처리
    public JwtExpiredException(String message) {
        super(message);
    }

}
