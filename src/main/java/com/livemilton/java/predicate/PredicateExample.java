package com.livemilton.java.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        //par
        Predicate<Integer> isEven = x -> x%2 == 0;
        boolean result = isEven.test(6);
        System.out.println("¿Es par?: " + result);

        //longitud cadena
        BiPredicate<String, Integer> checkLength =(str,len)->str.length() == len;

        result =checkLength.test("holanda", 7);
        System.out.println("¿Es igual: ? "+ result);
    }
}
