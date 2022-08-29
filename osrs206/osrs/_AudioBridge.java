package osrs;

import adapter.IAudioBridge;

public class _AudioBridge implements IAudioBridge {

	@Override
	public int playerX() {
		return class101.localPlayer.x;
	}

	@Override
	public int playerY() {
		return class101.localPlayer.y;
	}

	@Override
	public int areaSoundEffectsVolume() {
		return class19.clientPreferences.method2262();
	}

	@Override
	public int soundEffectsVolume() {
		return class19.clientPreferences.method2241();
	}

	@Override
	public int musicVolume() {
		return class19.clientPreferences.method2258();
	}

	@Override
	public boolean titleMusicDisabled() {
		return class19.clientPreferences.method2317();
	}

	@Override
	public void titleMusicDisabled(boolean var1) {
		class19.clientPreferences.method2248(var1);
	}

	@Override
	public void musicVolume(int var1) {
		class19.clientPreferences.method2297(var1);	
	}

}
