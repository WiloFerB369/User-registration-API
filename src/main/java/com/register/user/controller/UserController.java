package com.register.user.controller;

import com.register.user.controller.dto.UserDto;
import com.register.user.exception.UserNotFoundException;
import com.register.user.exception.UserWithEmailAlreadyRegisteredException;
import com.register.user.repository.document.User;
import com.register.user.service.UserService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController
{

    private final UserService userService;

    public UserController(@Autowired UserService userService)
    {
        this.userService = userService;

    }

    @PostMapping
    public User create(@RequestBody UserDto userDto){

        Optional<User> optionalUser = userService.findByEmail(userDto.getEmail());
        if(!optionalUser.isPresent()){
            return userService.create( new User(userDto));
        }
        else{
            throw new UserWithEmailAlreadyRegisteredException();
        }
    }

    @GetMapping("/{id}")
    @RolesAllowed("ADMIN")
    public User findById(@PathVariable String id){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent())
        {
            return optionalUser.get();
        }
        else {
            throw new UserNotFoundException();
        }
    }

    @PutMapping("/{id}")
    @RolesAllowed("ADMIN")
    public User updateById(@PathVariable String id, @RequestBody UserDto userDto)
    {
        Optional<User> user = userService.findById(id);

        if(user.isPresent()){
            return userService.update(user.get(), userDto );
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMIN")
    public boolean deleteById(@PathVariable String id){

        boolean deleteById = userService.deleteById(id);

        if(deleteById){
            return true;
        }
        else{
            throw new UserNotFoundException();
        }

    }
}
