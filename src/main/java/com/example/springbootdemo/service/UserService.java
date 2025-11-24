package com.example.springbootdemo.service;

import com.example.springbootdemo.api.model.User;
import com.example.springbootdemo.dto.ResponseUserDTO;
import com.example.springbootdemo.dto.UpdateUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
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
                return;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }

    public User updateUser(Integer id, UpdateUserDTO updateUserDTO) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == id) {

                User newUser = new User(id,updateUserDTO);

                users.set(i, newUser);
                return newUser;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }



}
