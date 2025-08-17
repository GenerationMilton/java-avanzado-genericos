package com.livemilton.java.optional.example01;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //EXAMPLE 1 CLASSIC
        /*
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre");
        String name = scanner.nextLine();

        Optional<String> optionalName = Optional.empty();

        if(name.isEmpty()){
            name = optionalName.orElse("Invitado");
        }
        System.out.println(name);
        */
        //EXAMPLE 2 IMPERATIVE

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre");
        String nameInput = scanner.nextLine();

        Optional<String> optional = Optional.ofNullable(nameInput)
                .filter(name -> !name.isEmpty());

        //ELSE GET or ELSE THROW
        //String name = optional.orElseGet(()-> "Invitado");
        String name = optional.orElseThrow(()-> new IllegalStateException("Error no hay name...."));
        System.out.println(name);

        scanner.close();

    }
}
