package osrs;
import javax.imageio.ImageIO;
public class class28 {
	
	static int baseX;
	
	static SpritePixels[] headIconPrayerSprites;
	static {
		ImageIO.setUseCache(false); // L: 12
	} // L: 13
	
	static final void method352(int var0, int var1, int var2) {
		int var3;
		for (var3 = 0; var3 < 8; ++var3) { // L: 130
			for (int var4 = 0; var4 < 8; ++var4) { // L: 131
				Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
			}
		}
		if (var1 > 0) { // L: 133
			for (var3 = 1; var3 < 8; ++var3) { // L: 134
				Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
			}
		}
		if (var2 > 0) { // L: 136
			for (var3 = 1; var3 < 8; ++var3) { // L: 137
				Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
			}
		}
		if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) { // L:
																			// 139
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
		} else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) { // L:
																					// 140
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) { // L:
																									// 141
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
		}
	} // L: 142
}
