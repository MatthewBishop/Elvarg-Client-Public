package osrs;
public class class8 {
	final int field27;
	final int field26;
	final String field28;
	
	class8(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readStringCp1252NullTerminated()); // L:
																										// 19
	} // L: 20
	class8(int var1, int var2, String var3) {
		this.field27 = var1; // L: 13
		this.field26 = var2; // L: 14
		this.field28 = var3; // L: 15
	} // L: 16
	String method57() {
		return Integer.toHexString(this.field27) + Integer.toHexString(this.field26) + this.field28; // L:
																										// 23
	}
	int method55() {
		return this.field26; // L: 27
	}
}
