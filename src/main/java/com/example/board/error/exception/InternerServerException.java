package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class InternerServerException extends BusinessException {

    public InternerServerException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}