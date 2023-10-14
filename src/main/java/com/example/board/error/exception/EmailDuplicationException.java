package com.example.board.error.exception;

import com.example.board.error.ErrorCode;

public class EmailDuplicationException extends BusinessException{
    public EmailDuplicationException(ErrorCode errorCode, String message){
        super(message, errorCode);
    }
}
