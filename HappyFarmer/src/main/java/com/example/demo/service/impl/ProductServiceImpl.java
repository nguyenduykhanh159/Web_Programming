package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.MockDataRepo;
import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private final MockDataRepo dataRepo;

    @Autowired
    public ProductServiceImpl(MockDataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return dataRepo.getAllProducts();
    }

    @Override
    public ProductModel getProduct(int prodId) {
        return dataRepo.getProduct(prodId);
    }

    @Override
    public void addProduct(ProductModel prod) {
        dataRepo.addProduct(prod);
    }
}
