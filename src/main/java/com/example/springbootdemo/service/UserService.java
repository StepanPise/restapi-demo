package com.example.springbootdemo.service;

import com.example.springbootdemo.api.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1,"Eric",22,"user1@mail.cz"));
        users.add(new User(2, "Alice", 33, "user2@mail.cz"));
    }

    public User getUser(Integer id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    public List<User> getAllUsers() {
        return users;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }
}
