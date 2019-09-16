package com.example.es.service;

import com.example.es.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAll();
    public ProductDto findById(String productId);
    public List<ProductDto> findByProductName(String productName);
    public ProductDto save(ProductDto productDto);
    public List<ProductDto> saveAll(List<ProductDto> products);
    public Boolean isExists(String productId);
    public ProductDto delete(ProductDto productDto);
}
