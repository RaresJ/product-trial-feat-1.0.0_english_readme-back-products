package com.github.raresj.altentest.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.raresj.altentest.backend.dto.ProductDto;
import com.github.raresj.altentest.backend.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
    private ProductService productService;

    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();

        return ResponseEntity.ok().body(products);
    }

    @PostMapping(path = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto createdProduct = productService.saveProduct(productDto);

        return ResponseEntity.ok().body(createdProduct);
    }

    @GetMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Integer productId) {
        ProductDto product = productService.getProductById(productId);

        return ResponseEntity.ok().body(product);
    }

    @PatchMapping(path = "/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Integer productId, @RequestBody ProductDto productDto) {
        ProductDto updatedProduct = productService.updateProduct(productId, productDto);

        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping(path = "/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer productId) {
        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
