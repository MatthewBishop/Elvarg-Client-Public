package osrs;

public class Anim_class201 {
	
	Anim_class115[] field2365;
	
	int field2366;
	
	Anim_class201(Buffer buffer, int param) {
		this.field2365 = new Anim_class115[param]; // L: 13
		this.field2366 = buffer.readUnsignedByte(); // L: 14
		for (int var3 = 0; var3 < this.field2365.length; ++var3) { // L: 15
			Anim_class115 var4 = new Anim_class115(this.field2366, buffer, false); // L: 16
			this.field2365[var3] = var4; // L: 17
		}
		this.method4131(); // L: 19
	} // L: 20
	
	void method4131() {
		Anim_class115[] var1 = this.field2365; // L: 24
		for (int var2 = 0; var2 < var1.length; ++var2) { // L: 25
			Anim_class115 var3 = var1[var2]; // L: 26
			if (var3.field1448 >= 0) { // L: 28
				var3.field1440 = this.field2365[var3.field1448]; // L: 29
			}
		}
	} // L: 34
	
	public int method4130() {
		return this.field2365.length; // L: 37
	}
	
	Anim_class115 method4123(int var1) {
		return this.field2365[var1]; // L: 41
	}
	
	Anim_class115[] method4124() {
		return this.field2365; // L: 45
	}
	
	void method4146(Anim_class122 var1, int var2) {
		this.method4126(var1, var2, (boolean[]) null, false); // L: 49
	} // L: 50
	
	void method4126(Anim_class122 var1, int var2, boolean[] var3, boolean var4) {
		int var5 = var1.method2766(); // L: 53
		int var6 = 0; // L: 54
		Anim_class115[] var7 = this.method4124(); // L: 56
		for (int var8 = 0; var8 < var7.length; ++var8) { // L: 57
			Anim_class115 var9 = var7[var8]; // L: 58
			if (var3 == null || var4 == var3[var6]) { // L: 60
				var1.method2790(var2, var9, var6, var5); // L: 61
			}
			++var6; // L: 63
		}
	} // L: 67
}
