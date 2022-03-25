package com.register.user.exception;

import com.register.user.error.ErrorCodeEnum;
import com.register.user.error.InternalServerErrorException;
import org.springframework.http.HttpStatus;

public class UserWithEmailAlreadyRegisteredException extends InternalServerErrorException
{
    public UserWithEmailAlreadyRegisteredException() {
        super(new ServerErrorResponseDto("User email already registered", ErrorCodeEnum.USER_WITH_EMAIL_ALREADY_EXISTS,
                HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
}
