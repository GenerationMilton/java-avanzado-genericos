package com.livemilton.java;

import com.livemilton.java.task.controller.TaskController;
import com.livemilton.java.task.excepciones.TaskException;
import com.livemilton.java.task.excepciones.TaskValidationException;
import com.livemilton.java.task.model.TaskRepository;
import com.livemilton.java.task.view.TaskView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class JavaAvanzadoApplication {

	public static void main(String[] args) throws TaskValidationException, TaskException, FileNotFoundException {
		TaskRepository repository = new TaskRepository();
		TaskController controller = new TaskController(repository);
		TaskView view = new TaskView(controller);

		view.showMenu();
	}

}
