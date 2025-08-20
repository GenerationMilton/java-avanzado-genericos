package com.livemilton.java.threads.executor;

import com.livemilton.java.threads.thread.ThreadExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVsExecutor {

    public static void main(String[] args) {
        System.out.println("Con Thread --------------");
        for(int i=1; i<4; i++){
            new Thread(
                    ()-> System.out.println("Tarea A "  + Thread.currentThread().getName())
            ).start();
        }

        System.out.println("Con Executor------------");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 1;i<4; i++){
            executorService.execute(
                    ()-> System.out.println("Tarea A Executor " + Thread.currentThread().getName())
            );
        }

        executorService.shutdown();
    }
}
