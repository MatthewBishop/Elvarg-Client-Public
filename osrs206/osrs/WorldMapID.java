package osrs;
public class WorldMapID {
	
	static final WorldMapID field2843;
	
	static final WorldMapID field2840;
	
	static ClanSettings field2842;
	
	final int value;
	static {
		field2843 = new WorldMapID(0); // L: 4
		field2840 = new WorldMapID(1); // L: 5
	}
	WorldMapID(int var1) {
		this.value = var1; // L: 9
	} // L: 10
	
	public static int Widget_unpackTargetMask(int var0) {
		return var0 >> 11 & 63; // L: 13
	}
	
	public static boolean method5003(int var0) {
		return (var0 >> 20 & 1) != 0; // L: 21
	}
}
