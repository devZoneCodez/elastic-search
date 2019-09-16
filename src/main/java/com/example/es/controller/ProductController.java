package com.example.es.controller;

import com.example.es.dto.ProductDto;
import com.example.es.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "all"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping(path = "find/{productId}"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto find(@PathVariable(name = "productId") String productId) {
        return productService.findById(productId);
    }

    @PostMapping(path = "add"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
        //productDto.setProductDesc("Description has been edited!!!");
        //return productDto;
    }

    @PostMapping(path = "addAll"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ProductDto> addProducts(@RequestBody List<ProductDto> products) {
        return productService.saveAll(products);
        //return products;
    }

    @PutMapping(path = "update/{productId}"
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto productDto
            , @PathVariable(name = "productId") String productId) {
        ProductDto p = productService.findById(productId);
        ProductDto savedProductDto = null;
        if (p != null) {
            savedProductDto = productService.save(productDto);
        }
        return savedProductDto;
    }

    @DeleteMapping("delete/{productId}")
    public ProductDto deleteProduct(@PathVariable(name = "productId") String productId) {
        ProductDto p = productService.findById(productId);
        ProductDto deletedProductDto = null;
        if (p != null) {
            deletedProductDto = productService.delete(p);
        }
        return deletedProductDto;
    }

    @GetMapping(path = "findAll/{productName}"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> findAll(@PathVariable(name = "productName") String productName) {
        return productService.findByProductName(productName);
    }

}
