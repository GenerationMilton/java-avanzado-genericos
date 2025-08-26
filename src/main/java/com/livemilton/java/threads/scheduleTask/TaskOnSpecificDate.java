package com.livemilton.java.threads.scheduleTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskOnSpecificDate {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.of(2025,8,25,21,47);
        LocalDateTime now = LocalDateTime.now();

        long delay = Duration.between(now, dateTime).toMillis();

        if(delay<0){
            System.out.println("La fecha ya paso...");
            return;
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.schedule( ()-> {
            System.out.println("Tarea despues de 4 segundos");
            executorService.shutdown();
        }, delay, TimeUnit.MILLISECONDS);

    }
}
