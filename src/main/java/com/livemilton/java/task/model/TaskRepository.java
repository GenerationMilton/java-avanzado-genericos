package com.livemilton.java.task.model;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    List<Task> tasks = new ArrayList<>();

    //guardar tarea
    public void save(Task task){
        tasks.add(task);
    }

    //encontrar tarea por id
    public Task findById(String id){
        for(Task task: tasks){
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }

    ///eliminar tarea
    public void remove(String id){
        Task task = findById(id);
        tasks.remove(task);
    }

    //encontrar las tareas
    public List<Task> findAll(){
        return tasks;
    }

    //Encontrar indice
    public int findIndexById(String id){
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
