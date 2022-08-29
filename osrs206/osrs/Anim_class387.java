package osrs;
import java.util.Arrays;
public final class Anim_class387 {
	
	static Anim_class387[] field4393;
	
	static int field4396;
	
	public static final Anim_class387 field4397;
	
	static int field4395;
	public float[] field4394;
	static {
		field4393 = new Anim_class387[0]; // L: 9
		field4396 = 100; // L: 15
		field4393 = new Anim_class387[100]; // L: 16
		field4395 = 0; // L: 17
		field4397 = new Anim_class387();
	} // L: 22
	public Anim_class387() {
		this.field4394 = new float[16];
		this.method6956(); // L: 41
	} // L: 42
	
	public Anim_class387(Anim_class387 var1) {
		this.field4394 = new float[16];
		this.method6973(var1); // L: 45
	} // L: 46
	
	public Anim_class387(Buffer var1, boolean var2) {
		this.field4394 = new float[16]; // L: 21
		this.method6957(var1, var2); // L: 49
	} // L: 50
	
	public void method6968() {
		synchronized (field4393) { // L: 35
			if (field4395 < field4396 - 1) { // L: 36
				field4393[++field4395 - 1] = this;
			}
		}
	} // L: 38
	
	void method6957(Buffer var1, boolean var2) {
		if (var2) { // L: 53
			Anim_class388 var13 = new Anim_class388(); // L: 54
			int var6 = var1.readShort(); // L: 57
			var6 &= 16383; // L: 59
			float var5 = (float) ((double) ((float) var6 / 16384.0F) * 6.283185307179586D); // L:
																							// 60
			var13.method7029(var5); // L: 62
			int var9 = var1.readShort(); // L: 65
			var9 &= 16383; // L: 67
			float var8 = (float) (6.283185307179586D * (double) ((float) var9 / 16384.0F)); // L:
																							// 68
			var13.method7027(var8); // L: 70
			int var12 = var1.readShort(); // L: 73
			var12 &= 16383; // L: 75
			float var11 = (float) (6.283185307179586D * (double) ((float) var12 / 16384.0F)); // L:
																								// 76
			var13.method7039(var11); // L: 78
			var13.method7026((float) var1.readShort(), (float) var1.readShort(), (float) var1.readShort()); // L:
																											// 79
			this.method6979(var13); // L: 80
		} else {
			for (int var3 = 0; var3 < 16; ++var3) { // L: 83
				this.field4394[var3] = var1.method7740(); // L: 84
			}
		}
	} // L: 87
	
	float[] method6958() {
		float[] var1 = new float[3]; // L: 90
		if ((double) this.field4394[2] < 0.999D && (double) this.field4394[2] > -0.999D) { // L:
																							// 91
			var1[1] = (float) (-Math.asin((double) this.field4394[2])); // L: 92
			double var2 = Math.cos((double) var1[1]); // L: 93
			var1[0] = (float) Math.atan2((double) this.field4394[6] / var2, (double) this.field4394[10] / var2); // L:
			// 94
			var1[2] = (float) Math.atan2((double) this.field4394[1] / var2, (double) this.field4394[0] / var2); // L:
																												// 95
		} else {
			var1[0] = 0.0F; // L: 98
			var1[1] = (float) Math.atan2((double) this.field4394[2], 0.0D); // L:
																			// 99
			var1[2] = (float) Math.atan2((double) (-this.field4394[9]), (double) this.field4394[5]); // L:
																										// 100
		}
		return var1; // L: 102
	}
	
