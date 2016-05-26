package coletanea.codigos.servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteMultithread {

	public static void main(String[] args) {
		
		System.out.println("Conectando servidor...");
		
		try(Socket cliente = new Socket("127.0.0.1",1234);){
			System.out.printf("Conexão aceita de: %s\n", cliente.getInetAddress().toString());
			System.out.println("Enciando Limite...");
			
			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			
			saida.flush();
			saida.writeObject(new Integer(10)); //envia limmite
			
			System.out.println("Recebendo Contagem...");
			
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			
			String msg;
			
			do{
				msg = (String) entrada.readObject();
				System.out.println(msg);
			}while(!msg.equals("EOT"));
			
		}catch(Exception e){
			System.out.println("Erro!\n" + e.getMessage());
		}//fechamento implicito da conexao
	}
}
