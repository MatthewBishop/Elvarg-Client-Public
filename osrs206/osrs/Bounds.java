package osrs;
public class Bounds {
	
	public int lowX;
	
	public int lowY;
	
	public int highX;
	
	public int highY;
	public Bounds(int var1, int var2, int var3, int var4) {
		this.setLow(var1, var2); // L: 14
		this.setHigh(var3, var4); // L: 15
	} // L: 16
	public Bounds(int var1, int var2) {
		this(0, 0, var1, var2); // L: 10
	} // L: 11
	
	public void setLow(int var1, int var2) {
		this.lowX = var1; // L: 19
		this.lowY = var2; // L: 20
	} // L: 21
	
	public void setHigh(int var1, int var2) {
		this.highX = var1; // L: 24
		this.highY = var2; // L: 25
	} // L: 26
	
	public boolean method6894(int var1, int var2) {
		return var1 >= this.lowX && var1 < this.highX + this.lowX && var2 >= this.lowY && var2 < this.lowY + this.highY;
	}
	
	public void method6895(Bounds var1, Bounds var2) {
		this.method6909(var1, var2); // L: 37
		this.method6918(var1, var2); // L: 38
	} // L: 39
	
	void method6909(Bounds var1, Bounds var2) {
		var2.lowX = this.lowX; // L: 42
		var2.highX = this.highX; // L: 43
		if (this.lowX < var1.lowX) { // L: 44
			var2.highX = (var2.highX * 1517770071 - (var1.lowX * 1517770071 - this.lowX * 1517770071)) * 140797543; // L:
			// 45
			var2.lowX = var1.lowX; // L: 46
		}
		if (var2.method6898() > var1.method6898()) { // L: 48
			var2.highX -= var2.method6898() - var1.method6898(); // L: 49
		}
		if (var2.highX < 0) { // L: 51
			var2.highX = 0;
		}
	} // L: 52
	
	void method6918(Bounds var1, Bounds var2) {
		var2.lowY = this.lowY; // L: 55
		var2.highY = this.highY; // L: 56
		if (this.lowY < var1.lowY) { // L: 57
			var2.highY = (var2.highY * -1363956205 - (var1.lowY * -1363956205 - this.lowY * -1363956205)) * 1996835867; // L:
			// 58
			var2.lowY = var1.lowY; // L: 59
		}
		if (var2.method6903() > var1.method6903()) { // L: 61
			var2.highY -= var2.method6903() - var1.method6903(); // L: 62
		}
		if (var2.highY < 0) { // L: 64
			var2.highY = 0;
		}
	} // L: 65
	
	int method6898() {
		return this.lowX + this.highX; // L: 68
	}
	
	int method6903() {
		return this.highY + this.lowY; // L: 72
	}
	public String toString() {
		return null;
	}
	
	static int method6922(int var0, int var1) {
		ItemContainer var2 = (ItemContainer) ItemContainer.itemContainers.get((long) var0); // L:
																							// 28
		if (var2 == null) { // L: 29
			return 0;
		} else if (var1 == -1) { // L: 30
			return 0;
		} else {
			int var3 = 0; // L: 31
			for (int var4 = 0; var4 < var2.quantities.length; ++var4) { // L: 32
				if (var2.ids[var4] == var1) {
					var3 += var2.quantities[var4]; // L: 33
				}
			}
			return var3; // L: 35
		}
	}
}
