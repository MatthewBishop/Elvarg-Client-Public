package osrs;
public class World {
	
	static int World_count;
	
	static int World_listCount;
	static int[] World_sortOption2;
	static int[] World_sortOption1;
	static String otp;
	
	int id;
	
	int properties;
	
	int population;
	String host;
	String activity;
	
	int location;
	
	int index;
	static {
		World_count = 0; // L: 14
		World_listCount = 0; // L: 15
		World_sortOption2 = new int[]{1, 1, 1, 1}; // L: 16
		World_sortOption1 = new int[]{0, 1, 2, 3}; // L: 17
	}
	World() {
	} // L: 27
	
	boolean isMembersOnly() {
		return (1 & this.properties) != 0; // L: 247
	}
	
	boolean method1628() {
		return (2 & this.properties) != 0; // L: 251
	}
	
	boolean isPvp() {
		return (4 & this.properties) != 0; // L: 255
	}
	
	boolean method1594() {
		return (8 & this.properties) != 0; // L: 259
	}
	
	boolean isDeadman() {
		return (536870912 & this.properties) != 0; // L: 263
	}
	
	boolean isBeta() {
		return (33554432 & this.properties) != 0; // L: 267
	}
	
	boolean method1597() {
		return (1073741824 & this.properties) != 0; // L: 271
	}
	
	public static Clock method1601() {
		try {
			return new NanoClock(); // L: 8
		} catch (Throwable var1) { // L: 10
			return new MilliClock(); // L: 11
		}
	}
	
	static final void method1627() {
		for (Projectile var0 = (Projectile) Client.projectiles.last(); var0 != null; var0 = (Projectile) Client.projectiles.previous()) { // L:
																																			// 4850
																																			// 4851
																																			// 4868
			if (var0.plane == PacketWriter.Client_plane && Client.cycle <= var0.cycleEnd) { // L:
																							// 4852
				if (Client.cycle >= var0.cycleStart) { // L: 4853
					if (var0.targetIndex > 0) { // L: 4854
						NPC var1 = Client.npcs[var0.targetIndex - 1]; // L: 4855
						if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) { // L:
																												// 4856
							var0.setDestination(var1.x, var1.y, SceneTilePaint.getTileHeight(var1.x, var1.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}
					if (var0.targetIndex < 0) { // L: 4858
						int var2 = -var0.targetIndex - 1; // L: 4860
						Player var3;
						if (var2 == Client.localPlayerIndex) { // L: 4861
							var3 = class101.localPlayer;
						} else {
							var3 = Client.players[var2]; // L: 4862
						}
						if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
							var0.setDestination(var3.x, var3.y, SceneTilePaint.getTileHeight(var3.x, var3.y, var0.plane) - var0.endHeight, Client.cycle); // L:
																																							// 4863
						}
					}
					var0.advance(Client.field555); // L: 4865
					class356.scene.drawEntity(PacketWriter.Client_plane, (int) var0.x, (int) var0.y, (int) var0.z, 60, var0, var0.yaw, -1L, false); // L:
																																					// 4866
				}
			} else {
				var0.remove();
			}
		}
	} // L: 4870
}
