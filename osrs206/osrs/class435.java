package osrs;
public class class435 extends DualNode {
	
	static AbstractArchive field4666;
	
	static EvictingDualNodeHashTable DBTableType_cache;
	public int[][] field4668;
	public Object[][] field4669;
	static {
		DBTableType_cache = new EvictingDualNodeHashTable(64); // L: 11
	}
	class435() {
	} // L: 16
	
	void method7592(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte(); // L: 35
			if (var2 == 0) { // L: 36
				return; // L: 39
			}
			this.method7593(var1, var2); // L: 37
		}
	}
	
	void method7593(Buffer var1, int var2) {
		if (var2 == 1) { // L: 42
			int var3 = var1.readUnsignedByte(); // L: 43
			if (this.field4668 == null) { // L: 44
				this.field4668 = new int[var3][];
			}
			for (int var4 = var1.readUnsignedByte(); var4 != 255; var4 = var1.readUnsignedByte()) { // L:
																									// 45
																									// 46
																									// 58
				int var5 = var4 & 127; // L: 47
				boolean var6 = (var4 & 128) != 0; // L: 48
				int[] var7 = new int[var1.readUnsignedByte()]; // L: 49
				for (int var8 = 0; var8 < var7.length; ++var8) { // L: 50
					var7[var8] = var1.readUShortSmart(); // L: 51
				}
				this.field4668[var5] = var7; // L: 53
				if (var6) { // L: 54
					if (this.field4669 == null) {
						this.field4669 = new Object[this.field4668.length][]; // L:
																				// 55
					}
					this.field4669[var5] = class435.method4353(var1, var7); // L:
																			// 56
				}
			}
		}
	} // L: 62
	
	void method7602() {
	} // L: 64

	static Object[] method4353(Buffer var0, int[] var1) {
		int var2 = var0.readUShortSmart(); // L: 30
		Object[] var3 = new Object[var1.length * var2]; // L: 31
		for (int var4 = 0; var4 < var2; ++var4) { // L: 32
			for (int var5 = 0; var5 < var1.length; ++var5) { // L: 33
				int var6 = var1.length * var4 + var5; // L: 34
				class432 var7 = _Junk.method5472(var1[var5]); // L: 35
				var3[var6] = var7.method7565(var0); // L: 36
			}
		}
		return var3; // L: 39
	}
}
