package com.livemilton.java.optional.example04;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //EXAMPLE 1
        List<String> names = List.of("Juan", "Ana", "Andrea", "Teddy", "Ricardo");
        Optional<String> first = names.stream().findFirst();
        first.ifPresent(name -> System.out.println("El primero es: " + name));

        //EXAMPLE 2
        List<String> emptyList = List.of();
        Optional<String> firstEmpty = emptyList.stream().findFirst();
        System.out.println("¿Esta presente? " + firstEmpty.isPresent());

        //EXAMPLE 3
        record Product(String name , double price){}

        List<Product> products = List.of(
                new Product("TV", 200),
                new Product("Netbook", 400)
        );

        Optional<Product> maybeTv = products.stream()
                .filter(p -> p.name().equalsIgnoreCase("TV"))
                .findFirst();

        Product result = maybeTv.orElse(new Product("Generico", 0));
        System.out.println("Resultado: "+ result.name + "- $" + result.price);

        //EXAMPLE 4
        String maybeName = "Milton";

        Optional.ofNullable(maybeName)
                .ifPresentOrElse(
                        name -> System.out.println("Nombre encontrado: " + name.toUpperCase()),
                        ()-> System.out.println("No se encontro nungun nombre")
                );


        //EXAMPLE 5
        List<Optional<String>> optionals = List.of(
                Optional.of("Hola"),
                Optional.empty(),
                Optional.of("Chao")
        );

        optionals
                .stream().filter(op -> op.isPresent())
                .map(optionalGet -> optionalGet.get())
                .forEach(System.out::println);

    }
}
