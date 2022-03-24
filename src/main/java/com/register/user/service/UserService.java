package com.register.user.service;

import com.register.user.controller.dto.UserDto;
import com.register.user.repository.document.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create( User user );

    Optional<User> findById(String id );

    User findByEmail(String email );

    List<User> all();

    boolean deleteById( String id );

    User update( String id, User user);
}
