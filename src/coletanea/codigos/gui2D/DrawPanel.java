package coletanea.codigos.gui2D;

import java.awt.Graphics;
import javax.swing.JPanel;

/* Figura 4.18
 * Utilizando DrawLine para conectar os cantos de um painel
 */

public class DrawPanel extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int largura = getWidth();
		int altura = getHeight();
		
		g.drawLine(0, 0,largura, altura);
		
		g.drawLine(0, altura, largura, 0);
	}
}
