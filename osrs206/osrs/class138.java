package osrs;
public class class138 extends class128 {
	
	static UrlRequester urlRequester;
	
	int field1623;
	String field1620;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class138(class131 var1) {
		this.this$0 = var1; // L: 323
	}
	
	void vmethod3150(Buffer var1) {
		this.field1623 = var1.readInt(); // L: 326
		this.field1620 = var1.readStringCp1252NullTerminated(); // L: 327
	} // L: 328
	
	void vmethod3149(ClanSettings var1) {
		var1.method2968(this.field1623, this.field1620); // L: 331
	} // L: 332
	
	public static void method2948(AbstractArchive var0) {
		class435.field4666 = var0; // L: 19
	} // L: 20
	
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (class362.World_worlds != null) { // L: 171
			class131.doWorldSorting(0, class362.World_worlds.length - 1, var0, var1, var2, var3); // L:
																									// 172
		}
	} // L: 174
	
	static boolean method2944() {
		return (Client.drawPlayerNames & 8) != 0; // L: 4953
	}
}
