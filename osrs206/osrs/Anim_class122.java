package osrs;

public class Anim_class122 extends DualNode {
	int field1521;
	
	public Anim_class117[][] field1518;
	
	Anim_class117[][] field1519;
	
	int field1520;
	
	int field1524;
	
	public Anim_Skeleton field1523;
	
	int field1522;
	boolean field1525;
	
	Anim_class122(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		this.field1518 = null; // L: 14
		this.field1519 = null; // L: 15
		this.field1522 = 0; // L: 19
		this.field1521 = var3; // L: 44
		byte[] var5 = var1.takeFile(this.field1521 >> 16 & 65535, this.field1521 & 65535); // L:
																							// 45
		Buffer var6 = new Buffer(var5);
		int var7 = var6.readUnsignedByte();
		int var8 = var6.readUnsignedShort();
		byte[] var9;
		if (var4) {
			var9 = var2.getFile(0, var8);
		} else {
			var9 = var2.getFile(var8, 0);
		}
		this.field1523 = new Anim_Skeleton(var8, var9);
		this.method2762(var6, var7); // L: 53
	} // L: 54
	
	void method2762(Buffer var1, int var2) {
		this.field1520 = var1.readUnsignedShort(); // L: 57
		this.field1524 = var1.readUnsignedShort(); // L: 58
		this.field1522 = var1.readUnsignedByte(); // L: 59
		int var3 = var1.readUnsignedShort(); // L: 60
		this.field1519 = new Anim_class117[this.field1523.method4150().method4130()][]; // L:
																					// 61
		this.field1518 = new Anim_class117[this.field1523.method4148()][]; // L: 62
		for (int var4 = 0; var4 < var3; ++var4) { // L: 63
			Anim_enum118 var5 = Anim_enum118.method2116(var1.readUnsignedByte()); // L:
																			// 64
			int var6 = var1.readShortSmart(); // L: 65
			Anim_enum119 var7 = Anim_enum119.method254(var1.readUnsignedByte()); // L: 66
			Anim_class117 var8 = new Anim_class117(); // L: 67
			var8.method2702(var1, var2); // L: 68
			int var9 = var5.method2736(); // L: 69
			Anim_class117[][] var10;
			if (var5 == Anim_enum118.field1477) { // L: 71
				var10 = this.field1519; // L: 72
			} else {
				var10 = this.field1518; // L: 75
			}
			if (var10[var6] == null) { // L: 77
				var10[var6] = new Anim_class117[var9]; // L: 78
			}
			var10[var6][var7.method2747()] = var8; // L: 80
			if (var5 == Anim_enum118.field1480) { // L: 81
				this.field1525 = true; // L: 82
			}
		}
	} // L: 85
	
	int method2786() {
		return this.field1520; // L: 88
	}
	
	int method2765() {
		return this.field1524; // L: 92
	}
	
	public int method2766() {
		return this.field1522; // L: 96
	}
	
	public int method2767() {
		return this.method2765() - this.method2786(); // L: 100
	}
	
	public boolean method2778() {
		return this.field1525; // L: 104
	}
	
	public void method2790(int var1, Anim_class115 var2, int var3, int var4) {
		Anim_class387 var5 = Anim_class387.method1884(); // L: 108
		this.method2770(var5, var3, var2, var1); // L: 109
		this.method2772(var5, var3, var2, var1); // L: 110
		this.method2779(var5, var3, var2, var1); // L: 111
		var2.method2656(var5); // L: 112
		var5.method6968(); // L: 113
	} // L: 114
	
