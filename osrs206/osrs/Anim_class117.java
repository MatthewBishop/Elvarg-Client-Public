package osrs;

public class Anim_class117 {
	boolean field1463;
	boolean field1459;
	
	Anim_enum116 field1468;
	
	Anim_enum116 field1461;
	
	Anim_RS3AnimParam[] field1462;
	boolean field1470;
	float field1464;
	float field1458;
	float[] field1465;
	float[] field1467;
	boolean field1472;
	
	int field1469;
	float[] field1460;
	
	int field1471;
	
	int field1466;
	float field1473;
	float field1474;
	Anim_class117() {
		this.field1465 = new float[4]; // L: 16
		this.field1467 = new float[4]; // L: 17
		this.field1472 = true; // L: 18
		this.field1469 = 0; // L: 19
	} // L: 26
	
	int method2702(Buffer var1, int var2) {
		int var3 = var1.readUnsignedShort(); // L: 29
		Anim_enum123.method1052(var1.readUnsignedByte()); // L: 30
		int var5 = var1.readUnsignedByte(); // L: 32
		Anim_enum116[] var6 = new Anim_enum116[]{Anim_enum116.rs_default, Anim_enum116.field1451, Anim_enum116.field1450, Anim_enum116.field1453, Anim_enum116.field1454}; // L:
																																				// 36
		Anim_enum116 var7 = (Anim_enum116) Anim_class117.findEnumerated(var6, var5); // L: 38
		if (var7 == null) { // L: 39
			var7 = Anim_enum116.rs_default;
		}
		this.field1468 = var7; // L: 42
		int var11 = var1.readUnsignedByte(); // L: 44
		Anim_enum116[] var8 = new Anim_enum116[]{Anim_enum116.rs_default, Anim_enum116.field1451, Anim_enum116.field1450, Anim_enum116.field1453, Anim_enum116.field1454};
		Anim_enum116 var9 = (Anim_enum116) Anim_class117.findEnumerated(var8, var11);
		if (var9 == null) {
			var9 = Anim_enum116.rs_default;
		}
		this.field1461 = var9; // L: 54
		this.field1463 = var1.readUnsignedByte() != 0;
		this.field1462 = new Anim_RS3AnimParam[var3];
		Anim_RS3AnimParam var13 = null; // L: 57
		int var12;
		for (var12 = 0; var12 < var3; ++var12) { // L: 58
			Anim_RS3AnimParam var10 = new Anim_RS3AnimParam();
			var10.method2630(var1, var2); // L: 60
			this.field1462[var12] = var10;
			if (var13 != null) { // L: 62
				var13.field1426 = var10;
			}
			var13 = var10;
		}
		this.field1471 = this.field1462[0].field1420;
		this.field1466 = this.field1462[this.method2709() - 1].field1420;
		this.field1460 = new float[this.method2706() + 1];
		for (var12 = this.method2704(); var12 <= this.method2703(); ++var12) {
			this.field1460[var12 - this.method2704()] = Anim_class117.method4918(this, (float) var12); // L:
																											// 72
		}
		this.field1462 = null;
		this.field1473 = Anim_class117.method4918(this, (float) (this.method2704() - 1)); // L:
																								// 76
		this.field1474 = Anim_class117.method4918(this, (float) (this.method2703() + 1));
		return var3; // L: 78
	}
	
	public float method2701(int var1) {
		if (var1 < this.method2704()) { // L: 83
			return this.field1473;
		} else {
			return var1 > this.method2703() ? this.field1474 : this.field1460[var1 - this.method2704()]; // L:
																											// 86
		}
	}
	
	int method2704() {
		return this.field1471;
	}
	
	int method2703() {
		return this.field1466; // L: 98
	}
	
	int method2706() {
		return this.method2703() - this.method2704();
	}
	
	int method2705(float var1) {
		if (this.field1469 < 0 || (float) this.field1462[this.field1469].field1420 > var1 || this.field1462[this.field1469].field1426 != null && (float) this.field1462[this.field1469].field1426.field1420 <= var1) {
			if (var1 >= (float) this.method2704() && var1 <= (float) this.method2703()) {
				int var2 = this.method2709();
				int var3 = this.field1469; // L: 113
				if (var2 > 0) {
					int var4 = 0;
					int var5 = var2 - 1;
					do {
						int var6 = var4 + var5 >> 1;
						if (var1 < (float) this.field1462[var6].field1420) { // L:
																				// 119
							if (var1 > (float) this.field1462[var6 - 1].field1420) {
								var3 = var6 - 1; // L: 121
								break;
							}
							var5 = var6 - 1; // L: 125
						} else {
							if (var1 <= (float) this.field1462[var6].field1420) { // L:
																					// 128
								var3 = var6; // L: 138
								break; // L: 139
							}
							if (var1 < (float) this.field1462[var6 + 1].field1420) { // L:
																						// 129
								var3 = var6; // L: 130
								break; // L: 131
							}
							var4 = var6 + 1; // L: 134
						}
					} while (var4 <= var5); // L: 141
				}
				if (var3 != this.field1469) { // L: 143
					this.field1469 = var3; // L: 144
					this.field1472 = true; // L: 145
				}
				return this.field1469; // L: 147
			} else {
				return -1; // L: 110
			}
		} else {
			return this.field1469;
		}
	}
	
