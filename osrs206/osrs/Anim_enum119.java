package osrs;
public class Anim_enum119 implements Anim_IClientEnum {
	
	static final Anim_enum119 rs_default;
	
	static final Anim_enum119 field1504;
	
	static final Anim_enum119 field1505;
	
	static final Anim_enum119 field1501;
	
	static final Anim_enum119 field1492;
	
	static final Anim_enum119 field1493;
	
	static final Anim_enum119 field1494;
	
	static final Anim_enum119 field1495;
	
	static final Anim_enum119 field1496;
	
	static final Anim_enum119 field1489;
	
	static final Anim_enum119 field1498;
	
	static final Anim_enum119 field1499;
	
	static final Anim_enum119 field1500;
	
	static final Anim_enum119 field1502;
	
	static final Anim_enum119 field1488;
	
	static final Anim_enum119 field1503;
	
	static final Anim_enum119 field1491;
	
	final int field1490;
	
	final int field1506;
	
	final int field1507;
	static {
		rs_default = new Anim_enum119(0, 0, (String) null, -1, -1); // L: 52
		field1504 = new Anim_enum119(1, 1, (String) null, 0, 2); // L: 53
		field1505 = new Anim_enum119(2, 2, (String) null, 1, 2); // L: 54
		field1501 = new Anim_enum119(3, 3, (String) null, 2, 2); // L: 55
		field1492 = new Anim_enum119(4, 4, (String) null, 3, 1); // L: 56
		field1493 = new Anim_enum119(5, 5, (String) null, 4, 1); // L: 57
		field1494 = new Anim_enum119(6, 6, (String) null, 5, 1); // L: 58
		field1495 = new Anim_enum119(7, 7, (String) null, 6, 3); // L: 59
		field1496 = new Anim_enum119(8, 8, (String) null, 7, 3); // L: 60
		field1489 = new Anim_enum119(9, 9, (String) null, 8, 3); // L: 61
		field1498 = new Anim_enum119(10, 10, (String) null, 0, 7); // L: 62
		field1499 = new Anim_enum119(11, 11, (String) null, 1, 7); // L: 63
		field1500 = new Anim_enum119(12, 12, (String) null, 2, 7); // L: 64
		field1502 = new Anim_enum119(13, 13, (String) null, 3, 7); // L: 65
		field1488 = new Anim_enum119(14, 14, (String) null, 4, 7); // L: 66
		field1503 = new Anim_enum119(15, 15, (String) null, 5, 7); // L: 67
		field1491 = new Anim_enum119(16, 16, (String) null, 0, 5); // L: 68
	}
	
	Anim_enum119(int var1, int var2, String var3, int var4, int var5) {
		this.field1490 = var1; // L: 78
		this.field1506 = var2; // L: 79
		this.field1507 = var4; // L: 80
	} // L: 81
	
	public int rsOrdinal() {
		return this.field1506; // L: 84
	}
	
	int method2747() {
		return this.field1507; // L: 88
	}

	static Anim_enum119 method254(int var0) {
		Anim_enum119 var1 = (Anim_enum119) Anim_class117.findEnumerated(rsValues(), var0); // L:
																								// 92
		if (var1 == null) {
			var1 = rs_default; // L: 93
		}
		return var1; // L: 94
	}

	static Anim_enum119[] rsValues() {
		return new Anim_enum119[]{rs_default, field1504, field1505, field1501, field1492, field1493, field1494, field1495, field1496, field1489, field1498, field1499, field1500, field1502, field1488, field1503, field1491}; // L:
																																																																																													// 74
	}
}
