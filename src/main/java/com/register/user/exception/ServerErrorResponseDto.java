package com.register.user.exception;

import com.register.user.error.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
public class ServerErrorResponseDto
{
    private String message;
    private ErrorCodeEnum errorCode;
    int httpStatus;
    public ServerErrorResponseDto( String message, ErrorCodeEnum errorCode, HttpStatus httpStatus )
    {
        this.message = message;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus.value();
    }

    public String getMessage()
    {
        return message;
    }

    public ErrorCodeEnum getErrorCode()
    {
        return errorCode;
    }

    public int getHttpStatus()
    {
        return httpStatus;
    }
}