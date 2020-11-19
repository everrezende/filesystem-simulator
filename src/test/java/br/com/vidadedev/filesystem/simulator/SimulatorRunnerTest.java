package br.com.vidadedev.filesystem.simulator;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.util.Assert;

import br.com.vidadedev.filesystem.simulator.service.IDirectoryService;

@SpringBootTest
public class SimulatorRunnerTest {

	@Autowired
	private SimulatorRunner simulatorRunner;
	
	@Autowired
	private IDirectoryService directService;
	
	private final String ROOT_DIR = "/";
	
	@Test
	@Description("Teste de navegacao de diretorio")
	public void changeDirTest() {
		String destinationDir = "tmp";
		String resultDir = "/tmp";
		
		simulatorRunner.executeCommand("changedir " + ROOT_DIR);
		simulatorRunner.executeCommand("changedir " + destinationDir);
		
		Assert.isTrue(directService.getCurrentDir().equals(resultDir));
	}
	
	@Test
	@Description("Teste de criacao de diretorio")
	public void createDir() {
		String newDir = "application-test-dir";
		String destDir = "/tmp";
		
		simulatorRunner.executeCommand("changedir " + ROOT_DIR);
		simulatorRunner.executeCommand("changedir tmp");
		simulatorRunner.executeCommand("adddir " + newDir);
		
		File tmpDir = new File(destDir);
		String[] content = tmpDir.list();
		
		boolean existDir = false;
		
		for(String c : content) {
			if(c.equals(newDir)) {
				existDir = true;
				break;
			}
		}
		
		Assert.isTrue(existDir);
		
	}
	
}
