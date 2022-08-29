package osrs;
public abstract class Clock {
	Clock() {
	} // L: 4
	
	public abstract void mark();
	
	public abstract int wait(int var1, int var2);
	
	public static boolean method3331(int var0) {
		return var0 >= WorldMapDecorationType.field3553.id && var0 <= WorldMapDecorationType.field3552.id; // L:
																											// 43
	}
}
