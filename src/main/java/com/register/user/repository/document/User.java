package com.register.user.repository.document;

import com.register.user.controller.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document
public class User {

    @Id
    private String id;

    private long dni;

    private String name;

    private String lastName;

    @Indexed( unique = true)
    private String email;

    private String phone;

    private String passwordHash;

    List<RoleEnum> roles;

    private Date created;

    public User() {
    }

    public User (long dni, String name, String lastName, String email, String phone, String passwordHash)
    {
       this.dni =dni;
       this.name = name;
       this.lastName = lastName;
       this.email = email;
       this.phone = phone;
       this.passwordHash = passwordHash;
       this.created = new Date();
    }

    public User(UserDto userDto)
    {
        this.dni = userDto.getDni();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.phone = userDto.getPhone();
        this.passwordHash = userDto.getPassword();
        this.created = new Date();
        this.roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
        this.passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
    }

    public String getId() {
        return id;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Date getCreated() {
        return created;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void update(UserDto userDto){

        if ( userDto.getPassword() != null )
        {
            this.passwordHash =  BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt());
        }

    }
}

