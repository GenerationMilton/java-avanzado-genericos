package com.livemilton.java.projectstreams.product.service;

import com.livemilton.java.projectstreams.product.exceptions.InvalidProductException;
import com.livemilton.java.projectstreams.product.exceptions.ProductNotFoundException;
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
    * save product
    * */
    public void saveProduct(Product product) throws InvalidProductException {
        ProductValidator.validate(product);
        if(!productRepository.existByid(product.getId())){
            productRepository.save(product);
            System.out.println("Producto guardado...");
        } else {
            throw new InvalidProductException("El producto que dese agregar, ya existe!");
        }
    }

    /*
    * Delete product
    * */
    public void deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.delete(id);
            System.out.println("El producto fue eliminado");
        } else {
            throw new ProductNotFoundException("El producto que desea eliminar no existe");
        }
    }

    /*
     * Update product
     * */
    public void updateProduct(Product product) throws ProductNotFoundException, InvalidProductException {
        ProductValidator.validate(product);
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            productRepository.update(optionalProduct);
            System.out.println("El producto fue actualizado");
        } else {
            throw new ProductNotFoundException("El producto que desea actualizar no existe");
        }
    }


}
