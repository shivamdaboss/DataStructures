import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;



public class Music{
	String filename;
	
	public Music(String file) {
		filename = file;
	}
	
	public static void playSound(String filename) {
		try {
			File file = new File(filename);
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);;
			Clip clip = (Clip) AudioSystem.getClip();
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		}
		catch(Exception e) {
			
		}
	}
	
}
