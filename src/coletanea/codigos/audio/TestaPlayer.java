package coletanea.codigos.audio;

import java.io.File;

public class TestaPlayer {

	public static void main(String[] args){
        File musica = new File("res/alarm_beep.wav");//pode ser wav ou mp3
        System.out.println("Reproduzindo: " + musica.getAbsolutePath());
        Music track = new Music(musica);
        Play play = new Play(track);
        Thread newThrd = new Thread(play);
        newThrd.start();


    }
}
