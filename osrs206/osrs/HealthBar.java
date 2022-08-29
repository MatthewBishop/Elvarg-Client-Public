package osrs;

public class HealthBar extends Node {
	
	static ClanSettings guestClanSettings;
	public static char field1258;
	
	static int selectedSpellFlags;
	
	HealthBarDefinition definition;
	
	IterableNodeDeque updates;
	
	HealthBar(HealthBarDefinition var1) {
		this.updates = new IterableNodeDeque(); // L: 12
		this.definition = var1; // L: 15
	} // L: 16
	
	void put(int var1, int var2, int var3, int var4) {
		HealthBarUpdate var5 = null; // L: 19
		int var6 = 0; // L: 20
		for (HealthBarUpdate var7 = (HealthBarUpdate) this.updates.last(); var7 != null; var7 = (HealthBarUpdate) this.updates.previous()) { // L:
																																				// 21
			++var6; // L: 22
			if (var7.cycle == var1) { // L: 23
				var7.set(var1, var2, var3, var4); // L: 24
				return; // L: 25
			}
			if (var7.cycle <= var1) {
				var5 = var7; // L: 27
			}
		}
		if (var5 == null) { // L: 29
			if (var6 < 4) { // L: 30
				this.updates.addLast(new HealthBarUpdate(var1, var2, var3, var4));
			}
		} else {
			IterableNodeDeque.IterableNodeDeque_addBefore(new HealthBarUpdate(var1, var2, var3, var4), var5); // L:
																												// 33
			if (var6 >= 4) {
				this.updates.last().remove(); // L: 34
			}
		}
	} // L: 31 35
	
	HealthBarUpdate get(int var1) {
		HealthBarUpdate var2 = (HealthBarUpdate) this.updates.last(); // L: 38
		if (var2 != null && var2.cycle <= var1) { // L: 39
			for (HealthBarUpdate var3 = (HealthBarUpdate) this.updates.previous(); var3 != null && var3.cycle <= var1; var3 = (HealthBarUpdate) this.updates.previous()) { // L:
																																											// 40
																																											// 41
				var2.remove(); // L: 42
				var2 = var3; // L: 43
			}
			if (this.definition.int5 + var2.cycleOffset + var2.cycle > var1) { // L:
																				// 47
				return var2;
			} else {
				var2.remove(); // L: 49
				return null; // L: 50
			}
		} else {
			return null;
		}
	}
	
	boolean isEmpty() {
		return this.updates.method6147(); // L: 55
	}
	
	static int method2356(CharSequence var0, int var1, boolean var2) {
		if (var1 >= 2 && var1 <= 36) { // L: 85
			boolean var3 = false; // L: 86
			boolean var4 = false; // L: 87
			int var5 = 0; // L: 88
			int var6 = var0.length(); // L: 89
			for (int var7 = 0; var7 < var6; ++var7) { // L: 90
				char var8 = var0.charAt(var7); // L: 91
				if (var7 == 0) { // L: 92
					if (var8 == '-') { // L: 93
						var3 = true; // L: 94
						continue;
					}
					if (var8 == '+') { // L: 97
						continue;
					}
				}
				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0'; // L: 99
				} else if (var8 >= 'A' && var8 <= 'Z') { // L: 100
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') { // L: 101
						throw new NumberFormatException(); // L: 102
					}
					var10 = var8 - 'W';
				}
				if (var10 >= var1) { // L: 103
					throw new NumberFormatException();
				}
				if (var3) { // L: 104
					var10 = -var10;
				}
				int var9 = var10 + var5 * var1; // L: 105
				if (var9 / var1 != var5) { // L: 106
					throw new NumberFormatException();
				}
				var5 = var9; // L: 107
				var4 = true; // L: 108
			}
			if (!var4) { // L: 110
				throw new NumberFormatException();
			} else {
				return var5; // L: 111
			}
		} else {
			throw new IllegalArgumentException("" + var1);
		}
	}
	
	static final void method2349(int var0, int var1, int var2, int var3) {
		WorldMap.method7376(); // L: 5428
	} // L: 5429
}
