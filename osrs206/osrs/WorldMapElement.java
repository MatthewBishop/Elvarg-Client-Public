package osrs;
public class WorldMapElement extends DualNode {
	
	static WorldMapElement[] WorldMapElement_cached;
	
	public static int WorldMapElement_count;
	
	static EvictingDualNodeHashTable WorldMapElement_cachedSprites;
	
	public final int objectId;
	
	public int sprite1;
	
	int sprite2;
	public String name;
	
	public int field1834;
	
	public int textSize;
	public boolean field1830;
	public boolean field1837;
	public String[] menuActions;
	public String menuTargetName;
	int[] field1840;
	
	int field1841;
	
	int field1842;
	
	int field1843;
	
	int field1827;
	
	public HorizontalAlignment horizontalAlignment;
	
	public VerticalAlignment verticalAlignment;
	int[] field1833;
	byte[] field1844;
	
	public int category;
	static {
		WorldMapElement_cachedSprites = new EvictingDualNodeHashTable(256); // L:
																			// 16
	}
	WorldMapElement(int var1) {
		this.sprite1 = -1; // L: 18
		this.sprite2 = -1; // L: 19
		this.textSize = 0; // L: 22
		this.field1830 = true; // L: 24
		this.field1837 = false; // L: 25
		this.menuActions = new String[5]; // L: 26
		this.field1841 = Integer.MAX_VALUE; // L: 29
		this.field1842 = Integer.MAX_VALUE; // L: 30
		this.field1843 = Integer.MIN_VALUE; // L: 31
		this.field1827 = Integer.MIN_VALUE; // L: 32
		this.horizontalAlignment = HorizontalAlignment.HorizontalAlignment_centered; // L:
																						// 33
		this.verticalAlignment = VerticalAlignment.VerticalAlignment_centered; // L:
																				// 34
		this.category = -1; // L: 37
		this.objectId = var1; // L: 40
	} // L: 41
	
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte(); // L: 70
			if (var2 == 0) { // L: 71
				return; // L: 74
			}
			this.decodeNext(var1, var2); // L: 72
		}
	}
	
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) { // L: 77
			this.sprite1 = var1.method7752();
		} else if (var2 == 2) { // L: 78
			this.sprite2 = var1.method7752();
		} else if (var2 == 3) { // L: 79
			this.name = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) { // L: 80
			this.field1834 = var1.readMedium();
		} else if (var2 == 5) { // L: 81
			var1.readMedium(); // L: 82
		} else if (var2 == 6) { // L: 84
			this.textSize = var1.readUnsignedByte();
		} else {
			int var3;
			if (var2 == 7) { // L: 85
				var3 = var1.readUnsignedByte(); // L: 86
				if ((var3 & 1) == 0) { // L: 87
					this.field1830 = false;
				}
				if ((var3 & 2) == 2) { // L: 88
					this.field1837 = true;
				}
			} else if (var2 == 8) { // L: 90
				var1.readUnsignedByte(); // L: 91
			} else if (var2 >= 10 && var2 <= 14) { // L: 93
				this.menuActions[var2 - 10] = var1.readStringCp1252NullTerminated();
			} else if (var2 == 15) { // L: 94
				var3 = var1.readUnsignedByte(); // L: 95
				this.field1840 = new int[var3 * 2]; // L: 96
				int var4;
				for (var4 = 0; var4 < var3 * 2; ++var4) { // L: 97
					this.field1840[var4] = var1.readShort();
				}
				var1.readInt(); // L: 98
				var4 = var1.readUnsignedByte(); // L: 99
				this.field1833 = new int[var4]; // L: 100
				int var5;
				for (var5 = 0; var5 < this.field1833.length; ++var5) { // L: 101
					this.field1833[var5] = var1.readInt();
				}
				this.field1844 = new byte[var3]; // L: 102
				for (var5 = 0; var5 < var3; ++var5) { // L: 103
					this.field1844[var5] = var1.readByte();
				}
			} else if (var2 != 16) { // L: 105
				if (var2 == 17) { // L: 106
					this.menuTargetName = var1.readStringCp1252NullTerminated();
				} else if (var2 == 18) { // L: 107
					var1.method7752(); // L: 108
				} else if (var2 == 19) { // L: 110
					this.category = var1.readUnsignedShort();
				} else if (var2 == 21) { // L: 111
					var1.readInt(); // L: 112
				} else if (var2 == 22) { // L: 114
					var1.readInt(); // L: 115
				} else if (var2 == 23) { // L: 117
					var1.readUnsignedByte(); // L: 118
					var1.readUnsignedByte(); // L: 119
					var1.readUnsignedByte(); // L: 120
				} else if (var2 == 24) { // L: 122
					var1.readShort(); // L: 123
					var1.readShort(); // L: 124
				} else if (var2 == 25) { // L: 126
					var1.method7752(); // L: 127
				} else if (var2 == 28) { // L: 129
					var1.readUnsignedByte(); // L: 130
				} else if (var2 == 29) { // L: 132
					this.horizontalAlignment = (HorizontalAlignment) Actor.findEnumerated(ModeWhere.method6076(), var1.readUnsignedByte()); // L:
																																			// 133
				} else if (var2 == 30) { // L: 135
					this.verticalAlignment = (VerticalAlignment) Actor.findEnumerated(class124.method2820(), var1.readUnsignedByte()); // L:
																																		// 136
				}
			}
		}
	} // L: 139
	
	void method3377() {
		if (this.field1840 != null) { // L: 142
			for (int var1 = 0; var1 < this.field1840.length; var1 += 2) { // L:
																			// 143
				if (this.field1840[var1] < this.field1841) { // L: 144
					this.field1841 = this.field1840[var1];
				} else if (this.field1840[var1] > this.field1843) { // L: 145
					this.field1843 = this.field1840[var1];
				}
				if (this.field1840[var1 + 1] < this.field1842) { // L: 146
					this.field1842 = this.field1840[var1 + 1];
				} else if (this.field1840[var1 + 1] > this.field1827) {
					this.field1827 = this.field1840[var1 + 1]; // L: 147
				}
			}
		}
	} // L: 150
	
	public SpritePixels getSpriteBool(boolean var1) {
		int var2 = this.sprite1; // L: 153
		return this.getSprite(var2); // L: 154
	}
	
	SpritePixels getSprite(int var1) {
		if (var1 < 0) { // L: 158
			return null;
		} else {
			SpritePixels var2 = (SpritePixels) WorldMapElement_cachedSprites.get((long) var1); // L:
																								// 159
			if (var2 != null) { // L: 160
				return var2;
			} else {
				var2 = class7.SpriteBuffer_getSprite(class121.WorldMapElement_archive, var1, 0); // L:
																									// 161
				if (var2 != null) { // L: 162
					WorldMapElement_cachedSprites.put(var2, (long) var1); // L:
																			// 163
				}
				return var2; // L: 165
			}
		}
	}
	
	public int getObjectId() {
		return this.objectId; // L: 169
	}
}
