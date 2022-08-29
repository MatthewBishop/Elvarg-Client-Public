package osrs;
final public class class431 implements class428 {
	
	public void vmethod7583(Object var1, Buffer var2) {
		this.method7554((Long) var1, var2); // L: 35
	} // L: 36
	
	public Object vmethod7580(Buffer var1) {
		return var1.readLong(); // L: 31
	}
	
	void method7554(Long var1, Buffer var2) {
		var2.writeLong(var1); // L: 26
	} // L: 27
	
	static boolean method7559(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1); // L: 183
		if (var2 == null) { // L: 184
			return false;
		} else {
			ChatChannel.SpriteBuffer_decode(var2); // L: 185
			return true; // L: 186
		}
	}
}
