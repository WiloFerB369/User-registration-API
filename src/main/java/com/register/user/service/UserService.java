package com.register.user.service;

import com.register.user.document.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User create(User user);

    User findByEmail(String email);

    Optional<User> findById(String id);

    User updatePasswordAndPhone(String id, User user);

    boolean deleteById(String id);
}
