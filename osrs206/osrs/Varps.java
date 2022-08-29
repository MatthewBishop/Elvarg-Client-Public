package osrs;

public class Varps {
	static int[] Varps_masks;
	public static int[] Varps_temp;
	public static int[] Varps_main;
	static {
		Varps_masks = new int[32]; // L: 6
		int var0 = 2; // L: 9
		for (int var1 = 0; var1 < 32; ++var1) { // L: 10
			Varps_masks[var1] = var0 - 1; // L: 11
			var0 += var0; // L: 12
		}
		Varps_temp = new int[4000]; // L: 16
		Varps_main = new int[4000]; // L: 17
	}
	
	public static byte[] method5530(Object var0, boolean var1) {
		if (var0 == null) { // L: 21
			return null;
		} else if (var0 instanceof byte[]) { // L: 22
			byte[] var3 = (byte[]) ((byte[]) var0); // L: 23
			return var1 ? _Junk.method5432(var3) : var3; // L: 24
		} else if (var0 instanceof AbstractByteArrayCopier) { // L: 27
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier) var0; // L:
																			// 28
			return var2.get(); // L: 29
		} else {
			throw new IllegalArgumentException(); // L: 31
		}
	}
}
