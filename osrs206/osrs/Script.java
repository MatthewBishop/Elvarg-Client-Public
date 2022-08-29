package osrs;
import java.io.IOException;

import audioengine.StaticSound;
public class Script extends DualNode {
	
	static EvictingDualNodeHashTable Script_cached;
	
	public static int canvasWidth;
	String field967;
	int[] opcodes;
	int[] intOperands;
	String[] stringOperands;
	
	int localIntCount;
	
	int localStringCount;
	
	int intArgumentCount;
	
	int stringArgumentCount;
	
	IterableNodeHashTable[] switches;
	static {
		Script_cached = new EvictingDualNodeHashTable(128); // L: 12
	}
	Script() {
	} // L: 23
	
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1]; // L: 127
	}
	
	static final void method1977(Actor var0) {
		if (var0.field1129 != 0) { // L: 4279
			if (var0.targetIndex != -1) { // L: 4280
				Object var1 = null; // L: 4281
				if (var0.targetIndex < 32768) { // L: 4282
					var1 = Client.npcs[var0.targetIndex];
				} else if (var0.targetIndex >= 32768) { // L: 4283
					var1 = Client.players[var0.targetIndex - 32768];
				}
				if (var1 != null) { // L: 4284
					int var2 = var0.x - ((Actor) var1).x; // L: 4285
					int var3 = var0.y - ((Actor) var1).y; // L: 4286
					if (var2 != 0 || var3 != 0) { // L: 4287
						var0.orientation = (int) (Math.atan2((double) var2, (double) var3) * 325.949D) & 2047;
					}
				} else if (var0.false0) { // L: 4289
					var0.targetIndex = -1; // L: 4290
					var0.false0 = false; // L: 4291
				}
			}
			if (var0.field1165 != -1 && (var0.pathLength == 0 || var0.field1202 > 0)) { // L:
																						// 4294
				var0.orientation = var0.field1165; // L: 4295
				var0.field1165 = -1; // L: 4296
			}
			int var4 = var0.orientation - var0.rotation & 2047; // L: 4298
			if (var4 == 0 && var0.false0) { // L: 4299
				var0.targetIndex = -1; // L: 4300
				var0.false0 = false; // L: 4301
			}
			if (var4 != 0) { // L: 4303
				++var0.field1196; // L: 4304
				boolean var6;
				if (var4 > 1024) { // L: 4305
					var0.rotation -= var0.field1161 ? var4 : var0.field1129 * 124924459 * 881523843; // L:
																										// 4306
					var6 = true; // L: 4307
					if (var4 < var0.field1129 || var4 > 2048 - var0.field1129) { // L:
																					// 4308
						var0.rotation = var0.orientation; // L: 4309
						var6 = false; // L: 4310
					}
					if (!var0.field1161 && var0.idleSequence == var0.movementSequence && (var0.field1196 > 25 || var6)) { // L:
																															// 4312
						if (var0.turnLeftSequence != -1) { // L: 4313
							var0.movementSequence = var0.turnLeftSequence;
						} else {
							var0.movementSequence = var0.walkSequence; // L:
																		// 4314
						}
					}
				} else {
					var0.rotation += var0.field1161 ? var4 : 124924459 * var0.field1129 * 881523843; // L:
																										// 4318
					var6 = true; // L: 4319
					if (var4 < var0.field1129 || var4 > 2048 - var0.field1129) { // L:
																					// 4320
						var0.rotation = var0.orientation; // L: 4321
						var6 = false; // L: 4322
					}
					if (!var0.field1161 && var0.movementSequence == var0.idleSequence && (var0.field1196 > 25 || var6)) { // L:
																															// 4324
						if (var0.turnRightSequence != -1) { // L: 4325
							var0.movementSequence = var0.turnRightSequence;
						} else {
							var0.movementSequence = var0.walkSequence; // L:
																		// 4326
						}
					}
				}
				var0.rotation &= 2047; // L: 4330
				var0.field1161 = false; // L: 4331
			} else {
				var0.field1196 = 0; // L: 4333
			}
		}
	} // L: 4334
	
	static final void method1978(boolean var0) {
		StaticSound.playPcmPlayers(); // L: 5708
		++Client.packetWriter.pendingWrites; // L: 5709
		if (Client.packetWriter.pendingWrites >= 50 || var0) { // L: 5710
			Client.packetWriter.pendingWrites = 0; // L: 5711
			if (!Client.hadNetworkError && Client.packetWriter.getSocket() != null) { // L:
																						// 5712
				PacketBufferNode var1 = EnumComposition.getPacketBufferNode(ClientPacket.field2969, Client.packetWriter.isaacCipher); // L:
																																		// 5714
				Client.packetWriter.addNode(var1); // L: 5715
				try {
					Client.packetWriter.flush(); // L: 5717
				} catch (IOException var3) { // L: 5719
					Client.hadNetworkError = true; // L: 5720
				}
			}
		}
	} // L: 5723
}
