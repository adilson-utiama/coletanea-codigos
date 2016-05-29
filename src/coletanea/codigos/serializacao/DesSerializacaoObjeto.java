package coletanea.codigos.serializacao;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DesSerializacaoObjeto {

	public static void main(String[] args) {

		String file = "serializado.ser";
		try {
			FileInputStream inputStream = new FileInputStream(file);
			ObjectInputStream object = new ObjectInputStream(inputStream);
			Cliente cliente = (Cliente) object.readObject();
			lerDados(cliente);
			object.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void lerDados(Cliente cliente) {
		System.out.println("Cliente: " + cliente.getNome() + "\nCodigo: "
				+ cliente.getCodigo() + "\nDescricao: "
				+ cliente.getDescricao() + "\nData de Cadastro: "
				+ formatar(cliente.getDataCadastro()));
		
		System.out.println(cliente.getNaoSerializa()); //retorna null, propriedade marcada com transient
	}

	private static String formatar(Calendar dataCadastro) {
		return new SimpleDateFormat("dd/MM/yyyy")
				.format(dataCadastro.getTime());
	}
}
