package com.livemilton.java.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethodsExample {

    public static void main(String[] args) {
        //EXAMPLE 1
        List<String> names = List.of("Ana", "Luis", "Marta", "Juan", "Ana", "Fernando");
        List<String> longNames = names.stream()
                .filter(name -> name.length() >3 ) // filter by name with 3 letters
                .toList();
        System.out.println(longNames);

        //EXAMPLE 2 MAP

        List<Integer> lengthNames = names.stream()
                .map( name -> name.length())
                .collect(Collectors.toList());
        System.out.println(lengthNames);

        //EXAMPLE 3 FLATMAP
        List<List<Integer>> list = List.of(List.of(1,2), List.of(3,4));
        List<Integer> flatNames = list.stream()
                .flatMap(l -> l.stream()) // Stream of List to List into List
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(flatNames);

        //EXAMPLE 4 - DISTINC & SORTED
        List<Integer> numbers = List.of(3,1,3,5,2);
        List<Integer> uniqueOrderes = numbers.stream()
                .distinct()  //Delete duplicates
                .sorted()  //Sort the elements
                .toList();

        System.out.println(uniqueOrderes);

        //EXAMPLE 5  - SET
        Set<String> setNames = names.stream()
                .filter(n -> n.length() >2)
                .collect(Collectors.toSet());  //SET don't permit duplicates

        System.out.println(setNames);


        //EXAMPLE 6 - COUNT
        long count = names.stream()
                .filter(n -> n.contains("a"))
                .count();
        System.out.println(count);


        //EXAMPLE 7  - REDUCE Acumulador
        int sum = numbers.stream()
                .reduce(0, (result, number) -> result + number);

        System.out.println(sum);

        //EXAMPLE 8 - FOR EACH
        names.stream()
                .map( name-> name.toUpperCase())
                .forEach( name -> System.out.println(name));

    }
}
