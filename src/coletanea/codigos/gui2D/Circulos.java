package coletanea.codigos.gui2D;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circulos extends JPanel{

	public void paintComponent ( Graphics g ){
		super.paintComponent( g );
		
		for( int i=0; i<10;i++){
		g.drawOval(110-i*10, 110-i*10, 50+i*20, 50+i*20);
		//tamanho do oval (+i*20) dividido por 2
		//para definir as cordenadas seguintes (-i*10)
		}
	}
	
	public static void main(String[] args) {
		
		Circulos painel = new Circulos();
		
		JFrame aplicativo = new JFrame();
		
		aplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicativo.add(painel);
		aplicativo.setSize(300, 300);
		aplicativo.setVisible(true);
	}
}
