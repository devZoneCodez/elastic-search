package com.example.es.service;

import com.example.es.dto.ProductDto;
import com.example.es.model.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAll();
    public ProductDto findById(Long productId);
    public List<ProductDto> findByProductName(String productName);
    public ProductDto save(ProductDto productDto);
    public ProductDto delete(ProductDto productDto);
}
