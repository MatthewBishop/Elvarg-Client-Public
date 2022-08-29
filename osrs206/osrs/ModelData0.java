package osrs;

public class ModelData0 {
	
	static int SpriteBuffer_spriteWidth;
	
	protected static boolean hasFocus;
	ModelData0() {
	} // L: 4
	
	static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
		int var2 = var0.readBits(2); // L: 589
		int var3;
		int var4;
		int var7;
		int var8;
		int var9;
		int var10;
		if (var2 == 0) { // L: 590
			if (var0.readBits(1) != 0) { // L: 591
				updateExternalPlayer(var0, var1);
			}
			var3 = var0.readBits(13); // L: 592
			var4 = var0.readBits(13); // L: 593
			boolean var12 = var0.readBits(1) == 1; // L: 594
			if (var12) { // L: 595
				Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
			}
			if (Client.players[var1] != null) { // L: 596
				throw new RuntimeException(); // L: 597
			} else {
				Player var11 = Client.players[var1] = new Player(); // L: 599
				var11.index = var1; // L: 600
				if (Players.field1307[var1] != null) { // L: 601
					var11.read(Players.field1307[var1]);
				}
				var11.orientation = Players.Players_orientations[var1]; // L:
																		// 602
				var11.targetIndex = Players.Players_targetIndices[var1]; // L:
																			// 603
				var7 = Players.Players_regions[var1]; // L: 604
				var8 = var7 >> 28; // L: 605
				var9 = var7 >> 14 & 255; // L: 606
				var10 = var7 & 255; // L: 607
				var11.pathTraversed[0] = Players.field1304[var1]; // L: 608
				var11.plane = (byte) var8; // L: 609
				var11.resetPath((var9 << 13) + var3 - class28.baseX, (var10 << 13) + var4 - WorldMapLabelSize.baseY); // L:
				// 610
				var11.field1088 = false; // L: 611
				return true; // L: 612
			}
		} else if (var2 == 1) { // L: 614
			var3 = var0.readBits(2); // L: 615
			var4 = Players.Players_regions[var1]; // L: 616
			Players.Players_regions[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455); // L:
																									// 617
			return false; // L: 618
		} else {
			int var5;
			int var6;
			if (var2 == 2) { // L: 620
				var3 = var0.readBits(5); // L: 621
				var4 = var3 >> 3; // L: 622
				var5 = var3 & 7; // L: 623
				var6 = Players.Players_regions[var1]; // L: 624
				var7 = (var6 >> 28) + var4 & 3; // L: 625
				var8 = var6 >> 14 & 255; // L: 626
				var9 = var6 & 255; // L: 627
				if (var5 == 0) { // L: 628
					--var8; // L: 629
					--var9; // L: 630
				}
				if (var5 == 1) { // L: 632
					--var9;
				}
				if (var5 == 2) { // L: 633
					++var8; // L: 634
					--var9; // L: 635
				}
				if (var5 == 3) { // L: 637
					--var8;
				}
				if (var5 == 4) { // L: 638
					++var8;
				}
				if (var5 == 5) { // L: 639
					--var8; // L: 640
					++var9; // L: 641
				}
				if (var5 == 6) { // L: 643
					++var9;
				}
				if (var5 == 7) { // L: 644
					++var8; // L: 645
					++var9; // L: 646
				}
				Players.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28); // L:
																					// 648
				return false; // L: 649
			} else {
				var3 = var0.readBits(18); // L: 651
				var4 = var3 >> 16; // L: 652
				var5 = var3 >> 8 & 255; // L: 653
				var6 = var3 & 255; // L: 654
				var7 = Players.Players_regions[var1]; // L: 655
				var8 = (var7 >> 28) + var4 & 3; // L: 656
				var9 = var5 + (var7 >> 14) & 255; // L: 657
				var10 = var6 + var7 & 255; // L: 658
				Players.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28); // L:
																						// 659
				return false; // L: 660
			}
		}
	}
}
