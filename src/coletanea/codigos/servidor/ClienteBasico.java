package coletanea.codigos.servidor;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClienteBasico {

	public static void main(String[] args) {
		
		System.out.println("Conectando servidor...");
		try(Socket cliente = new Socket("127.0.0.1", 1234);){
			System.out.println("Conexao aceita de " + cliente.getInetAddress().toString());
			System.out.println("Recebendo mensagens...");
			
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			
			String msg;
			
			do{
				msg = (String) entrada.readObject();
				System.out.println(msg);
			}while(!msg.equals("EOT"));
			
			System.out.println("Conexão encerrada!");
		}catch(Exception erro){
			System.out.println("Erro!\n" + erro.getMessage());
		}
	}
}
