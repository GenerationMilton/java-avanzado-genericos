package com.livemilton.java.threads.thread;

public class ThreadExample extends Thread{

    private String name;

    public ThreadExample(String name) {
        this.name=name;

    }

    //override run method
    @Override
    public void run() {
       for (int i =1; i<=5;i++){
           System.out.println(name + " Mensaje: " + i + " Ejecutando en: " + Thread.currentThread().getName());

           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               System.out.println(e.getMessage());
           }
       }
    }

    //execute run method
    public static void main(String[] args) {

        System.out.println("Inicio: " + Thread.currentThread().getName());

        ThreadExample threadExample = new ThreadExample("Proceso A");
        ThreadExample threadExample2 = new ThreadExample("Proceso B");

        threadExample.start();
        threadExample2.start();

        System.out.println("FIn del hilo principal");
    }
}
