package com.livemilton.java.optional.example02;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //EXAMPLE 1

        Optional<String> name = Optional.of("Milton");

        Optional<String> nameUpperCase = name.map( n -> n.toUpperCase());

        System.out.println("Nombre en Mayuscula "+ nameUpperCase.orElse("Sin nombre"));

        //EXAMPLE 2 map

        Optional<String> name_2 = Optional.of("        miltoneladas      ");
        String nameLowerCase = name_2
                .map( spaces -> spaces.trim())
                .map( lower -> lower.toLowerCase())
                .orElse("Sin nombre");
        System.out.println("Username "+ nameLowerCase);


        //FLATMAP
        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.of("Valor interno"));
        Optional<String> resultFlapMap = optionalOfOptional.flatMap(op -> op );

        System.out.println(resultFlapMap);

    }
}
