package osrs;

public class SpotAnimationDefinition extends DualNode {
	
	public static AbstractArchive SpotAnimationDefinition_archive;
	
	static EvictingDualNodeHashTable SpotAnimationDefinition_cached;
	
	static EvictingDualNodeHashTable SpotAnimationDefinition_cachedModels;
	
	int id;
	
	int archive;
	
	public int sequence;
	short[] recolorFrom;
	short[] recolorTo;
	short[] retextureFrom;
	short[] retextureTo;
	
	int widthScale;
	
	int heightScale;
	
	int orientation;
	
	int ambient;
	
	int contrast;
	static {
		SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64); // L:
																			// 14
		SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30); // L:
																					// 15
	}
	SpotAnimationDefinition() {
		this.sequence = -1; // L: 18
		this.widthScale = 128; // L: 23
		this.heightScale = 128; // L: 24
		this.orientation = 0; // L: 25
		this.ambient = 0; // L: 26
		this.contrast = 0; // L: 27
	} // L: 29
	
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte(); // L: 44
			if (var2 == 0) { // L: 45
				return; // L: 48
			}
			this.decodeNext(var1, var2); // L: 46
		}
	}
	
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) { // L: 51
			this.archive = var1.readUnsignedShort();
		} else if (var2 == 2) { // L: 52
			this.sequence = var1.readUnsignedShort();
		} else if (var2 == 4) { // L: 53
			this.widthScale = var1.readUnsignedShort();
		} else if (var2 == 5) { // L: 54
			this.heightScale = var1.readUnsignedShort();
		} else if (var2 == 6) { // L: 55
			this.orientation = var1.readUnsignedShort();
		} else if (var2 == 7) { // L: 56
			this.ambient = var1.readUnsignedByte();
		} else if (var2 == 8) {
			this.contrast = var1.readUnsignedByte(); // L: 57
		} else {
			int var3;
			int var4;
			if (var2 == 40) { // L: 58
				var3 = var1.readUnsignedByte(); // L: 59
				this.recolorFrom = new short[var3]; // L: 60
				this.recolorTo = new short[var3]; // L: 61
				for (var4 = 0; var4 < var3; ++var4) { // L: 62
					this.recolorFrom[var4] = (short) var1.readUnsignedShort(); // L:
																				// 63
					this.recolorTo[var4] = (short) var1.readUnsignedShort(); // L:
																				// 64
				}
			} else if (var2 == 41) { // L: 67
				var3 = var1.readUnsignedByte(); // L: 68
				this.retextureFrom = new short[var3]; // L: 69
				this.retextureTo = new short[var3]; // L: 70
				for (var4 = 0; var4 < var3; ++var4) { // L: 71
					this.retextureFrom[var4] = (short) var1.readUnsignedShort(); // L:
																					// 72
					this.retextureTo[var4] = (short) var1.readUnsignedShort(); // L:
																				// 73
				}
			}
		}
	} // L: 77
	
	public final Model getModel(int var1) {
		Model var2 = (Model) SpotAnimationDefinition_cachedModels.get((long) this.id); // L:
																						// 80
		if (var2 == null) { // L: 81
			ModelData var3 = ModelData.ModelData_get(class147.SpotAnimationDefinition_modelArchive, this.archive, 0); // L:
			// 82
			if (var3 == null) { // L: 83
				return null;
			}
			int var4;
			if (this.recolorFrom != null) { // L: 84
				for (var4 = 0; var4 < this.recolorFrom.length; ++var4) { // L:
																			// 85
					var3.recolor(this.recolorFrom[var4], this.recolorTo[var4]); // L:
																				// 86
				}
			}
			if (this.retextureFrom != null) { // L: 89
				for (var4 = 0; var4 < this.retextureFrom.length; ++var4) { // L:
																			// 90
					var3.retexture(this.retextureFrom[var4], this.retextureTo[var4]); // L:
																						// 91
				}
			}
			var2 = var3.toModel(this.ambient + 64, this.contrast + 850, -30, -50, -30); // L:
																						// 94
			SpotAnimationDefinition_cachedModels.put(var2, (long) this.id); // L:
																			// 95
		}
		Model var5;
		if (this.sequence != -1 && var1 != -1) { // L: 98
			var5 = Anim_SequenceDefinition.SequenceDefinition_get(this.sequence).transformSpotAnimationModel(var2, var1);
		} else {
			var5 = var2.toSharedSpotAnimationModel(true); // L: 99
		}
		if (this.widthScale != 128 || this.heightScale != 128) { // L: 100
			var5.scale(this.widthScale, this.heightScale, this.widthScale);
		}
		if (this.orientation != 0) { // L: 101
			if (this.orientation == 90) { // L: 102
				var5.rotateY90Ccw();
			}
			if (this.orientation == 180) { // L: 103
				var5.rotateY90Ccw(); // L: 104
				var5.rotateY90Ccw(); // L: 105
			}
			if (this.orientation == 270) { // L: 107
				var5.rotateY90Ccw(); // L: 108
				var5.rotateY90Ccw(); // L: 109
				var5.rotateY90Ccw(); // L: 110
			}
		}
		return var5; // L: 113
	}
}
