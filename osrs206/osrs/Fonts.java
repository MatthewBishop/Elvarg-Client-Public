package osrs;
import java.util.HashMap;
public class Fonts {
	static String[] cacheParentPaths;
	
	AbstractArchive spritesArchive;
	
	AbstractArchive fontsArchive;
	HashMap map;
	
	public Fonts(AbstractArchive var1, AbstractArchive var2) {
		this.spritesArchive = var1; // L: 14
		this.fontsArchive = var2; // L: 15
		this.map = new HashMap(); // L: 16
	} // L: 17
	
	public HashMap createMap(FontName[] var1) {
		HashMap var2 = new HashMap(); // L: 20
		FontName[] var3 = var1; // L: 22
		for (int var4 = 0; var4 < var3.length; ++var4) { // L: 23
			FontName var5 = var3[var4]; // L: 24
			if (this.map.containsKey(var5)) { // L: 26
				var2.put(var5, this.map.get(var5)); // L: 27
			} else {
				Font var6 = ServerPacket.method5211(this.spritesArchive, this.fontsArchive, var5.name, ""); // L:
																											// 30
				if (var6 != null) { // L: 31
					this.map.put(var5, var6); // L: 32
					var2.put(var5, var6); // L: 33
				}
			}
		}
		return var2; // L: 39
	}
}
