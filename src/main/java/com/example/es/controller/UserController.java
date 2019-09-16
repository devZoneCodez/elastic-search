package com.example.es.controller;

import com.example.es.dto.UserDto;
import com.example.es.model.User;
import com.example.es.service.UserService;
import com.example.es.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter converter;

    @PostMapping(path = "add"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = converter.convertToEntity(userDto);
        user.setFirstName("Name has been edited in the controller");
        UserDto tempDto = converter.convertToDto(user);
        return tempDto;
    }

}
