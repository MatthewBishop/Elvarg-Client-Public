package osrs;

public class Anim_Snippet {

	public static final float field1429;
	public static final float field1432;
	static {
		field1429 = Math.ulp(1.0F); // L: 10
		field1432 = 2.0F * field1429; // L: 11
	}
	
	static void method3690(Float var0, Float var1) {
		if (var0 + field1429 < 1.3333334F) { // L: 299
			float var2 = var0 - 2.0F; // L: 300
			float var3 = var0 - 1.0F; // L: 301
			float var4 = (float) Math.sqrt((double) (var2 * var2 - var3 * 4.0F * var3)); // L:
																							// 302
			float var5 = (-var2 + var4) * 0.5F; // L: 303
			if (var1 + field1429 > var5) { // L: 304
				var1 = var5 - field1429; // L: 305
			} else {
				var5 = (-var2 - var4) * 0.5F; // L: 308
				if (var1 < field1429 + var5) { // L: 309
					var1 = field1429 + var5; // L: 310
				}
			}
		} else {
			var0 = 1.3333334F - field1429; // L: 315
			var1 = 0.33333334F - field1429; // L: 316
		}
	} // L: 318
	
	
	public static int method3534(float[] var0, int var1, float var2, boolean var3, float var4, boolean var5, float[] var6) {
		float var7 = 0.0F; // L: 15
		for (int var8 = 0; var8 < var1 + 1; ++var8) { // L: 16
			var7 += Math.abs(var0[var8]); // L: 17
		}
		float var24 = (Math.abs(var2) + Math.abs(var4)) * (float) (var1 + 1) * field1429; // L:
																									// 19
		if (var7 <= var24) { // L: 20
			return -1; // L: 21
		} else {
			float[] var9 = new float[var1 + 1]; // L: 23
			int var10;
			for (var10 = 0; var10 < var1 + 1; ++var10) { // L: 24
				var9[var10] = var0[var10] * (1.0F / var7); // L: 25
			}
			while (Math.abs(var9[var1]) < var24) { // L: 27
				--var1; // L: 28
			}
			var10 = 0; // L: 30
			if (var1 == 0) { // L: 31
				return var10; // L: 32
			} else if (var1 == 1) { // L: 34
				var6[0] = -var9[0] / var9[1]; // L: 35
				boolean var22 = var3 ? var2 < var24 + var6[0] : var2 < var6[0] - var24; // L:
																						// 36
				boolean var23 = var5 ? var4 > var6[0] - var24 : var4 > var6[0] + var24; // L:
																						// 37
				var10 = var22 && var23 ? 1 : 0; // L: 38
				if (var10 > 0) { // L: 39
					if (var3 && var6[0] < var2) { // L: 40
						var6[0] = var2; // L: 41
					} else if (var5 && var6[0] > var4) { // L: 43
						var6[0] = var4; // L: 44
					}
				}
				return var10; // L: 47
			} else {
				Anim_class389 var11 = new Anim_class389(var9, var1); // L: 50
				float[] var12 = new float[var1 + 1]; // L: 51
				for (int var13 = 1; var13 <= var1; ++var13) { // L: 52
					var12[var13 - 1] = (float) var13 * var9[var13]; // L: 53
				}
				float[] var21 = new float[var1 + 1]; // L: 55
				int var14 = method3534(var12, var1 - 1, var2, false, var4, false, var21); // L:
																							// 56
				if (var14 == -1) { // L: 57
					return 0; // L: 58
				} else {
					boolean var15 = false; // L: 60
					float var17 = 0.0F; // L: 62
					float var18 = 0.0F;
					float var19 = 0.0F;
					for (int var20 = 0; var20 <= var14; ++var20) {
						if (var10 > var1) {
							return var10;
						}
						float var16;
						if (var20 == 0) {
							var16 = var2; // L: 68
							var18 = method3281(var9, var1, var2);
							if (Math.abs(var18) <= var24 && var3) { // L: 70
								var6[var10++] = var2;
							}
						} else {
							var16 = var19; // L: 73
							var18 = var17; // L: 74
						}
						if (var14 == var20) { // L: 76
							var19 = var4; // L: 77
							var15 = false; // L: 78
						} else {
							var19 = var21[var20]; // L: 81
						}
						var17 = method3281(var9, var1, var19); // L:
																			// 83
						if (var15) { // L: 84
							var15 = false; // L: 85
						} else if (Math.abs(var17) < var24) { // L: 88
							if (var14 != var20 || var5) { // L: 89
								var6[var10++] = var19; // L: 90
								var15 = true; // L: 91
							}
						} else if (var18 < 0.0F && var17 > 0.0F || var18 > 0.0F && var17 < 0.0F) { // L:
																									// 94
							var6[var10++] = method7453(var11, var16, var19, 0.0F); // L:
																								// 95
							if (var10 > 1 && var6[var10 - 2] >= var6[var10 - 1] - var24) { // L:
																							// 96
								var6[var10 - 2] = 0.5F * (var6[var10 - 1] + var6[var10 - 2]); // L:
																								// 97
								--var10; // L: 98
							}
						}
					}
					return var10; // L: 104
				}
			}
		}
	}
		
