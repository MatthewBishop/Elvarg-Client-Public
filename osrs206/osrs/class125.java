package osrs;
import net.runelite.rs.ScriptOpcodes;
public class class125 extends class128 {
	
	int field1557;
	
	int field1553;
	
	int field1554;
	
	int field1555;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class125(class131 var1) {
		this.this$0 = var1;
		this.field1557 = -1; // L: 158
	} // L: 163
	
	void vmethod3150(Buffer var1) {
		this.field1557 = var1.readUnsignedShort(); // L: 166
		this.field1553 = var1.readInt(); // L: 167
		this.field1554 = var1.readUnsignedByte(); // L: 168
		this.field1555 = var1.readUnsignedByte(); // L: 169
	} // L: 170
	
	void vmethod3149(ClanSettings var1) {
		var1.method2964(this.field1557, this.field1553, this.field1554, this.field1555); // L:
																							// 173
	} // L: 174
	
	static String method2829() {
		return class19.clientPreferences.method2247() ? NetCache.method5952(Login.Login_username) : Login.Login_username; // L:
																															// 272
	}
	
	static void method2830() {
		ItemContainer.itemContainers = new NodeHashTable(32); // L: 78
	} // L: 79
	
	static int method2821(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class124.scriptDotWidget : GrandExchangeOfferOwnWorldComparator.scriptActiveWidget; // L:
		// 1111
		if (var0 == ScriptOpcodes.CC_GETX) { // L: 1112
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.x; // L:
																								// 1113
			return 1; // L: 1114
		} else if (var0 == ScriptOpcodes.CC_GETY) { // L: 1116
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.y; // L:
																								// 1117
			return 1; // L: 1118
		} else if (var0 == ScriptOpcodes.CC_GETWIDTH) { // L: 1120
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.width; // L:
																									// 1121
			return 1; // L: 1122
		} else if (var0 == ScriptOpcodes.CC_GETHEIGHT) { // L: 1124
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.height; // L:
																										// 1125
			return 1; // L: 1126
		} else if (var0 == ScriptOpcodes.CC_GETHIDE) { // L: 1128
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0; // L:
			// 1129
			return 1; // L: 1130
		} else if (var0 == ScriptOpcodes.CC_GETLAYER) { // L: 1132
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.parentId; // L:
																										// 1133
			return 1; // L: 1134
		} else {
			return 2; // L: 1136
		}
	}
	
	static void method2824() {
		Client.menuOptionsCount = 0; // L: 8423
		Client.isMenuOpen = false; // L: 8424
	} // L: 8425
}
