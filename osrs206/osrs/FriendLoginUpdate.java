package osrs;

import misc.Equations;

public class FriendLoginUpdate extends Link {
	
	public int field4300;
	
	public Username username;
	public short world;
	
	FriendLoginUpdate(Username var1, int var2) {
		this.field4300 = (int) (Equations.getCurrentTime() / 1000L); // L: 109
		this.username = var1; // L: 110
		this.world = (short) var2; // L: 111
	} // L: 112
	
	public static class437 method6631(int var0) {
		class437 var1 = (class437) class437.DBRowType_cache.get((long) var0); // L:
																				// 24
		if (var1 != null) { // L: 25
			return var1;
		} else {
			byte[] var2 = class437.field4675.takeFile(38, var0); // L: 26
			var1 = new class437(); // L: 27
			if (var2 != null) { // L: 28
				var1.method7635(new Buffer(var2));
			}
			var1.method7636(); // L: 29
			class437.DBRowType_cache.put(var1, (long) var0); // L: 30
			return var1; // L: 31
		}
	}
	
	static final void method6632(String var0) {
		StringBuilder var10000 = (new StringBuilder()).append(var0);
		Object var10001 = null;
		String var1 = var10000.append(" is already on your friend list").toString(); // L:
																						// 135
		class290.addGameMessage(30, "", var1); // L: 137
	} // L: 139
}
