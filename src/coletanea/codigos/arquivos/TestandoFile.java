package coletanea.codigos.arquivos;

import java.io.File;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JFileChooser;

public class TestandoFile {

	public static void main(String[] args) {
		
		
		JFileChooser chooser = new JFileChooser();
		int dialog = chooser.showSaveDialog(null);
		File diretorio = chooser.getCurrentDirectory();
		
		
		//File diretorio = new File(directory);
		File[] listFiles = diretorio.listFiles();
		
		List<File> arquivos = new ArrayList<>();
		for (File file : listFiles) {
			if(file.isFile()){
				arquivos.add(file);
			}
		}
		
		arquivos.forEach(file -> System.out.println(file.getName()));
		
		
		
	}
}
