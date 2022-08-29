package osrs;
public enum Anim_enum123 implements Anim_IClientEnum {
	
	field1535(0, 0), 
	field1529(1, 1), 
	field1542(2, 2), 
	field1531(3, 3), 
	field1536(4, 4), 
	field1533(5, 5), 
	field1534(6, 6), 
	field1532(7, 7), 
	rs_default(8, 8);
	final int value;
	
	final int rs_ordinal;
	Anim_enum123(int var3, int var4) {
		this.value = var3; // L: 117
		this.rs_ordinal = var4; // L: 118
	} // L: 119
	
	public int rsOrdinal() {
		return this.rs_ordinal; // L: 122
	}

	static Anim_enum123 method1052(int var0) {
		Anim_enum123 var1 = (Anim_enum123) Anim_class117.findEnumerated(rsValues(), var0); // L:
																							// 126
		if (var1 == null) {
			var1 = rs_default; // L: 127
		}
		return var1; // L: 128
	}

	static Anim_enum123[] rsValues() {
		return new Anim_enum123[]{field1535, field1529, field1542, field1531, field1536, field1533, field1534, field1532, rs_default}; // L:
		// 113
	}
}
