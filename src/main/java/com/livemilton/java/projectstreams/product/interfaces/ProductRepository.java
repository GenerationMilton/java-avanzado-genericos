package com.livemilton.java.projectstreams.product.interfaces;

import com.livemilton.java.projectstreams.product.exceptions.InvalidProductException;
import com.livemilton.java.projectstreams.product.exceptions.ProductNotFoundException;
import com.livemilton.java.projectstreams.product.model.Product;
import com.livemilton.java.projectstreams.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll() throws InvalidProductException;
    Optional<Product> findById(Long id);
    void save(Product product);
    void delete(Long id);
    void update(Optional<Product> product) throws ProductNotFoundException;
    boolean existByid(Long id);

}
