package com.livemilton.java.threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownComparison {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=1; i<5; i++){
            final int taskId= i;
            executorService.submit(()-> {
                System.out.println("Tarea iniciando con Executor " + taskId
                        + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("Tarea " +  taskId + " fue interrumpida");
                    return;
                }
                System.out.println("Tarea finalizada");
            });
        }
        Thread.sleep(5000);

        boolean error = true;

        if(error){
            System.out.println("Situacion Critica");
            executorService.shutdownNow();
        }else{
            System.out.println("Finalizacion ordenada");
            executorService.shutdown();
        }









    }
}
