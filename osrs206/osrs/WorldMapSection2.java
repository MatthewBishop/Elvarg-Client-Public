package osrs;

public class WorldMapSection2 implements WorldMapSection {
	
	int minPlane;
	
	int planes;
	
	int regionStartX;
	
	int regionStartY;
	
	int regionEndX;
	
	int regionEndY;
	
	int field2693;
	
	int field2689;
	
	int field2695;
	
	int field2687;
	WorldMapSection2() {
	} // L: 18
	
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2693) { // L: 22
			var1.regionLowX = this.field2693;
		}
		if (var1.regionHighX < this.field2695) {
			var1.regionHighX = this.field2695; // L: 23
		}
		if (var1.regionLowY > this.field2689) { // L: 24
			var1.regionLowY = this.field2689;
		}
		if (var1.regionHighY < this.field2687) { // L: 25
			var1.regionHighY = this.field2687;
		}
	} // L: 26
	
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) { // L:
																			// 30
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY; // L:
																																						// 33
		} else {
			return false; // L: 31
		}
	}
	
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field2693 && var1 >> 6 <= this.field2695 && var2 >> 6 >= this.field2689 && var2 >> 6 <= this.field2687; // L:
																																			// 38
	}
	
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) { // L: 43
			return null; // L: 44
		} else {
			int[] var4 = new int[]{var2 + (this.field2693 * 64 - this.regionStartX * 64), var3 + (this.field2689 * 64 - this.regionStartY * 64)}; // L:
																																					// 46
																																					// 47
																																					// 48
			return var4; // L: 49
		}
	}
	
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) { // L: 54
			return null; // L: 55
		} else {
			int var3 = this.regionStartX * 64 - this.field2693 * 64 + var1; // L:
																			// 57
			int var4 = var2 + (this.regionStartY * 64 - this.field2689 * 64); // L:
																				// 58
			return new Coord(this.minPlane, var3, var4); // L: 59
		}
	}
	
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte(); // L: 64
		this.planes = var1.readUnsignedByte(); // L: 65
		this.regionStartX = var1.readUnsignedShort(); // L: 66
		this.regionStartY = var1.readUnsignedShort(); // L: 67
		this.regionEndX = var1.readUnsignedShort(); // L: 68
		this.regionEndY = var1.readUnsignedShort(); // L: 69
		this.field2693 = var1.readUnsignedShort(); // L: 70
		this.field2689 = var1.readUnsignedShort(); // L: 71
		this.field2695 = var1.readUnsignedShort(); // L: 72
		this.field2687 = var1.readUnsignedShort(); // L: 73
		this.postRead(); // L: 74
	} // L: 75
	
	void postRead() {
	} // L: 77
	
	public static boolean loadInterface(int var0) {
		if (class228.Widget_loadedInterfaces[var0]) { // L: 237
			return true;
		} else if (!_Junk.Widget_archive.tryLoadGroup(var0)) { // L:
																				// 238
			return false;
		} else {
			int var1 = _Junk.Widget_archive.getGroupFileCount(var0); // L:
																					// 239
			if (var1 == 0) { // L: 240
				class228.Widget_loadedInterfaces[var0] = true; // L: 241
				return true; // L: 242
			} else {
				if (_Junk.Widget_interfaceComponents[var0] == null) { // L:
																			// 244
					_Junk.Widget_interfaceComponents[var0] = new Widget[var1];
				}
				for (int var2 = 0; var2 < var1; ++var2) { // L: 245
					if (_Junk.Widget_interfaceComponents[var0][var2] == null) { // L:
																						// 246
						byte[] var3 = _Junk.Widget_archive.takeFile(var0, var2); // L:
																								// 247
						if (var3 != null) { // L: 248
							_Junk.Widget_interfaceComponents[var0][var2] = new Widget(); // L:
																								// 249
							_Junk.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16); // L:
																										// 250
							if (var3[0] == -1) { // L: 251
								_Junk.Widget_interfaceComponents[var0][var2].decode(new Buffer(var3));
							} else {
								_Junk.Widget_interfaceComponents[var0][var2].decodeLegacy(new Buffer(var3)); // L:
								// 252
							}
						}
					}
				}
				class228.Widget_loadedInterfaces[var0] = true; // L: 256
				return true; // L: 257
			}
		}
	}
}
