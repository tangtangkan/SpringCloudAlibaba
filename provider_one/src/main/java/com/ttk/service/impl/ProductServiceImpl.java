package com.ttk.service.impl;

import com.ttk.entities.Product;
import com.ttk.mapper.ProductMapper;
import com.ttk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Product findById(Long pid) {
        return productMapper.findById(pid);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }
}
