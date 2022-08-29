package osrs;
public class WorldMapCacheName {
	
	public static final WorldMapCacheName field2867;
	
	public static final WorldMapCacheName field2865;
	
	public static final WorldMapCacheName field2866;
	
	static final WorldMapCacheName field2869;
	
	public static final WorldMapCacheName field2868;
	public final String name;
	static {
		field2867 = new WorldMapCacheName("details"); // L: 4
		field2865 = new WorldMapCacheName("compositemap"); // L: 5
		field2866 = new WorldMapCacheName("compositetexture"); // L: 6
		field2869 = new WorldMapCacheName("area"); // L: 7
		field2868 = new WorldMapCacheName("labels"); // L: 8
	}
	WorldMapCacheName(String var1) {
		this.name = var1; // L: 12
	} // L: 13
	
	public static VarbitComposition method5054(int var0) {
		VarbitComposition var1 = (VarbitComposition) VarbitComposition.VarbitDefinition_cached.get((long) var0); // L:
		// 28
		if (var1 != null) { // L: 29
			return var1;
		} else {
			byte[] var2 = VarbitComposition.VarbitDefinition_archive.takeFile(14, var0); // L:
																							// 30
			var1 = new VarbitComposition(); // L: 31
			if (var2 != null) { // L: 32
				var1.decode(new Buffer(var2));
			}
			VarbitComposition.VarbitDefinition_cached.put(var1, (long) var0); // L:
																				// 33
			return var1; // L: 34
		}
	}
}
