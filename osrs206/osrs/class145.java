package osrs;
public class class145 {
	
	static IndexedSprite[] title_muteSprite;
	static byte[][] regionMapArchives;
	
	long field1675;
	
	long field1673;
	
	IterableNodeDeque field1676;
	
	public class145(Buffer var1) {
		this.field1673 = -1L; // L: 10
		this.field1676 = new IterableNodeDeque(); // L: 11
		this.method3074(var1); // L: 19
	} // L: 20
	
	void method3074(Buffer var1) {
		this.field1675 = var1.readLong(); // L: 23
		this.field1673 = var1.readLong(); // L: 24
		for (int var2 = var1.readUnsignedByte(); var2 != 0; var2 = var1.readUnsignedByte()) { // L:
																								// 25
																								// 26
																								// 36
			Object var3;
			if (var2 == 1) { // L: 28
				var3 = new class140(this);
			} else if (var2 == 4) { // L: 29
				var3 = new class151(this);
			} else if (var2 == 3) { // L: 30
				var3 = new class136(this);
			} else if (var2 == 2) { // L: 31
				var3 = new class134(this);
			} else {
				if (var2 != 5) { // L: 32
					throw new RuntimeException(""); // L: 33
				}
				var3 = new class141(this);
			}
			((class144) var3).vmethod3137(var1); // L: 34
			this.field1676.addFirst((Node) var3); // L: 35
		}
	} // L: 38
	
	public void method3075(ClanChannel var1) {
		if (this.field1675 == var1.key && this.field1673 == var1.field1693) { // L:
																				// 41
			for (class144 var2 = (class144) this.field1676.last(); var2 != null; var2 = (class144) this.field1676.previous()) { // L:
																																// 42
				var2.vmethod3138(var1); // L: 43
			}
			++var1.field1693; // L: 45
		} else {
			throw new RuntimeException("");
		}
	} // L: 46
	
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field3448 == null) { // L: 1030
			throw new RuntimeException(); // L: 1031
		} else {
			if (var0.field3517 == null) { // L: 1033
				var0.field3517 = new int[var0.field3448.length]; // L: 1034
			}
			var0.field3517[var1] = Integer.MAX_VALUE; // L: 1036
		}
	} // L: 1037
}
