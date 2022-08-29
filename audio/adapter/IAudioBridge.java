package adapter;

/*
uses preferences

2248
2297
 */

public interface IAudioBridge {

	int playerX();
	int playerY();
	int areaSoundEffectsVolume();
	int soundEffectsVolume();
	int musicVolume();
	boolean titleMusicDisabled();
	void titleMusicDisabled(boolean var1);
	void musicVolume(int var1);
}
