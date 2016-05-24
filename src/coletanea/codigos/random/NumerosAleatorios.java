package coletanea.codigos.random;

import java.util.Random;

public class NumerosAleatorios {

	public static void main(String[] args) {
		
		Random r = new Random();
		int nextInt = r.nextInt(100);
		
		System.out.println(nextInt);
		
		double random = Math.random();
		System.out.println(random);
	}
}
