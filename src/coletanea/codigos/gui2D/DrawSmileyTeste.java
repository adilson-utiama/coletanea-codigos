package coletanea.codigos.gui2D;

import javax.swing.JFrame;

public class DrawSmileyTeste {

	public static void main(String[] args) {
		
		DrawSmiley painel = new DrawSmiley();
		JFrame aplicativo = new JFrame();
		
		aplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicativo.add(painel);
		aplicativo.setVisible(true);
		aplicativo.setSize(230, 250);
	}
}
