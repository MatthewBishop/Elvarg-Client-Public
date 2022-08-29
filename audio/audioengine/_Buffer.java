package audioengine;

import java.math.BigInteger;
class _Buffer extends _Node {
	static int[] crc32Table;
	static long[] crc64Table;
	protected byte[] array;
	
	protected int offset;
	static {
		crc32Table = new int[256]; // L: 16
		int var2;
		for (int var1 = 0; var1 < 256; ++var1) { // L: 21
			int var4 = var1; // L: 22
			for (var2 = 0; var2 < 8; ++var2) { // L: 23
				if ((var4 & 1) == 1) { // L: 24
					var4 = var4 >>> 1 ^ -306674912;
				} else {
					var4 >>>= 1; // L: 25
				}
			}
			crc32Table[var1] = var4; // L: 27
		}
		crc64Table = new long[256]; // L: 31
		for (var2 = 0; var2 < 256; ++var2) { // L: 36
			long var0 = (long) var2; // L: 37
			for (int var3 = 0; var3 < 8; ++var3) { // L: 38
				if (1L == (var0 & 1L)) { // L: 39
					var0 = var0 >>> 1 ^ -3932672073523589310L;
				} else {
					var0 >>>= 1; // L: 40
				}
			}
			crc64Table[var2] = var0; // L: 42
		}
	} // L: 44

	protected _Buffer(byte[] var1) {
		this.array = var1; // L: 61
		this.offset = 0; // L: 62
	} // L: 63
		
	protected void writeByte(int var1) {
		this.array[++this.offset - 1] = (byte) var1; // L: 71
	} // L: 72
	
	protected void writeShort(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 75
		this.array[++this.offset - 1] = (byte) var1; // L: 76
	} // L: 77
	
