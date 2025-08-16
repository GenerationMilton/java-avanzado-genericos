package com.livemilton.java.record;

public class Main {
    public static void main(String[] args) {

        Product product = new Product("TV",30000);
        product.getName();

        ProductDto productDto = new ProductDto("BICICLE",500);
        productDto.name();
        productDto.price();
        productDto.toString();
        ProductDto.methodStatic();
    }
}
