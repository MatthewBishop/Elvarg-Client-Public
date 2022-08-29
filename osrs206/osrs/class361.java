package osrs;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
public final class class361 {
	final Comparator field4269;
	final Map field4274;
	
	final class347 field4270;
	
	final class347 field4268;
	
	final long field4272;
	
	final class359 field4273;
	
	final int field4271;
	
	class361(long var1, int var3, class359 var4) {
		this.field4269 = new class360(this); // L: 7
		this.field4272 = var1; // L: 34
		this.field4271 = var3; // L: 35
		this.field4273 = var4; // L: 36
		if (this.field4271 == -1) { // L: 37
			this.field4274 = new HashMap(64); // L: 38
			this.field4270 = new class347(64, this.field4269); // L: 39
			this.field4268 = null; // L: 40
		} else {
			if (this.field4273 == null) { // L: 43
				throw new IllegalArgumentException("");
			}
			this.field4274 = new HashMap(this.field4271); // L: 44
			this.field4270 = new class347(this.field4271, this.field4269); // L:
																			// 45
			this.field4268 = new class347(this.field4271); // L: 46
		}
	} // L: 48
	
	public class361(int var1, class359 var2) {
		this(-1L, var1, var2); // L: 30
	} // L: 31
	
	boolean method6549() {
		return this.field4271 != -1; // L: 51
	}
	
	public Object method6538(Object var1) {
		synchronized (this) { // L: 55
			if (this.field4272 != -1L) { // L: 56
				this.method6541();
			}
			class362 var3 = (class362) this.field4274.get(var1); // L: 57
			if (var3 == null) { // L: 58
				return null;
			} else {
				this.method6540(var3, false); // L: 59
				return var3.field4276; // L: 60
			}
		}
	}
	
	public Object method6539(Object var1, Object var2) {
		synchronized (this) {
			if (this.field4272 != -1L) {
				this.method6541();
			}
			class362 var4 = (class362) this.field4274.get(var1);
			if (var4 != null) {
				Object var8 = var4.field4276;
				var4.field4276 = var2;
				this.method6540(var4, false);
				return var8;
			} else {
				class362 var5;
				if (this.method6549() && this.field4274.size() == this.field4271) {
					var5 = (class362) this.field4268.remove();
					this.field4274.remove(var5.field4275);
					this.field4270.remove(var5); // L: 77
				}
				var5 = new class362(var2, var1); // L: 79
				this.field4274.put(var1, var5); // L: 80
				this.method6540(var5, true); // L: 81
				return null; // L: 82
			}
		}
	}
	
	void method6540(class362 var1, boolean var2) {
		if (!var2) { // L: 88
			this.field4270.remove(var1); // L: 89
			if (this.method6549() && !this.field4268.remove(var1)) { // L: 90 91
				throw new IllegalStateException("");
			}
		}
		var1.field4277 = System.currentTimeMillis(); // L: 94
		if (this.method6549()) { // L: 95
			switch (this.field4273.field4258) { // L: 96
				case 0 :
					++var1.field4278; // L: 101
					break;
				case 1 :
					var1.field4278 = var1.field4277; // L: 98
			}
			this.field4268.add(var1); // L: 104
		}
		this.field4270.add(var1); // L: 106
	} // L: 107
	
	void method6541() {
		if (-1L == this.field4272) { // L: 111
			throw new IllegalStateException("");
		} else {
			long var1 = System.currentTimeMillis() - this.field4272; // L: 112
			while (!this.field4270.isEmpty()) { // L: 113
				class362 var3 = (class362) this.field4270.peek(); // L: 114
				if (var3.field4277 >= var1) { // L: 115
					return; // L: 120
				}
				this.field4274.remove(var3.field4275); // L: 116
				this.field4270.remove(var3); // L: 117
				if (this.method6549()) { // L: 118
					this.field4268.remove(var3);
				}
			}
		}
	} // L: 122
	
	static void method6552() {
		Tiles.Tiles_underlays = null; // L: 64
		Tiles.Tiles_overlays = null; // L: 65
		Tiles.Tiles_shapes = null; // L: 66
		Tiles.field996 = null; // L: 67
		class1.field2 = null; // L: 68
		UserComparator6.field1415 = null; // L: 69
		class430.field4651 = null; // L: 70
		_Junk.Tiles_hue = null; // L: 71
		Tiles.Tiles_saturation = null; // L: 72
		Varcs.Tiles_lightness = null; // L: 73
		class465.Tiles_hueMultiplier = null; // L: 74
		WorldMapScaleHandler.field2877 = null; // L: 75
	} // L: 76
}