	private static float method7453(Anim_class389 var0, float var1, float var2, float var3) {
		float var4 = method3281(var0.field4415, var0.field4414, var1); // L:
																					// 116
		if (Math.abs(var4) < field1429) { // L: 117
			return var1;
		} else {
			float var5 = method3281(var0.field4415, var0.field4414, var2); // L:
																						// 118
			if (Math.abs(var5) < field1429) { // L: 119
				return var2;
			} else {
				float var6 = 0.0F; // L: 120
				float var7 = 0.0F; // L: 121
				float var8 = 0.0F; // L: 122
				float var13 = 0.0F; // L: 127
				boolean var14 = true; // L: 128
				boolean var15 = false; // L: 129
				do {
					var15 = false; // L: 131
					if (var14) { // L: 132
						var6 = var1; // L: 133
						var13 = var4; // L: 134
						var7 = var2 - var1; // L: 135
						var8 = var7; // L: 136
						var14 = false; // L: 137
					}
					if (Math.abs(var13) < Math.abs(var5)) { // L: 139
						var1 = var2; // L: 140
						var2 = var6; // L: 141
						var6 = var1; // L: 142
						var4 = var5; // L: 143
						var5 = var13; // L: 144
						var13 = var4; // L: 145
					}
					float var16 = field1432 * Math.abs(var2) + 0.5F * var3; // L:
																						// 147
					float var17 = 0.5F * (var6 - var2); // L: 148
					boolean var18 = Math.abs(var17) > var16 && var5 != 0.0F; // L:
																				// 149
					if (var18) { // L: 150
						if (Math.abs(var8) >= var16 && Math.abs(var4) > Math.abs(var5)) { // L:
																							// 151
							float var12 = var5 / var4; // L: 156
							float var9;
							float var10;
							if (var6 == var1) { // L: 157
								var9 = 2.0F * var17 * var12; // L: 158
								var10 = 1.0F - var12; // L: 159
							} else {
								var10 = var4 / var13; // L: 162
								float var11 = var5 / var13; // L: 163
								var9 = ((var10 - var11) * 2.0F * var17 * var10 - (var2 - var1) * (var11 - 1.0F)) * var12; // L:
																															// 164
								var10 = (var12 - 1.0F) * (var10 - 1.0F) * (var11 - 1.0F); // L:
																							// 165
							}
							if ((double) var9 > 0.0D) { // L: 167
								var10 = -var10;
							} else {
								var9 = -var9; // L: 168
							}
							var12 = var8; // L: 169
							var8 = var7; // L: 170
							if (2.0F * var9 < var10 * 3.0F * var17 - Math.abs(var16 * var10) && var9 < Math.abs(var10 * var12 * 0.5F)) { // L:
																																			// 171
								var7 = var9 / var10; // L: 172
							} else {
								var7 = var17; // L: 175
								var8 = var17; // L: 176
							}
						} else {
							var7 = var17; // L: 152
							var8 = var17; // L: 153
						}
						var1 = var2; // L: 179
						var4 = var5; // L: 180
						if (Math.abs(var7) > var16) { // L: 181
							var2 += var7;
						} else if ((double) var17 > 0.0D) { // L: 182
							var2 += var16;
						} else {
							var2 -= var16; // L: 183
						}
						var5 = method3281(var0.field4415, var0.field4414, var2); // L:
																							// 184
						if ((double) (var5 * (var13 / Math.abs(var13))) > 0.0D) { // L:
																					// 185
							var14 = true; // L: 186
							var15 = true; // L: 187
						} else {
							var15 = true; // L: 190
						}
					}
				} while (var15);
				return var2; // L: 194
			}
		}
	}
	
	private static float method3281(float[] var0, int var1, float var2) {
		float var3 = var0[var1]; // L: 108
		for (int var4 = var1 - 1; var4 >= 0; --var4) { // L: 109
			var3 = var2 * var3 + var0[var4]; // L: 110
		}
		return var3; // L: 112
	}
}

