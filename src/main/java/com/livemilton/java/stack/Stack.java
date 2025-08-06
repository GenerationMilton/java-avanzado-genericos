package com.livemilton.java.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack <T>{
    private final List<T> elements = new ArrayList<>();

    //añadir
    public void push(T element){
        elements.add(element);
        System.out.println("Elemento agregado... " + element);
    }
    
    
    //validar si esta vacia
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    
    //traer elementos de la 1 posicion
    public T peek() throws IllegalAccessException {
        if(isEmpty()){
            throw new IllegalAccessException("la pila esta vacia");
        }
        return elements.get(elements.size()-1);
    }

    //retirar elemento encima de la pila
    public T pop() throws IllegalAccessException {
        if(isEmpty()){
            throw new IllegalAccessException("la pila esta vacia");
        }
        return elements.remove(elements.size()-1);
    }

    //imprimir elements
    public void print(){
        for(Object o: elements){
            System.out.println(o);
        }
    }
}
