package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class UserNotFoundException extends BusinessException{
    public UserNotFoundException(ErrorCode errorCode, String message) {
        super(message, errorCode);
    }

}
