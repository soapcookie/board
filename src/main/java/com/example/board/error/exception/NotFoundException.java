package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorCode errorCode, String message) {
        super(message, errorCode);
    }

}