	protected void writeMedium(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 >> 16); // L: 80
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 81
		this.array[++this.offset - 1] = (byte) var1; // L: 82
	} // L: 83
	
	protected void writeInt(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 >> 24); // L: 86
		this.array[++this.offset - 1] = (byte) (var1 >> 16); // L: 87
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 88
		this.array[++this.offset - 1] = (byte) var1; // L: 89
	} // L: 90
	protected void writeLongMedium(long var1) {
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 40)); // L: 93
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 32)); // L: 94
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 24)); // L: 95
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 16)); // L: 96
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 8)); // L: 97
		this.array[++this.offset - 1] = (byte) ((int) var1); // L: 98
	} // L: 99
	protected void writeLong(long var1) {
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 56)); // L: 102
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 48)); // L: 103
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 40)); // L: 104
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 32)); // L: 105
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 24)); // L: 106
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 16)); // L: 107
		this.array[++this.offset - 1] = (byte) ((int) (var1 >> 8)); // L: 108
		this.array[++this.offset - 1] = (byte) ((int) var1); // L: 109
	} // L: 110
	
	protected void writeBoolean(boolean var1) {
		this.writeByte(var1 ? 1 : 0); // L: 113
	} // L: 114
		
	protected void writeCESU8(CharSequence var1) {
		int var3 = var1.length(); // L: 142
		int var4 = 0; // L: 143
		int var5;
		for (var5 = 0; var5 < var3; ++var5) { // L: 144
			char var12 = var1.charAt(var5); // L: 145
			if (var12 <= 127) { // L: 146
				++var4;
			} else if (var12 <= 2047) { // L: 147
				var4 += 2;
			} else {
				var4 += 3; // L: 148
			}
		}
		this.array[++this.offset - 1] = 0; // L: 153
		this.writeVarInt(var4); // L: 154
		var4 = this.offset * 1978245093; // L: 155
		byte[] var6 = this.array; // L: 157
		int var7 = this.offset; // L: 158
		int var8 = var1.length(); // L: 160
		int var9 = var7; // L: 161
		for (int var10 = 0; var10 < var8; ++var10) { // L: 162
			char var11 = var1.charAt(var10); // L: 163
			if (var11 <= 127) { // L: 164
				var6[var9++] = (byte) var11; // L: 165
			} else if (var11 <= 2047) { // L: 167
				var6[var9++] = (byte) (192 | var11 >> 6); // L: 168
				var6[var9++] = (byte) (128 | var11 & '?'); // L: 169
			} else {
				var6[var9++] = (byte) (224 | var11 >> '\f'); // L: 172
				var6[var9++] = (byte) (128 | var11 >> 6 & 63); // L: 173
				var6[var9++] = (byte) (128 | var11 & '?'); // L: 174
			}
		}
		var5 = var9 - var7; // L: 177
		this.offset = (var5 * 1978245093 + var4) * -1883142675; // L: 179
	} // L: 180
	
	protected void writeBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) { // L: 183
			this.array[++this.offset - 1] = var1[var4];
		}
	} // L: 184
	
	protected void method7727(_Buffer var1) {
		this.writeBytes(var1.array, 0, var1.offset); // L: 187
	} // L: 188
	
	protected void writeLengthInt(int var1) {
		if (var1 < 0) { // L: 191
			throw new IllegalArgumentException(); // L: 192
		} else {
			this.array[this.offset - var1 - 4] = (byte) (var1 >> 24); // L: 194
			this.array[this.offset - var1 - 3] = (byte) (var1 >> 16); // L: 195
			this.array[this.offset - var1 - 2] = (byte) (var1 >> 8); // L: 196
			this.array[this.offset - var1 - 1] = (byte) var1; // L: 197
		}
	} // L: 198
	
	protected void writeLengthShort(int var1) {
		if (var1 >= 0 && var1 <= 65535) { // L: 201
			this.array[this.offset - var1 - 2] = (byte) (var1 >> 8); // L: 204
			this.array[this.offset - var1 - 1] = (byte) var1; // L: 205
		} else {
			throw new IllegalArgumentException(); // L: 202
		}
	} // L: 206
	
	protected void method7935(int var1) {
		if (var1 >= 0 && var1 <= 255) { // L: 209
			this.array[this.offset - var1 - 1] = (byte) var1; // L: 212
		} else {
			throw new IllegalArgumentException(); // L: 210
		}
	} // L: 213
	
	protected void writeSmartByteShort(int var1) {
		if (var1 >= 0 && var1 < 128) { // L: 216
			this.writeByte(var1); // L: 217
		} else if (var1 >= 0 && var1 < 32768) { // L: 220
			this.writeShort(var1 + 32768); // L: 221
		} else {
			throw new IllegalArgumentException(); // L: 224
		}
	} // L: 218 222
	
	protected void writeVarInt(int var1) {
		if ((var1 & -128) != 0) { // L: 228
			if ((var1 & -16384) != 0) { // L: 229
				if ((var1 & -2097152) != 0) { // L: 230
					if ((var1 & -268435456) != 0) { // L: 231
						this.writeByte(var1 >>> 28 | 128);
					}
					this.writeByte(var1 >>> 21 | 128); // L: 232
				}
				this.writeByte(var1 >>> 14 | 128); // L: 234
			}
			this.writeByte(var1 >>> 7 | 128); // L: 236
		}
		this.writeByte(var1 & 127); // L: 238
	} // L: 239
	
	protected int readUnsignedByte() {
		return this.array[++this.offset - 1] & 255; // L: 242
	}
	
	protected byte readByte() {
		return this.array[++this.offset - 1]; // L: 246
	}
	
	protected int readUnsignedShort() {
		this.offset += 2; // L: 250
		return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8); // L:
																									// 251
	}
	
	protected int readShort() {
		this.offset += 2; // L: 255
		int var1 = (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8); // L:
																										// 256
		if (var1 > 32767) { // L: 257
			var1 -= 65536;
		}
		return var1; // L: 258
	}
	
	protected int readMedium() {
		this.offset += 3; // L: 262
		return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8); // L:
																																				// 263
	}
	
	protected int readInt() {
		this.offset += 4; // L: 267
		return ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 2] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 24); // L:
																																																// 268
	}
	
	protected long readLong() {
		long var1 = (long) this.readInt() & 4294967295L; // L: 272
		long var3 = (long) this.readInt() & 4294967295L; // L: 273
		return (var1 << 32) + var3; // L: 274
	}
	
	protected float method7740() {
		return Float.intBitsToFloat(this.readInt()); // L: 278
	}
	
	protected boolean readBoolean() {
		return (this.readUnsignedByte() & 1) == 1; // L: 282
	}
	
	protected String readCESU8() {
		byte var1 = this.array[++this.offset - 1]; // L: 312
		if (var1 != 0) { // L: 313
			throw new IllegalStateException("");
		} else {
			int var2 = this.readVarInt(); // L: 314
			if (var2 + this.offset > this.array.length) { // L: 315
				throw new IllegalStateException("");
			} else {
				byte[] var4 = this.array; // L: 317
				int var5 = this.offset; // L: 318
				char[] var6 = new char[var2]; // L: 320
				int var7 = 0; // L: 321
				int var8 = var5; // L: 322
				int var11;
				for (int var9 = var5 + var2; var8 < var9; var6[var7++] = (char) var11) { // L:
																							// 323
																							// 324
																							// 355
					int var10 = var4[var8++] & 255; // L: 325
					if (var10 < 128) { // L: 327
						if (var10 == 0) { // L: 328
							var11 = 65533;
						} else {
							var11 = var10; // L: 329
						}
					} else if (var10 < 192) { // L: 331
						var11 = 65533;
					} else if (var10 < 224) { // L: 332
						if (var8 < var9 && (var4[var8] & 192) == 128) { // L:
																		// 333
							var11 = (var10 & 31) << 6 | var4[var8++] & 63; // L:
																			// 334
							if (var11 < 128) { // L: 335
								var11 = 65533;
							}
						} else {
							var11 = 65533; // L: 337
						}
					} else if (var10 < 240) { // L: 339
						if (var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) { // L:
																												// 340
							var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63; // L:
																										// 341
							if (var11 < 2048) { // L: 342
								var11 = 65533;
							}
						} else {
							var11 = 65533; // L: 344
						}
					} else if (var10 < 248) { // L: 346
						if (var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) { // L:
																																				// 347
							var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63; // L:
																																	// 348
							if (var11 >= 65536 && var11 <= 1114111) { // L: 349
								var11 = 65533; // L: 350
							} else {
								var11 = 65533;
							}
						} else {
							var11 = 65533; // L: 352
						}
					} else {
						var11 = 65533; // L: 354
					}
				}
				String var3 = new String(var6, 0, var7); // L: 357
				this.offset += var2; // L: 360
				return var3; // L: 361
			}
		}
	}
	
	protected void readBytes(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = this.array[++this.offset - 1]; // L: 365
		}
	} // L: 366
	
	protected int readShortSmart() {
		int var1 = this.array[this.offset] & 255; // L: 369
		return var1 < 128 ? this.readUnsignedByte() - 64 : this.readUnsignedShort() - 49152; // L:
																								// 370
																								// 371
	}
	
	protected int readUShortSmart() {
		int var1 = this.array[this.offset] & 255; // L: 375
		return var1 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 32768; // L:
																						// 376
																						// 377
	}
	
	protected int method7749() {
		int var1 = this.array[this.offset] & 255; // L: 381
		return var1 < 128 ? this.readUnsignedByte() - 1 : this.readUnsignedShort() - 32769; // L:
																							// 382
																							// 383
	}
	
	protected int method7770() {
		int var1 = 0; // L: 387
		int var2;
		for (var2 = this.readUShortSmart(); var2 == 32767; var2 = this.readUShortSmart()) { // L:
																							// 388
																							// 389
																							// 391
			var1 += 32767; // L: 390
		}
		var1 += var2; // L: 393
		return var1; // L: 394
	}
	
	protected int method7715() {
		return this.array[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort(); // L:
																											// 398
		// 399
	}
	
	protected int method7752() {
		if (this.array[this.offset] < 0) { // L: 403
			return this.readInt() & Integer.MAX_VALUE;
		} else {
			int var1 = this.readUnsignedShort(); // L: 404
			return var1 == 32767 ? -1 : var1; // L: 405
		}
	}
	
	protected int readVarInt() {
		byte var1 = this.array[++this.offset - 1]; // L: 410
		int var2;
		for (var2 = 0; var1 < 0; var1 = this.array[++this.offset - 1]) { // L:
																			// 411
																			// 412
																			// 414
			var2 = (var2 | var1 & 127) << 7; // L: 413
		}
		return var2 | var1; // L: 416
	}
	
	protected int method7754() {
		int var2 = 0; // L: 421
		int var3 = 0; // L: 422
		int var1;
		do {
			var1 = this.readUnsignedByte(); // L: 424
			var2 |= (var1 & 127) << var3; // L: 425
			var3 += 7; // L: 426
		} while (var1 > 127); // L: 427
		return var2; // L: 428
	}
	
	protected void xteaEncryptAll(int[] var1) {
		int var2 = this.offset / 8; // L: 432
		this.offset = 0; // L: 433
		for (int var3 = 0; var3 < var2; ++var3) { // L: 434
			int var4 = this.readInt(); // L: 435
			int var5 = this.readInt(); // L: 436
			int var6 = 0; // L: 437
			int var7 = -1640531527; // L: 438
			for (int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) { // L:
				// 439
				// 440
				// 443
				var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]; // L:
																					// 441
				var6 += var7; // L: 442
			}
			this.offset -= 8; // L: 445
			this.writeInt(var4); // L: 446
			this.writeInt(var5); // L: 447
		}
	} // L: 449
	
	protected void xteaDecryptAll(int[] var1) {
		int var2 = this.offset / 8; // L: 452
		this.offset = 0; // L: 453
		for (int var3 = 0; var3 < var2; ++var3) { // L: 454
			int var4 = this.readInt(); // L: 455
			int var5 = this.readInt(); // L: 456
			int var6 = -957401312; // L: 457
			int var7 = -1640531527; // L: 458
			for (int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) { // L:
																												// 459
				// 460
				// 463
				var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6; // L:
																						// 461
				var6 -= var7; // L: 462
			}
			this.offset -= 8; // L: 465
			this.writeInt(var4); // L: 466
			this.writeInt(var5); // L: 467
		}
	} // L: 469
	
	protected void xteaEncrypt(int[] var1, int var2, int var3) {
		int var4 = this.offset; // L: 472
		this.offset = var2; // L: 473
		int var5 = (var3 - var2) / 8; // L: 474
		for (int var6 = 0; var6 < var5; ++var6) { // L: 475
			int var7 = this.readInt(); // L: 476
			int var8 = this.readInt(); // L: 477
			int var9 = 0; // L: 478
			int var10 = -1640531527; // L: 479
			for (int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) { // L:
				// 480
				// 481
				// 484
				var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]; // L:
																					// 482
				var9 += var10; // L: 483
			}
			this.offset -= 8; // L: 486
			this.writeInt(var7); // L: 487
			this.writeInt(var8); // L: 488
		}
		this.offset = var4; // L: 490
	} // L: 491
	
	protected void xteaDecrypt(int[] var1, int var2, int var3) {
		int var4 = this.offset; // L: 494
		this.offset = var2; // L: 495
		int var5 = (var3 - var2) / 8; // L: 496
		for (int var6 = 0; var6 < var5; ++var6) { // L: 497
			int var7 = this.readInt(); // L: 498
			int var8 = this.readInt(); // L: 499
			int var9 = -957401312; // L: 500
			int var10 = -1640531527; // L: 501
			for (int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) { // L:
				// 502
				// 503
				// 506
				var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9; // L:
																						// 504
				var9 -= var10; // L: 505
			}
			this.offset -= 8; // L: 508
			this.writeInt(var7); // L: 509
			this.writeInt(var8); // L: 510
		}
		this.offset = var4; // L: 512
	} // L: 513
	
	protected void encryptRsa(BigInteger var1, BigInteger var2) {
		int var3 = this.offset; // L: 516
		this.offset = 0; // L: 517
		byte[] var4 = new byte[var3]; // L: 518
		this.readBytes(var4, 0, var3); // L: 519
		BigInteger var5 = new BigInteger(var4); // L: 520
		BigInteger var6 = var5.modPow(var1, var2); // L: 521
		byte[] var7 = var6.toByteArray(); // L: 522
		this.offset = 0; // L: 523
		this.writeShort(var7.length); // L: 524
		this.writeBytes(var7, 0, var7.length); // L: 525
	} // L: 526
		
	protected void method7762(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 + 128); // L: 543
	} // L: 544
	
	protected void method7763(int var1) {
		this.array[++this.offset - 1] = (byte) (0 - var1); // L: 547
	} // L: 548
	
	protected void method7764(int var1) {
		this.array[++this.offset - 1] = (byte) (128 - var1); // L: 551
	} // L: 552
	
	protected int method7765() {
		return this.array[++this.offset - 1] - 128 & 255; // L: 555
	}
	
	protected int method7766() {
		return 0 - this.array[++this.offset - 1] & 255; // L: 559
	}
	
	protected int method7767() {
		return 128 - this.array[++this.offset - 1] & 255; // L: 563
	}
	
	protected byte method7768() {
		return (byte) (this.array[++this.offset - 1] - 128); // L: 567
	}
	
	protected byte method7769() {
		return (byte) (0 - this.array[++this.offset - 1]); // L: 571
	}
	
	protected byte method7952() {
		return (byte) (128 - this.array[++this.offset - 1]); // L: 575
	}
	
	protected void writeIntME(int var1) {
		this.array[++this.offset - 1] = (byte) var1; // L: 579
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 580
	} // L: 581
	
	protected void method7863(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 584
		this.array[++this.offset - 1] = (byte) (var1 + 128); // L: 585
	} // L: 586
	
	protected void method7929(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 + 128); // L: 589
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 590
	} // L: 591
	
	protected int method7774() {
		this.offset += 2; // L: 594
		return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255); // L:
																									// 595
	}
	
	protected int method7775() {
		this.offset += 2; // L: 599
		return (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8); // L:
																										// 600
	}
	
	protected int method7776() {
		this.offset += 2; // L: 604
		return ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255); // L:
																										// 605
	}
	
	protected int method7777() {
		this.offset += 2; // L: 609
		int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] & 255); // L:
																										// 610
		if (var1 > 32767) { // L: 611
			var1 -= 65536;
		}
		return var1; // L: 612
	}
	
	protected int method7813() {
		this.offset += 2; // L: 616
		int var1 = (this.array[this.offset - 1] - 128 & 255) + ((this.array[this.offset - 2] & 255) << 8); // L:
																											// 617
		if (var1 > 32767) { // L: 618
			var1 -= 65536;
		}
		return var1; // L: 619
	}
	
	protected int method7779() {
		this.offset += 2; // L: 623
		int var1 = ((this.array[this.offset - 1] & 255) << 8) + (this.array[this.offset - 2] - 128 & 255); // L:
																											// 624
		if (var1 > 32767) { // L: 625
			var1 -= 65536;
		}
		return var1; // L: 626
	}
	
	protected int method7780() {
		this.offset += 3; // L: 630
		return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 3] & 255) << 16) + (this.array[this.offset - 2] & 255); // L:
																																				// 631
	}
	
	protected int method7848() {
		this.offset += 3; // L: 635
		return (this.array[this.offset - 1] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16); // L:
																																				// 636
	}
	
	protected void method7760(int var1) {
		this.array[++this.offset - 1] = (byte) var1; // L: 640
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 641
		this.array[++this.offset - 1] = (byte) (var1 >> 16); // L: 642
		this.array[++this.offset - 1] = (byte) (var1 >> 24); // L: 643
	} // L: 644
	
	protected void method7783(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 647
		this.array[++this.offset - 1] = (byte) var1; // L: 648
		this.array[++this.offset - 1] = (byte) (var1 >> 24); // L: 649
		this.array[++this.offset - 1] = (byte) (var1 >> 16); // L: 650
	} // L: 651
	
	protected void method7784(int var1) {
		this.array[++this.offset - 1] = (byte) (var1 >> 16); // L: 654
		this.array[++this.offset - 1] = (byte) (var1 >> 24); // L: 655
		this.array[++this.offset - 1] = (byte) var1; // L: 656
		this.array[++this.offset - 1] = (byte) (var1 >> 8); // L: 657
	} // L: 658
	
	protected int method7785() {
		this.offset += 4; // L: 661
		return (this.array[this.offset - 4] & 255) + ((this.array[this.offset - 3] & 255) << 8) + ((this.array[this.offset - 2] & 255) << 16) + ((this.array[this.offset - 1] & 255) << 24); // L:
																																																// 662
	}
	
	protected int method7786() {
		this.offset += 4; // L: 666
		return ((this.array[this.offset - 2] & 255) << 24) + ((this.array[this.offset - 4] & 255) << 8) + (this.array[this.offset - 3] & 255) + ((this.array[this.offset - 1] & 255) << 16); // L:
																																																// 667
	}
	
	protected int method7787() {
		this.offset += 4; // L: 671
		return ((this.array[this.offset - 1] & 255) << 8) + ((this.array[this.offset - 4] & 255) << 16) + (this.array[this.offset - 2] & 255) + ((this.array[this.offset - 3] & 255) << 24); // L:
																																																// 672
	}
	
	protected void method7828(byte[] var1, int var2, int var3) {
		for (int var4 = var2; var4 < var3 + var2; ++var4) {
			var1[var4] = (byte) (this.array[++this.offset - 1] - 128); // L: 676
		}
	} // L: 677
}