	public float[] method6959() {
		float[] var1 = new float[]{(float) (-Math.asin((double) this.field4394[6])), 0.0F, 0.0F}; // L:
																									// 106
																									// 107
		double var2 = Math.cos((double) var1[0]); // L: 108
		double var4;
		double var6;
		if (Math.abs(var2) > 0.005D) { // L: 109
			var4 = (double) this.field4394[2]; // L: 110
			var6 = (double) this.field4394[10]; // L: 111
			double var8 = (double) this.field4394[4]; // L: 112
			double var10 = (double) this.field4394[5]; // L: 113
			var1[1] = (float) Math.atan2(var4, var6); // L: 114
			var1[2] = (float) Math.atan2(var8, var10); // L: 115
		} else {
			var4 = (double) this.field4394[1]; // L: 118
			var6 = (double) this.field4394[0]; // L: 119
			if (this.field4394[6] < 0.0F) { // L: 120
				var1[1] = (float) Math.atan2(var4, var6); // L: 121
			} else {
				var1[1] = (float) (-Math.atan2(var4, var6)); // L: 124
			}
			var1[2] = 0.0F; // L: 126
		}
		return var1; // L: 128
	}
	
	void method6956() {
		this.field4394[0] = 1.0F; // L: 132
		this.field4394[1] = 0.0F; // L: 133
		this.field4394[2] = 0.0F; // L: 134
		this.field4394[3] = 0.0F; // L: 135
		this.field4394[4] = 0.0F; // L: 136
		this.field4394[5] = 1.0F; // L: 137
		this.field4394[6] = 0.0F; // L: 138
		this.field4394[7] = 0.0F; // L: 139
		this.field4394[8] = 0.0F; // L: 140
		this.field4394[9] = 0.0F; // L: 141
		this.field4394[10] = 1.0F; // L: 142
		this.field4394[11] = 0.0F; // L: 143
		this.field4394[12] = 0.0F; // L: 144
		this.field4394[13] = 0.0F; // L: 145
		this.field4394[14] = 0.0F; // L: 146
		this.field4394[15] = 1.0F; // L: 147
	} // L: 148
	
	public void method7016() {
		this.field4394[0] = 0.0F; // L: 151
		this.field4394[1] = 0.0F; // L: 152
		this.field4394[2] = 0.0F; // L: 153
		this.field4394[3] = 0.0F; // L: 154
		this.field4394[4] = 0.0F; // L: 155
		this.field4394[5] = 0.0F; // L: 156
		this.field4394[6] = 0.0F; // L: 157
		this.field4394[7] = 0.0F; // L: 158
		this.field4394[8] = 0.0F; // L: 159
		this.field4394[9] = 0.0F; // L: 160
		this.field4394[10] = 0.0F; // L: 161
		this.field4394[11] = 0.0F; // L: 162
		this.field4394[12] = 0.0F; // L: 163
		this.field4394[13] = 0.0F; // L: 164
		this.field4394[14] = 0.0F; // L: 165
		this.field4394[15] = 0.0F; // L: 166
	} // L: 167
	
	public void method6973(Anim_class387 var1) {
		System.arraycopy(var1.field4394, 0, this.field4394, 0, 16); // L: 170
	} // L: 171
	
	public void method6963(float var1) {
		this.method6964(var1, var1, var1); // L: 174
	} // L: 175
	
	public void method6964(float var1, float var2, float var3) {
		this.method6956(); // L: 178
		this.field4394[0] = var1; // L: 179
		this.field4394[5] = var2; // L: 180
		this.field4394[10] = var3; // L: 181
	} // L: 182
	
	public void method6965(Anim_class387 var1) {
		for (int var2 = 0; var2 < this.field4394.length; ++var2) { // L: 185
			float[] var10000 = this.field4394; // L: 186
			var10000[var2] += var1.field4394[var2];
		}
	} // L: 188
	
