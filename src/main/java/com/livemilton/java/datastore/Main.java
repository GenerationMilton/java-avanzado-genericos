package com.livemilton.java.datastore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStore<User, String> userStore= new DataStore<>();

        try{
            System.out.println("Añadiendo usuarios... ");

            //Add
            userStore.add("123", new User("123","Fernando"));
            userStore.add("1234", new User("1234","Maria"));
            userStore.add("12345", new User("12345","Ana"));
            //userStore.add(null, new User("12345", "Ana"));

            //find
            System.out.println("Encontrado: " + userStore.find("123"));

            //eliminado
            System.out.println("Eliminado: " + userStore.remove("123"));


        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        //imprimir usuarios agregados

        List<User> users = userStore.getAll();
        for (User user: users){
            System.out.println(user);
        }


    }
}
