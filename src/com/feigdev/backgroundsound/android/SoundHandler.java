package com.feigdev.backgroundsound.android;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;

public class SoundHandler {
	MediaPlayer music;
//	MediaPlayer sfx1;
//	MediaPlayer sfx2;
//	MediaPlayer sfx3;
	
	public SoundHandler(){
		music = new MediaPlayer();
//		sfx1 = new MediaPlayer();
//		sfx2 = new MediaPlayer();
//		sfx3 = new MediaPlayer();
	}
	
	public void netInit(String path){
		try {
			music.reset();
			music.setAudioStreamType(AudioManager.STREAM_MUSIC);
			music.setDataSource(path);
			music.setLooping(true);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stopMusic(){
		music.stop();
	}
	
	public void startMusic(){
		try {
			music.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		music.start();
	}
	
	public void killPlayers(){
		music.release();
//		sfx1.release();
//		sfx2.release();
//		sfx3.release();
	}
}
