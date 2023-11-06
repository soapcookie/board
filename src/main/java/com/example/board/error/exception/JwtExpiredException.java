package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class JwtExpiredException extends BusinessException{
    public JwtExpiredException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
