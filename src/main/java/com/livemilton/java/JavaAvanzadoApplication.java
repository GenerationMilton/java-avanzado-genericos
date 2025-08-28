package com.livemilton.java;

import com.livemilton.java.project.concurrence.log.model.LogEntry;
import com.livemilton.java.project.concurrence.log.model.LogSummary;
import com.livemilton.java.project.concurrence.log.service.LogProcessorTask;
import com.livemilton.java.project.concurrence.log.service.LogService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@SpringBootApplication
public class JavaAvanzadoApplication {

	public static void main(String[] args) {

		System.out.println("🚀 Iniciando análisis de logs...");

		File logsFolder = new File("logs");
		File[] logFiles = logsFolder.listFiles((dir, name) -> name.endsWith(".log"));

		if (logFiles == null || logFiles.length == 0) {
			System.out.println("⚠️ No se encontraron archivos .log en la carpeta 'logs'. Asegúrate de crearla y poner archivos dentro.");
			return;
		}

		LogService service = new LogService();

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<LogSummary>> futures = new ArrayList<>();

		for(File logFile: logFiles){
			List<LogEntry> entries = service.readLogsFromFile(logFile.getAbsolutePath());
			LogProcessorTask task = new LogProcessorTask(entries);
			futures.add(executorService.submit(task));
		}

		for(Future<LogSummary> future: futures){
            try {
                LogSummary summary = future.get();
				System.out.println(summary);
            } catch (InterruptedException | ExecutionException e) {
				System.out.println(e.getMessage());
            }
        }

		executorService.shutdown();


	}

}
