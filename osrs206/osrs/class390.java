package osrs;
public enum class390 implements MouseWheel {
	
	field4422(0, 1), 
	field4418(1, 2), 
	field4419(3, 3), 
	field4420(2, 10);
	
	static int field4423;
	
	final int field4417;
	
	final int field4421;
	class390(int var3, int var4) {
		this.field4417 = var3; // L: 16
		this.field4421 = var4; // L: 17
	} // L: 18
	
	public int rsOrdinal() {
		return this.field4421; // L: 22
	}
	
	static IndexedSprite method7053() {
		IndexedSprite var0 = new IndexedSprite(); // L: 136
		var0.width = ModelData0.SpriteBuffer_spriteWidth; // L: 137
		var0.height = class456.SpriteBuffer_spriteHeight; // L: 138
		var0.xOffset = class426.SpriteBuffer_xOffsets[0]; // L: 139
		var0.yOffset = class142.SpriteBuffer_yOffsets[0]; // L: 140
		var0.subWidth = class359.SpriteBuffer_spriteWidths[0]; // L: 141
		var0.subHeight = class456.SpriteBuffer_spriteHeights[0]; // L: 142
		var0.palette = class13.SpriteBuffer_spritePalette; // L: 143
		var0.pixels = class421.SpriteBuffer_pixels[0]; // L: 144
		class426.SpriteBuffer_xOffsets = null; // L: 146
		class142.SpriteBuffer_yOffsets = null; // L: 147
		class359.SpriteBuffer_spriteWidths = null; // L: 148
		class456.SpriteBuffer_spriteHeights = null; // L: 149
		class13.SpriteBuffer_spritePalette = null; // L: 150
		class421.SpriteBuffer_pixels = null; // L: 151
		return var0; // L: 153
	}
}
