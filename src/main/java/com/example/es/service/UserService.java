package com.example.es.service;

import com.example.es.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public List<User> findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public List<User> findByPhone(Long phone);
    public User save(User user);
}
