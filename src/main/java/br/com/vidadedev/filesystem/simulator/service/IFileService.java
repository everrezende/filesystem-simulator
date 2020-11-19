package br.com.vidadedev.filesystem.simulator.service;

/**
 * Interface responsavel pelas operacoes de arquivos
 */
public interface IFileService {
	
	/**
	 * Cria um arquivo 
	 */
	void createFile(String fileName);
	
	/**
	 * Deleta um arquivo
	 */
	void deleteFile(String fileName);

}
