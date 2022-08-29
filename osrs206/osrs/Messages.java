package osrs;
import java.util.HashMap;
import java.util.Map;
public class Messages {
	static final Map Messages_channels;
	
	static final IterableNodeHashTable Messages_hashTable;
	
	static final IterableDualNodeQueue Messages_queue;
	
	static int Messages_count;
	
	static int gameCyclesToDo;
	static {
		Messages_channels = new HashMap(); // L: 9
		Messages_hashTable = new IterableNodeHashTable(1024); // L: 10
		Messages_queue = new IterableDualNodeQueue(); // L: 11
		Messages_count = 0; // L: 12
	}
	
	static final void method2494() {
		if (Client.field725 != PacketWriter.Client_plane) { // L: 3807
			Client.field725 = PacketWriter.Client_plane; // L: 3808
			int var0 = PacketWriter.Client_plane; // L: 3809
			int[] var1 = FloorUnderlayDefinition.sceneMinimapSprite.pixels; // L:
																			// 3811
			int var2 = var1.length; // L: 3812
			int var3;
			for (var3 = 0; var3 < var2; ++var3) { // L: 3813
				var1[var3] = 0;
			}
			int var4;
			int var5;
			for (var3 = 1; var3 < 103; ++var3) { // L: 3814
				var4 = (103 - var3) * 2048 + 24628; // L: 3815
				for (var5 = 1; var5 < 103; ++var5) { // L: 3816
					if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) { // L:
																					// 3817
						class356.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
					}
					if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
						class356.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3); // L:
																								// 3818
					}
					var4 += 4; // L: 3819
				}
			}
			var3 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + (238 + (int) (Math.random() * 20.0D) - 10); // L:
																																									// 3822
			var4 = 238 + (int) (Math.random() * 20.0D) - 10 << 16; // L: 3823
			FloorUnderlayDefinition.sceneMinimapSprite.setRaster(); // L: 3824
			int var6;
			for (var5 = 1; var5 < 103; ++var5) { // L: 3825
				for (var6 = 1; var6 < 103; ++var6) { // L: 3826
					if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) { // L:
																					// 3827
						_Junk.drawObject(var0, var6, var5, var3, var4);
					}
					if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) { // L:
																								// 3828
						_Junk.drawObject(var0 + 1, var6, var5, var3, var4);
					}
				}
			}
			Client.mapIconCount = 0; // L: 3831
			for (var5 = 0; var5 < 104; ++var5) { // L: 3832
				for (var6 = 0; var6 < 104; ++var6) { // L: 3833
					long var7 = class356.scene.getFloorDecorationTag(PacketWriter.Client_plane, var5, var6); // L:
																												// 3834
					if (0L != var7) { // L: 3835
						int var9 = _Junk.Entity_unpackID(var7); // L: 3836
						int var10 = class162.getObjectDefinition(var9).mapIconId; // L:
																					// 3837
						if (var10 >= 0 && class432.WorldMapElement_get(var10).field1837) { // L:
																							// 3838
																							// 3839
							Client.mapIcons[Client.mapIconCount] = class432.WorldMapElement_get(var10).getSpriteBool(false); // L:
																																// 3842
							Client.mapIconXs[Client.mapIconCount] = var5; // L:
																			// 3843
							Client.mapIconYs[Client.mapIconCount] = var6; // L:
																			// 3844
							++Client.mapIconCount; // L: 3845
						}
					}
				}
			}
			Message.rasterProvider.apply(); // L: 3850
		}
	} // L: 3853
}