	public void method6962(Anim_class387 var1) {
		float var2 = this.field4394[3] * var1.field4394[12] + var1.field4394[8] * this.field4394[2] + var1.field4394[0] * this.field4394[0] + var1.field4394[4] * this.field4394[1]; // L:
																																														// 191
		float var3 = this.field4394[2] * var1.field4394[9] + this.field4394[0] * var1.field4394[1] + this.field4394[1] * var1.field4394[5] + this.field4394[3] * var1.field4394[13]; // L:
																																														// 192
		float var4 = var1.field4394[10] * this.field4394[2] + var1.field4394[2] * this.field4394[0] + var1.field4394[6] * this.field4394[1] + var1.field4394[14] * this.field4394[3]; // L:
																																														// 193
		float var5 = this.field4394[3] * var1.field4394[15] + this.field4394[2] * var1.field4394[11] + var1.field4394[3] * this.field4394[0] + this.field4394[1] * var1.field4394[7]; // L:
																																														// 194
		float var6 = var1.field4394[12] * this.field4394[7] + this.field4394[4] * var1.field4394[0] + var1.field4394[4] * this.field4394[5] + this.field4394[6] * var1.field4394[8]; // L:
																																														// 195
		float var7 = this.field4394[5] * var1.field4394[5] + this.field4394[4] * var1.field4394[1] + this.field4394[6] * var1.field4394[9] + var1.field4394[13] * this.field4394[7]; // L:
																																														// 196
		float var8 = this.field4394[7] * var1.field4394[14] + var1.field4394[10] * this.field4394[6] + var1.field4394[2] * this.field4394[4] + this.field4394[5] * var1.field4394[6]; // L:
																																														// 197
		float var9 = this.field4394[6] * var1.field4394[11] + var1.field4394[3] * this.field4394[4] + this.field4394[5] * var1.field4394[7] + var1.field4394[15] * this.field4394[7]; // L:
																																														// 198
		float var10 = this.field4394[9] * var1.field4394[4] + this.field4394[8] * var1.field4394[0] + var1.field4394[8] * this.field4394[10] + this.field4394[11] * var1.field4394[12]; // L:
																																														// 199
		float var11 = var1.field4394[13] * this.field4394[11] + this.field4394[10] * var1.field4394[9] + this.field4394[8] * var1.field4394[1] + this.field4394[9] * var1.field4394[5]; // L:
																																														// 200
		float var12 = this.field4394[8] * var1.field4394[2] + this.field4394[9] * var1.field4394[6] + this.field4394[10] * var1.field4394[10] + this.field4394[11] * var1.field4394[14]; // L:
																																															// 201
		float var13 = this.field4394[10] * var1.field4394[11] + var1.field4394[7] * this.field4394[9] + this.field4394[8] * var1.field4394[3] + var1.field4394[15] * this.field4394[11]; // L:
																																															// 202
		float var14 = this.field4394[15] * var1.field4394[12] + var1.field4394[8] * this.field4394[14] + var1.field4394[4] * this.field4394[13] + this.field4394[12] * var1.field4394[0]; // L:
																																															// 203
		float var15 = var1.field4394[9] * this.field4394[14] + var1.field4394[1] * this.field4394[12] + this.field4394[13] * var1.field4394[5] + this.field4394[15] * var1.field4394[13]; // L:
																																															// 204
		float var16 = this.field4394[14] * var1.field4394[10] + this.field4394[12] * var1.field4394[2] + var1.field4394[6] * this.field4394[13] + var1.field4394[14] * this.field4394[15]; // L:
																																															// 205
		float var17 = this.field4394[13] * var1.field4394[7] + var1.field4394[3] * this.field4394[12] + this.field4394[14] * var1.field4394[11] + this.field4394[15] * var1.field4394[15]; // L:
																																															// 206
		this.field4394[0] = var2; // L: 207
		this.field4394[1] = var3; // L: 208
		this.field4394[2] = var4; // L: 209
		this.field4394[3] = var5; // L: 210
		this.field4394[4] = var6; // L: 211
		this.field4394[5] = var7; // L: 212
		this.field4394[6] = var8; // L: 213
		this.field4394[7] = var9; // L: 214
		this.field4394[8] = var10; // L: 215
		this.field4394[9] = var11; // L: 216
		this.field4394[10] = var12; // L: 217
		this.field4394[11] = var13; // L: 218
		this.field4394[12] = var14; // L: 219
		this.field4394[13] = var15; // L: 220
		this.field4394[14] = var16; // L: 221
		this.field4394[15] = var17; // L: 222
	} // L: 223
	
