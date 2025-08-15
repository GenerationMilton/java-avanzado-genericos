package com.livemilton.java.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<String, Integer> stringLength = str -> str.length();
        int length = stringLength.apply("programacion");
        System.out.println("La longitud es: " + length);

        BiFunction<Integer, Integer, String> sumToString =(a,b)-> "Resultado: "+ (a+b);
        String result = sumToString.apply(7,5);

        System.out.println(result);
    }
}
