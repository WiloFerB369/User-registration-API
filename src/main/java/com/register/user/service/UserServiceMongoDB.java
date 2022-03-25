package com.register.user.service;

import com.register.user.controller.dto.UserDto;
import com.register.user.exception.UserNotFoundException;
import com.register.user.repository.document.User;
import com.register.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService
{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id )
    {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public User update(User user, UserDto userDto)
    {
        user.update(userDto);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById( String id ) {
        if(userRepository.existsById( id ))
        {
            userRepository.deleteById( id );
            return true;
        }
        return false;
    }

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }
}