	public void method6967(Anim_class386 var1) {
		float var2 = var1.field4391 * var1.field4391; // L: 226
		float var3 = var1.field4388 * var1.field4391; // L: 227
		float var4 = var1.field4391 * var1.field4387; // L: 228
		float var5 = var1.field4391 * var1.field4390; // L: 229
		float var6 = var1.field4388 * var1.field4388; // L: 230
		float var7 = var1.field4388 * var1.field4387; // L: 231
		float var8 = var1.field4390 * var1.field4388; // L: 232
		float var9 = var1.field4387 * var1.field4387; // L: 233
		float var10 = var1.field4387 * var1.field4390; // L: 234
		float var11 = var1.field4390 * var1.field4390; // L: 235
		this.field4394[0] = var2 + var6 - var11 - var9; // L: 236
		this.field4394[1] = var7 + var5 + var7 + var5; // L: 237
		this.field4394[2] = var8 - var4 - var4 + var8; // L: 238
		this.field4394[4] = var7 - var5 - var5 + var7; // L: 239
		this.field4394[5] = var9 + var2 - var6 - var11; // L: 240
		this.field4394[6] = var10 + var3 + var10 + var3; // L: 241
		this.field4394[8] = var8 + var8 + var4 + var4; // L: 242
		this.field4394[9] = var10 + (var10 - var3 - var3); // L: 243
		this.field4394[10] = var2 + var11 - var9 - var6; // L: 244
	} // L: 245
	
	void method6979(Anim_class388 var1) {
		this.field4394[0] = var1.field4405; // L: 248
		this.field4394[1] = var1.field4400; // L: 249
		this.field4394[2] = var1.field4402; // L: 250
		this.field4394[3] = 0.0F; // L: 251
		this.field4394[4] = var1.field4409; // L: 252
		this.field4394[5] = var1.field4403; // L: 253
		this.field4394[6] = var1.field4408; // L: 254
		this.field4394[7] = 0.0F; // L: 255
		this.field4394[8] = var1.field4401; // L: 256
		this.field4394[9] = var1.field4407; // L: 257
		this.field4394[10] = var1.field4406; // L: 258
		this.field4394[11] = 0.0F; // L: 259
		this.field4394[12] = var1.field4404; // L: 260
		this.field4394[13] = var1.field4410; // L: 261
		this.field4394[14] = var1.field4411; // L: 262
		this.field4394[15] = 1.0F; // L: 263
	} // L: 264
	
	float method6969() {
		return this.field4394[12] * this.field4394[9] * this.field4394[3] * this.field4394[6] + (this.field4394[14] * this.field4394[8] * this.field4394[5] * this.field4394[3] + this.field4394[10] * this.field4394[4] * this.field4394[3] * this.field4394[13] + (this.field4394[12] * this.field4394[11] * this.field4394[5] * this.field4394[2] + (this.field4394[12] * this.field4394[1] * this.field4394[7] * this.field4394[10] + (this.field4394[15] * this.field4394[1] * this.field4394[6] * this.field4394[8] + this.field4394[11] * this.field4394[0] * this.field4394[6] * this.field4394[13] + (this.field4394[15] * this.field4394[10] * this.field4394[0] * this.field4394[5] - this.field4394[14] * this.field4394[11] * this.field4394[5] * this.field4394[0] - this.field4394[15] * this.field4394[9] * this.field4394[0] * this.field4394[6]) + this.field4394[7] * this.field4394[0] * this.field4394[9] * this.field4394[14] - this.field4394[10] * this.field4394[0] * this.field4394[7] * this.field4394[13] - this.field4394[10] * this.field4394[1] * this.field4394[4] * this.field4394[15] + this.field4394[1] * this.field4394[4] * this.field4394[11] * this.field4394[14] - this.field4394[11] * this.field4394[6] * this.field4394[1] * this.field4394[12] - this.field4394[14] * this.field4394[7] * this.field4394[1] * this.field4394[8]) + this.field4394[4] * this.field4394[2] * this.field4394[9] * this.field4394[15] - this.field4394[2] * this.field4394[4] * this.field4394[11] * this.field4394[13] - this.field4394[15] * this.field4394[8] * this.field4394[5] * this.field4394[2]) + this.field4394[13] * this.field4394[7] * this.field4394[2] * this.field4394[8] - this.field4394[2] * this.field4394[7] * this.field4394[9] * this.field4394[12] - this.field4394[9] * this.field4394[4] * this.field4394[3] * this.field4394[14]) - this.field4394[10] * this.field4394[3] * this.field4394[5] * this.field4394[12] - this.field4394[13] * this.field4394[3] * this.field4394[6] * this.field4394[8]); // L:
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															// 267
	}
	