	void method2770(Anim_class387 var1, int var2, Anim_class115 var3, int var4) {
		float[] var5 = var3.method2660(this.field1522); // L: 117
		float var6 = var5[0]; // L: 118
		float var7 = var5[1]; // L: 119
		float var8 = var5[2]; // L: 120
		if (this.field1519[var2] != null) { // L: 121
			Anim_class117 var9 = this.field1519[var2][0]; // L: 122
			Anim_class117 var10 = this.field1519[var2][1]; // L: 123
			Anim_class117 var11 = this.field1519[var2][2]; // L: 124
			if (var9 != null) { // L: 125
				var6 = var9.method2701(var4);
			}
			if (var10 != null) { // L: 126
				var7 = var10.method2701(var4);
			}
			if (var11 != null) { // L: 127
				var8 = var11.method2701(var4);
			}
		}
		Anim_class386 var22;
		synchronized (Anim_class386.field4389) { // L: 131
			if (Anim_class386.field4385 == 0) { // L: 132
				var22 = new Anim_class386();
			} else {
				Anim_class386.field4389[--Anim_class386.field4385].method6951(); // L: 134
				var22 = Anim_class386.field4389[Anim_class386.field4385]; // L: 135
			}
		}
		var22.method6945(1.0F, 0.0F, 0.0F, var6); // L: 140
		Anim_class386 var23;
		synchronized (Anim_class386.field4389) { // L: 143
			if (Anim_class386.field4385 == 0) { // L: 144
				var23 = new Anim_class386();
			} else {
				Anim_class386.field4389[--Anim_class386.field4385].method6951(); // L: 146
				var23 = Anim_class386.field4389[Anim_class386.field4385]; // L: 147
			}
		}
		var23.method6945(0.0F, 1.0F, 0.0F, var7); // L: 152
		Anim_class386 var13;
		synchronized (Anim_class386.field4389) { // L: 155
			if (Anim_class386.field4385 == 0) { // L: 156
				var13 = new Anim_class386();
			} else {
				Anim_class386.field4389[--Anim_class386.field4385].method6951(); // L: 158
				var13 = Anim_class386.field4389[Anim_class386.field4385]; // L: 159
			}
		}
		var13.method6945(0.0F, 0.0F, 1.0F, var8); // L: 164
		Anim_class386 var15;
		synchronized (Anim_class386.field4389) { // L: 167
			if (Anim_class386.field4385 == 0) { // L: 168
				var15 = new Anim_class386();
			} else {
				Anim_class386.field4389[--Anim_class386.field4385].method6951(); // L: 170
				var15 = Anim_class386.field4389[Anim_class386.field4385]; // L: 171
			}
		}
		var15.method6938(var13); // L: 176
		var15.method6938(var22); // L: 177
		var15.method6938(var23); // L: 178
		Anim_class387 var17 = Anim_class387.method1884(); // L: 179
		var17.method6967(var15); // L: 180
		var1.method6962(var17); // L: 181
		var22.method6936(); // L: 182
		var23.method6936(); // L: 183
		var13.method6936(); // L: 184
		var15.method6936(); // L: 185
		var17.method6968(); // L: 186
	} // L: 187
	
	void method2779(Anim_class387 var1, int var2, Anim_class115 var3, int var4) {
		float[] var5 = var3.method2661(this.field1522); // L: 190
		float var6 = var5[0]; // L: 191
		float var7 = var5[1]; // L: 192
		float var8 = var5[2]; // L: 193
		if (this.field1519[var2] != null) { // L: 194
			Anim_class117 var9 = this.field1519[var2][3]; // L: 195
			Anim_class117 var10 = this.field1519[var2][4]; // L: 196
			Anim_class117 var11 = this.field1519[var2][5]; // L: 197
			if (var9 != null) { // L: 198
				var6 = var9.method2701(var4);
			}
			if (var10 != null) { // L: 199
				var7 = var10.method2701(var4);
			}
			if (var11 != null) { // L: 200
				var8 = var11.method2701(var4);
			}
		}
		var1.field4394[12] = var6; // L: 202
		var1.field4394[13] = var7; // L: 203
		var1.field4394[14] = var8; // L: 204
	} // L: 205
	
	void method2772(Anim_class387 var1, int var2, Anim_class115 var3, int var4) {
		float[] var5 = var3.method2679(this.field1522); // L: 208
		float var6 = var5[0]; // L: 209
		float var7 = var5[1]; // L: 210
		float var8 = var5[2]; // L: 211
		if (this.field1519[var2] != null) { // L: 212
			Anim_class117 var9 = this.field1519[var2][6]; // L: 213
			Anim_class117 var10 = this.field1519[var2][7]; // L: 214
			Anim_class117 var11 = this.field1519[var2][8]; // L: 215
			if (var9 != null) { // L: 216
				var6 = var9.method2701(var4);
			}
			if (var10 != null) { // L: 217
				var7 = var10.method2701(var4);
			}
			if (var11 != null) { // L: 218
				var8 = var11.method2701(var4);
			}
		}
		Anim_class387 var12 = Anim_class387.method1884(); // L: 220
		var12.method6964(var6, var7, var8); // L: 221
		var1.method6962(var12); // L: 222
		var12.method6968(); // L: 223
	} // L: 224
}
