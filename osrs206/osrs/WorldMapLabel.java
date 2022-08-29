package osrs;
public class WorldMapLabel {
	String text;
	
	int width;
	
	int height;
	
	WorldMapLabelSize size;
	
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1; // L: 10
		this.width = var2; // L: 11
		this.height = var3; // L: 12
		this.size = var4; // L: 13
	} // L: 14
	
	public static void method5000(AbstractArchive var0) {
		VarcInt.VarcInt_archive = var0; // L: 15
	} // L: 16
	
	public static void method4999() {
		try {
			JagexCache.JagexCache_dat2File.close(); // L: 295
			for (int var0 = 0; var0 < class142.idxCount; ++var0) { // L: 296
				class359.JagexCache_idxFiles[var0].close();
			}
			JagexCache.JagexCache_idx255File.close(); // L: 297
			JagexCache.JagexCache_randomDat.close(); // L: 298
		} catch (Exception var2) { // L: 300
		}
	} // L: 301
}
