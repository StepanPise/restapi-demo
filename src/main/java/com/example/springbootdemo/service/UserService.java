package com.example.springbootdemo.service;

import com.example.springbootdemo.api.model.User;
import com.example.springbootdemo.dto.ResponseUserDTO;
import com.example.springbootdemo.dto.UpdateUserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1,"Eric",22,"user1@mail.cz" ,"heslo123"));
        users.add(new User(2, "Alice", 33, "user2@mail.cz", "heslo123"));
    }

    public int generateID() {
        int maxId = 0;
        for (User u : users) {
            if (u.getId() > maxId) {
                maxId = u.getId();
            }
        }
        return maxId + 1;
    }

    public ResponseUserDTO getUser(Integer id) {
        for (User u : users) {
            if (u.getId() == id) {
                ResponseUserDTO newResponseUserDTO = new ResponseUserDTO(u);
                return newResponseUserDTO;
            }
        }
        return null;
    }

    public List<ResponseUserDTO> getAllUsers() {

        List<ResponseUserDTO> responseList = new ArrayList<>();
        for (User u : users) {
            responseList.add(new ResponseUserDTO(u));
        }

        return responseList;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public void deleteUser(Integer id) {
        for (User u : users) {
            if (u.getId() == id) {
                users.remove(u);
            }
        }
    }

    public User updateUser(Integer id, UpdateUserDTO updateUserDTO) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == id) {

                User newUser = new User(id,updateUserDTO);

                users.set(i, newUser);
                return newUser;
            }
        }
        return null;
    }



}
