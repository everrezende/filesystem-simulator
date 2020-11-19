package br.com.vidadedev.filesystem.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FileSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FileSystemApplication.class, args);
		context.getBean(SimulatorRunner.class).run();
	}

}
