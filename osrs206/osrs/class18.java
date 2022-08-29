package osrs;
import java.util.Comparator;
import java.util.Map.Entry;
public class class18 implements Comparator {
	
	static int js5Port;
	
	static int cameraX;
	// $FF: synthetic field
	
	final class10 this$0;
	
	class18(class10 var1) {
		this.this$0 = var1; // L: 50
	}
	
	int method233(Entry var1, Entry var2) {
		return ((Float) var2.getValue()).compareTo((Float) var1.getValue()); // L:
																				// 52
	}
	public int compare(Object var1, Object var2) {
		return this.method233((Entry) var1, (Entry) var2); // L: 56
	}
	public boolean equals(Object var1) {
		return super.equals(var1); // L: 60
	}
	
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel) Messages.Messages_channels.get(var0); // L:
																				// 35
		return var2.getMessage(var1); // L: 36
	}
	
	public static final boolean isKeyDown() {
		synchronized (KeyHandler.KeyHandler_instance) { // L: 175
			if (KeyHandler.field127 == KeyHandler.field147) { // L: 176
				return false;
			} else {
				_Junk.field3196 = KeyHandler.field148[KeyHandler.field147]; // L:
																				// 177
				HealthBar.field1258 = KeyHandler.field149[KeyHandler.field147]; // L:
																				// 178
				KeyHandler.field147 = KeyHandler.field147 + 1 & 127; // L: 179
				return true; // L: 180
			}
		}
	}
	
	static final boolean method234() {
		return Client.isMenuOpen; // L: 8499
	}
}
