package osrs;
import net.runelite.rs.ScriptOpcodes;
public final class PendingSpawn extends Node {
	
	int plane;
	
	int type;
	
	int x;
	
	int y;
	
	int objectId;
	
	int field1121;
	
	int field1122;
	
	int id;
	
	int orientation;
	
	int field1125;
	
	int delay;
	
	int hitpoints;
	PendingSpawn() {
		this.delay = 0; // L: 16
		this.hitpoints = -1; // L: 17
	} // L: 19
	
	static int method2180(int var0, Script var1, boolean var2) {
		int var3 = -1; // L: 571
		Widget var4;
		if (var0 >= 2000) { // L: 573
			var0 -= 1000; // L: 574
			var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																							// 575
			var4 = class140.getWidget(var3); // L: 576
		} else {
			var4 = var2 ? class124.scriptDotWidget : GrandExchangeOfferOwnWorldComparator.scriptActiveWidget; // L:
																												// 578
		}
		if (var0 == ScriptOpcodes.CC_SETPOSITION) { // L: 579
			class446.Interpreter_intStackSize -= 4; // L: 580
			var4.rawX = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																								// 581
			var4.rawY = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																									// 582
			var4.xAlignment = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 2]; // L:
																										// 583
			var4.yAlignment = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 3]; // L:
																										// 584
			ChatChannel.invalidateWidget(var4); // L: 585
			class353.client.alignWidget(var4); // L: 586
			if (var3 != -1 && var4.type == 0) { // L: 587
				BufferedNetSocket.revalidateWidgetScroll(_Junk.Widget_interfaceComponents[var3 >> 16], var4, false);
			}
			return 1; // L: 588
		} else if (var0 == ScriptOpcodes.CC_SETSIZE) { // L: 590
			class446.Interpreter_intStackSize -= 4; // L: 591
			var4.rawWidth = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																									// 592
			var4.rawHeight = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																										// 593
			var4.widthAlignment = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 2]; // L:
																											// 594
			var4.heightAlignment = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 3]; // L:
																											// 595
			ChatChannel.invalidateWidget(var4); // L: 596
			class353.client.alignWidget(var4); // L: 597
			if (var3 != -1 && var4.type == 0) { // L: 598
				BufferedNetSocket.revalidateWidgetScroll(_Junk.Widget_interfaceComponents[var3 >> 16], var4, false);
			}
			return 1; // L: 599
		} else if (var0 == ScriptOpcodes.CC_SETHIDE) { // L: 601
			boolean var5 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
																										// 602
			if (var5 != var4.isHidden) { // L: 603
				var4.isHidden = var5; // L: 604
				ChatChannel.invalidateWidget(var4); // L: 605
			}
			return 1; // L: 607
		} else if (var0 == ScriptOpcodes.CC_SETNOCLICKTHROUGH) { // L: 609
			var4.noClickThrough = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
																												// 610
			return 1; // L: 611
		} else if (var0 == ScriptOpcodes.CC_SETNOSCROLLTHROUGH) { // L: 613
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
																												// 614
			return 1; // L: 615
		} else {
			return 2; // L: 617
		}
	}
}
