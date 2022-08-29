package osrs;

public enum Anim_enum116 implements Anim_IClientEnum {
	
	rs_default(0, 0), 
	field1451(1, 1), 
	field1450(2, 2), 
	field1453(3, 3), 
	field1454(4, 4);
	
	final int field1452;
	
	final int field1457;
	Anim_enum116(int var3, int var4) {
		this.field1452 = var3; // L: 143
		this.field1457 = var4; // L: 144
	} // L: 145
	
	public int rsOrdinal() {
		return this.field1457; // L: 148
	}
}
