package com.register.user.service;

import com.register.user.document.User;
import com.register.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User findByEmail(String email) {
        return userRepository.findUserByEmail( email );
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById( id );
    }

    @Override
    public User updatePasswordAndPhone(String id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
        {
            User userTemp = optionalUser.get();

            userTemp.setPassword(user.getPassword());
            userTemp.setPhone(user.getPhone());

            return userRepository.save(userTemp);
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
