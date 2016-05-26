package coletanea.codigos.random;

import java.util.Random;

public class NumerosAleatorios {

	public static void main(String[] args) {
		
		Random r = new Random();
		int nextInt = r.nextInt(10) + 1;
		System.out.println(nextInt);
		
		double random = Math.random();
		System.out.println(random);
		
		int num = (int) (Math.random() * 100);
		System.out.println(num);
		
		Random rand = new Random();
		String[] nomes = {"Adilson","Wilson","Edson","Gilson","Adelson","Ilton"};
		System.out.println(nomes[rand.nextInt(nomes.length - 1)]);
	}
}
