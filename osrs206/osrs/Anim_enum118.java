package osrs;

public class Anim_enum118 implements Anim_IClientEnum {
	
	static final Anim_enum118 rs_default;
	
	static final Anim_enum118 field1477;
	
	static final Anim_enum118 field1478;
	
	static final Anim_enum118 field1479;
	
	static final Anim_enum118 field1480;
	
	static final Anim_enum118 field1484;
	
	final int field1482;
	
	final int field1483;
	
	final int field1486;
	static {
		rs_default = new Anim_enum118(0, 0, (String) null, 0); // L: 14
		field1477 = new Anim_enum118(1, 1, (String) null, 9); // L: 15
		field1478 = new Anim_enum118(2, 2, (String) null, 3); // L: 16
		field1479 = new Anim_enum118(3, 3, (String) null, 6); // L: 17
		field1480 = new Anim_enum118(4, 4, (String) null, 1); // L: 18
		field1484 = new Anim_enum118(5, 5, (String) null, 3); // L: 19
	}
	Anim_enum118(int var1, int var2, String var3, int var4) {
		this.field1482 = var1; // L: 25
		this.field1483 = var2; // L: 26
		this.field1486 = var4; // L: 27
	} // L: 28
	
	public int rsOrdinal() {
		return this.field1483; // L: 46
	}
	
	int method2736() {
		return this.field1486; // L: 41
	}

	static Anim_enum118 method2116(int var0) {
		Anim_enum118[] var1 = new Anim_enum118[]{rs_default, field1477, field1478, field1479, field1480, field1484}; // L:
																																									// 33
		Anim_enum118 var2 = (Anim_enum118) Anim_class117.findEnumerated(var1, var0); // L: 35
		if (var2 == null) { // L: 36
			var2 = rs_default;
		}
		return var2; // L: 37
	}
}
