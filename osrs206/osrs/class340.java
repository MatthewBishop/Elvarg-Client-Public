package osrs;
public class class340 {
	static char[] cp1252AsciiExtension = {' ', '\u00a0', '_', '-', '\u00e0', '\u00e1', '\u00e2', '\u00e4', '\u00e3', '\u00c0', '\u00c1', '\u00c2', '\u00c4', '\u00c3', '\u00e8', '\u00e9', '\u00ea', '\u00eb', '\u00c8', '\u00c9', '\u00ca', '\u00cb', '\u00ed', '\u00ee', '\u00ef', '\u00cd', '\u00ce', '\u00cf', '\u00f2', '\u00f3', '\u00f4', '\u00f6', '\u00f5', '\u00d2', '\u00d3', '\u00d4', '\u00d6', '\u00d5', '\u00f9', '\u00fa', '\u00fb', '\u00fc', '\u00d9', '\u00da', '\u00db', '\u00dc', '\u00e7', '\u00c7', '\u00ff', '\u0178', '\u00f1', '\u00d1', '\u00df'};
	
	static int field4138;
	
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field3448 == null) { // L: 998
			if (var2 == null) { // L: 999
				return; // L: 1005
			}
			var0.field3448 = new byte[11][]; // L: 1000
			var0.field3406 = new byte[11][]; // L: 1001
			var0.field3450 = new int[11]; // L: 1002
			var0.field3451 = new int[11]; // L: 1003
		}
		var0.field3448[var1] = var2; // L: 1007
		if (var2 != null) {
			var0.field3498 = true; // L: 1008
		} else {
			var0.field3498 = false; // L: 1010
			for (int var4 = 0; var4 < var0.field3448.length; ++var4) { // L:
																		// 1011
				if (var0.field3448[var4] != null) { // L: 1012
					var0.field3498 = true; // L: 1013
					break;
				}
			}
		}
		var0.field3406[var1] = var3; // L: 1018
	} // L: 1019
}
