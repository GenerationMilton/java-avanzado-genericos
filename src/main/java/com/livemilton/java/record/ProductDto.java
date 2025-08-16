package com.livemilton.java.record;

public record ProductDto(String name, double price) {

    /*
    * Inmutables, don't change his values , dont use setter, I can add logic
    * */

    public static String ATRIBUTO = "Hola";
    public ProductDto {
    }

    public ProductDto(String name) {
        this(name, 0);
    }

    public static void methodStatic(){
        System.out.println("Hola, soy un metodo...");
    }
}
