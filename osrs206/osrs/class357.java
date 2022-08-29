package osrs;
public class class357 {
	static double method6530(double var0, double var2, double var4) {
		double var8 = (var0 - var2) / var4; // L: 10
		double var6 = Math.exp(var8 * -var8 / 2.0D) / Math.sqrt(6.283185307179586D); // L:
																						// 12
		return var6 / var4; // L: 14
	}
	
	public static int hashString(CharSequence var0) {
		int var1 = var0.length(); // L: 141
		int var2 = 0; // L: 142
		for (int var3 = 0; var3 < var1; ++var3) { // L: 143
			var2 = (var2 << 5) - var2 + class295.charToByteCp1252(var0.charAt(var3));
		}
		return var2; // L: 144
	}
}
