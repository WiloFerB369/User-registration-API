package com.register.user.document;

import com.register.user.controller.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class User {

    @Id
    private String id;

    private long dni;

    private String name;

    private String lastName;

    private String email;

    private String phone;

    private String password;

    private Date created;

    public User() {
    }

    public User (long dni, String name, String lastName, String email, String phone, String password)
    {
       this.dni =dni;
       this.name = name;
       this.lastName = lastName;
       this.email = email;
       this.phone = phone;
       this.password = password;
       this.created = new Date();
    }

    public User(UserDto userDto)
    {
        this.dni = userDto.getDni();
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.phone = userDto.getPhone();
        this.password = userDto.getPassword();
        this.created = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

