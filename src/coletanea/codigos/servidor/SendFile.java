package coletanea.codigos.servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendFile {

	public static void main(String[] args) {
		
		System.out.println("Conectando servidor...");
		
		try(Socket clienteC = new Socket("127.0.0.1", 1234);
				Socket clienteD = new Socket("127.0.0.1", 1235)){
			System.out.printf("Conexão aceita de %s \n", clienteC.getInetAddress().toString());
			
			File file = new File("texto.txt");
			
			System.out.printf("Enviando arquivo %s ", file.getName());
			
			BufferedInputStream arquivo = new BufferedInputStream(new FileInputStream(file));
			
			PrintWriter canalC = new PrintWriter(clienteC.getOutputStream(), true);
			
			long sent = 0, total = file.length();
			
			System.out.printf("%s bytes no arquivo", total);
			
			canalC.println(file.getName()); //envio dos dados do arquivo
			canalC.println(total + "");
			canalC.close(); //fecha canal modo texto
			
			BufferedOutputStream canalD = new BufferedOutputStream(clienteD.getOutputStream());
			
			while(sent + 256 < total){
				byte dados[] = new byte[256]; //cria aray para bloco
				arquivo.read(dados, 0, 2556); //le dados para bloco
				canalD.write(dados, 0, 256); //envia bloco
				sent += 256; //totaliza bloco
			}
			
			if(sent <total){
				int fim = (int) (total -sent);
				byte dados[] = new byte[fim]; //cria aray para bloco
				arquivo.read(dados, 0, fim); //le dados para o bloco final
				canalD.write(dados, 0, fim); //envia bloco final
			}
			canalD.close();
			arquivo.close();
			
			System.out.println(total + " bytes enviados!");
			
		}catch(Exception erro){
			System.out.println("Erro!\n" + erro.getMessage());
		}
		System.out.println("Conexão encerrada.");
	}
}
