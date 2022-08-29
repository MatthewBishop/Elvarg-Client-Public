package osrs;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class class421 implements class420 {
	public static byte[][] SpriteBuffer_pixels;
	
	static int field4607;
	Map field4606;
	
	final class449 field4605;
	
	public class421(class449 var1) {
		this.field4605 = var1; // L: 15
	} // L: 16
	
	public int vmethod7440(int var1) {
		if (this.field4606 != null) { // L: 20
			class450 var2 = (class450) this.field4606.get(var1); // L: 21
			if (var2 != null) {
				return (Integer) var2.field4766; // L: 22
			}
		}
		return (Integer) this.field4605.vmethod8027(var1); // L: 24
	}
	
	public void vmethod7441(int var1, Object var2) {
		if (this.field4606 == null) { // L: 29
			this.field4606 = new HashMap(); // L: 30
			this.field4606.put(var1, new class450(var1, var2)); // L: 31
		} else {
			class450 var3 = (class450) this.field4606.get(var1); // L: 34
			if (var3 == null) {
				this.field4606.put(var1, new class450(var1, var2)); // L: 35
			} else {
				var3.field4766 = var2; // L: 36
			}
		}
	} // L: 38
	public Iterator iterator() {
		return this.field4606 == null ? Collections.emptyList().iterator() : this.field4606.values().iterator(); // L:
		// 42
		// 43
	}
	
	public static IndexedSprite SpriteBuffer_getIndexedSpriteByName(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1); // L: 85
		int var4 = var0.getFileId(var3, var2); // L: 86
		IndexedSprite var5;
		if (!Ignored.method6774(var0, var3, var4)) { // L: 89
			var5 = null; // L: 90
		} else {
			var5 = class390.method7053(); // L: 93
		}
		return var5; // L: 95
	}
}
