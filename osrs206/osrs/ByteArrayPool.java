package osrs;
import java.util.ArrayList;
import java.util.HashMap;
public class ByteArrayPool {
	
	static int ByteArrayPool_smallCount;
	
	static int ByteArrayPool_mediumCount;
	
	static int ByteArrayPool_largeCount;
	
	static int field4216;
	
	static int field4207;
	
	static int field4208;
	
	static int field4209;
	
	static int field4210;
	static byte[][] ByteArrayPool_small;
	static byte[][] ByteArrayPool_medium;
	static byte[][] ByteArrayPool_large;
	static byte[][] field4214;
	public static ArrayList field4202;
	static {
		ByteArrayPool_smallCount = 0; // L: 13
		ByteArrayPool_mediumCount = 0; // L: 14
		ByteArrayPool_largeCount = 0; // L: 15
		field4216 = 0; // L: 16
		field4207 = 1000; // L: 17
		field4208 = 250; // L: 18
		field4209 = 100; // L: 19
		field4210 = 50; // L: 20
		ByteArrayPool_small = new byte[1000][]; // L: 21
		ByteArrayPool_medium = new byte[250][]; // L: 22
		ByteArrayPool_large = new byte[100][]; // L: 23
		field4214 = new byte[50][]; // L: 24
		field4202 = new ArrayList(); // L: 28
		class228.method4899(); // L: 31
		new HashMap();
	} // L: 36
	
	static synchronized byte[] ByteArrayPool_getArrayBool(int var0, boolean var1) {
		byte[] var4;
		if (var0 != 100) { // L: 52
			if (var0 < 100) {
			}
		} else if (ByteArrayPool_smallCount > 0) {
			var4 = ByteArrayPool_small[--ByteArrayPool_smallCount]; // L: 53
			ByteArrayPool_small[ByteArrayPool_smallCount] = null; // L: 54
			return var4; // L: 55
		}
		if (var0 != 5000) { // L: 57
			if (var0 < 5000) {
			}
		} else if (ByteArrayPool_mediumCount > 0) {
			var4 = ByteArrayPool_medium[--ByteArrayPool_mediumCount]; // L: 58
			ByteArrayPool_medium[ByteArrayPool_mediumCount] = null; // L: 59
			return var4; // L: 60
		}
		if (var0 != 10000) { // L: 62
			if (var0 < 10000) {
			}
		} else if (ByteArrayPool_largeCount > 0) {
			var4 = ByteArrayPool_large[--ByteArrayPool_largeCount]; // L: 63
			ByteArrayPool_large[ByteArrayPool_largeCount] = null; // L: 64
			return var4; // L: 65
		}
		if (var0 != 30000) { // L: 67
			if (var0 < 30000) {
			}
		} else if (field4216 > 0) {
			var4 = field4214[--field4216]; // L: 68
			field4214[field4216] = null; // L: 69
			return var4; // L: 70
		}
		if (class464.ByteArrayPool_arrays != null) { // L: 72
			for (int var2 = 0; var2 < Canvas.ByteArrayPool_alternativeSizes.length; ++var2) { // L:
																								// 73
				if (Canvas.ByteArrayPool_alternativeSizes[var2] != var0) { // L:
																			// 74
					if (var0 < Canvas.ByteArrayPool_alternativeSizes[var2]) {
					}
				} else if (class17.ByteArrayPool_altSizeArrayCounts[var2] > 0) {
					byte[] var3 = class464.ByteArrayPool_arrays[var2][--class17.ByteArrayPool_altSizeArrayCounts[var2]]; // L:
					// 75
					class464.ByteArrayPool_arrays[var2][class17.ByteArrayPool_altSizeArrayCounts[var2]] = null; // L:
																												// 76
					return var3; // L: 77
				}
			}
		}
		return new byte[var0]; // L: 90
	}
	
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) { // L: 4802
			var0.isUnanimated = false; // L: 4803
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.idleSequence == var0.movementSequence) { // L:
																																							// 4804
																																							// 4805
				var0.isUnanimated = true;
			}
			int var2 = var0.x >> 7; // L: 4807
			int var3 = var0.y >> 7; // L: 4808
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) { // L: 4809
				long var4 = TaskHandler.calculateTag(0, 0, 0, false, var0.index); // L:
																					// 4810
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) { // L:
																																// 4811
					var0.isUnanimated = false; // L: 4812
					var0.tileHeight = SceneTilePaint.getTileHeight(var0.x, var0.y, PacketWriter.Client_plane); // L:
					// 4813
					var0.playerCycle = Client.cycle; // L: 4814
					class356.scene.addNullableObject(PacketWriter.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.minX, var0.minY, var0.maxX, var0.maxY); // L:
																																																// 4815
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) { // L:
																		// 4818
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) { // L:
																									// 4819
							return;
						}
						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount; // L:
																							// 4820
					}
					var0.tileHeight = SceneTilePaint.getTileHeight(var0.x, var0.y, PacketWriter.Client_plane); // L:
					// 4822
					var0.playerCycle = Client.cycle; // L: 4823
					class356.scene.drawEntity(PacketWriter.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking); // L:
																																							// 4824
				}
			}
		}
	} // L: 4828
}
