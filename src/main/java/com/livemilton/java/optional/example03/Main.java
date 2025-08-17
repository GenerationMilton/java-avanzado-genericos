package com.livemilton.java.optional.example03;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //filter
        //EXAMPLE 1
        Optional<String> dni = Optional.of("1234567");

        Optional<String> result = dni.filter(d-> d.startsWith("1"));

        System.out.println("DNI: " + result.orElse("No valido") );

        //EXAMPLE 2
        Optional<String> email = Optional.ofNullable("    livemilton@devtalles.com      ");

        email.map( spaces -> spaces.trim())
                .filter(e-> e.contains("@"))
                .ifPresent( message -> System.out.println("Enviando correo a " + message));
    }
}
