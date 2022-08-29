package osrs;
public class WorldMapSection0 implements WorldMapSection {
	
	int oldZ;
	
	int newZ;
	
	int oldX;
	
	int oldY;
	
	int newX;
	
	int newY;
	
	int oldChunkXLow;
	
	int oldChunkYLow;
	
	int oldChunkXHigh;
	
	int oldChunkYHigh;
	
	int newChunkXLow;
	
	int newChunkYLow;
	
	int newChunkXHigh;
	
	int newChunkYHigh;
	WorldMapSection0() {
	}
	
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}
		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}
		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}
		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}
	}
	
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.oldZ + this.newZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}
	
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7; // L:
																																																													// 42
	}
	
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.newX * 64 - this.oldX * 64) + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}
	
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = var2 + (this.oldY * 64 - this.newY * 64) + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}
	
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte(); // L: 78
		this.newY = var1.readUnsignedShort(); // L: 79
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}
	
	void postRead() {
	}
	
	public static void method4936(AbstractArchive var0) {
		EnumComposition.EnumDefinition_archive = var0;
	} // L: 26
	
	public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
		int var3 = var0.length(); // L: 11
		int var4 = var1.length(); // L: 12
		int var5 = 0; // L: 13
		int var6 = 0; // L: 14
		char var7 = 0; // L: 15
		char var8 = 0; // L: 16
		while (var5 - var7 < var3 || var6 - var8 < var4) { // L: 18
			if (var5 - var7 >= var3) { // L: 19
				return -1;
			}
			if (var6 - var8 >= var4) { // L: 20
				return 1;
			}
			char var9;
			if (var7 != 0) { // L: 23
				var9 = var7; // L: 24
				boolean var14 = false; // L: 25
			} else {
				var9 = var0.charAt(var5++); // L: 27
			}
			char var10;
			if (var8 != 0) { // L: 28
				var10 = var8; // L: 29
				boolean var15 = false; // L: 30
			} else {
				var10 = var1.charAt(var6++); // L: 32
			}
			var7 = class127.method2848(var9); // L: 33
			var8 = class127.method2848(var10); // L: 34
			var9 = FileSystem.standardizeChar(var9, var2); // L: 35
			var10 = FileSystem.standardizeChar(var10, var2); // L: 36
			if (var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) { // L:
																								// 37
				var9 = Character.toLowerCase(var9); // L: 38
				var10 = Character.toLowerCase(var10); // L: 39
				if (var10 != var9) { // L: 40
					return class137.lowercaseChar(var9, var2) - class137.lowercaseChar(var10, var2);
				}
			}
		}
		int var16 = Math.min(var3, var4); // L: 43
		char var12;
		int var17;
		for (var17 = 0; var17 < var16; ++var17) { // L: 44
			if (var2 == Language.Language_FR) { // L: 45
				var5 = var3 - 1 - var17; // L: 46
				var6 = var4 - 1 - var17; // L: 47
			} else {
				var6 = var17; // L: 49
				var5 = var17;
			}
			char var11 = var0.charAt(var5); // L: 50
			var12 = var1.charAt(var6); // L: 51
			if (var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) { // L:
																									// 52
				var11 = Character.toLowerCase(var11); // L: 53
				var12 = Character.toLowerCase(var12); // L: 54
				if (var11 != var12) {
					return class137.lowercaseChar(var11, var2) - class137.lowercaseChar(var12, var2); // L:
																										// 55
				}
			}
		}
		var17 = var3 - var4; // L: 58
		if (var17 != 0) { // L: 59
			return var17;
		} else {
			for (int var18 = 0; var18 < var16; ++var18) { // L: 60
				var12 = var0.charAt(var18); // L: 61
				char var13 = var1.charAt(var18); // L: 62
				if (var12 != var13) { // L: 63
					return class137.lowercaseChar(var12, var2) - class137.lowercaseChar(var13, var2);
				}
			}
			return 0; // L: 65
		}
	}
	
	static int method4947(Widget var0) {
		if (var0.type != 11) { // L: 1248
			Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																									// 1249
			return 1; // L: 1250
		} else {
			String var1 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
																											// 1252
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var0.method5626(var1); // L:
			// 1253
			return 1; // L: 1254
		}
	}
}
