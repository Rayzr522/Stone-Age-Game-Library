
package com.sagl.audio;

import java.applet.Applet;
import java.applet.AudioClip;

import com.sagl.thread.ThreadedCode;

public class Sound {

	private AudioClip	clip;

	public Sound(String location) {

		try {
			clip = Applet.newAudioClip(Sound.class.getResource(location));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void play() {

		new ThreadedCode() {

			public void run() {
				clip.play();
			}
		};

	}

	public void stop() {

		clip.stop();

	}

	public void loop() {

		new ThreadedCode() {

			public void run() {
				clip.loop();
			}
		};

	}

}
