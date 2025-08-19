package com.livemilton.java.projectstreams.product.service;

import com.livemilton.java.projectstreams.product.exceptions.InvalidProductException;
import com.livemilton.java.projectstreams.product.model.Product;

public class ProductValidator {

    public static void validate(Product product) throws InvalidProductException {
        if(product.getPrice()<=0){
            throw new InvalidProductException("El precio debe ser mayor a cero");
        }
        if(product.getStock() <0){
            throw new InvalidProductException("El stcok no puede ser negativo");
        }
    }
}
