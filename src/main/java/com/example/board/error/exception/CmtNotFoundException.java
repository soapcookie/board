package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class CmtNotFoundException extends BusinessException{
    public CmtNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
