package com.ttk.mapper;

import com.ttk.entities.Product;

import java.util.List;

public interface ProductMapper {

    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}
