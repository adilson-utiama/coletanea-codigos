package coletanea.codigos.servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBasico {

	public static void main(String[] args) {
		
		System.out.println("Iniciando sevidor....");
		
		try(ServerSocket servidor = new ServerSocket(1234);){
			System.out.println("Servidor operando na porta 1234");
			while(true){
				System.out.println("Esperando conex�o....");
				
				Socket cliente = servidor.accept(); //aceita conexao
				
				System.out.println("Conex�o aberta de " 
						+ cliente.getInetAddress().toString());
				System.out.println("Enviando dados...");
				
				ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
				
				saida.flush(); //envia cabecalho de preparo do outro endpoint
				saida.writeObject("Servidor Basico conectado!");
				saida.writeObject("Dados da conex�o: " + cliente.toString());
				saida.writeObject("Tchau!");
				
				System.out.println("Dados enviados!");
				
				saida.writeObject("EOT");
				
				cliente.close();
				
				System.out.println("Conex�o encerrada");
			}
		}catch(IOException erro){
			System.out.println("Erro!\n" + erro.getMessage());
		}
	}
}
