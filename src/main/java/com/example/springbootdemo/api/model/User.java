package com.example.springbootdemo.api.model;

import com.example.springbootdemo.dto.CreateUserDTO;

public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String password;

    public User(int id, String name, int age, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public User(int id, CreateUserDTO createUserDTO) {
        this.id = id;
        this.name = createUserDTO.getName();
        this.age = createUserDTO.getAge();
        this.email = createUserDTO.getEmail();
        this.password = createUserDTO.getPassword();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
