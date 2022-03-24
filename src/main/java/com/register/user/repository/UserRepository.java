package com.register.user.repository;

import com.register.user.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>
{
    User findByEmail(String email);
}
