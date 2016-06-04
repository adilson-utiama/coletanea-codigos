package coletanea.codigos.random;

import java.util.Random;
//Exemplo 7.7
//Proframa de jogo de dados utilizando arrays em vez de switch
public class RollDice_7_7 {

	public static void main(String[] args) {
		Random randomNumber = new Random();
		int[] frequencia = new int[7];//array de contador de frequencia

		//lanca o dado 6000 vezes, utiliza o valor do dado como indice de frequencia
		for (int jogaDado = 1; jogaDado <= 6000; jogaDado++) {
			++frequencia[1 + randomNumber.nextInt(6)];
		}
		System.out.printf("%s%13s\n", "Face", "Frequencia");
		//gera saida do valor de cada elemento de array
		for (int face = 1; face < frequencia.length; face++) {
			System.out.printf("%4d%13d\n", face, frequencia[face]);
		}
	}
}
