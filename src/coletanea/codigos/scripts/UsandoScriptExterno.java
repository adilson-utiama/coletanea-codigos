package coletanea.codigos.scripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UsandoScriptExterno {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String stdIn = "",  s;
		try {
			Process exec = Runtime.getRuntime().exec("comandos.bat");
			
			Scanner scanner = new Scanner(exec.getInputStream());
			while(scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}
			
			
//			BufferedReader stdInput = new BufferedReader(new
//	                 InputStreamReader(exec.getInputStream()));
//			
//			 // l� o conteudo da sa�da padr�o do comando e guarda em vari�vel
//            while ((s = stdInput.readLine()) != null) {
//                stdIn += s + "\n";
//            }
//
//			System.out.println("Saida Padrao: \n" + stdIn);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
