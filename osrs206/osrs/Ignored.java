package osrs;
public class Ignored extends User {
	
	int id;
	Ignored() {
	} // L: 6
	
	int compareTo_ignored(Ignored var1) {
		return this.id - var1.id; // L: 9
	}
	
	public int compareTo_user(User var1) {
		return this.compareTo_ignored((Ignored) var1); // L: 13
	}
	public int compareTo(Object var1) {
		return this.compareTo_ignored((Ignored) var1); // L: 17
	}
	
	public static PrivateChatMode method6780(int var0) {
		PrivateChatMode[] var1 = new PrivateChatMode[]{PrivateChatMode.field4818, PrivateChatMode.field4817, PrivateChatMode.field4819}; // L:
																																			// 18
		PrivateChatMode[] var2 = var1; // L: 20
		for (int var3 = 0; var3 < var2.length; ++var3) { // L: 21
			PrivateChatMode var4 = var2[var3]; // L: 22
			if (var0 == var4.field4820) { // L: 24
				return var4;
			}
		}
		return null; // L: 28
	}
	
	public static boolean method6774(AbstractArchive var0, int var1, int var2) {
		byte[] var3 = var0.takeFile(var1, var2); // L: 176
		if (var3 == null) { // L: 177
			return false;
		} else {
			ChatChannel.SpriteBuffer_decode(var3); // L: 178
			return true; // L: 179
		}
	}
}
