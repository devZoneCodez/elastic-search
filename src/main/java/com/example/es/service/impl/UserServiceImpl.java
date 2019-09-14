package com.example.es.service.impl;

import com.example.es.model.User;
import com.example.es.repo.UserRepository;
import com.example.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Iterable<User> iterableUsers = userRepository.findAll();
        iterableUsers.forEach(users::add);
        return users;
    }

    @Override
    public List<User> findByFirstName() {
        return userRepository.findByFirstName();
    }

    @Override
    public List<User> findByLastName() {
        return userRepository.findByLastName();
    }

    @Override
    public List<User> findByPhone() {
        return userRepository.findByPhone();
    }
}
