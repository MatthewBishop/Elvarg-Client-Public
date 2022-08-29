package osrs;
public class class152 extends class128 {
	
	int field1715;
	
	long field1716;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class152(class131 var1) {
		this.this$0 = var1; // L: 307
	}
	
	void vmethod3150(Buffer var1) {
		this.field1715 = var1.readInt(); // L: 310
		this.field1716 = var1.readLong(); // L: 311
	} // L: 312
	
	void vmethod3149(ClanSettings var1) {
		var1.method2967(this.field1715, this.field1716); // L: 315
	} // L: 316
	
	static int method3147(int var0, int var1) {
		ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get((long) var0); // L:
																							// 14
		if (var2 == null) { // L: 15
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1; // L:
																				// 16
																				// 17
		}
	}
}
