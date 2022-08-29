package osrs;
public class VarpDefinition extends DualNode {
	
	public static AbstractArchive VarpDefinition_archive;
	
	public static int field1822;
	
	public static EvictingDualNodeHashTable VarpDefinition_cached;
	static boolean field1821;
	
	public int type;
	static {
		VarpDefinition_cached = new EvictingDualNodeHashTable(64); // L: 12
	}
	VarpDefinition() {
		this.type = 0; // L: 13
	} // L: 15
	
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte(); // L: 29
			if (var2 == 0) { // L: 30
				return; // L: 33
			}
			this.decodeNext(var1, var2); // L: 31
		}
	}
	
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 5) { // L: 36
			this.type = var1.readUnsignedShort();
		}
	} // L: 38
	
	public static int method3374(int var0) {
		return class270.field3179[var0]; // L: 24
	}
	
	static final boolean method3373(int var0) {
		if (var0 < 0) { // L: 8693
			return false;
		} else {
			int var1 = Client.menuOpcodes[var0]; // L: 8694
			if (var1 >= 2000) { // L: 8695
				var1 -= 2000;
			}
			return var1 == 1007; // L: 8696
		}
	}
}
