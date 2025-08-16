package com.livemilton.java.record;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*
        Product product = new Product("TV",30000);
        product.getName();

        ProductDto productDto = new ProductDto("BICICLE",500);
        productDto.name();
        productDto.price();
        productDto.toString();
        ProductDto.methodStatic();

         */

        //EXAMPLE 1 STREAMS ADVANCED
        List<ProductDto> products = List.of(
                new ProductDto("Notebook", 1200.0),
                new ProductDto("Mouse", 25.5),
                new ProductDto("Keyboard", 55.0)
        );

        List<String> discountedProducts = products.stream()
                .map(productDto -> new ProductDto(productDto.name(), productDto.price()))
                .map(productDto -> String.format("%s: $%.2f", productDto.name(), productDto.price()*0.9))
                .toList();
        System.out.println(discountedProducts);



        //Example 2 advanced agroupation
        Map<String, List<ProductDto>> byPriceRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price() >50.0 ? "Caro" : "Barato"
                ));

        Map<String, Long> countByRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price() >50.0 ? "Caro" : "Barato",
                        Collectors.counting()
                ));

        System.out.println(byPriceRange);
        System.out.println(countByRange);
    }
}
