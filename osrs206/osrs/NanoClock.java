package osrs;
public class NanoClock extends Clock {
	
	long lastTimeNano;
	NanoClock() {
		this.lastTimeNano = System.nanoTime(); // L: 10
	} // L: 11
	
	public void mark() {
		this.lastTimeNano = System.nanoTime(); // L: 14
	} // L: 15
	
	public int wait(int var1, int var2) {
		long var3 = (long) var2 * 1000000L; // L: 18
		long var5 = this.lastTimeNano - System.nanoTime(); // L: 19
		if (var5 < var3) { // L: 20
			var5 = var3;
		}
		DynamicObject.method1991(var5 / 1000000L); // L: 21
		long var7 = System.nanoTime(); // L: 22
		int var9;
		for (var9 = 0; var9 < 10 && (var9 < 1 || this.lastTimeNano < var7); this.lastTimeNano += (long) var1 * 1000000L) { // L:
																															// 23
																															// 24
																															// 26
			++var9; // L: 25
		}
		if (this.lastTimeNano < var7) { // L: 28
			this.lastTimeNano = var7;
		}
		return var9; // L: 29
	}
}
