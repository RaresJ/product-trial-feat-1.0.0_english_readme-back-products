package com.github.raresj.altentest.backend.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.raresj.altentest.backend.dto.ProductDto;
import com.github.raresj.altentest.backend.entity.Product;
import com.github.raresj.altentest.backend.repository.ProductRepository;
import com.github.raresj.altentest.backend.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
            .map(product -> modelMapper.map(product, ProductDto.class))
            .toList();
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);

        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public ProductDto getProductById(Integer id) {
        return modelMapper.map(productRepository.findById(id).orElse(null), ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(Integer id, ProductDto productDto) {
        Product newProduct = modelMapper.map(productDto, Product.class);
        Product oldProduct = productRepository.getReferenceById(id);

        oldProduct.updateFrom(newProduct);
        oldProduct = productRepository.save(oldProduct);

        return modelMapper.map(oldProduct, ProductDto.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
