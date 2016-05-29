package coletanea.codigos.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLeitura {

	public static void main(String[] args) throws IOException {
		
		Properties file = new Properties();
		FileInputStream stream = new FileInputStream("propriedades.propertie");
		file.load(stream);
		
		System.out.println(file.getProperty("prop.nome"));
		System.out.println(file.getProperty("prop.idade"));
		
	}
}
