package com.livemilton.java.ternarios;

public class ternarios {
    public static void main(String[] args) {
        int age = 20;
        String message;
        String message2;

        //Example 1
        if(age >=18 ){
            message="Mayor de edad";
        } else {
            message="Menor de edad";
        }

        System.out.println(message);

        message2 = age >=18 ? "Mayor de edad" : "Menor de edad";
        System.out.println(message2);


        //Example 2
        int score = 75;
        String level;

        /*
        if(score >= 90){
            level= "Excelente";
        } else if (score>=70) {
            level ="Bueno";
        } else {
            level= "Regular";
        }
        */

        level= score >=90 ? "Excelente" : score>=70 ? "Bueno" : "regular";
        System.out.println(level);



        //Example 3
        int accessLevel = 2;
        String accessMessage = "Acceso denegado. ";

        /*
        if(accessLevel >= 1){
            if(accessLevel>=3){
                accessMessage= "Acceso total.";

            }else {
                accessMessage = "Acceso parcial.";
            }
        } else {
            accessMessage ="Acceso Denegado";
        }
        */

        accessMessage = accessLevel >=1 ? ( accessLevel>=3 ? "Acceso Total." : "Acceso Parcial" ): "Acceso Denegado";
        System.out.println(accessMessage);

    }
}
