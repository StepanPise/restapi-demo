package com.example.springbootdemo.dto;

public class ResponseUserDTO {
    private int id;
    private String name;
    private int age;
    private String email;

    public ResponseUserDTO() {}

    public ResponseUserDTO(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
