package com.example.springbootdemo.dto;

import jakarta.validation.constraints.*;

public class CreateUserDTO {

    @NotBlank
    private String name;

    @Min(value = 0)
    private int age;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public CreateUserDTO(){
    }

    public CreateUserDTO(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
