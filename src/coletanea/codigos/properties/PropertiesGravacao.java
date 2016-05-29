package coletanea.codigos.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesGravacao {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.setProperty("prop.nome", "Adilson");
		prop.setProperty("prop.idade", "37");
		prop.setProperty("prop.telefone", "123456");
		prop.store(new FileOutputStream("propriedades.propertie"), "Arquivo Exemplo");
		
		
		
	}
}
