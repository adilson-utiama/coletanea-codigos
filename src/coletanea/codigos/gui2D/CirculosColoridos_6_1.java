package coletanea.codigos.gui2D;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CirculosColoridos_6_1 extends JPanel{

	Random randomCor = new Random();
	int r = 1 + randomCor.nextInt(255);
	int g = 1 + randomCor.nextInt(255);
	int b = 1 + randomCor.nextInt(255);
	Color cor = new Color(r,g,b);	
	int r2 = 1 + randomCor.nextInt(255);
	int g2 = 1 + randomCor.nextInt(255);
	int b2 = 1 + randomCor.nextInt(255);
	Color cor2 = new Color(r2,g2,b2);
	
	public void paintComponent ( Graphics g ){
		super.paintComponent( g );
	
		for( int i=0; i<3;i++){
		g.setColor(cor);
		g.fillOval(20+(i*40), 20+(i*40), 230-(i*80), 230-(i*80));
		g.setColor(cor2);
		g.fillOval(40+(i*40), 40+(i*40), 190-(i*80), 190-(i*80));
		}
	
	}
	
	public static void main(String[] args) {
		
		CirculosColoridos_6_1 painel = new CirculosColoridos_6_1();
		JFrame aplicativo = new JFrame();
		
		aplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicativo.add(painel);
		aplicativo.setSize(300, 300);
		aplicativo.setVisible(true);
	}
}
