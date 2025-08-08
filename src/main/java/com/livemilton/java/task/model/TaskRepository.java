package com.livemilton.java.task.model;

import com.livemilton.java.task.excepciones.TaskException;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    List<Task> tasks = new ArrayList<>();

    //guardar tarea
    public void save(Task task){
        if(task==null){
            throw new TaskException("La tarea no puede ser nula");
        }
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
        if(task==null){
            throw new TaskException("La tarea no puede ser nula");
        }
        tasks.remove(task);
    }


    ///eliminar tarea
    public void remove(Task task){

        if(task==null){
            throw new TaskException("La tarea no puede ser nula");
        }
        if(!tasks.contains(task)){
            throw new TaskException("La tarea no existe en la lista");
        }
        tasks.remove(task);
    }

    //encontrar las tareas
    public List<Task> findAll(){
        if(tasks.isEmpty()){
            throw new TaskException("La lista esta vacia");
        }
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

    //Actualizar
    public void updateTask(Task updateTask){
        if(updateTask==null){
            throw new TaskException("La tarea no puede ser nula");
        }
        int index = findIndexById(updateTask.getId());

        if(index ==-1){
            throw new TaskException("El indice no es valido");
        }
        tasks.set(index, updateTask);

    }
}
