package com.livemilton.java.threads.scheduleTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule( ()-> {
            System.out.println("Task after 4 seconds");
        }, 4, TimeUnit.SECONDS);


        executorService.schedule( ()-> {
            System.out.println("Task after 5 seconds");
        }, 5, TimeUnit.SECONDS);
        //executorService.shutdown(); Cierra la tarea

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea de seis segundos");
                timer.cancel();
            }
        }, 6000);

    }
}
