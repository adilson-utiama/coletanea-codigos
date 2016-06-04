package coletanea.codigos.gui2D;

import java.awt.Graphics;
//Figura 5.26: Shapes.java
//Dessenho de varias formas

import javax.swing.JPanel;

public class Shapes extends JPanel{
	
	private int escolha;

	//Construtor Shape
	public Shapes( int escolhaUsuario ){
		escolha = escolhaUsuario;
	}
	
	//Metodo desenha uma cascata de formas que iniciam do canto superior esquerdo 
	public void paintComponent( Graphics g ){
		super.paintComponent( g );
		
		for (int i = 0; i < 10; i++) {
			switch ( escolha ){
			case 1: //desenha retangulos
				g.drawRect(10 + i * 10, 10 + i * 10 , 50 + i * 10, 50 + i * 10 );
				break;
			case 2: //desenha elipses
				g.drawOval(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
				break;
			
			}
		}
	}
}
