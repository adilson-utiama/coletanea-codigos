package coletanea.codigos.scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerUso {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new FileReader("texto"))
        	.useDelimiter("\\||\\n");
		
		while (scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}
	}
}
