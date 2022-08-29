package osrs;

public abstract class Actor extends Renderable {
	static byte[][] regionLandArchives;
	
	public int x;
	
	public int y;
	
	int rotation;
	boolean isWalking;
	
	int field1205;
	
	int playerCycle;
	
	int idleSequence;
	
	int turnLeftSequence;
	
	int turnRightSequence;
	
	int walkSequence;
	
	int walkBackSequence;
	
	int walkLeftSequence;
	
	int walkRightSequence;
	
	int runSequence;
	
	int field1180;
	
	int field1144;
	
	int field1145;
	
	int field1155;
	
	int field1179;
	
	int field1137;
	
	int field1149;
	String overheadText;
	boolean isAutoChatting;
	boolean field1152;
	
	int overheadTextCyclesRemaining;
	
	int overheadTextColor;
	
	int overheadTextEffect;
	byte hitSplatCount;
	int[] hitSplatTypes;
	int[] hitSplatValues;
	int[] hitSplatCycles;
	int[] hitSplatTypes2;
	int[] hitSplatValues2;
	
	IterableNodeDeque healthBars;
	
	int targetIndex;
	boolean false0;
	
	int field1165;
	boolean field1161;
	
	int movementSequence;
	
	int movementFrame;
	
	int movementFrameCycle;
	
	int sequence;
	
	int sequenceFrame;
	
	int sequenceFrameCycle;
	
	int sequenceDelay;
	
	int field1190;
	
	int spotAnimation;
	
	int spotAnimationFrame;
	
	int spotAnimationFrameCycle;
	
	int field1178;
	
	int spotAnimationHeight;
	
	int field1140;
	
	int field1181;
	
	int field1182;
	
	int field1183;
	
	int field1184;
	
	int field1194;
	
	int field1186;
	
	int npcCycle;
	
	int defaultHeight;
	
	int field1189;
	
	int field1135;
	byte field1191;
	byte field1192;
	byte field1193;
	byte field1133;
	
	int orientation;
	
	int field1196;
	
	int field1129;
	
	int pathLength;
	int[] pathX;
	int[] pathY;
	
	class192[] pathTraversed;
	
	int field1202;
	
	int field1203;
	
	int field1204;
	Actor() {
		this.isWalking = false; // L: 13
		this.field1205 = 1; // L: 14
		this.idleSequence = -1; // L: 16
		this.turnLeftSequence = -1;
		this.turnRightSequence = -1;
		this.walkSequence = -1;
		this.walkBackSequence = -1; // L: 20
		this.walkLeftSequence = -1;
		this.walkRightSequence = -1; // L: 22
		this.runSequence = -1; // L: 23
		this.field1180 = -1; // L: 24
		this.field1144 = -1;
		this.field1145 = -1; // L: 26
		this.field1155 = -1; // L: 27
		this.field1179 = -1; // L: 28
		this.field1137 = -1; // L: 29
		this.field1149 = -1; // L: 30
		this.overheadText = null; // L: 31
		this.field1152 = false; // L: 33
		this.overheadTextCyclesRemaining = 100; // L: 34
		this.overheadTextColor = 0; // L: 35
		this.overheadTextEffect = 0; // L: 36
		this.hitSplatCount = 0; // L: 38
		this.hitSplatTypes = new int[4]; // L: 39
		this.hitSplatValues = new int[4]; // L: 40
		this.hitSplatCycles = new int[4]; // L: 41
		this.hitSplatTypes2 = new int[4]; // L: 42
		this.hitSplatValues2 = new int[4]; // L: 43
		this.healthBars = new IterableNodeDeque(); // L: 44
		this.targetIndex = -1; // L: 45
		this.false0 = false; // L: 46
		this.field1165 = -1; // L: 47
		this.movementSequence = -1; // L: 49
		this.movementFrame = 0; // L: 50
		this.movementFrameCycle = 0; // L: 51
		this.sequence = -1; // L: 52
		this.sequenceFrame = 0; // L: 53
		this.sequenceFrameCycle = 0; // L: 54
		this.sequenceDelay = 0; // L: 55
		this.field1190 = 0; // L: 56
		this.spotAnimation = -1; // L: 57
		this.spotAnimationFrame = 0; // L: 58
		this.spotAnimationFrameCycle = 0; // L: 59
		this.npcCycle = 0; // L: 69
		this.defaultHeight = 200; // L: 70
		this.field1189 = -1; // L: 71
		this.field1135 = -1; // L: 72
		this.field1196 = 0; // L: 78
		this.field1129 = 32; // L: 79
		this.pathLength = 0; // L: 80
		this.pathX = new int[10]; // L: 81
		this.pathY = new int[10]; // L: 82
		this.pathTraversed = new class192[10]; // L: 83
		this.field1202 = 0; // L: 84
		this.field1203 = 0; // L: 85
		this.field1204 = -1; // L: 86
	} // L: 88
	
	boolean isVisible() {
		return false; // L: 96
	}
	
