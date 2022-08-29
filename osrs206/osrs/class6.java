package osrs;
public enum class6 implements MouseWheel {
	
	field17(0, 0);
	
	static IndexedSprite titlebuttonSprite;
	
	static Archive archive17;
	
	public final int field16;
	
	final int field15;
	class6(int var3, int var4) {
		this.field16 = var3; // L: 12
		this.field15 = var4; // L: 13
	} // L: 14
	
	public int rsOrdinal() {
		return this.field15; // L: 18
	}
	
	public static boolean method37() {
		ReflectionCheck var0 = (ReflectionCheck) class33.reflectionChecks.last(); // L:
																					// 28
		return var0 != null; // L: 29
	}
}
