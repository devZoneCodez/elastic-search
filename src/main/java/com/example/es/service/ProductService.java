package com.example.es.service;

import com.example.es.dto.ProductDto;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAll();
    public ProductDto findById(Long productId);
    public List<ProductDto> findByProductName(String productName);
    public ProductDto save(ProductDto productDto);
    public List<ProductDto> saveAll(List<ProductDto> products);
    public ProductDto delete(ProductDto productDto);
}