	Anim_RS3AnimParam method2717(float var1) {
		int var2 = this.method2705(var1); // L: 151
		return var2 >= 0 && var2 < this.field1462.length ? this.field1462[var2] : null; // L:
																						// 152
																						// 153
																						// 156
	}
	
	int method2709() {
		return this.field1462 == null ? 0 : this.field1462.length; // L: 161 162
	}

	static void method2355(Anim_class117 var0, float[] var1, float[] var2) {
		if (var0 != null) { // L: 273
			var0.field1464 = var1[0]; // L: 276
			float var3 = var1[3] - var1[0]; // L: 277
			float var4 = var2[3] - var2[0]; // L: 278
			float var5 = var1[1] - var1[0]; // L: 279
			float var6 = 0.0F; // L: 280
			float var7 = 0.0F; // L: 281
			if (0.0D != (double) var5) { // L: 282
				var6 = (var2[1] - var2[0]) / var5; // L: 283
			}
			var5 = var1[3] - var1[2]; // L: 285
			if ((double) var5 != 0.0D) { // L: 286
				var7 = (var2[3] - var2[2]) / var5; // L: 287
			}
			float var8 = 1.0F / (var3 * var3); // L: 289
			float var9 = var3 * var6; // L: 290
			float var10 = var3 * var7; // L: 291
			var0.field1465[0] = (var10 + var9 - var4 - var4) * var8 / var3; // L:
																			// 292
			var0.field1465[1] = (var4 + var4 + var4 - var9 - var9 - var10) * var8; // L:
																					// 293
			var0.field1465[2] = var6; // L: 294
			var0.field1465[3] = var2[0]; // L: 295
		}
	} // L: 274 296

