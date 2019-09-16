package com.example.es.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDesc;
}
