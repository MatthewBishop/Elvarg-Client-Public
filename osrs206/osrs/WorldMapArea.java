package osrs;
import java.util.Iterator;
import java.util.LinkedList;
public class WorldMapArea {
	
	int id;
	String internalName;
	String externalName;
	
	int backGroundColor;
	
	int zoom;
	
	Coord origin;
	
	int regionLowX;
	
	int regionHighX;
	
	int regionLowY;
	
	int regionHighY;
	boolean isMain;
	LinkedList sections;
	public WorldMapArea() {
		this.id = -1; // L: 9
		this.backGroundColor = -1;
		this.zoom = -1; // L: 13
		this.origin = null; // L: 14
		this.regionLowX = Integer.MAX_VALUE; // L: 15
		this.regionHighX = 0;
		this.regionLowY = Integer.MAX_VALUE; // L: 17
		this.regionHighY = 0; // L: 18
		this.isMain = false; // L: 19
	}
	
	public void read(Buffer var1, int var2) {
		this.id = var2; // L: 23
		this.internalName = var1.readStringCp1252NullTerminated(); // L: 24
		this.externalName = var1.readStringCp1252NullTerminated(); // L: 25
		this.origin = new Coord(var1.readInt()); // L: 26
		this.backGroundColor = var1.readInt(); // L: 27
		var1.readUnsignedByte(); // L: 28
		this.isMain = var1.readUnsignedByte() == 1; // L: 29
		this.zoom = var1.readUnsignedByte(); // L: 30
		int var3 = var1.readUnsignedByte(); // L: 31
		this.sections = new LinkedList(); // L: 32
		for (int var4 = 0; var4 < var3; ++var4) { // L: 33
			this.sections.add(this.readWorldMapSection(var1)); // L: 34
		}
		this.setBounds(); // L: 36
	} // L: 37
	
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte(); // L: 40
		WorldMapSectionType var3 = (WorldMapSectionType) Actor.findEnumerated(WorldMapSectionType.method4950(), var2); // L:
		// 41
		Object var4 = null; // L: 42
		switch (var3.type) { // L: 43
			case 0 :
				var4 = new class228(); // L: 48
				break; // L: 49
			case 1 :
				var4 = new WorldMapSection2(); // L: 53
				break; // L: 54
			case 2 :
				var4 = new WorldMapSection0(); // L: 56
				break;
			case 3 :
				var4 = new WorldMapSection1(); // L: 45
				break;
			default :
				throw new IllegalStateException(""); // L: 51
		}
		((WorldMapSection) var4).read(var1); // L: 59
		return (WorldMapSection) var4; // L: 60
	}
	
	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator(); // L: 64
		WorldMapSection var5;
		do {
			if (!var4.hasNext()) { // L: 71
				return false; // L: 72
			}
			var5 = (WorldMapSection) var4.next(); // L: 65
		} while (!var5.containsCoord(var1, var2, var3)); // L: 67
		return true; // L: 68
	}
	
	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64; // L: 76
		int var4 = var2 / 64; // L: 77
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) { // L: 78
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) { // L: 79
				Iterator var5 = this.sections.iterator(); // L: 80
				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false; // L: 88
					}
					var6 = (WorldMapSection) var5.next(); // L: 81
				} while (!var6.containsPosition(var1, var2)); // L: 83
				return true; // L: 84
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator(); // L: 92
		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null; // L: 100
			}
			var5 = (WorldMapSection) var4.next(); // L: 93
		} while (!var5.containsCoord(var1, var2, var3)); // L: 95
		return var5.getBorderTileLengths(var1, var2, var3); // L: 96
	}
	
	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator(); // L: 104
		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null; // L: 112
			}
			var4 = (WorldMapSection) var3.next(); // L: 105
		} while (!var4.containsPosition(var1, var2)); // L: 107
		return var4.coord(var1, var2); // L: 108
	}
	
	void setBounds() {
		Iterator var1 = this.sections.iterator(); // L: 116
		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection) var1.next(); // L: 117
			var2.expandBounds(this); // L: 119
		}
	} // L: 122
	
	public int getId() {
		return this.id; // L: 125
	}
	
	public boolean getIsMain() {
		return this.isMain; // L: 129
	}
	
	public String getInternalName() {
		return this.internalName; // L: 133
	}
	
	public String getExternalName() {
		return this.externalName; // L: 137
	}
	
	int getBackGroundColor() {
		return this.backGroundColor; // L: 141
	}
	
	public int getZoom() {
		return this.zoom; // L: 145
	}
	
	public int getRegionLowX() {
		return this.regionLowX; // L: 149
	}
	
	public int getRegionHighX() {
		return this.regionHighX; // L: 153
	}
	
	public int getRegionLowY() {
		return this.regionLowY; // L: 157
	}
	
	public int getRegionHighY() {
		return this.regionHighY; // L: 161
	}
	
	public int getOriginX() {
		return this.origin.x; // L: 165
	}
	
	public int getOriginPlane() {
		return this.origin.plane; // L: 169
	}
	
	public int getOriginY() {
		return this.origin.y; // L: 173
	}
	
	public Coord getOrigin() {
		return new Coord(this.origin); // L: 177
	}
	
	public static Object method4621(byte[] var0, boolean var1) {
		if (var0 == null) { // L: 7
			return null;
		} else if (var0.length > 136) { // L: 8
			DirectByteArrayCopier var2 = new DirectByteArrayCopier(); // L: 10
			var2.set(var0); // L: 11
			return var2; // L: 12
		} else {
			return var0; // L: 16
		}
	}
}