	public void method6970() {
		float var1 = 1.0F / this.method6969(); // L: 271
		float var2 = (this.field4394[7] * this.field4394[9] * this.field4394[14] + this.field4394[5] * this.field4394[10] * this.field4394[15] - this.field4394[14] * this.field4394[5] * this.field4394[11] - this.field4394[15] * this.field4394[6] * this.field4394[9] + this.field4394[11] * this.field4394[6] * this.field4394[13] - this.field4394[13] * this.field4394[7] * this.field4394[10]) * var1; // L:
																																																																																																				// 272
		float var3 = (this.field4394[14] * this.field4394[11] * this.field4394[1] + this.field4394[15] * -this.field4394[1] * this.field4394[10] + this.field4394[9] * this.field4394[2] * this.field4394[15] - this.field4394[13] * this.field4394[2] * this.field4394[11] - this.field4394[9] * this.field4394[3] * this.field4394[14] + this.field4394[10] * this.field4394[3] * this.field4394[13]) * var1; // L:
																																																																																																				// 273
		float var4 = (this.field4394[14] * this.field4394[3] * this.field4394[5] + this.field4394[13] * this.field4394[7] * this.field4394[2] + (this.field4394[15] * this.field4394[6] * this.field4394[1] - this.field4394[14] * this.field4394[1] * this.field4394[7] - this.field4394[2] * this.field4394[5] * this.field4394[15]) - this.field4394[13] * this.field4394[6] * this.field4394[3]) * var1; // L:
																																																																																																				// 274
		float var5 = var1 * (this.field4394[6] * this.field4394[3] * this.field4394[9] + (this.field4394[5] * this.field4394[2] * this.field4394[11] + this.field4394[7] * this.field4394[1] * this.field4394[10] + this.field4394[11] * -this.field4394[1] * this.field4394[6] - this.field4394[9] * this.field4394[7] * this.field4394[2] - this.field4394[10] * this.field4394[3] * this.field4394[5])); // L:
																																																																																																			// 275
		float var6 = (this.field4394[12] * this.field4394[7] * this.field4394[10] + (this.field4394[15] * this.field4394[10] * -this.field4394[4] + this.field4394[4] * this.field4394[11] * this.field4394[14] + this.field4394[8] * this.field4394[6] * this.field4394[15] - this.field4394[12] * this.field4394[6] * this.field4394[11] - this.field4394[7] * this.field4394[8] * this.field4394[14])) * var1; // L:
																																																																																																					// 276
		float var7 = var1 * (this.field4394[2] * this.field4394[11] * this.field4394[12] + (this.field4394[15] * this.field4394[10] * this.field4394[0] - this.field4394[11] * this.field4394[0] * this.field4394[14] - this.field4394[15] * this.field4394[2] * this.field4394[8]) + this.field4394[3] * this.field4394[8] * this.field4394[14] - this.field4394[10] * this.field4394[3] * this.field4394[12]); // L:
																																																																																																					// 277
		float var8 = (this.field4394[2] * this.field4394[4] * this.field4394[15] + this.field4394[14] * this.field4394[7] * this.field4394[0] + -this.field4394[0] * this.field4394[6] * this.field4394[15] - this.field4394[2] * this.field4394[7] * this.field4394[12] - this.field4394[3] * this.field4394[4] * this.field4394[14] + this.field4394[12] * this.field4394[3] * this.field4394[6]) * var1; // L:
																																																																																																			// 278
		float var9 = (this.field4394[7] * this.field4394[2] * this.field4394[8] + (this.field4394[6] * this.field4394[0] * this.field4394[11] - this.field4394[10] * this.field4394[7] * this.field4394[0] - this.field4394[2] * this.field4394[4] * this.field4394[11]) + this.field4394[4] * this.field4394[3] * this.field4394[10] - this.field4394[8] * this.field4394[3] * this.field4394[6]) * var1; // L:
																																																																																																			// 279
		float var10 = var1 * (this.field4394[12] * this.field4394[5] * this.field4394[11] + (this.field4394[9] * this.field4394[4] * this.field4394[15] - this.field4394[4] * this.field4394[11] * this.field4394[13] - this.field4394[8] * this.field4394[5] * this.field4394[15]) + this.field4394[8] * this.field4394[7] * this.field4394[13] - this.field4394[12] * this.field4394[9] * this.field4394[7]); // L:
																																																																																																				// 280
		float var11 = (this.field4394[3] * this.field4394[9] * this.field4394[12] + (this.field4394[15] * this.field4394[9] * -this.field4394[0] + this.field4394[13] * this.field4394[11] * this.field4394[0] + this.field4394[1] * this.field4394[8] * this.field4394[15] - this.field4394[11] * this.field4394[1] * this.field4394[12] - this.field4394[8] * this.field4394[3] * this.field4394[13])) * var1; // L:
																																																																																																					// 281
		float var12 = (this.field4394[7] * this.field4394[1] * this.field4394[12] + (this.field4394[15] * this.field4394[5] * this.field4394[0] - this.field4394[7] * this.field4394[0] * this.field4394[13] - this.field4394[15] * this.field4394[1] * this.field4394[4]) + this.field4394[3] * this.field4394[4] * this.field4394[13] - this.field4394[12] * this.field4394[5] * this.field4394[3]) * var1; // L:
																																																																																																				// 282
		float var13 = var1 * (this.field4394[8] * this.field4394[5] * this.field4394[3] + (this.field4394[11] * this.field4394[4] * this.field4394[1] + this.field4394[9] * this.field4394[0] * this.field4394[7] + this.field4394[11] * -this.field4394[0] * this.field4394[5] - this.field4394[1] * this.field4394[7] * this.field4394[8] - this.field4394[4] * this.field4394[3] * this.field4394[9])); // L:
																																																																																																			// 283
		float var14 = var1 * (this.field4394[6] * this.field4394[9] * this.field4394[12] + (this.field4394[5] * this.field4394[8] * this.field4394[14] + this.field4394[9] * -this.field4394[4] * this.field4394[14] + this.field4394[13] * this.field4394[4] * this.field4394[10] - this.field4394[12] * this.field4394[10] * this.field4394[5] - this.field4394[6] * this.field4394[8] * this.field4394[13])); // L:
																																																																																																					// 284
		float var15 = var1 * (this.field4394[14] * this.field4394[9] * this.field4394[0] - this.field4394[10] * this.field4394[0] * this.field4394[13] - this.field4394[14] * this.field4394[8] * this.field4394[1] + this.field4394[12] * this.field4394[10] * this.field4394[1] + this.field4394[13] * this.field4394[8] * this.field4394[2] - this.field4394[9] * this.field4394[2] * this.field4394[12]); // L:
																																																																																																				// 285
		float var16 = var1 * (this.field4394[12] * this.field4394[2] * this.field4394[5] + (this.field4394[1] * this.field4394[4] * this.field4394[14] + this.field4394[13] * this.field4394[6] * this.field4394[0] + this.field4394[14] * this.field4394[5] * -this.field4394[0] - this.field4394[6] * this.field4394[1] * this.field4394[12] - this.field4394[4] * this.field4394[2] * this.field4394[13])); // L:
																																																																																																				// 286
		float var17 = (this.field4394[9] * this.field4394[2] * this.field4394[4] + this.field4394[5] * this.field4394[0] * this.field4394[10] - this.field4394[9] * this.field4394[0] * this.field4394[6] - this.field4394[10] * this.field4394[1] * this.field4394[4] + this.field4394[1] * this.field4394[6] * this.field4394[8] - this.field4394[5] * this.field4394[2] * this.field4394[8]) * var1; // L:
																																																																																																		// 287
		this.field4394[0] = var2; // L: 288
		this.field4394[1] = var3; // L: 289
		this.field4394[2] = var4; // L: 290
		this.field4394[3] = var5; // L: 291
		this.field4394[4] = var6; // L: 292
		this.field4394[5] = var7; // L: 293
		this.field4394[6] = var8; // L: 294
		this.field4394[7] = var9; // L: 295
		this.field4394[8] = var10; // L: 296
		this.field4394[9] = var11; // L: 297
		this.field4394[10] = var12; // L: 298
		this.field4394[11] = var13; // L: 299
		this.field4394[12] = var14; // L: 300
		this.field4394[13] = var15; // L: 301
		this.field4394[14] = var16; // L: 302
		this.field4394[15] = var17; // L: 303
	} // L: 304
	
