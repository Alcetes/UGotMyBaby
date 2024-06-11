package app.resources;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {

	private Sounds() {

		sounds.put(NOTIFY, loadSound("/notify.wav"));

	}

	public static Clip loadSound(String soundFile) {
		AudioInputStream audioInputStream;
		try {

			audioInputStream = AudioSystem.getAudioInputStream(Sounds.class.getResource(soundFile));

			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			return clip;
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Sounds getUniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Sounds();
		}
		return uniqueInstance;
	}

	public Clip getSound(int id) {
		return sounds.get(id);
	}

	public void play(int id) {
		stop(id);
		sounds.get(id).setFramePosition(0);
		sounds.get(id).start();
	}

	public void stop(int id) {
		if (sounds.get(id).isRunning()) {
			sounds.get(id).stop();
		}
	}

	static public final int NOTIFY = 1;

	private HashMap<Integer, Clip> sounds = new HashMap<Integer, Clip>();

	private static Sounds uniqueInstance;

}
