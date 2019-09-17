package com.example.es.service.impl;

import com.example.es.config.AppMessage;
import com.example.es.dto.ProductDto;
import com.example.es.exception.RecordNotFoundException;
import com.example.es.model.Product;
import com.example.es.repo.ProductRepository;
import com.example.es.service.ProductService;
import com.example.es.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Converter converter;

    @Autowired
    private AppMessage appMessage;

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> products = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findAll();
        productIterable.forEach(product -> {
            products.add(converter.convertToDto(product));
        });
        return products;
    }

    @Override
    public ProductDto findById(String productId) {
        /*if (productId != null) {
            String error = MessageFormat.format(appMessage.getProperty("product.not.exists"), productId);
            throw new RecordNotFoundException(error);
        }*/
        Optional<Product> product = productRepository.findById(productId);

        if (!product.isPresent()) {
            String errorMsg = MessageFormat.format(appMessage.getProperty("product.not.exists"), productId);
            throw new RecordNotFoundException(errorMsg);
        }
        return converter.convertToDto(product.get());
    }

    @Override
    public List<ProductDto> findByProductName(String productName) {
        List<ProductDto> products = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findByProductName(productName);
        productIterable.forEach(product -> {
            products.add(converter.convertToDto(product));
        });
        return products;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product p = productRepository.save(converter.convertToEntity(productDto));
        return converter.convertToDto(p);
    }

    @Override
    public List<ProductDto> saveAll(List<ProductDto> productList) {
        List<Product> products = new ArrayList<>();
        productList.forEach(p -> {
            products.add(converter.convertToEntity(p));
        });
        Iterable<Product> savedProductList = productRepository.saveAll(products);
        List<ProductDto> savedProductDtoList = new ArrayList<>();
        savedProductList.forEach(p -> {
            savedProductDtoList.add(converter.convertToDto(p));
        });
        return savedProductDtoList;
    }

    @Override
    public Boolean isExists(String productId) {
        return productRepository.existsById(productId);
    }

    @Override
    public ProductDto delete(ProductDto productDto) {
        productRepository.delete(converter.convertToEntity(productDto));
        return productDto;
    }

}
