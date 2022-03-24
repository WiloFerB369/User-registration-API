package com.register.user.controller.dto;

public class UserDto
{
    private final long dni;

    private final String name;

    private final String lastName;

    private final String email;

    private final String phone;

    private String password;

    public  UserDto(long dni, String name, String lastName, String email, String phone, String password)
    {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public long getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}

