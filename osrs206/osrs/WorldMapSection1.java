package osrs;
public class WorldMapSection1 implements WorldMapSection {
	
	int minPlane;
	
	int planes;
	
	int regionStartX;
	
	int regionStartY;
	
	int regionEndX;
	
	int regionEndY;
	WorldMapSection1() {
	} // L: 14
	
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.regionEndX) { // L: 18
			var1.regionLowX = this.regionEndX;
		}
		if (var1.regionHighX < this.regionEndX) {
			var1.regionHighX = this.regionEndX; // L: 19
		}
		if (var1.regionLowY > this.regionEndY) { // L: 20
			var1.regionLowY = this.regionEndY;
		}
		if (var1.regionHighY < this.regionEndY) { // L: 21
			var1.regionHighY = this.regionEndY;
		}
	} // L: 22
	
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) { // L:
																			// 26
			return var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY; // L:
																						// 29
		} else {
			return false; // L: 27
		}
	}
	
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY; // L:
																				// 34
	}
	
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) { // L: 39
			return null; // L: 40
		} else {
			int[] var4 = new int[]{var2 + (this.regionEndX * 64 - this.regionStartX * 64), var3 + (this.regionEndY * 64 - this.regionStartY * 64)}; // L:
																																					// 42
																																					// 43
																																					// 44
			return var4; // L: 45
		}
	}
	
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) { // L: 50
			return null; // L: 51
		} else {
			int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1; // L:
																				// 53
			int var4 = var2 + (this.regionStartY * 64 - this.regionEndY * 64); // L:
																				// 54
			return new Coord(this.minPlane, var3, var4); // L: 55
		}
	}
	
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte(); // L: 60
		this.planes = var1.readUnsignedByte(); // L: 61
		this.regionStartX = var1.readUnsignedShort(); // L: 62
		this.regionStartY = var1.readUnsignedShort(); // L: 63
		this.regionEndX = var1.readUnsignedShort(); // L: 64
		this.regionEndY = var1.readUnsignedShort(); // L: 65
		this.postRead(); // L: 66
	} // L: 67
	
	void postRead() {
	} // L: 69
}
