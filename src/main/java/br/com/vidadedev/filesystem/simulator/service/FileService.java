package br.com.vidadedev.filesystem.simulator.service;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class FileService implements IFileService{

	@Override
	public void createFile(String fileName) {
		File newFile = new File(fileName);
		try {
			int fileCount = 1;
			
			while(newFile.exists()) {
				String[] fileNameParts = fileName.split( Pattern.quote(".") );
				newFile = new File(fileNameParts[0] + "(" + fileCount + ")." + fileNameParts[1]);
				fileCount++;
			}
			
			newFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Error on create file.");
		}
	}

	@Override
	public void deleteFile(String fileName) {
		File f = new File(fileName);
		if(f.exists()) {
			f.delete();
		}else {
			System.out.println("Invalid file name");
		}
	}

}
