package coletanea.codigos.threadtest;

import java.io.File;

import coletanea.codigos.audio.Music;
import coletanea.codigos.audio.Play;

public class TesterThread {

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 10; i++) {
			File musica = new File("res/glass.wav");//pode ser wav ou mp3
	        System.out.println("Reproduzindo: " + musica.getAbsolutePath());
	        Music track = new Music(musica);
	        Play play = new Play(track);
	        Thread newThrd = new Thread(play);
	        newThrd.start();
	        //vai tocar o sample a cada minuto
			Thread.sleep(60000);
		}
	}
}
