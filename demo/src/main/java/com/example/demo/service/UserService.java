package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService{
    List<User> getAllUsers();
    User findByUsername(String username);
    User getById(Long id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);


}
