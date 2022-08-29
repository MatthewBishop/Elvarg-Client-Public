package osrs;
public class class228 implements WorldMapSection {
	
	static IndexedSprite options_buttons_2Sprite;
	public static boolean[] Widget_loadedInterfaces;
	
	static int cameraZ;
	
	int field2762;
	
	int field2761;
	
	int field2751;
	
	int field2752;
	
	int field2749;
	
	int field2754;
	
	int field2750;
	
	int field2756;
	
	int field2757;
	
	int field2758;
	class228() {
	} // L: 18
	
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2749) { // L: 22
			var1.regionLowX = this.field2749;
		}
		if (var1.regionHighX < this.field2749) {
			var1.regionHighX = this.field2749; // L: 23
		}
		if (var1.regionLowY > this.field2754) { // L: 24
			var1.regionLowY = this.field2754;
		}
		if (var1.regionHighY < this.field2754) { // L: 25
			var1.regionHighY = this.field2754;
		}
	} // L: 26
	
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field2762 && var1 < this.field2761 + this.field2762) { // L:
																				// 30
			return var2 >= (this.field2751 << 6) + (this.field2750 << 3) && var2 <= (this.field2751 << 6) + (this.field2750 << 3) + 7 && var3 >= (this.field2752 << 6) + (this.field2756 << 3) && var3 <= (this.field2752 << 6) + (this.field2756 << 3) + 7; // L:
																																																																// 33
		} else {
			return false; // L: 31
		}
	}
	
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field2749 << 6) + (this.field2757 << 3) && var1 <= (this.field2749 << 6) + (this.field2757 << 3) + 7 && var2 >= (this.field2754 << 6) + (this.field2758 << 3) && var2 <= (this.field2754 << 6) + (this.field2758 << 3) + 7; // L:
																																																															// 38
	}
	
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field2749 * 64 - this.field2751 * 64) + (this.field2757 * 8 - this.field2750 * 8), var3 + (this.field2754 * 64 - this.field2752 * 64) + (this.field2758 * 8 - this.field2756 * 8)};
			return var4; // L: 49
		}
	}
	
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) { // L: 54
			return null; // L: 55
		} else {
			int var3 = this.field2751 * 64 - this.field2749 * 64 + (this.field2750 * 8 - this.field2757 * 8) + var1; // L:
			// 57
			int var4 = var2 + (this.field2752 * 64 - this.field2754 * 64) + (this.field2756 * 8 - this.field2758 * 8); // L:
			// 58
			return new Coord(this.field2762, var3, var4); // L: 59
		}
	}
	
	public void read(Buffer var1) {
		this.field2762 = var1.readUnsignedByte(); // L: 64
		this.field2761 = var1.readUnsignedByte(); // L: 65
		this.field2751 = var1.readUnsignedShort(); // L: 66
		this.field2750 = var1.readUnsignedByte(); // L: 67
		this.field2752 = var1.readUnsignedShort(); // L: 68
		this.field2756 = var1.readUnsignedByte(); // L: 69
		this.field2749 = var1.readUnsignedShort(); // L: 70
		this.field2757 = var1.readUnsignedByte(); // L: 71
		this.field2754 = var1.readUnsignedShort(); // L: 72
		this.field2758 = var1.readUnsignedByte(); // L: 73
		this.method4882(); // L: 74
	} // L: 75
	
	void method4882() {
	} // L: 77
	
	public static void method4899() {
		ByteArrayPool.field4202.clear(); // L: 43
		ByteArrayPool.field4202.add(100); // L: 44
		ByteArrayPool.field4202.add(5000); // L: 45
		ByteArrayPool.field4202.add(10000); // L: 46
		ByteArrayPool.field4202.add(30000); // L: 47
	} // L: 48
}
