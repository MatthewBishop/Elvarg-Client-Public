package osrs;
import java.util.HashMap;
import java.util.Map;

import adapter.ISequenceDefinition;

public class Anim_SequenceDefinition extends DualNode implements ISequenceDefinition {
	static boolean field2166;
	
	static AbstractArchive SequenceDefinition_archive;
	
	static AbstractArchive SequenceDefinition_animationsArchive;
	
	static AbstractArchive SequenceDefinition_skeletonsArchive;
	
	public static EvictingDualNodeHashTable SequenceDefinition_cached;
	
	public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
	
	public static EvictingDualNodeHashTable SequenceDefinition_cachedModel;
	
	int SequenceDefinition_cachedModelId;
	public Map skeletalsound;
	
	int skeletalRangeBegin;
	
	int skeletalRangeEnd;
	public int[] frameIds;
	int[] chatFrameIds;
	public int[] frameLengths;
	public int[] soundEffects;
	
	public int frameCount;
	int[] field2180;
	boolean[] field2181;
	public boolean field2182;
	
	public int field2183;
	
	public int shield;
	
	public int weapon;
	
	public int field2186;
	
	public int field2187;
	
	public int field2188;
	
	public int field2174;
	static {
		field2166 = false; // L: 16
		SequenceDefinition_cached = new EvictingDualNodeHashTable(64); // L: 20
		SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100); // L:
																				// 21
		SequenceDefinition_cachedModel = new EvictingDualNodeHashTable(100); // L:
																				// 22
	}
	Anim_SequenceDefinition() {
		this.SequenceDefinition_cachedModelId = -1; // L: 23
		this.skeletalRangeBegin = 0; // L: 25
		this.skeletalRangeEnd = 0; // L: 26
		this.frameCount = -1; // L: 31
		this.field2182 = false; // L: 34
		this.field2183 = 5; // L: 35
		this.shield = -1; // L: 36
		this.weapon = -1; // L: 37
		this.field2186 = 99; // L: 38
		this.field2187 = -1; // L: 39
		this.field2188 = -1; // L: 40
		this.field2174 = 2; // L: 41
	} // L: 43
	
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte(); // L: 64
			if (var2 == 0) { // L: 65
				return; // L: 68
			}
			this.decodeNext(var1, var2); // L: 66
		}
	}
	
	void decodeNext(Buffer var1, int var2) {
		int var3;
		int var4;
		if (var2 == 1) { // L: 71
			var3 = var1.readUnsignedShort(); // L: 72
			this.frameLengths = new int[var3]; // L: 73
			for (var4 = 0; var4 < var3; ++var4) { // L: 74
				this.frameLengths[var4] = var1.readUnsignedShort();
			}
			this.frameIds = new int[var3]; // L: 75
			for (var4 = 0; var4 < var3; ++var4) { // L: 76
				this.frameIds[var4] = var1.readUnsignedShort();
			}
			for (var4 = 0; var4 < var3; ++var4) { // L: 77
				this.frameIds[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 2) { // L: 79
			this.frameCount = var1.readUnsignedShort();
		} else if (var2 == 3) { // L: 80
			var3 = var1.readUnsignedByte(); // L: 81
			this.field2180 = new int[var3 + 1]; // L: 82
			for (var4 = 0; var4 < var3; ++var4) { // L: 83
				this.field2180[var4] = var1.readUnsignedByte();
			}
			this.field2180[var3] = 9999999; // L: 84
		} else if (var2 == 4) { // L: 86
			this.field2182 = true;
		} else if (var2 == 5) { // L: 87
			this.field2183 = var1.readUnsignedByte();
		} else if (var2 == 6) { // L: 88
			this.shield = var1.readUnsignedShort();
		} else if (var2 == 7) { // L: 89
			this.weapon = var1.readUnsignedShort();
		} else if (var2 == 8) { // L: 90
			this.field2186 = var1.readUnsignedByte();
		} else if (var2 == 9) { // L: 91
			this.field2187 = var1.readUnsignedByte();
		} else if (var2 == 10) { // L: 92
			this.field2188 = var1.readUnsignedByte();
		} else if (var2 == 11) { // L: 93
			this.field2174 = var1.readUnsignedByte();
		} else if (var2 == 12) { // L: 94
			var3 = var1.readUnsignedByte(); // L: 95
			this.chatFrameIds = new int[var3]; // L: 96
			for (var4 = 0; var4 < var3; ++var4) { // L: 97
				this.chatFrameIds[var4] = var1.readUnsignedShort();
			}
			for (var4 = 0; var4 < var3; ++var4) { // L: 98
				this.chatFrameIds[var4] += var1.readUnsignedShort() << 16;
			}
		} else if (var2 == 13) { // L: 100
			var3 = var1.readUnsignedByte(); // L: 101
			this.soundEffects = new int[var3]; // L: 102
			for (var4 = 0; var4 < var3; ++var4) { // L: 103
				this.soundEffects[var4] = var1.readMedium();
			}
		} else if (var2 == 14) { // L: 105
			this.SequenceDefinition_cachedModelId = var1.readInt(); // L: 106
		} else if (var2 == 15) { // L: 108
			var3 = var1.readUnsignedShort(); // L: 109
			this.skeletalsound = new HashMap(); // L: 110
			for (var4 = 0; var4 < var3; ++var4) { // L: 111
				int var5 = var1.readUnsignedShort(); // L: 112
				int var6 = var1.readMedium(); // L: 113
				this.skeletalsound.put(var5, var6); // L: 114
			}
		} else if (var2 == 16) { // L: 117
			this.skeletalRangeBegin = var1.readUnsignedShort(); // L: 118
			this.skeletalRangeEnd = var1.readUnsignedShort(); // L: 119
		} else if (var2 == 17) { // L: 121
			this.field2181 = new boolean[256]; // L: 122
			for (var3 = 0; var3 < this.field2181.length; ++var3) { // L: 123
				this.field2181[var3] = false; // L: 124
			}
			var3 = var1.readUnsignedByte(); // L: 126
			for (var4 = 0; var4 < var3; ++var4) { // L: 127
				this.field2181[var1.readUnsignedByte()] = true; // L: 128
			}
		}
	} // L: 132
	
	void postDecode() {
		if (this.field2187 == -1) { // L: 135
			if (this.field2180 == null && this.field2181 == null) { // L: 136
				this.field2187 = 0; // L: 137
			} else {
				this.field2187 = 2;
			}
		}
		if (this.field2188 == -1) { // L: 139
			if (this.field2180 == null && this.field2181 == null) { // L: 140
				this.field2188 = 0; // L: 141
			} else {
				this.field2188 = 2;
			}
		}
	} // L: 143
	
	public Model transformActorModel(Model var1, int var2) {
		if (!this.isCachedModelIdSet()) { // L: 146
			var2 = this.frameIds[var2]; // L: 147
			Anim_Frames var8 = Anim_Frames.getFrames(var2 >> 16); // L: 148
			var2 &= 65535; // L: 149
			if (var8 == null) { // L: 150
				return var1.toSharedSequenceModel(true);
			} else {
				Model var7 = var1.toSharedSequenceModel(!var8.hasAlphaTransform(var2)); // L:
																						// 151
				var7.animate(var8, var2); // L: 152
				return var7; // L: 153
			}
		} else {
			int var4 = this.SequenceDefinition_cachedModelId; // L: 157
			Anim_class122 var5 = (Anim_class122) SequenceDefinition_cachedModel.get((long) var4); // L:
																						// 159
			Anim_class122 var3;
			if (var5 != null) { // L: 160
				var3 = var5; // L: 161
			} else {
				var5 = Anim_SequenceDefinition.method1963(SequenceDefinition_animationsArchive, SequenceDefinition_skeletonsArchive, var4, false); // L:
																																				// 164
				if (var5 != null) { // L: 165
					SequenceDefinition_cachedModel.put(var5, (long) var4);
				}
				var3 = var5; // L: 166
			}
			if (var3 == null) { // L: 169
				return var1.toSharedSequenceModel(true);
			} else {
				Model var6 = var1.toSharedSequenceModel(!var3.method2778()); // L:
																				// 170
				var6.method4404(var3, var2); // L: 171
				return var6; // L: 172
			}
		}
	}
	
	Model transformObjectModel(Model var1, int var2, int var3) {
		if (!this.isCachedModelIdSet()) { // L: 177
			var2 = this.frameIds[var2]; // L: 178
			Anim_Frames var9 = Anim_Frames.getFrames(var2 >> 16); // L: 179
			var2 &= 65535; // L: 180
			if (var9 == null) {
				return var1.toSharedSequenceModel(true); // L: 181
			} else {
				Model var8 = var1.toSharedSequenceModel(!var9.hasAlphaTransform(var2)); // L:
																						// 182
				var3 &= 3; // L: 183
				if (var3 == 1) { // L: 184
					var8.rotateY270Ccw();
				} else if (var3 == 2) { // L: 185
					var8.rotateY180();
				} else if (var3 == 3) { // L: 186
					var8.rotateY90Ccw();
				}
				var8.animate(var9, var2); // L: 187
				if (var3 == 1) { // L: 188
					var8.rotateY90Ccw();
				} else if (var3 == 2) { // L: 189
					var8.rotateY180();
				} else if (var3 == 3) { // L: 190
					var8.rotateY270Ccw();
				}
				return var8; // L: 191
			}
		} else {
			int var5 = this.SequenceDefinition_cachedModelId; // L: 195
			Anim_class122 var6 = (Anim_class122) SequenceDefinition_cachedModel.get((long) var5); // L:
																						// 197
			Anim_class122 var4;
			if (var6 != null) { // L: 198
				var4 = var6; // L: 199
			} else {
				var6 = Anim_SequenceDefinition.method1963(SequenceDefinition_animationsArchive, SequenceDefinition_skeletonsArchive, var5, false); // L:
																																				// 202
				if (var6 != null) { // L: 203
					SequenceDefinition_cachedModel.put(var6, (long) var5);
				}
				var4 = var6; // L: 204
			}
			if (var4 == null) { // L: 207
				return var1.toSharedSequenceModel(true);
			} else {
				Model var7 = var1.toSharedSequenceModel(!var4.method2778()); // L:
																				// 208
				var3 &= 3; // L: 209
				if (var3 == 1) { // L: 210
					var7.rotateY270Ccw();
				} else if (var3 == 2) { // L: 211
					var7.rotateY180();
				} else if (var3 == 3) { // L: 212
					var7.rotateY90Ccw();
				}
				var7.method4404(var4, var2); // L: 213
				if (var3 == 1) { // L: 214
					var7.rotateY90Ccw();
				} else if (var3 == 2) { // L: 215
					var7.rotateY180();
				} else if (var3 == 3) { // L: 216
					var7.rotateY270Ccw();
				}
				return var7; // L: 217
			}
		}
	}
	
	Model transformSpotAnimationModel(Model var1, int var2) {
		if (!this.isCachedModelIdSet()) { // L: 222
			var2 = this.frameIds[var2]; // L: 223
			Anim_Frames var8 = Anim_Frames.getFrames(var2 >> 16); // L: 224
			var2 &= 65535; // L: 225
			if (var8 == null) { // L: 226
				return var1.toSharedSpotAnimationModel(true);
			} else {
				Model var7 = var1.toSharedSpotAnimationModel(!var8.hasAlphaTransform(var2)); // L:
																								// 227
				var7.animate(var8, var2); // L: 228
				return var7; // L: 229
			}
		} else {
			int var4 = this.SequenceDefinition_cachedModelId; // L: 233
			Anim_class122 var5 = (Anim_class122) SequenceDefinition_cachedModel.get((long) var4); // L:
																						// 235
			Anim_class122 var3;
			if (var5 != null) { // L: 236
				var3 = var5; // L: 237
			} else {
				var5 = Anim_SequenceDefinition.method1963(SequenceDefinition_animationsArchive, SequenceDefinition_skeletonsArchive, var4, false); // L:
																																				// 240
				if (var5 != null) { // L: 241
					SequenceDefinition_cachedModel.put(var5, (long) var4);
				}
				var3 = var5; // L: 242
			}
			if (var3 == null) { // L: 245
				return var1.toSharedSpotAnimationModel(true);
			} else {
				Model var6 = var1.toSharedSpotAnimationModel(!var3.method2778()); // L:
																					// 246
				var6.method4404(var3, var2); // L: 247
				return var6; // L: 248
			}
		}
	}
	
	public Model applyTransformations(Model var1, int var2, Anim_SequenceDefinition var3, int var4) {
		if (field2166 && !this.isCachedModelIdSet() && !var3.isCachedModelIdSet()) { // L:
																						// 253
			return this.method3828(var1, var2, var3, var4); // L: 254
		} else {
			Model var5 = var1.toSharedSequenceModel(false); // L: 256
			boolean var6 = false; // L: 257
			Anim_Frames var7 = null; // L: 258
			Anim_class122 var8;
			if (this.isCachedModelIdSet()) { // L: 259
				var8 = this.method3836(); // L: 260
				if (var3.isCachedModelIdSet() && this.field2181 == null) { // L:
																			// 261
					var5.method4404(var8, var2); // L: 262
					return var5; // L: 263
				}
				var5.method4399(var8, var2, this.field2181, false); // L: 265
			} else {
				var2 = this.frameIds[var2]; // L: 268
				var7 = Anim_Frames.getFrames(var2 >> 16); // L: 269
				var2 &= 65535; // L: 270
				if (var7 == null) { // L: 271
					return var3.transformActorModel(var1, var4);
				}
				if (!var3.isCachedModelIdSet() && (this.field2180 == null || var4 == -1)) { // L:
																							// 272
					var5.animate(var7, var2); // L: 273
					return var5; // L: 274
				}
				if (this.field2180 == null || var4 == -1) { // L: 276
					var5.animate(var7, var2); // L: 277
					return var5; // L: 278
				}
				var6 = var3.isCachedModelIdSet(); // L: 280
				if (!var6) { // L: 281
					var5.method4398(var7, var2, this.field2180, false); // L:
																		// 282
				}
			}
			if (var3.isCachedModelIdSet()) { // L: 285
				var8 = var3.method3836(); // L: 286
				var5.method4399(var8, var4, this.field2181, true); // L: 287
			} else {
				var4 = var3.frameIds[var4]; // L: 290
				Anim_Frames var9 = Anim_Frames.getFrames(var4 >> 16); // L: 291
				var4 &= 65535; // L: 292
				if (var9 == null) { // L: 293
					return this.transformActorModel(var1, var2);
				}
				var5.method4398(var9, var4, this.field2180, true); // L: 294
			}
			if (var6 && var7 != null) { // L: 296
				var5.method4398(var7, var2, this.field2180, false); // L: 297
			}
			var5.resetBounds(); // L: 299
			return var5; // L: 300
		}
	}
	
	Model method3828(Model var1, int var2, Anim_SequenceDefinition var3, int var4) {
		var2 = this.frameIds[var2]; // L: 304
		Anim_Frames var5 = Anim_Frames.getFrames(var2 >> 16); // L: 305
		var2 &= 65535; // L: 306
		if (var5 == null) { // L: 307
			return var3.transformActorModel(var1, var4);
		} else {
			var4 = var3.frameIds[var4]; // L: 308
			Anim_Frames var6 = Anim_Frames.getFrames(var4 >> 16); // L: 309
			var4 &= 65535; // L: 310
			Model var7;
			if (var6 == null) { // L: 311
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2)); // L:
																					// 312
				var7.animate(var5, var2); // L: 313
				return var7; // L: 314
			} else {
				var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4)); // L:
				// 316
				var7.animate2(var5, var2, var6, var4, this.field2180); // L: 317
				return var7; // L: 318
			}
		}
	}
	
	public Model transformWidgetModel(Model var1, int var2) {
		if (!this.isCachedModelIdSet()) { // L: 322
			int var3 = this.frameIds[var2]; // L: 323
			Anim_Frames var4 = Anim_Frames.getFrames(var3 >> 16); // L: 324
			var3 &= 65535; // L: 325
			if (var4 == null) { // L: 326
				return var1.toSharedSequenceModel(true);
			} else {
				Anim_Frames var5 = null; // L: 327
				int var6 = 0; // L: 328
				if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) { // L:
																					// 329
					var6 = this.chatFrameIds[var2]; // L: 330
					var5 = Anim_Frames.getFrames(var6 >> 16); // L: 331
					var6 &= 65535; // L: 332
				}
				Model var7;
				if (var5 != null && var6 != 65535) { // L: 334
					var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3) & !var5.hasAlphaTransform(var6)); // L:
					// 339
					var7.animate(var4, var3); // L: 340
					var7.animate(var5, var6); // L: 341
					return var7; // L: 342
				} else {
					var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3)); // L:
																						// 335
					var7.animate(var4, var3); // L: 336
					return var7; // L: 337
				}
			}
		} else {
			return this.transformActorModel(var1, var2); // L: 345
		}
	}
	
	public boolean isCachedModelIdSet() {
		return this.SequenceDefinition_cachedModelId >= 0; // L: 350
	}
	
	public int skeletalFrameCount() {
		return this.skeletalRangeEnd - this.skeletalRangeBegin; // L: 354
	}
	
	public Anim_class122 method3836() {
		if (this.isCachedModelIdSet()) { // L: 366
			int var2 = this.SequenceDefinition_cachedModelId; // L: 368
			Anim_class122 var3 = (Anim_class122) SequenceDefinition_cachedModel.get((long) var2); // L:
																						// 370
			Anim_class122 var1;
			if (var3 != null) { // L: 371
				var1 = var3; // L: 372
			} else {
				var3 = Anim_SequenceDefinition.method1963(SequenceDefinition_animationsArchive, SequenceDefinition_skeletonsArchive, var2, false); // L:
																																				// 375
				if (var3 != null) { // L: 376
					SequenceDefinition_cachedModel.put(var3, (long) var2);
				}
				var1 = var3; // L: 377
			}
			return var1; // L: 379
		} else {
			return null; // L: 382
		}
	}
	
	@Override
	public int[] getSoundEffects() {
		return soundEffects;
	}

	@Override
	public Map getSkeletalSounds() {
		return skeletalsound;
	}

	public static void method762(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		SequenceDefinition_archive = var0; // L: 46
		SequenceDefinition_animationsArchive = var1; // L: 47
		SequenceDefinition_skeletonsArchive = var2; // L: 48
	} // L: 49

	public static Anim_SequenceDefinition SequenceDefinition_get(int var0) {
		Anim_SequenceDefinition var1 = (Anim_SequenceDefinition) SequenceDefinition_cached.get((long) var0); // L:
		// 52
		if (var1 != null) { // L: 53
			return var1;
		} else {
			byte[] var2 = SequenceDefinition_archive.takeFile(12, var0); // L:
																							// 54
			var1 = new Anim_SequenceDefinition(); // L: 55
			if (var2 != null) { // L: 56
				var1.decode(new Buffer(var2));
			}
			var1.postDecode(); // L: 57
			SequenceDefinition_cached.put(var1, (long) var0); // L:
																					// 58
			return var1; // L: 59
		}
	}

	public static Anim_class122 method1963(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
		boolean var4 = true;
		byte[] var5 = var0.getFile(var2 >> 16 & 65535, var2 & 65535);
		if (var5 == null) {
			var4 = false;
			return null; // L: 27
		} else {
			int var6 = (var5[1] & 255) << 8 | var5[2] & 255;
			byte[] var7;
			if (var3) {
				var7 = var1.getFile(0, var6);
			} else {
				var7 = var1.getFile(var6, 0);
			}
			if (var7 == null) { // L: 33
				var4 = false;
			}
			if (!var4) { // L: 34
				return null;
			} else {
				try {
					return new Anim_class122(var0, var1, var2, var3); // L: 36
				} catch (Exception var9) { // L: 38
					return null; // L: 39
				}
			}
		}
	}
}
