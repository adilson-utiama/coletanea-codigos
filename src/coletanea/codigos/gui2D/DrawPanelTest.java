package coletanea.codigos.gui2D;

import javax.swing.JFrame;

public class DrawPanelTest {

	public static void main(String[] args) {
		
		DrawPanel painel = new DrawPanel();
				
		JFrame aplicativo = new JFrame();
		
		aplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicativo.add(painel);
		aplicativo.setSize(250, 250);
		aplicativo.setVisible(true);
		
		
	}
}
