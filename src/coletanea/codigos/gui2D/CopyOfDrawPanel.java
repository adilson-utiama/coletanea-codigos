package coletanea.codigos.gui2D;

import java.awt.Graphics;
import javax.swing.JPanel;

/* Figura 4.20
 * Linhas que se estendem a partir de um canto
 */

public class CopyOfDrawPanel extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int largura = getWidth();
		int altura = getHeight();
		
		for(int i=1;i<15;i++){
		g.drawLine(0, 0+i*15, 0+i*15, altura);
		g.drawLine(0+i*15,0, altura,0+i*15);
		
		}
	}
}
