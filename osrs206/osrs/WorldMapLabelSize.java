package osrs;

public class WorldMapLabelSize {
	
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	
	static int baseY;
	
	final int field2671;
	
	final int field2672;
	
	final int field2676;
	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(2, 0, 4); // L: 7
		WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2); // L: 8
		WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0); // L: 9
	}
	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field2671 = var1; // L: 19
		this.field2672 = var2; // L: 20
		this.field2676 = var3; // L: 21
	} // L: 22
	
	boolean method4567(float var1) {
		return var1 >= (float) this.field2676; // L: 25
	}
	
	static WorldMapLabelSize[] method4568() {
		return new WorldMapLabelSize[]{WorldMapLabelSize_small, WorldMapLabelSize_large, WorldMapLabelSize_medium}; // L:
		// 15
	}
	
	public static boolean method4575(int var0) {
		return var0 == WorldMapDecorationType.field3544.id; // L: 47
	}
	
	static void runWidgetOnLoadListener(int var0) {
		if (var0 != -1) { // L: 4972
			if (WorldMapSection2.loadInterface(var0)) { // L: 4973
				Widget[] var1 = _Junk.Widget_interfaceComponents[var0]; // L:
																				// 4974
				for (int var2 = 0; var2 < var1.length; ++var2) { // L: 4975
					Widget var3 = var1[var2]; // L: 4976
					if (var3.onLoad != null) { // L: 4977
						ScriptEvent var4 = new ScriptEvent(); // L: 4978
						var4.widget = var3; // L: 4979
						var4.args = var3.onLoad; // L: 4980
						class135.runScript(var4, 5000000, 0); // L: 4981
					}
				}
			}
		}
	} // L: 4984
	
	static void setWindowedMode(int var0) {
		Client.field711 = 0L; // L: 4371
		if (var0 >= 2) { // L: 4372
			Client.isResizable = true;
		} else {
			Client.isResizable = false; // L: 4373
		}
		if (class9.getWindowedMode() == 1) { // L: 4374
			class353.client.setMaxCanvasSize(765, 503); // L: 4375
		} else {
			class353.client.setMaxCanvasSize(7680, 2160); // L: 4378
		}
		if (Client.gameState >= 25) { // L: 4380
			SpriteMask.method5522();
		}
	} // L: 4381
	
	static void method4566(int var0) {
		class20.tempMenuAction = new MenuAction(); // L: 11719
		class20.tempMenuAction.param0 = Client.menuArguments1[var0]; // L: 11720
		class20.tempMenuAction.param1 = Client.menuArguments2[var0]; // L: 11721
		class20.tempMenuAction.opcode = Client.menuOpcodes[var0]; // L: 11722
		class20.tempMenuAction.identifier = Client.menuIdentifiers[var0]; // L:
																			// 11723
		class20.tempMenuAction.action = Client.menuActions[var0]; // L: 11724
	} // L: 11725
}
