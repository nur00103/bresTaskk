package com.example.brestaskk.exception;


import com.example.brestaskk.enums.ExceptionEnum;

public class MyException extends RuntimeException {
    private final int code;
    private final String message;
    public MyException(ExceptionEnum errorCodeEnum){
        super(errorCodeEnum.getMessage());
        this.code= errorCodeEnum.getCode();
        this.message= errorCodeEnum.getMessage();
    }
    public MyException(int code, String message){
        super(message);
        this.code= code;
        this.message= message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
