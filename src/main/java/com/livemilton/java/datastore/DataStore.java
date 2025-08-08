package com.livemilton.java.datastore;

import java.util.*;

public class DataStore<T, K>{

    private final List<T> dataList;
    private final Map<K,T> dataMap;

    public DataStore() {
        this.dataList = new ArrayList<>();
        this.dataMap = new HashMap<>();
    }

    //metodo add
    public boolean add(K key, T item){
        Objects.requireNonNull(key,"La clave no puede ser nula");
        Objects.requireNonNull(item, "El item no puede ser nulo");

        if(dataMap.containsKey(key)){
            return false;
        }
        dataList.add(item);
        dataMap.put(key,item);
        return true;
    }


    //metodo remove
    public T remove(K key){
        Objects.requireNonNull(key, "La clave no puede ser nula");
        T item = dataMap.remove(key);
        if(item !=null){
            dataList.remove(item);
        }
        return item;
    }

    //metodo encontrar
    public T find(K key){
        Objects.requireNonNull(key, "La clave no puede ser nula");
        return dataMap.get(key);
    }

    //metodo traer todo
    public List<T> getAll() {
        return Collections.unmodifiableList(dataList);
    }

}
