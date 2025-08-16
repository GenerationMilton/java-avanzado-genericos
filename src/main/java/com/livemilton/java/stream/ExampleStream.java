package com.livemilton.java.stream;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStream {

    public static void main(String[] args) {
        List<Integer> number = List.of(1,2,3,4,5,6,7,8);
        Stream<Integer> streamNumbers = number.stream();
        streamNumbers.forEach( streamNum -> System.out.println(streamNum));

        Stream<String> stream = Stream.of("A","B","C");
        stream.forEach( streamEx -> System.out.println(streamEx));

        String[] array = {"X","Y","Z"};
        Stream<String> stream2 = Arrays.stream(array);
        stream2.forEach( stream2Ex-> System.out.println(stream2Ex));

        Stream<String> holaStream = Stream.generate(()-> "Hola Mundo!!").limit(3);
        holaStream.forEach(hola-> System.out.println(hola));


        //example 2
        List<String> names = List.of("Ana","Luis","Marta","Juan");

        names.stream()
                .filter(name -> name.length() >3)
                .map(name -> name.toUpperCase())
                .forEach(namesEx -> System.out.println(namesEx));
    }
}
