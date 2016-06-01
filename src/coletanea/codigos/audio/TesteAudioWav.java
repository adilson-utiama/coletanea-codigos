package coletanea.codigos.audio;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TesteAudioWav {

	public static void main(String[] args) throws Exception {
		
		// Carrega o arquivo de áudio (não funciona com .mp3, só .wav) 
	    URL oUrl = new URL("http://www.soundjay.com/button/beep-02.wav");
	    Clip oClip = AudioSystem.getClip();
	    AudioInputStream oStream = AudioSystem.getAudioInputStream(oUrl);
	    oClip.open(oStream);

	    oClip.loop(0); // Toca uma vez
	    //clip.loop(Clip.LOOP_CONTINUOUSLY); // Toca continuamente (para o caso de músicas)

	    // Para a execução (senão o programa termina antes de você ouvir o som)
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            JOptionPane.showMessageDialog(null, "Clique pra fechar!");
	        }
	    });
	}

    

}
