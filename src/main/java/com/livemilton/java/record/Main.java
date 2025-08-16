package com.livemilton.java.record;

import java.util.List;
import java.util.Map;
import java.util.Set;
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

        // 2. Reduccion matematica
        Double total = products.stream()
                .map(productDto -> productDto.price())
                .reduce(0.0, (sum, price)-> sum + price);

        System.out.println(total);

        //
        String productSummary = products.stream()
                .map(p-> p.name() + "( $" + p.price() + " )")
                .reduce("",(s1, s2) ->{
                    if (s1.isEmpty()){
                        return s2;
                    }else {
                        return  s1 + " | " + s2;
                    }
                });

        System.out.println(productSummary);

        //Conversion between collection
        Set<Double> uniquePrices = products.stream()
                .map(ProductDto::price)
                .collect(Collectors.toSet());

        System.out.println(uniquePrices);

        Map<String, Double> productMap = products.stream()
                .collect(Collectors.toMap(
                        ProductDto::name,
                        ProductDto::price
                ));
        System.out.println(productMap);

    }
}
