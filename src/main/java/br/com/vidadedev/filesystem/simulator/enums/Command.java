package br.com.vidadedev.filesystem.simulator.enums;

/**
 * ENUM de comandos disponiveis na aplicacao
 */
public enum Command {
	PWD,
	LIST,
	CD,
	ADD_DIR,
	DIR_UP,
	ADD_FILE,
	DELETE_FILE;
	
	public static Command fromString(String text) {
		switch (text.toLowerCase()) {
		case "pwd":
			return PWD;
		case "adddir":
			return ADD_DIR;
		case "list":
			return LIST;
		case "changedir":
			return CD;
		case "dirup":
			return DIR_UP;
		case "addfile":
			return ADD_FILE;	
		case "delete":
			return DELETE_FILE;	
		default:
			return null;
		}
	}
	
}
