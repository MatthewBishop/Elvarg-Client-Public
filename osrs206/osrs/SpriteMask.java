package osrs;
public class SpriteMask extends DualNode {
	
	public final int width;
	
	public final int height;
	public final int[] xWidths;
	public final int[] xStarts;
	SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
		this.width = var1; // L: 973
		this.height = var2; // L: 974
		this.xWidths = var3; // L: 975
		this.xStarts = var4; // L: 976
	} // L: 977
	
	public boolean contains(int var1, int var2) {
		if (var2 >= 0 && var2 < this.xStarts.length) { // L: 980
			int var3 = this.xStarts[var2]; // L: 981
			if (var1 >= var3 && var1 <= var3 + this.xWidths[var2]) { // L: 982
				return true;
			}
		}
		return false; // L: 984
	}
	
	public static int[] method5523() {
		int[] var0 = new int[KeyHandler.field144]; // L: 257
		for (int var1 = 0; var1 < KeyHandler.field144; ++var1) { // L: 258
			var0[var1] = KeyHandler.field134[var1]; // L: 259
		}
		return var0; // L: 261
	}
	
	static int method5524(int var0, Script var1, boolean var2) {
		if (var0 != 7000 && var0 != 7005 && var0 != 7010 && var0 != 7015 && var0 != 7020 && var0 != 7025 && var0 != 7030 && var0 != 7035) { // L:
																																			// 4557
			if (var0 != 7001 && var0 != 7002 && var0 != 7011 && var0 != 7012 && var0 != 7021 && var0 != 7022) { // L:
				// 4561
				if (var0 != 7003 && var0 != 7013 && var0 != 7023) { // L: 4565
					if (var0 != 7006 && var0 != 7007 && var0 != 7016 && var0 != 7017 && var0 != 7026 && var0 != 7027) { // L:
						// 4569
						if (var0 != 7008 && var0 != 7018 && var0 != 7028) { // L:
																			// 4573
							if (var0 != 7031 && var0 != 7032) { // L: 4577
								if (var0 == 7033) { // L: 4582
									--Interpreter.Interpreter_stringStackSize; // L:
																				// 4583
									return 1; // L: 4584
								} else if (var0 != 7036 && var0 != 7037) { // L:
																			// 4586
									if (var0 == 7038) { // L: 4590
										--class446.Interpreter_intStackSize; // L:
																				// 4591
										return 1; // L: 4592
									} else if (var0 != 7004 && var0 != 7009 && var0 != 7014 && var0 != 7019 && var0 != 7024 && var0 != 7029 && var0 != 7034 && var0 != 7039) { // L:
										// 4594
										return 2; // L: 4598
									} else {
										--class446.Interpreter_intStackSize; // L:
																				// 4595
										return 1; // L: 4596
									}
								} else {
									class446.Interpreter_intStackSize -= 2; // L:
																			// 4587
									return 1; // L: 4588
								}
							} else {
								--Interpreter.Interpreter_stringStackSize; // L:
																			// 4578
								--class446.Interpreter_intStackSize; // L: 4579
								return 1; // L: 4580
							}
						} else {
							--class446.Interpreter_intStackSize; // L: 4574
							return 1; // L: 4575
						}
					} else {
						class446.Interpreter_intStackSize -= 2; // L: 4570
						return 1; // L: 4571
					}
				} else {
					class446.Interpreter_intStackSize -= 2; // L: 4566
					return 1; // L: 4567
				}
			} else {
				class446.Interpreter_intStackSize -= 3; // L: 4562
				return 1; // L: 4563
			}
		} else {
			class446.Interpreter_intStackSize -= 5; // L: 4558
			return 1; // L: 4559
		}
	}
	
	static void method5522() {
		PacketBufferNode var0 = EnumComposition.getPacketBufferNode(ClientPacket.field3008, Client.packetWriter.isaacCipher); // L:
																																// 4385
		var0.packetBuffer.writeByte(class9.getWindowedMode()); // L: 4386
		var0.packetBuffer.writeShort(Script.canvasWidth); // L: 4387
		var0.packetBuffer.writeShort(class78.canvasHeight); // L: 4388
		Client.packetWriter.addNode(var0); // L: 4389
	} // L: 4390
}
