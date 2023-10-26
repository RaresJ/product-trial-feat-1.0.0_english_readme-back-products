package com.github.raresj.altentest.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void updateFrom(Product newProduct) {
        this.code = newProduct.getCode();
        this.name = newProduct.getName();
        this.description = newProduct.getDescription();
        this.price = newProduct.getPrice();
        this.quantity = newProduct.getQuantity();
        this.inventoryStatus = newProduct.getInventoryStatus();
        this.category = newProduct.getCategory();
        this.image = newProduct.getImage();
        this.rating = newProduct.getRating();
    }
}
