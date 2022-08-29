package osrs;
public class class269 {
	
	static final void method5224(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field560) { // L: 10719
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0; // L: 10720
		}
		Client.field560 = false; // L: 10721
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !Static.mouseCam && MouseHandler.MouseHandler_currentButton == 4) { // L:
																																	// 10722
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) { // L:
																						// 10723
				var0.scrollY -= 4; // L: 10724
				ChatChannel.invalidateWidget(var0); // L: 10725
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) { // L:
																												// 10727
				var0.scrollY += 4; // L: 10728
				ChatChannel.invalidateWidget(var0); // L: 10729
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) { // L:
																																													// 10731
				var7 = var3 * (var3 - 32) / var4; // L: 10732
				if (var7 < 8) { // L: 10733
					var7 = 8;
				}
				int var8 = var6 - var2 - 16 - var7 / 2; // L: 10734
				int var9 = var3 - 32 - var7; // L: 10735
				var0.scrollY = var8 * (var4 - var3) / var9; // L: 10736
				ChatChannel.invalidateWidget(var0); // L: 10737
				Client.field560 = true; // L: 10738
			}
		}
		if (Client.mouseWheelRotation != 0) { // L: 10741
			var7 = var0.width; // L: 10742
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) { // L:
																									// 10743
				var0.scrollY += Client.mouseWheelRotation * 45; // L: 10744
				ChatChannel.invalidateWidget(var0); // L: 10745
			}
		}
	} // L: 10748
}
