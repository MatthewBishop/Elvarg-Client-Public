package osrs;
public enum HorizontalAlignment implements MouseWheel {
	
	field1910(1, 0), 
	HorizontalAlignment_centered(2, 1), 
	field1905(0, 2);
	
	public final int value;
	
	final int id;
	HorizontalAlignment(int var3, int var4) {
		this.value = var3; // L: 18
		this.id = var4; // L: 19
	} // L: 20
	
	public int rsOrdinal() {
		return this.id; // L: 24
	}
	
	static boolean getTapToDrop() {
		return Client.tapToDrop; // L: 11040
	}
}
