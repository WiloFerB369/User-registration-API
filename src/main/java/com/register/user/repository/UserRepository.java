package com.register.user.repository;

import com.register.user.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository< User, String>
{
    User findUserByEmail(String email);
}
