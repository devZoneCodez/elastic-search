package com.example.es.controller;

import com.example.es.dto.ProductDto;
import com.example.es.dto.UserDto;
import com.example.es.model.User;
import com.example.es.service.ProductService;
import com.example.es.service.UserService;
import com.example.es.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "add"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        //return productService.save(productDto)
        productDto.setProductDesc("Description has been edited!!!");
        return productDto;
    }

}
