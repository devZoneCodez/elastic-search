package com.example.es.util;

import com.example.es.dto.ProductDto;
import com.example.es.dto.UserDto;
import com.example.es.model.Product;
import com.example.es.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Autowired
    private ModelMapper userModelMapper;

    @Autowired
    private ModelMapper productModelMapper;

    public User convertToEntity(UserDto userDto) {
        User user = userModelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto convertToDto(User userEntity) {
        UserDto userDto = userModelMapper.map(userEntity, UserDto.class);
        return userDto;
    }

    public Product convertToEntity(ProductDto productDto) {
        Product product = productModelMapper.map(productDto, Product.class);
        return product;
    }

    public ProductDto convertToDto(Product productEntity) {
        ProductDto productDto = productModelMapper.map(productEntity, ProductDto.class);
        return productDto;
    }
}
