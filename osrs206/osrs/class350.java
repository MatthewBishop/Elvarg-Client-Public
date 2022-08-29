package osrs;
public class class350 {
	public static void writeRandomDat(byte[] var0, int var1, byte[] var2, int var3, int var4) {
		if (var2 == var0) { // L: 12
			if (var3 == var1) { // L: 13
				return;
			}
			if (var3 > var1 && var3 < var4 + var1) { // L: 14
				--var4; // L: 15
				var1 += var4; // L: 16
				var3 += var4; // L: 17
				var4 = var1 - var4; // L: 18
				for (var4 += 7; var1 >= var4; var2[var3--] = var0[var1--]) { // L:
																				// 19
																				// 20
																				// 28
					var2[var3--] = var0[var1--]; // L: 21
					var2[var3--] = var0[var1--]; // L: 22
					var2[var3--] = var0[var1--]; // L: 23
					var2[var3--] = var0[var1--]; // L: 24
					var2[var3--] = var0[var1--]; // L: 25
					var2[var3--] = var0[var1--]; // L: 26
					var2[var3--] = var0[var1--]; // L: 27
				}
				for (var4 -= 7; var1 >= var4; var2[var3--] = var0[var1--]) { // L:
																				// 30
																				// 31
				}
				return; // L: 32
			}
		}
		var4 += var1; // L: 35
		for (var4 -= 7; var1 < var4; var2[var3++] = var0[var1++]) { // L: 36 37
																	// 45
			var2[var3++] = var0[var1++]; // L: 38
			var2[var3++] = var0[var1++]; // L: 39
			var2[var3++] = var0[var1++]; // L: 40
			var2[var3++] = var0[var1++]; // L: 41
			var2[var3++] = var0[var1++]; // L: 42
			var2[var3++] = var0[var1++]; // L: 43
			var2[var3++] = var0[var1++]; // L: 44
		}
		for (var4 += 7; var1 < var4; var2[var3++] = var0[var1++]) { // L: 47 48
		}
	} // L: 49
}
