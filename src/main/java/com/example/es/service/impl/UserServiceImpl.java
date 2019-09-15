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
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> findByPhone(Long phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }
}
