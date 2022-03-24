package com.register.user.service;

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
        return Optional.of(userRepository.findById(id).get());
    }

    @Override
    public User findByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public User update(String id, User user) {

        if (userRepository.findById(id).isPresent())
        {
            User userTemp = userRepository.findById(id).get();

            userTemp.setDni(user.getDni());
            userTemp.setName(user.getName());
            userTemp.setLastName(user.getLastName());
            userTemp.setEmail(user.getEmail());
            userTemp.setPhone(user.getPhone());

            if ( user.getPasswordHash() != null )
            {
                userTemp.setPasswordHash( BCrypt.hashpw( user.getPasswordHash(), BCrypt.gensalt() ));
            }

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

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }
}