	public float[] method6992() {
		float[] var1 = new float[3]; // L: 341
		Anim_class385 var2 = new Anim_class385(this.field4394[0], this.field4394[1], this.field4394[2]); // L:
																								// 342
		Anim_class385 var3 = new Anim_class385(this.field4394[4], this.field4394[5], this.field4394[6]); // L:
																								// 343
		Anim_class385 var4 = new Anim_class385(this.field4394[8], this.field4394[9], this.field4394[10]); // L:
																								// 344
		var1[0] = var2.method6929(); // L: 345
		var1[1] = var3.method6929(); // L: 346
		var1[2] = var4.method6929(); // L: 347
		return var1; // L: 348
	}
	public String toString() {
		StringBuilder var1 = new StringBuilder(); // L: 309
		this.method6959(); // L: 310
		this.method6958(); // L: 311
		for (int var2 = 0; var2 < 4; ++var2) { // L: 312
			for (int var3 = 0; var3 < 4; ++var3) { // L: 313
				if (var3 > 0) {
					var1.append("\t"); // L: 314
				}
				float var4 = this.field4394[var3 + var2 * 4]; // L: 315
				if (Math.sqrt((double) (var4 * var4)) < 9.999999747378752E-5D) { // L:
																					// 316
					var4 = 0.0F;
				}
				var1.append(var4); // L: 317
			}
			var1.append("\n"); // L: 319
		}
		return var1.toString(); // L: 321
	}
	public int hashCode() {
		boolean var1 = true; // L: 326
		byte var2 = 1; // L: 327
		int var3 = var2 * 31 + Arrays.hashCode(this.field4394); // L: 328
		return var3; // L: 329
	}
	public boolean equals(Object var1) {
		if (!(var1 instanceof Anim_class387)) { // L: 334
			return false;
		} else {
			Anim_class387 var2 = (Anim_class387) var1; // L: 335
			for (int var3 = 0; var3 < 16; ++var3) { // L: 336
				if (var2.field4394[var3] != this.field4394[var3]) {
					return false;
				}
			}
			return true; // L: 337
		}
	}

	public static Anim_class387 method1884() {
		synchronized (field4393) { // L: 25
			if (field4395 == 0) { // L: 26
				return new Anim_class387();
			} else {
				field4393[--field4395].method6956(); // L: 28
				return field4393[field4395]; // L: 29
			}
		}
	}
}
