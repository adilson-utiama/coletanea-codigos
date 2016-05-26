package coletanea.codigos.servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveFile {

	public static void main(String[] args) {

		System.out.println("Criando Servidor...");
		try (ServerSocket servidorC = new ServerSocket(1234);
				ServerSocket servidorD = new ServerSocket(1235);) {

			System.out.println("Servidor operando nas portas 1234/1235");

			while (true) {
				System.out.println("Esperando conexão...");
				
				try (Socket clienteC = servidorC.accept();
						Socket clienteD = servidorD.accept();) {

					System.out.println("Conexão aberta de "
							+ clienteC.getInetAddress().toString());

					BufferedReader canalC = new BufferedReader(
							new InputStreamReader(clienteC.getInputStream()));

					String nomeArquivo = canalC.readLine() + ".txt";

					if (nomeArquivo.startsWith("@shutdown")) {
						System.out.println("@shutdown");
						break;
					}

					System.out.println("Recebendo arquivo " + nomeArquivo);

					long recv = 0;
					long total = Integer.parseInt(canalC.readLine());
					canalC.close();

					// abre canal de dados
					BufferedInputStream canalD = new BufferedInputStream(
							clienteD.getInputStream());

					// abre arquivo para dados transferidos
					BufferedOutputStream arquivo = new BufferedOutputStream(
							new FileOutputStream(nomeArquivo));

					while (recv < total) {
						byte dados[] = new byte[256];
						canalD.read(dados, 0, 256);
						arquivo.write(dados, 0, 256);
						recv += 256;
					}

					if (recv < total) {
						int fim = (int) (total - recv);
						byte dados[] = new byte[fim];
						canalD.read(dados, 0, fim);
						arquivo.write(dados, 0, fim);
					}
					arquivo.close();
					canalD.close();
					System.out.println(total + " dados recebidos.");
				}catch(Exception erro){
					System.out.println("Problemas na recepção.");
					erro.printStackTrace();
				}
				System.out.println("Conexão encerrada");
			}
			System.out.println("Servidor encerrado.");
		} catch (Exception erro) {
			System.out.println("Erro!\n" + erro.getMessage());
		}
		
	}
	
}
