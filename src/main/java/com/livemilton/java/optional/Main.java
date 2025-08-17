package com.livemilton.java.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //EXAMPLE 1
        Optional<String> name = Optional.of("Gabriel");

        if(name.isPresent()){
            System.out.println("El nombre esta presente");
        }


        //EXAMPLE 2
        String value = "Daniel";

        Optional<String> nick = Optional.ofNullable(value);
        Optional<String> empty = Optional.empty();

        if(empty.isPresent()){
            System.out.println("El nombre esta presente");
        }else {
            System.out.println("vacio");
        }


        //EXAMPLE 3
        Optional<String> greeding = Optional.of("Hola mundo");
        greeding.ifPresent(message -> System.out.println("Soy Milton: " + message));



    }
}
