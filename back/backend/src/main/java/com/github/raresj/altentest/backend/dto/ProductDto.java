package com.github.raresj.altentest.backend.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
    private String inventoryStatus;
    private String category;
    private String image;
    private Integer rating;
}