	static float method4918(Anim_class117 var0, float var1) {
		if (var0 != null && var0.method2709() != 0) {
			if (var1 < (float) var0.field1462[0].field1420) { // L: 21
				return var0.field1468 == Anim_enum116.rs_default ? var0.field1462[0].field1423 : method3349(var0, var1, true); // L:
																																		// 22
			} else if (var1 > (float) var0.field1462[var0.method2709() - 1].field1420) {
				return var0.field1461 == Anim_enum116.rs_default ? var0.field1462[var0.method2709() - 1].field1423 : method3349(var0, var1, false); // L:
																																								// 31
			} else if (var0.field1459) {
				return var0.field1462[0].field1423;
			} else {
				Anim_RS3AnimParam var2 = var0.method2717(var1);
				boolean var3 = false;
				boolean var4 = false;
				if (var2 == null) {
					return 0.0F; // L: 183
				} else {
					float var7;
					if (0.0D == (double) var2.field1419 && (double) var2.field1425 == 0.0D) {
						var3 = true; // L: 41
					} else if (Float.MAX_VALUE == var2.field1419 && Float.MAX_VALUE == var2.field1425) {
						var4 = true;
					} else if (var2.field1426 != null) {
						if (var0.field1472) {
							float[] var5 = new float[4]; // L: 48
							float[] var6 = new float[4];
							var5[0] = (float) var2.field1420;
							var6[0] = var2.field1423;
							var5[1] = var5[0] + var2.field1419 * 0.33333334F;
							var6[1] = 0.33333334F * var2.field1425 + var6[0];
							var5[3] = (float) var2.field1426.field1420;
							var6[3] = var2.field1426.field1423;
							var5[2] = var5[3] - 0.33333334F * var2.field1426.field1421; // L:
																						// 56
							var6[2] = var6[3] - var2.field1426.field1422 * 0.33333334F; // L:
																						// 57
							if (var0.field1463) {
								if (var0 != null) {
									var7 = var5[3] - var5[0];
									if (0.0D != (double) var7) { // L: 64
										float var8 = var5[1] - var5[0]; // L: 67
										float var9 = var5[2] - var5[0]; // L: 68
										Float var10 = var8 / var7; // L: 69
										Float var11 = var9 / var7; // L: 70
										var0.field1470 = var10 == 0.33333334F && var11 == 0.6666667F; // L:
																										// 71
										float var12 = var10; // L: 72
										float var13 = var11; // L: 73
										if ((double) var10 < 0.0D) { // L: 74
											var10 = 0.0F;
										}
										if ((double) var11 > 1.0D) { // L: 75
											var11 = 1.0F;
										}
										if ((double) var10 > 1.0D || var11 < -1.0F) { // L:
																						// 76
											Float var14 = var10; // L: 77
											Float var15 = 1.0F - var11; // L: 80
											if (var10 < 0.0F) { // L: 81
												var14 = 0.0F;
											}
											if (var15 < 0.0F) { // L: 82
												var15 = 0.0F;
											}
											if (var14 > 1.0F || var15 > 1.0F) { // L:
																				// 83
												float var16 = (float) ((double) (var14 * (var14 - 2.0F + var15)) + (double) var15 * ((double) var15 - 2.0D) + 1.0D); // L:
																																										// 84
												if (Anim_Snippet.field1429 + var16 > 0.0F) { // L:
																							// 85
													Anim_Snippet.method3690(var14, var15); // L:
																								// 86
												}
											}
											var15 = 1.0F - var15; // L: 89
										}
										if (var10 != var12) { // L: 92
											var5[1] = var5[0] + var10 * var7; // L:
																				// 93
											if ((double) var12 != 0.0D) { // L:
																			// 94
												var6[1] = var6[0] + (var6[1] - var6[0]) * var10 / var12; // L:
																											// 95
											}
										}
										if (var11 != var13) { // L: 98
											var5[2] = var5[0] + var11 * var7; // L:
																				// 99
											if (1.0D != (double) var13) { // L:
																			// 100
												var6[2] = (float) ((double) var6[3] - (double) (var6[3] - var6[2]) * (1.0D - (double) var11) / (1.0D - (double) var13)); // L:
																																											// 101
											}
										}
										var0.field1464 = var5[0]; // L: 104
										var0.field1458 = var5[3]; // L: 105
										method7040(0.0F, var10, var11, 1.0F, var0.field1465); // L:
																										// 106
										method7040(var6[0], var6[1], var6[2], var6[3], var0.field1467); // L:
										// 107
									}
								}
							} else {
								Anim_class117.method2355(var0, var5, var6); // L:
																		// 111
							}
							var0.field1472 = false; // L: 113
						}
					} else {
						var3 = true; // L: 117
					}
					if (var3) { // L: 119
						return var2.field1423; // L: 120
					} else if (var4) { // L: 122
						return (float) var2.field1420 != var1 && var2.field1426 != null ? var2.field1426.field1423 : var2.field1423; // L:
																																		// 123
																																		// 124
																																		// 127
					} else {
						float var17;
						float var18;
						if (var0.field1463) { // L: 130
							if (var0 == null) { // L: 133
								var18 = 0.0F; // L: 134
							} else {
								if (var1 == var0.field1464) { // L: 138
									var17 = 0.0F; // L: 139
								} else if (var0.field1458 == var1) { // L: 141
									var17 = 1.0F; // L: 142
								} else {
									var17 = (var1 - var0.field1464) / (var0.field1458 - var0.field1464); // L:
																											// 145
								}
								if (var0.field1470) { // L: 148
									var7 = var17; // L: 149
								} else {
									float[] var19 = new float[]{var0.field1465[0] - var17, var0.field1465[1], var0.field1465[2], var0.field1465[3]}; // L:
																																						// 152
																																						// 153
																																						// 154
																																						// 155
																																						// 156
									float[] var20 = new float[5]; // L: 157
									int var21 = Anim_Snippet.method3534(var19, 3, 0.0F, true, 1.0F, true, var20); // L:
									// 158
									if (var21 == 1) { // L: 159
										var7 = var20[0]; // L: 160
									} else {
										var7 = 0.0F; // L: 163
									}
								}
								var18 = var0.field1467[0] + var7 * (var0.field1467[1] + (var0.field1467[2] + var7 * var0.field1467[3]) * var7); // L:
								// 166
							}
							return var18; // L: 168
						} else {
							if (var0 == null) { // L: 173
								var18 = 0.0F; // L: 174
							} else {
								var17 = var1 - var0.field1464; // L: 177
								var18 = var17 * ((var17 * var0.field1465[0] + var0.field1465[1]) * var17 + var0.field1465[2]) + var0.field1465[3]; // L:
																																					// 178
							}
							return var18; // L: 180
						}
					}
				}
			}
		} else {
			return 0.0F;
		}
	}

