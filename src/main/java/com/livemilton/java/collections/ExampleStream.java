package com.livemilton.java.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStream {

    public static void main(String[] args) {

        //example 1
        List<String> fruits = Arrays.asList("Manzana", "Banana","Kiwi");

        List<String> filterFruits = fruits.stream()
                .filter(f-> f.length() >5)
                .toList();

        System.out.println(fruits);
        System.out.println(filterFruits);

        List<Integer> numbers = Arrays.asList(1,3,4,5,6,7,8,9);
        Stream<Integer> integerStream = numbers.stream().map( n->n*n);
        List<Integer> numberSquare = integerStream.toList();
        System.out.println(numberSquare);
    }
}
