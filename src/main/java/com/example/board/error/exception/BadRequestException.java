package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class BadRequestException extends BusinessException{
    public BadRequestException(String message, ErrorCode errorCode){
        super(message,errorCode);
    }
}
