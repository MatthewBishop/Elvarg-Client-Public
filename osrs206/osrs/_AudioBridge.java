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
	public int method2262() {
		return class19.clientPreferences.method2262();
	}

	@Override
	public int method2241() {
		return class19.clientPreferences.method2241();
	}

	@Override
	public int method2258() {
		return class19.clientPreferences.method2258();
	}

	@Override
	public boolean method2317() {
		return class19.clientPreferences.method2317();
	}

	@Override
	public void method2248(boolean var1) {
		class19.clientPreferences.method2248(var1);
	}

	@Override
	public void method2297(int var1) {
		class19.clientPreferences.method2297(var1);	
	}

}
