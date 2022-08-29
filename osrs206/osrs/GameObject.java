package osrs;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.runelite.rs.ScriptOpcodes;
public final class GameObject {
	
	int plane;
	
	int z;
	
	int centerX;
	
	int centerY;
	
	public Renderable renderable;
	
	int orientation;
	
	int startX;
	
	int endX;
	
	int startY;
	
	int endY;
	
	int field2655;
	
	int lastDrawn;
	
	public long tag;
	
	int flags;
	GameObject() {
		this.tag = 0L; // L: 16
		this.flags = 0; // L: 17
	} // L: 19
	
	static Date method4552() throws ParseException {
		SimpleDateFormat var0 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH); // L:
																					// 1132
		var0.setLenient(false); // L: 1133
		StringBuilder var1 = new StringBuilder(); // L: 1134
		String[] var2 = Login.field911; // L: 1136
		for (int var3 = 0; var3 < var2.length; ++var3) { // L: 1137
			String var4 = var2[var3]; // L: 1138
			if (var4 == null) { // L: 1140
				GraphicsObject.method1877("Date not valid.", "Please ensure all characters are populated.", ""); // L:
				// 1141
				return null; // L: 1142
			}
			var1.append(var4); // L: 1144
		}
		var1.append("12"); // L: 1148
		return var0.parse(var1.toString()); // L: 1149
	}
	
	static int method4553(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? class124.scriptDotWidget : GrandExchangeOfferOwnWorldComparator.scriptActiveWidget; // L:
		// 1209
		if (var0 == ScriptOpcodes.CC_GETINVOBJECT) { // L: 1210
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.itemId; // L:
																										// 1211
			return 1; // L: 1212
		} else if (var0 == ScriptOpcodes.CC_GETINVCOUNT) { // L: 1214
			if (var3.itemId != -1) { // L: 1215
				Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																								// 1216
			}
			return 1; // L: 1217
		} else if (var0 == ScriptOpcodes.CC_GETID) { // L: 1219
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.childIndex; // L:
																											// 1220
			return 1; // L: 1221
		} else if (var0 == 1707) { // L: 1223
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.method5680() ? 1 : 0; // L:
			// 1224
			return 1; // L: 1225
		} else if (var0 == 1708) { // L: 1227
			return class29.method363(var3); // L: 1228
		} else {
			return var0 == 1709 ? WorldMapSection0.method4947(var3) : 2; // L:
																			// 1230
																			// 1231
																			// 1233
		}
	}
}
