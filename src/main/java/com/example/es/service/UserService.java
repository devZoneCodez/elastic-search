package com.example.es.service;

import com.example.es.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public List<User> findByFirstName();
    public List<User> findByLastName();
    public List<User> findByPhone();
}
