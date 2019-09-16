package com.example.es.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "products", type = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Long productId;
    private String productName;
    private String productDesc;
}
