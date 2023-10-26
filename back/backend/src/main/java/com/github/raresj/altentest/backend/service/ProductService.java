package com.github.raresj.altentest.backend.service;

import java.util.List;

import com.github.raresj.altentest.backend.dto.ProductDto;

public interface ProductService {
    public List<ProductDto> getAllProducts();
    public ProductDto saveProduct(ProductDto product);
    public ProductDto getProductById(Integer id);
    public ProductDto updateProduct(Integer id, ProductDto productDto);
    public void deleteProduct(Integer id);
}
