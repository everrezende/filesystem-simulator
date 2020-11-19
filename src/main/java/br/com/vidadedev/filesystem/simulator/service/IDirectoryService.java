package br.com.vidadedev.filesystem.simulator.service;

/**
 * Interface responsavel pelas operacoes de diretorios
 */
public interface IDirectoryService {

	/**
	 * Set do diretorio atual
	 */
	void setCurrentDir(String currentDir);
	
	/**
	 * Get do diretorio
	 */
	String getCurrentDir();
	
	/**
	 * Retorna o separador de diretorio do sistema
	 */
	String getSeparator();
	
	/**
	 * Lista o conteudo do diretorio atual
	 */
	void list();
	
	/**
	 * Cria uma pasta dentro do diretorio atual
	 */
	void createDir(String name);
	
	/**
	 * Navega para o diretorio pai
	 */
	void dirUp();
	
}
