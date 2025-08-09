package com.livemilton.java.task.controller;

import com.livemilton.java.task.excepciones.TaskException;
import com.livemilton.java.task.model.Task;
import com.livemilton.java.task.model.TaskRepository;

import java.util.List;

public class TaskController {

    private final TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String id, String title, String description, Boolean completed){
        Task task = new Task(id, title,description,completed);
        this.taskRepository.save(task);
        System.out.println("La tarea fue agregada exitosamente.");
    }

    public void removeTask(String id){
        try{
            this.taskRepository.remove(id);
        }catch (TaskException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void showTask(){
        List<Task> tasks= this.taskRepository.findAll();

        for(Task task: tasks){
            System.out.println(task);
        }
    }

    public void updateTask(String id, String title, String description, Boolean completed){
        Task updateTask = new Task(id, title, description, completed);
        this.taskRepository.updateTask(updateTask);
    }

}
