package com.example.springbootdemo.service;

import com.example.springbootdemo.api.model.User;
import com.example.springbootdemo.dto.ResponseUserDTO;
import com.example.springbootdemo.dto.UpdateUserDTO;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDTO getUser(Integer id) {
        return userRepository.findById(id)
                .map(ResponseUserDTO::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public List<ResponseUserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(ResponseUserDTO::new).toList();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        userRepository.deleteById(id);
    }

    public User updateUser(Integer id, UpdateUserDTO updateUserDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        existingUser.setName(updateUserDTO.getName());
        existingUser.setAge(updateUserDTO.getAge());
        existingUser.setEmail(updateUserDTO.getEmail());
        existingUser.setPassword(updateUserDTO.getPassword());

        //existingUser = new User(id,updateUserDTO);

        return userRepository.save(existingUser);
    }



}
