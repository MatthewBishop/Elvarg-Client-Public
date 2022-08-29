package osrs;
public enum FillMode implements MouseWheel {
	
	SOLID(0, 0), 
	field4778(1, 1), 
	field4783(2, 2);
	
	public final int field4781;
	
	final int field4782;
	FillMode(int var3, int var4) {
		this.field4781 = var3; // L: 19
		this.field4782 = var4; // L: 20
	} // L: 21
	
	public int rsOrdinal() {
		return this.field4782; // L: 25
	}
}