	static float method3349(Anim_class117 var0, float var1, boolean var2) {
		float var3 = 0.0F; // L: 187
		if (var0 != null && var0.method2709() != 0) { // L: 188
			float var4 = (float) var0.field1462[0].field1420; // L: 191
			float var5 = (float) var0.field1462[var0.method2709() - 1].field1420; // L:
																					// 192
			float var6 = var5 - var4; // L: 193
			if ((double) var6 == 0.0D) { // L: 194
				return var0.field1462[0].field1423; // L: 195
			} else {
				float var7 = 0.0F; // L: 197
				if (var1 > var5) { // L: 198
					var7 = (var1 - var5) / var6; // L: 199
				} else {
					var7 = (var1 - var4) / var6; // L: 202
				}
				double var8 = (double) ((int) var7); // L: 204
				float var10 = Math.abs((float) ((double) var7 - var8)); // L:
																		// 205
				float var11 = var10 * var6; // L: 206
				var8 = Math.abs(var8 + 1.0D); // L: 207
				double var12 = var8 / 2.0D; // L: 208
				double var14 = (double) ((int) var12); // L: 209
				var10 = (float) (var12 - var14); // L: 210
				float var16;
				float var17;
				if (var2) { // L: 213
					if (var0.field1468 == Anim_enum116.field1454) { // L: 214
						if (0.0D != (double) var10) { // L: 215
							var11 += var4; // L: 216
						} else {
							var11 = var5 - var11; // L: 219
						}
					} else if (var0.field1468 != Anim_enum116.field1450 && var0.field1468 != Anim_enum116.field1453) { // L:
																												// 222
						if (var0.field1468 == Anim_enum116.field1451) { // L: 225
							var11 = var4 - var1; // L: 226
							var16 = var0.field1462[0].field1421; // L: 227
							var17 = var0.field1462[0].field1422; // L: 228
							var3 = var0.field1462[0].field1423; // L: 229
							if (0.0D != (double) var16) { // L: 230
								var3 -= var17 * var11 / var16; // L: 231
							}
							return var3; // L: 233
						}
					} else {
						var11 = var5 - var11; // L: 223
					}
				} else if (var0.field1461 == Anim_enum116.field1454) { // L: 237
					if (0.0D != (double) var10) { // L: 238
						var11 = var5 - var11; // L: 239
					} else {
						var11 += var4; // L: 242
					}
				} else if (var0.field1461 != Anim_enum116.field1450 && var0.field1461 != Anim_enum116.field1453) { // L:
																											// 245
					if (var0.field1461 == Anim_enum116.field1451) { // L: 248
						var11 = var1 - var5; // L: 249
						var16 = var0.field1462[var0.method2709() - 1].field1419; // L:
																					// 250
						var17 = var0.field1462[var0.method2709() - 1].field1425; // L:
																					// 251
						var3 = var0.field1462[var0.method2709() - 1].field1423; // L:
																				// 252
						if (0.0D != (double) var16) { // L: 253
							var3 += var11 * var17 / var16; // L: 254
						}
						return var3; // L: 256
					}
				} else {
					var11 += var4; // L: 246
				}
				var3 = Anim_class117.method4918(var0, var11); // L: 259
				float var18;
				if (var2 && var0.field1468 == Anim_enum116.field1453) { // L: 261
					var18 = var0.field1462[var0.method2709() - 1].field1423 - var0.field1462[0].field1423; // L:
																											// 262
					var3 = (float) ((double) var3 - var8 * (double) var18); // L:
																			// 263
				} else if (!var2 && var0.field1461 == Anim_enum116.field1453) { // L:
																			// 265
					var18 = var0.field1462[var0.method2709() - 1].field1423 - var0.field1462[0].field1423; // L:
																											// 266
					var3 = (float) ((double) var3 + (double) var18 * var8); // L:
																			// 267
				}
				return var3; // L: 269
			}
		} else {
			return var3; // L: 189
		}
	}

	public static Anim_IClientEnum findEnumerated(Anim_IClientEnum[] var0, int var1) {
		Anim_IClientEnum[] var2 = var0; // L: 17
		for (int var3 = 0; var3 < var2.length; ++var3) { // L: 18
			Anim_IClientEnum var4 = var2[var3]; // L: 19
			if (var1 == var4.rsOrdinal()) {
				return var4; // L: 21
			}
		}
		return null; // L: 25
	}
	
	private static void method7040(float var0, float var1, float var2, float var3, float[] var4) {
		float var5 = var1 - var0; // L: 321
		float var6 = var2 - var1; // L: 322
		float var7 = var3 - var2; // L: 323
		float var8 = var6 - var5; // L: 324
		var4[3] = var7 - var6 - var8; // L: 325
		var4[2] = var8 + var8 + var8; // L: 326
		var4[1] = var5 + var5 + var5; // L: 327
		var4[0] = var0; // L: 328
	} // L: 329
}
