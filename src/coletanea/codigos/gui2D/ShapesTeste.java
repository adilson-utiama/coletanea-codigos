package coletanea.codigos.gui2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapesTeste {

	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog(
				"Digite 1 para desenhar Retangulos \n" +
				"Digite 2 para desenhar Elipses" );
 		int escolha = Integer.parseInt( input );
		
		Shapes painel = new Shapes( escolha );//cria o painel com a entrada do usuario
		
		JFrame aplicativo = new JFrame();//cria um  novo JFrame
		
		aplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplicativo.add( painel ); // Adiciona o painel ao Frame
		aplicativo.setSize(300, 300);
		aplicativo.setVisible(true);
		
		
		
		
	}
}
