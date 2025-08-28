package com.livemilton.java.project2.reactive;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,5);
        
        long start = System.currentTimeMillis();
        
        numbers.parallelStream().map(
                n-> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Procesando numero: " + n);
                    return n * 2;
                }).forEach(System.out::println);
        
        long end = System.currentTimeMillis();
        System.out.println(" Tiempo total (secuencial): " + (end - start) + " ms");
    }
}
