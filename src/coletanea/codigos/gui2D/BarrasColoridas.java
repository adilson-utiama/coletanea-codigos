package coletanea.codigos.gui2D;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BarrasColoridas extends JPanel {

	Random randomCor = new Random();

	Color cor;
	private String numero;

	public BarrasColoridas(String numer) {
		this.numero = numer;
		System.out.println(numero);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < numero.length(); i++) {
			int red = 1 + randomCor.nextInt(255);
			int green = 1 + randomCor.nextInt(255);
			int blue = 1 + randomCor.nextInt(255);
			cor = new Color(red, green, blue);
			
			int n = Integer.parseInt(numero.substring(0 + i, i + 1));
			g.setColor(cor);
			g.fillRect(0, 0 + i * 20, 0 + n * 30, 20);

			String num = numero.substring(0 + i, i + 1);
			g.setColor(Color.BLACK);
			g.drawString(num, n * 30, 20 + i * 20);

		}
	}

	public static void main(String[] args) {

		// necessita de tratamento de erro
		String num = JOptionPane.showInputDialog("Digite um numero inteiro : ");

		BarrasColoridas painel = new BarrasColoridas(num);
		JFrame aplicativo = new JFrame();

		aplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicativo.add(painel);
		aplicativo.setSize(300, 300);
		aplicativo.setVisible(true);

	}
}
