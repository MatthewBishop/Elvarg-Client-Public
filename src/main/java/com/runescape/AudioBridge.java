package com.runescape;

import adapter.IAudioBridge;

public class AudioBridge implements IAudioBridge {

	@Override
	public int playerX() {
		return Client.localPlayer.x;
	}

	@Override
	public int playerY() {
		return Client.localPlayer.y;
	}

	@Override
	public int areaSoundEffectsVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int soundEffectsVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int musicVolume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean titleMusicDisabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void titleMusicDisabled(boolean var1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void musicVolume(int var1) {
		// TODO Auto-generated method stub
		
	}

}
