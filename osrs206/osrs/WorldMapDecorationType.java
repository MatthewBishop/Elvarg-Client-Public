package osrs;
public enum WorldMapDecorationType implements MouseWheel {
	
	field3549(0, 0), 
	field3543(1, 0), 
	field3533(2, 0), 
	field3534(3, 0), 
	field3535(9, 2), 
	field3536(4, 1), 
	field3537(5, 1), 
	field3538(6, 1), 
	field3539(7, 1), 
	field3532(8, 1), 
	field3541(12, 2), 
	field3542(13, 2), 
	field3551(14, 2), 
	field3531(15, 2), 
	field3545(16, 2), 
	field3546(17, 2), 
	field3547(18, 2), 
	field3548(19, 2), 
	field3540(20, 2), 
	field3550(21, 2), 
	field3553(10, 2), 
	field3552(11, 2), 
	field3544(22, 3);
	
	public final int id;
	
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3; // L: 34
	} // L: 35
	
	public int rsOrdinal() {
		return this.id; // L: 39
	}
	
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z'; // L:
																			// 155
	}
}
