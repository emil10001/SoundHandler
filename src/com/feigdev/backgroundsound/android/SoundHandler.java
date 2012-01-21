package com.feigdev.backgroundsound.android;

import java.io.IOException;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

public class SoundHandler {
	private MediaPlayer music;
	private MediaPlayer sfx1 = null;
	private MediaPlayer sfx2 = null;
	private MediaPlayer sfx3 = null;
	public static final int SFX1 = 101011;
	public static final int SFX2 = 101012;
	public static final int SFX3 = 101013;
	
	public SoundHandler(){
		music = new MediaPlayer();
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
	
	public void localInit(Context c, Uri file){
		try {
			music.reset();
			music.setAudioStreamType(AudioManager.STREAM_MUSIC);
			music.setDataSource(c,file);
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

	public void initSfx(Context c, int resource, int sfxNum){
		try {
			switch (sfxNum){
			case SFX1:
				if (sfx1 != null){
					return;
				}
				sfx1 = MediaPlayer.create(c,resource);
				sfx1.setLooping(false);
				break;
			case SFX2:
				if (sfx2 != null){
					return;
				}
				sfx2 = MediaPlayer.create(c,resource);
				sfx2.setLooping(false);
				break;
			case SFX3:
				if (sfx3 != null){
					return;
				}
				sfx3 = MediaPlayer.create(c,resource);
				sfx3.setLooping(false);
				break;
			}
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void localInitSfx(Context c, Uri file, int sfxNum){
		try {
			switch (sfxNum){
			case SFX1:
				sfx1.reset();
				sfx1.setAudioStreamType(AudioManager.STREAM_MUSIC);
				sfx1.setDataSource(c,file);
				sfx1.setLooping(false);
				break;
			case SFX2:
				sfx2.reset();
				sfx2.setAudioStreamType(AudioManager.STREAM_MUSIC);
				sfx2.setDataSource(c,file);
				sfx2.setLooping(false);
				break;
			case SFX3:
				sfx3.reset();
				sfx3.setAudioStreamType(AudioManager.STREAM_MUSIC);
				sfx3.setDataSource(c,file);
				sfx3.setLooping(false);
				break;
			}
			
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
	

	public void startMusic(){
		if (music.isPlaying()){
			return;
		}
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
	
	public void playSfx(int sfxNum){
		try {
			switch (sfxNum){
			case SFX1:
				if (sfx1.isPlaying()){
					return;
				}
				sfx1.start();
				break;
			case SFX2:
				if (sfx2.isPlaying()){
					return;
				}
				sfx2.start();
				break;
			case SFX3:
				if (sfx3.isPlaying()){
					return;
				}
				sfx3.start();
				break;
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void stopMusic(){
		if (!music.isPlaying()){
			return;
		}
		music.stop();
	}
	
	public void killPlayers(){
		music.release();
		sfx1.release();
		sfx2.release();
		sfx3.release();
	}
}
