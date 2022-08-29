package osrs;
public enum class83 implements MouseWheel {
	
	field1074(0, -1), 
	field1084(1, 2), 
	field1075(2, 3), 
	field1077(3, 4), 
	field1078(4, 5), 
	field1079(5, 6);
	
	final int field1080;
	
	final int field1081;
	class83(int var3, int var4) {
		this.field1080 = var3; // L: 21
		this.field1081 = var4; // L: 22
	} // L: 23
	
	public int rsOrdinal() {
		return this.field1081; // L: 27
	}
	
	public static void method2118() {
		if (KeyHandler.KeyHandler_instance != null) { // L: 167
			synchronized (KeyHandler.KeyHandler_instance) { // L: 168
				KeyHandler.KeyHandler_instance = null; // L: 169
			} // L: 170
		}
	} // L: 172
	
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9'; // L: 159
	}
}
