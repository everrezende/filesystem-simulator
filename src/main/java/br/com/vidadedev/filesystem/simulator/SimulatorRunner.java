package br.com.vidadedev.filesystem.simulator;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vidadedev.filesystem.simulator.enums.Command;
import br.com.vidadedev.filesystem.simulator.service.IDirectoryService;
import br.com.vidadedev.filesystem.simulator.service.IFileService;

@Component
public class SimulatorRunner {

	@Autowired
	private IDirectoryService directoryService;
	
	@Autowired
	private IFileService fileService;
	
	/**
	 * Inicia a aplicacao console
	 */
	public void run() {
		
		System.out.println("Welcome to simulator!");
		
		Scanner keyboardScanner = new Scanner(System.in);
		String input = "";
		
		System.out.println(directoryService.getCurrentDir() + "> ");
		input = keyboardScanner.nextLine();
		
		while(!"exit".equalsIgnoreCase(input)) {
			executeCommand(input);
			System.out.print(directoryService.getCurrentDir() + "> ");
			input = keyboardScanner.nextLine();
		}
		
		System.out.println("Bye! Bye!");
		keyboardScanner.close();
		
	}
	
	/**
	 * Executa um comando a partir de uma entrada de teclado
	 */
	public void executeCommand(String input) {
		
		String inputCommand = null;
		String inputArg = null;
		
		if(input.contains(" ")) {
			inputCommand = input.split(" ")[0];
			inputArg = input.split(" ")[1];
		}else {
			inputCommand = input;
		}
		
		Command command = Command.fromString(inputCommand);
		
		if(command == Command.PWD) {
			System.out.println(directoryService.getCurrentDir());
		}else if(command == Command.LIST){
			directoryService.list();
		}else if(command == Command.CD && inputArg != null){
			directoryService.setCurrentDir(inputArg);
		}else if(command == Command.ADD_DIR && inputArg != null){
			directoryService.createDir(inputArg);
		}else if(command == Command.DIR_UP){
			directoryService.dirUp();
		}else if(command == Command.ADD_FILE && inputArg != null){
			fileService.createFile(directoryService.getCurrentDir() + directoryService.getSeparator() + inputArg);
		}else if(command == Command.DELETE_FILE && inputArg != null){
			fileService.deleteFile(directoryService.getCurrentDir() + directoryService.getSeparator() + inputArg);
		}else {
			System.out.println("Invalid command!");
		}
	}
	
}
