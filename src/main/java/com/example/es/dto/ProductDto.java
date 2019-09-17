package com.example.es.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductDto implements Serializable {
    private String productId;
    private String productName;
    private String productDesc;
}
