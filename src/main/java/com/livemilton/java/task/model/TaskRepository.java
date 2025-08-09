package com.livemilton.java.task.model;

import com.livemilton.java.task.excepciones.TaskException;
import com.livemilton.java.task.persistence.TaskPersistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    List<Task> tasks;

    public TaskRepository() throws FileNotFoundException {
        tasks = TaskPersistence.loadTasks();
    }

    //guardar tarea
    public void save(Task task) throws TaskException {
        if(task==null){
            throw new TaskException("La tarea no puede ser nula");
        }
        tasks.add(task);
        TaskPersistence.saveTasks(tasks);
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
    public void remove(String id) throws TaskException {
        Task task = findById(id);
        if(task==null){
            throw new TaskException("La tarea no puede ser nula");
        }
        tasks.remove(task);
        TaskPersistence.saveTasks(tasks);
    }


    ///eliminar tarea
    public void remove(Task task) throws TaskException {

        if(task==null){
            throw new TaskException("La tarea no puede ser nula");
        }
        if(!tasks.contains(task)){
            throw new TaskException("La tarea no existe en la lista");
        }
        tasks.remove(task);
        TaskPersistence.saveTasks(tasks);
    }

    //encontrar las tareas
    public List<Task> findAll() throws TaskException {
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
    public void updateTask(Task updateTask) throws TaskException {
        if(updateTask==null){
            throw new TaskException("La tarea no puede ser nula");
        }
        int index = findIndexById(updateTask.getId());

        if(index ==-1){
            throw new TaskException("El indice no es valido");
        }
        tasks.set(index, updateTask);
        TaskPersistence.saveTasks(tasks);
    }
}
