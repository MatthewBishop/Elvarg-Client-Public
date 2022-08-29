package osrs;
public enum class124 implements MouseWheel {
	
	field1546(0, 0), 
	field1544(4, 1), 
	field1543(1, 2), 
	field1550(2, 3), 
	field1547(3, 4);
	
	static Widget scriptDotWidget;
	
	public final int field1548;
	
	final int id;
	class124(int var3, int var4) {
		this.field1548 = var3; // L: 17
		this.id = var4; // L: 18
	} // L: 19
	
	public int rsOrdinal() {
		return this.id; // L: 23
	}
	
	static int method2818(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode) var0.get((long) var1);
			return var3 == null ? var2 : var3.integer;
		}
	}
	
	public static FloorOverlayDefinition method2814(int var0) {
		FloorOverlayDefinition var1 = (FloorOverlayDefinition) FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long) var0); // L:
																																		// 30
		if (var1 != null) { // L: 31
			return var1;
		} else {
			byte[] var2 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var0); // L:
																									// 32
			var1 = new FloorOverlayDefinition(); // L: 33
			if (var2 != null) { // L: 34
				var1.decode(new Buffer(var2), var0);
			}
			var1.postDecode(); // L: 35
			FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var1, (long) var0); // L:
																							// 36
			return var1; // L: 37
		}
	}
	
	static VerticalAlignment[] method2820() {
		return new VerticalAlignment[]{VerticalAlignment.field1963, VerticalAlignment.field1961, VerticalAlignment.VerticalAlignment_centered}; // L:
																																				// 14
	}
	
	static int getWidgetFlags(Widget var0) {
		IntegerNode var1 = (IntegerNode) Client.widgetFlags.get((long) var0.childIndex + ((long) var0.id << 32)); // L:
		// 12289
		return var1 != null ? var1.integer : var0.flags; // L: 12290 12291
	}
}
