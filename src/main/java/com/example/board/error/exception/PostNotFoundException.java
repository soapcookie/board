package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class PostNotFoundException extends BusinessException{
    public PostNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
    }

