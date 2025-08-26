package com.livemilton.java.threads.scheduleTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {

    public static void main(String[] args) {

        //SCHEDULE EXECUTOR SERVICE
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule( ()-> {
            System.out.println("Task after 4 seconds");
        }, 4, TimeUnit.SECONDS);


        executorService.schedule( ()-> {
            System.out.println("Task after 5 seconds");
        }, 5, TimeUnit.SECONDS);
        //executorService.shutdown(); Cierra la tarea

        //TIMER
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea de seis segundos");
                //timer.cancel();
            }
        }, 6000);


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = new Runnable() {
            int counter=0;

            @Override
            public void run() {
                System.out.println("Enviando recordatorio");
                counter++;

                if(counter>3){
                    System.out.println("Se enviaron todos los recordatorios");
                    scheduledExecutorService.shutdown();
                }

            }
        };

        scheduledExecutorService.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);

    }
}
