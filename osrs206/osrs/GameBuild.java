package osrs;
public class GameBuild {
	
	static int field3588;
	
	static final GameBuild LIVE;
	
	static final GameBuild BUILDLIVE;
	
	static final GameBuild RC;
	
	static final GameBuild WIP;
	public final String name;
	
	public final int buildId;
	static {
		LIVE = new GameBuild("LIVE", 0); // L: 5
		BUILDLIVE = new GameBuild("BUILDLIVE", 3); // L: 6
		RC = new GameBuild("RC", 1); // L: 7
		WIP = new GameBuild("WIP", 2); // L: 8
	}
	GameBuild(String var1, int var2) {
		this.name = var1; // L: 17
		this.buildId = var2; // L: 18
	} // L: 19
}
