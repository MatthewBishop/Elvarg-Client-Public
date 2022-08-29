package osrs;
import net.runelite.rs.ScriptOpcodes;
public class WorldMapDecoration {
	
	final int objectDefinitionId;
	
	final int decoration;
	
	final int rotation;
	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1; // L: 9
		this.decoration = var2; // L: 10
		this.rotation = var3; // L: 11
	} // L: 12
	
	static int method4992(int var0, Script var1, boolean var2) {
		Widget var3 = class140.getWidget(Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]); // L:
		// 1322
		if (var0 == ScriptOpcodes.IF_GETX) { // L: 1323
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.x; // L:
																								// 1324
			return 1; // L: 1325
		} else if (var0 == ScriptOpcodes.IF_GETY) { // L: 1327
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.y; // L:
																								// 1328
			return 1; // L: 1329
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) { // L: 1331
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.width; // L:
																									// 1332
			return 1; // L: 1333
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) { // L: 1335
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.height; // L:
																										// 1336
			return 1; // L: 1337
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) { // L: 1339
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0; // L:
			// 1340
			return 1; // L: 1341
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) { // L: 1343
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var3.parentId; // L:
																										// 1344
			return 1; // L: 1345
		} else {
			return 2; // L: 1347
		}
	}
	
	static void Widget_runOnTargetLeave() {
		if (Client.isSpellSelected) { // L: 9573
			Widget var0 = ScriptFrame.getWidgetChild(NetCache.selectedSpellWidget, Client.selectedSpellChildIndex); // L:
			// 9574
			if (var0 != null && var0.onTargetLeave != null) { // L: 9575
				ScriptEvent var1 = new ScriptEvent(); // L: 9576
				var1.widget = var0; // L: 9577
				var1.args = var0.onTargetLeave; // L: 9578
				BoundaryObject.runScriptEvent(var1); // L: 9579
			}
			Client.selectedSpellItemId = -1; // L: 9581
			Client.isSpellSelected = false; // L: 9582
			ChatChannel.invalidateWidget(var0); // L: 9583
		}
	} // L: 9584
	
	static void method4991(int var0) {
		Client.oculusOrbState = var0; // L: 12414
	} // L: 12415
}
