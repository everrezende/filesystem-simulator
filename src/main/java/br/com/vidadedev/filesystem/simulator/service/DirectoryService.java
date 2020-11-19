package br.com.vidadedev.filesystem.simulator.service;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class DirectoryService implements IDirectoryService{

	private final String ROOT_DIR = "/";
	private String currentDir = ROOT_DIR;
	private String SEPARATOR = "/";
	
	@Override
	public void setCurrentDir(String currentDir) {
		if(ROOT_DIR.equalsIgnoreCase(currentDir)) {
			this.currentDir = ROOT_DIR;
		}else if(this.currentDir.equalsIgnoreCase(ROOT_DIR)) {
			String destination = ROOT_DIR + currentDir;

			if(!isValidDir(destination)) {
				System.out.println("Invalid dir!");
			}
			this.currentDir = destination;
		}else {
			String destination = this.currentDir + SEPARATOR + currentDir;
			
			if(!isValidDir(destination)) {
				System.out.println("Invalid dir!");
			}
			this.currentDir = destination;
		}
	}

	@Override
	public String getCurrentDir() {
		return currentDir;
	}

	@Override
	public void list() {
		File dir = new File(currentDir);
		String[] content = dir.list();
		for(String c : content) {
			System.out.println(c);
		}
	}

	@Override
	public void createDir(String name) {
		File newDir = new File(getCurrentDir() + SEPARATOR + name);
		newDir.mkdir();
	}
	
	@Override
	public void dirUp() {
		if(ROOT_DIR.equalsIgnoreCase(currentDir)) {
			return;
		}else {
			String[] dirs = currentDir.substring(1, currentDir.length()).split(SEPARATOR);
			String parentDir = "";
			for (int i = 0; i < dirs.length-1; i++) {
				parentDir = parentDir + SEPARATOR + dirs[i];
			}
			
			if(parentDir.isEmpty()) {
				setCurrentDir(ROOT_DIR);
			}else {
				if(!isValidDir(parentDir)) {
					System.out.println("Invalid dir!");
					return;
				}
				this.currentDir = parentDir;
			}
		}
	}
	
	/**
	 * Verifica se um diretorio existe
	 */
	private boolean isValidDir(String dir) {
		File destination = new File(dir);
		return destination.exists();
	}

	@Override
	public String getSeparator() {
		return SEPARATOR;
	}
	
}
