package com.livemilton.java.task.view;

import com.livemilton.java.task.controller.TaskController;
import com.livemilton.java.task.excepciones.TaskException;
import com.livemilton.java.task.excepciones.TaskValidationException;
import com.livemilton.java.task.model.Task;

import java.util.Scanner;

public class TaskView {

    private final TaskController taskController;
    private final Scanner scanner;


    public TaskView(TaskController taskController) {
        this.taskController = taskController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() throws TaskValidationException, TaskException {
        while(true){
            System.out.println("\n Gestion de Tareas");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Eliminar Tareas");
            System.out.println("3. Actualizar Tarea");
            System.out.println("4. Mostrar Tareas");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion");

            String option = scanner.nextLine();
            switch (option){
                case "1":
                    addTaskView();
                     break;

                case "2":
                    removeTaskView();
                    break;

                case "3":
                    updateTaskView();
                    break;

                case "4":
                    showTaskView();
                    break;

                case "5":
                    System.out.println("Saliendo del sistema");
                    return;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente");

            }
        }
    }

    public void addTaskView() throws TaskValidationException, TaskException {

        Task task = getTaskInput();
        taskController.addTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());
        System.out.println("Tarea agregada correctamente");
    }

    public void removeTaskView() throws TaskValidationException, TaskException {
        System.out.println("Ingrese el Id a eliminar");
        String id= scanner.nextLine();
        this.taskController.removeTask(id);
        System.out.println("Tarea eliminada correctamente");
    }

    public void showTaskView() throws TaskValidationException, TaskException {
        System.out.println("\nLa lista de Tareas");
        this.taskController.showTask();
    }


    public void  updateTaskView() throws TaskValidationException, TaskException {

        Task task = getTaskInput();
        taskController.updateTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());
        System.out.println("Tarea actualizada correctamente");
    }

    private Task getTaskInput(){

        String id;
        do{
            System.out.println("Ingresar ID");
            id = scanner.nextLine();
            if(id.isEmpty()){
                System.out.println("El id no puede estar vacio");
            }
        }while(id.isEmpty());

        String title;
        do{
            System.out.println("Ingrese el TItulo");
            title= scanner.nextLine();
            if(title.isEmpty()){
                System.out.println("El titulo no puede estar vacio");
            }
        }while (title.isEmpty());

        String description;
        do{
            System.out.println("Ingrese la descripcion");
            description= scanner.nextLine();
            if(description.isEmpty()){
                System.out.println("La descripcion no puede estar vacia");
            }
        }while (description.isEmpty());

        Boolean completed = null;
        while(completed==null){
            System.out.println("Esta completada? true/false");
            String input = scanner.nextLine().trim().toLowerCase();
            if(input.equals("true")){
                completed=true;
            }else if(input.equals("false")){
                completed=false;
            }else {
                System.out.println("El valor ingresado no es correcto, ingrese: 'true' o 'false' ");
            }
        }


        return new Task (id, title, description,completed);
    }
}
