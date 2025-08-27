package com.livemilton.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


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

	}

}
