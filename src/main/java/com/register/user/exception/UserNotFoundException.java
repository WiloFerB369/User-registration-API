package com.register.user.exception;

import com.register.user.error.ErrorCodeEnum;
import com.register.user.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends InternalServerErrorException
{
    public UserNotFoundException() {
        super(new ServerErrorResponseDto("User nor found", ErrorCodeEnum.USER_NOT_FOUND,
                        HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
}
