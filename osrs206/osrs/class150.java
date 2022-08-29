package osrs;
public class class150 extends class128 {
	
	static ClanChannel guestClanChannel;
	
	long field1707;
	String field1708;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class150(class131 var1) {
		this.this$0 = var1;
		this.field1707 = -1L; // L: 194
		this.field1708 = null; // L: 195
	} // L: 197
	
	void vmethod3150(Buffer var1) {
		if (var1.readUnsignedByte() != 255) { // L: 200
			--var1.offset; // L: 201
			this.field1707 = var1.readLong(); // L: 202
		}
		this.field1708 = var1.readStringCp1252NullTerminatedOrNull(); // L: 204
	} // L: 205
	
	void vmethod3149(ClanSettings var1) {
		var1.method2959(this.field1707, this.field1708); // L: 208
	} // L: 209
	
	static final void method3135(int var0, int var1) {
		if (Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) { // L:
																									// 8437
			if (Client.showMouseOverText) { // L: 8438
				int var2 = class240.method5005(); // L: 8439
				String var3;
				if (Client.isItemSelected == 1 && Client.menuOptionsCount < 2) { // L:
																					// 8441
					var3 = "Use" + " " + Client.selectedItemName + " " + "->";
				} else if (Client.isSpellSelected && Client.menuOptionsCount < 2) { // L:
																					// 8442
					var3 = Client.selectedSpellActionName + " " + Client.selectedSpellName + " " + "->";
				} else {
					String var4;
					if (var2 < 0) { // L: 8446
						var4 = ""; // L: 8447
					} else if (Client.menuTargets[var2].length() > 0) { // L:
																		// 8450
						var4 = Client.menuActions[var2] + " " + Client.menuTargets[var2];
					} else {
						var4 = Client.menuActions[var2]; // L: 8451
					}
					var3 = var4; // L: 8453
				}
				if (Client.menuOptionsCount > 2) { // L: 8455
					var3 = var3 + Static.colorStartTag(16777215) + " " + '/' + " " + (Client.menuOptionsCount - 2) + " more options";
				}
				TileItem.fontBold12.drawRandomAlphaAndSpacing(var3, var0 + 4, var1 + 15, 16777215, 0, Client.cycle / 1000); // L:
																															// 8456
			}
		}
	} // L: 8457
	
	static final void addWidgetItemMenuItem(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions; // L: 10868
		byte var6 = -1; // L: 10869
		String var7 = null; // L: 10870
		if (var5 != null && var5[var3] != null) { // L: 10871
			if (var3 == 0) { // L: 10872
				var6 = 33;
			} else if (var3 == 1) { // L: 10873
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35; // L: 10874
			} else if (var3 == 3) { // L: 10875
				var6 = 36;
			} else {
				var6 = 37; // L: 10876
			}
			var7 = var5[var3]; // L: 10877
		} else if (var3 == 4) { // L: 10880
			var6 = 37; // L: 10881
			var7 = "Drop"; // L: 10882
		}
		if (var6 != -1 && var7 != null) { // L: 10885
			class268.insertMenuItem(var7, Static.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4); // L:
																																// 10886
		}
	} // L: 10888
}
