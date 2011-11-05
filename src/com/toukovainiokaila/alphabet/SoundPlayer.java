package com.toukovainiokaila.alphabet;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundPlayer {
	private MediaPlayer mp = null;

	public void play(Context context, int resource) {
		stop();
		mp = MediaPlayer.create(context, resource);
		mp.start();
	}

	private void stop() {
		if (mp != null) {
			mp.stop();
			mp.release();
			mp = null;
		}
	}

}
