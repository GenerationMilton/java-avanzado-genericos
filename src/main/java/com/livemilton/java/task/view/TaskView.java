package com.livemilton.java.task.view;

import com.livemilton.java.task.controller.TaskController;
import com.livemilton.java.task.excepciones.TaskException;
import com.livemilton.java.task.excepciones.TaskValidationException;

import java.util.Scanner;

public class TaskView {

    private final TaskController taskController;
    private final Scanner scanner;


    public TaskView(TaskController taskController, Scanner scanner) {
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
                    break;

                case "3":
                    break;

                case "4":
                    break;

                case "5":
                    break;

            }
        }
    }

    public void addTaskView() throws TaskValidationException, TaskException {
        System.out.println("Ingresar ID");
        String id = scanner.nextLine();

        System.out.println("Ingrese el Título");
        String title= scanner.nextLine();

        System.out.println("Ingresar la descripcion");
        String description = scanner.nextLine();

        System.out.println("Esta completada? true/false");
        Boolean completed = Boolean.parseBoolean(scanner.nextLine());

        taskController.addTask(id,title,description,completed);
        System.out.println("Tarea agregada correctamente");
    }
}
