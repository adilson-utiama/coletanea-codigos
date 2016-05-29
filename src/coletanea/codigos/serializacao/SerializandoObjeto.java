package coletanea.codigos.serializacao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class SerializandoObjeto {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Loja Cliente", 123, "Loja do Cliente", Calendar.getInstance());
		cliente.setNaoSerializa("nao serializa");
		
		String file = "serializado.ser";
		ObjectOutputStream object = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			object = new ObjectOutputStream(fileOutputStream);
			object.writeObject(cliente);
			object.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Arquivo não encontrado!");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