	final void method2182() {
		this.pathLength = 0; // L: 91
		this.field1203 = 0; // L: 92
	} // L: 93
	
	public final void addHitSplat(int var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true; // L: 100
		boolean var8 = true; // L: 101
		int var9;
		for (var9 = 0; var9 < 4; ++var9) { // L: 102
			if (this.hitSplatCycles[var9] > var5) { // L: 103
				var7 = false;
			} else {
				var8 = false; // L: 104
			}
		}
		var9 = -1; // L: 106
		int var10 = -1; // L: 107
		int var11 = 0; // L: 108
		if (var1 >= 0) { // L: 109
			HitSplatDefinition var12 = Static.method2800(var1); // L: 110
			var10 = var12.field2035; // L: 111
			var11 = var12.field2026; // L: 112
		}
		int var14;
		if (var8) { // L: 114
			if (var10 == -1) { // L: 115
				return;
			}
			var9 = 0; // L: 116
			var14 = 0; // L: 117
			if (var10 == 0) { // L: 118
				var14 = this.hitSplatCycles[0];
			} else if (var10 == 1) { // L: 119
				var14 = this.hitSplatValues[0];
			}
			for (int var13 = 1; var13 < 4; ++var13) { // L: 120
				if (var10 == 0) { // L: 121
					if (this.hitSplatCycles[var13] < var14) { // L: 122
						var9 = var13; // L: 123
						var14 = this.hitSplatCycles[var13]; // L: 124
					}
				} else if (var10 == 1 && this.hitSplatValues[var13] < var14) { // L:
																				// 127
																				// 128
					var9 = var13; // L: 129
					var14 = this.hitSplatValues[var13]; // L: 130
				}
			}
			if (var10 == 1 && var14 >= var2) { // L: 134
				return;
			}
		} else {
			if (var7) { // L: 137
				this.hitSplatCount = 0;
			}
			for (var14 = 0; var14 < 4; ++var14) { // L: 138
				byte var15 = this.hitSplatCount; // L: 139
				this.hitSplatCount = (byte) ((this.hitSplatCount + 1) % 4); // L:
																			// 140
				if (this.hitSplatCycles[var15] <= var5) { // L: 141
					var9 = var15; // L: 142
					break; // L: 143
				}
			}
		}
		if (var9 >= 0) { // L: 147
			this.hitSplatTypes[var9] = var1; // L: 148
			this.hitSplatValues[var9] = var2; // L: 149
			this.hitSplatTypes2[var9] = var3; // L: 150
			this.hitSplatValues2[var9] = var4; // L: 151
			this.hitSplatCycles[var9] = var5 + var11 + var6; // L: 152
		}
	} // L: 153
	
	final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
		HealthBarDefinition var7 = _Junk.method5244(var1); // L: 156
		HealthBar var8 = null; // L: 157
		HealthBar var9 = null; // L: 158
		int var10 = var7.int2; // L: 159
		int var11 = 0; // L: 160
		HealthBar var12;
		for (var12 = (HealthBar) this.healthBars.last(); var12 != null; var12 = (HealthBar) this.healthBars.previous()) { // L:
																															// 161
			++var11; // L: 162
			if (var12.definition.field1876 == var7.field1876) { // L: 163
				var12.put(var2 + var4, var5, var6, var3); // L: 164
				return; // L: 165
			}
			if (var12.definition.int1 <= var7.int1) { // L: 167
				var8 = var12;
			}
			if (var12.definition.int2 > var10) { // L: 168
				var9 = var12; // L: 169
				var10 = var12.definition.int2; // L: 170
			}
		}
		if (var9 != null || var11 < 4) { // L: 173
			var12 = new HealthBar(var7); // L: 174
			if (var8 == null) { // L: 175
				this.healthBars.addLast(var12);
			} else {
				IterableNodeDeque.IterableNodeDeque_addBefore(var12, var8); // L:
																			// 176
			}
			var12.put(var2 + var4, var5, var6, var3); // L: 177
			if (var11 >= 4) { // L: 178
				var9.remove();
			}
		}
	} // L: 179
	
	final void removeHealthBar(int var1) {
		HealthBarDefinition var2 = _Junk.method5244(var1); // L: 182
		for (HealthBar var3 = (HealthBar) this.healthBars.last(); var3 != null; var3 = (HealthBar) this.healthBars.previous()) { // L:
																																	// 183
			if (var2 == var3.definition) { // L: 184
				var3.remove(); // L: 185
				return; // L: 186
			}
		}
	} // L: 189
	
	public static MouseWheel findEnumerated(MouseWheel[] var0, int var1) {
		MouseWheel[] var2 = var0; // L: 17
		for (int var3 = 0; var3 < var2.length; ++var3) { // L: 18
			MouseWheel var4 = var2[var3]; // L: 19
			if (var1 == var4.rsOrdinal()) {
				return var4; // L: 21
			}
		}
		return null; // L: 25
	}
		
}
