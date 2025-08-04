package com.livemilton.java;

public class MathUtils {

    //method inside a class that extends Number
    public static <T extends  Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();

    }
}
