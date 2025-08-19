package com.livemilton.java.projectstreams.product.controller;

import com.livemilton.java.projectstreams.product.exceptions.InvalidProductException;
import com.livemilton.java.projectstreams.product.exceptions.ProductNotFoundException;
import com.livemilton.java.projectstreams.product.model.Product;
import com.livemilton.java.projectstreams.product.service.ProductService;
import com.livemilton.java.projectstreams.product.utils.Validates;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //add product
    public void addProduct(Product product) throws InvalidProductException {
        Validates.validateObject(product, "El producto no puede ser un dato nulo");
        productService.saveProduct(product);
    }

    //remove product
    public void removeProduct(Long id) throws ProductNotFoundException, InvalidProductException {
        Validates.validateNumber(id, "EL id no puede ser nulo");
        productService.deleteProduct(id);
    }
    //get all
    public List<Product> getAllProduct() throws InvalidProductException {
        return productService.getAllProducts();
    }
    //get product by Id
    public Optional<Product> getProductById(Long id) throws InvalidProductException {
        Validates.validateNumber(id, "EL id no puede ser nulo");
        return productService.getProductById(id);
    }

    //update
    public void updateProduct(Product product) throws ProductNotFoundException, InvalidProductException {
        Validates.validateObject(product, "El producto no puede ser un dato nulo");
        productService.updateProduct(product);
    }




}
