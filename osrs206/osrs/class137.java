package osrs;
public class class137 extends class128 {
	String field1616;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class137(class131 var1) {
		this.this$0 = var1; // L: 229
	}
	
	void vmethod3150(Buffer var1) {
		this.field1616 = var1.readStringCp1252NullTerminated(); // L: 232
		var1.readInt(); // L: 233
	} // L: 234
	
	void vmethod3149(ClanSettings var1) {
		var1.name = this.field1616; // L: 237
	} // L: 238
	
	public static int method2931(int var0, int var1, int var2) {
		int var3 = VarpDefinition.method3374(var2 - var1 + 1); // L: 37
		var3 <<= var1; // L: 38
		return var0 & ~var3; // L: 39
	}
	
	static int lowercaseChar(char var0, Language var1) {
		int var2 = var0 << 4; // L: 104
		if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) { // L:
																			// 105
			var0 = Character.toLowerCase(var0); // L: 106
			var2 = (var0 << 4) + 1; // L: 107
		}
		if (var0 == 241 && var1 == Language.Language_ES) { // L: 109
			var2 = 1762;
		}
		return var2; // L: 110
	}
	
	static Object method2937(int var0) {
		return InvDefinition.method3360((class432) Actor.findEnumerated(class432.method7566(), var0)); // L:
																										// 5010
	}
}
