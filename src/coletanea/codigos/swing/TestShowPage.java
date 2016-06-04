package coletanea.codigos.swing;

import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class TestShowPage {
	 public static void main(String args[]) {  
	  JTextPane tp = new JTextPane();
	  JScrollPane js = new JScrollPane();
	  js.getViewport().add(tp);
	  JFrame jf = new JFrame();
	  jf.getContentPane().add(js);
	  jf.pack();
	  jf.setSize(400,500);
	  jf.setVisible(true); 
	  
	  try {
	    URL url = new URL("https://www.alura.com.br/");
	    tp.setPage(url);
	    } 
	  catch (Exception e) {
	    e.printStackTrace();
	    }
	  }
	 }