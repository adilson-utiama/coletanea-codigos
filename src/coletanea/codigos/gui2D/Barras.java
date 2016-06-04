package coletanea.codigos.gui2D;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Barras extends JPanel{
	
	private String numero;
	
	public Barras(String numer){
		this.numero = numer;
		System.out.println(numero);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i=0;i<numero.length();i++){
			int n = Integer.parseInt(numero.substring(0+i,i+1));
		
		g.drawRect(0,0+i*10, 0+n*20, 10);
		
		}
	}
	
	public static void main(String[] args) {
		
		//necessita de tratamento de erro
		String num = JOptionPane.showInputDialog(
				"Digite um numero inteiro : "
				);
		
		Barras painel = new Barras(num);
		JFrame aplicativo = new JFrame();
		
		aplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicativo.add(painel);
		aplicativo.setSize(300,300);
		aplicativo.setVisible(true);
		
	}
}
