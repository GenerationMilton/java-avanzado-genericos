package com.livemilton.java;


public class Box<T> {

    //Clase generica
    private T value;

    //constructor
    public Box(T value){
        this.value = value;
    }

    //getter and setter generico
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    //to string generico
    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }
}
