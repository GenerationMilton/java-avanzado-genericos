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


        //example 3
        Stream<String> stream1 = Stream.of("Ana","Luis","Marta","Juan");
        //stream1.forEach( stream1Ex -> System.out.println(stream1Ex));  //Operacion Terminal

        List<String> stringsExample = stream1.toList();
        System.out.println(stringsExample);

        //example 4
        /*
        * Intemediate operations
        * Transform a Stream to another Stream
        * lazy: don't execute since a terminal operation been invoked.
         */
        List<String> namesIntermediate = Arrays.asList("Gabriel", "Fernando", "Maria", "Marta");

        Stream<String> filteredStream = names.stream()
                .filter(name ->{
                    System.out.println("Filtrando: " + name);
                    return name.startsWith("M");
                });
        System.out.println("Nothing has been printed");

        filteredStream.forEach( filterSr -> System.out.println(filterSr));

        //example 5
        /*
        * Terminal Operations
        * consume the Stream
        * Return a concrete result (List, number, print, etc)
        * An Stream only have been ONE terminal operation
        * */
        List<String> namesTerminal = Arrays.asList("Gabriel", "Fernando", "Maria", "Marta");

        long count = namesTerminal.stream()
                .filter(namesTer -> namesTer.startsWith("M")) //Intermediate Operation
                .count(); // Terminal

        System.out.println("Cantidad de nombres que empiezan con M: "+ count);


    }
}
