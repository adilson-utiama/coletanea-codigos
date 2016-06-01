package coletanea.codigos.imagens;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestaCarregamentoImagem {

	public static void main(String[] args) {
		
		 //janela do programa      
        JFrame frame = new JFrame("Carregar Imagem");  
        //container onde serão adicionados todos componentes  
        Container container = frame.getContentPane();  
  
        //carrega a imagem passando o nome da mesma  
        ImageIcon img = new ImageIcon("res/minion.jpg");  
          
        //pega a altura e largura  
        int altura = img.getIconHeight();  
        int largura = img.getIconWidth();  
          
        //adiciona a imagem em um label  
        JLabel label = new JLabel(img);  
        //adiciona a altura e largura em outro label  
        JLabel label2 = new JLabel("Altura: "+altura+"      Largura: "+largura);  
  
        //cria o JPanel para adicionar os labels  
        JPanel panel = new JPanel();  
        panel.add(label, BorderLayout.NORTH);  
        //panel.add(label2, BorderLayout.CENTER);  
  
        //adiciona o panel no container  
        container.add(panel, BorderLayout.CENTER);
        container.add(label2, BorderLayout.SOUTH);
          
        frame.pack();  
        frame.setVisible(true);  
  
        //pronto e simples  
  
	}
}
