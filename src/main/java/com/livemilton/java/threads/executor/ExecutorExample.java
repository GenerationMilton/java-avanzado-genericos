package com.livemilton.java.threads.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute( () -> System.out.println("Tarea A " + Thread.currentThread().getName()));
        executorService.execute( () -> System.out.println("Tarea B " + Thread.currentThread().getName()));
        executorService.execute( () -> System.out.println("Tarea C " + Thread.currentThread().getName()));
        executorService.shutdown(); //method that awaits finish task and close the resource.
    }

}
