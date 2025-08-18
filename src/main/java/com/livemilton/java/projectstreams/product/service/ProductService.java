package com.livemilton.java.projectstreams.product.service;

import com.livemilton.java.projectstreams.product.exceptions.InvalidProductException;
import com.livemilton.java.projectstreams.product.interfaces.ProductRepository;
import com.livemilton.java.projectstreams.product.model.Product;

import java.util.List;
import java.util.Optional;


public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    /*
    * Get all products
    * */
    public List<Product> getAllProducts() throws InvalidProductException {
        return productRepository.findAll();
    }
    /*
     * Get products by id
     * */
    public Optional<Product>getProductById(Long id){
        return productRepository.findById(id);
    }

    /*
    *
    * */

}
