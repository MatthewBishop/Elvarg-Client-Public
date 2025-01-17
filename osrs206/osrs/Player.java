package osrs;

public final class Player extends Actor {
	
	public static FriendSystem friendSystem;
	
	static int menuHeight;
	
	Username username;
	
	PlayerComposition appearance;
	
	int headIconPk;
	
	int headIconPrayer;
	String[] actions;
	
	int combatLevel;
	
	int skillLevel;
	
	int tileHeight;
	
	int animationCycleStart;
	
	int animationCycleEnd;
	
	int field1095;
	
	int tileHeight2;
	
	int field1108;
	
	Model model0;
	
	int minX;
	
	int minY;
	
	int maxX;
	
	int maxY;
	boolean isUnanimated;
	
	int team;
	boolean isHidden;
	
	int plane;
	
	int index;
	
	TriBool isFriendTriBool;
	
	TriBool isInFriendsChat;
	
	TriBool isInClanChat;
	boolean field1088;
	
	int tileX;
	
	int tileY;
	Player() {
		this.headIconPk = -1; // L: 20
		this.headIconPrayer = -1; // L: 21
		this.actions = new String[3]; // L: 23
		for (int var1 = 0; var1 < 3; ++var1) { // L: 26
			this.actions[var1] = "";
		}
		this.combatLevel = 0; // L: 29
		this.skillLevel = 0; // L: 30
		this.animationCycleStart = 0; // L: 32
		this.animationCycleEnd = 0; // L: 33
		this.isUnanimated = false; // L: 42
		this.team = 0; // L: 43
		this.isHidden = false; // L: 44
		this.isFriendTriBool = TriBool.TriBool_unknown; // L: 47
		this.isInFriendsChat = TriBool.TriBool_unknown; // L: 48
		this.isInClanChat = TriBool.TriBool_unknown; // L: 49
		this.field1088 = false; // L: 50
	} // L: 54
	
	final void read(Buffer var1) {
		var1.offset = 0; // L: 57
		int var2 = var1.readUnsignedByte(); // L: 58
		this.headIconPk = var1.readByte(); // L: 59
		this.headIconPrayer = var1.readByte(); // L: 60
		int var3 = -1; // L: 61
		this.team = 0; // L: 62
		int[] var4 = new int[12]; // L: 63
		int var6;
		int var7;
		int var8;
		for (int var5 = 0; var5 < 12; ++var5) { // L: 64
			var6 = var1.readUnsignedByte(); // L: 65
			if (var6 == 0) { // L: 66
				var4[var5] = 0; // L: 67
			} else {
				var7 = var1.readUnsignedByte(); // L: 70
				var4[var5] = var7 + (var6 << 8); // L: 71
				if (var5 == 0 && var4[0] == 65535) { // L: 72
					var3 = var1.readUnsignedShort(); // L: 73
					break;
				}
				if (var4[var5] >= 512) { // L: 76
					var8 = EnumComposition.ItemDefinition_get(var4[var5] - 512).team; // L:
																						// 77
					if (var8 != 0) { // L: 78
						this.team = var8;
					}
				}
			}
		}
		int[] var11 = new int[5]; // L: 81
		for (var6 = 0; var6 < 5; ++var6) { // L: 82
			var7 = var1.readUnsignedByte(); // L: 83
			if (var7 < 0 || var7 >= PlayerComposition.field3342[var6].length) { // L:
																				// 84
				var7 = 0;
			}
			var11[var6] = var7; // L: 85
		}
		super.idleSequence = var1.readUnsignedShort(); // L: 87
		if (super.idleSequence == 65535) { // L: 88
			super.idleSequence = -1;
		}
		super.turnLeftSequence = var1.readUnsignedShort(); // L: 89
		if (super.turnLeftSequence == 65535) { // L: 90
			super.turnLeftSequence = -1;
		}
		super.turnRightSequence = super.turnLeftSequence; // L: 91
		super.walkSequence = var1.readUnsignedShort(); // L: 92
		if (super.walkSequence == 65535) { // L: 93
			super.walkSequence = -1;
		}
		super.walkBackSequence = var1.readUnsignedShort(); // L: 94
		if (super.walkBackSequence == 65535) { // L: 95
			super.walkBackSequence = -1;
		}
		super.walkLeftSequence = var1.readUnsignedShort(); // L: 96
		if (super.walkLeftSequence == 65535) { // L: 97
			super.walkLeftSequence = -1;
		}
		super.walkRightSequence = var1.readUnsignedShort(); // L: 98
		if (super.walkRightSequence == 65535) { // L: 99
			super.walkRightSequence = -1;
		}
		super.runSequence = var1.readUnsignedShort(); // L: 100
		if (super.runSequence == 65535) { // L: 101
			super.runSequence = -1;
		}
		this.username = new Username(var1.readStringCp1252NullTerminated(), HealthBarDefinition.loginType); // L:
																											// 102
		this.clearIsFriend(); // L: 103
		this.clearIsInFriendsChat(); // L: 104
		this.method2135(); // L: 105
		if (this == class101.localPlayer) { // L: 106
			RunException.localPlayerName = this.username.getName();
		}
		this.combatLevel = var1.readUnsignedByte(); // L: 107
		this.skillLevel = var1.readUnsignedShort(); // L: 108
		this.isHidden = var1.readUnsignedByte() == 1; // L: 109
		if (Client.gameBuild == 0 && Client.staffModLevel >= 2) { // L: 110
			this.isHidden = false;
		}
		class167[] var12 = null; // L: 111
		boolean var13 = false; // L: 112
		var8 = var1.readUnsignedShort(); // L: 113
		var13 = (var8 >> 15 & 1) == 1; // L: 114
		int var9;
		if (var8 > 0 && var8 != 32768) { // L: 115
			var12 = new class167[12]; // L: 116
			for (var9 = 0; var9 < 12; ++var9) { // L: 117
				int var10 = var8 >> 12 - var9 & 1; // L: 118
				if (var10 == 1) { // L: 119
					var12[var9] = UserComparator10.method2609(var4[var9] - 512, var1); // L:
																						// 120
				}
			}
		}
		if (var1.offset < var1.array.length) { // L: 124
			for (var9 = 0; var9 < 3; ++var9) { // L: 125
				this.actions[var9] = var1.readStringCp1252NullTerminated(); // L:
																			// 126
			}
		}
		if (this.appearance == null) { // L: 129
			this.appearance = new PlayerComposition();
		}
		this.appearance.method5566(var4, var12, var13, var11, var2 == 1, var3); // L:
																				// 130
	} // L: 131
	
	protected final Model getModel() {
		if (this.appearance == null) { // L: 194
			return null;
		} else {
			Anim_SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? Anim_SequenceDefinition.SequenceDefinition_get(super.sequence) : null; // L:
																																					// 195
			Anim_SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.idleSequence == super.movementSequence && var1 != null ? null : Anim_SequenceDefinition.SequenceDefinition_get(super.movementSequence); // L:
																																																								// 196
			Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame); // L:
																											// 197
			if (var3 == null) { // L: 198
				return null;
			} else {
				var3.calculateBoundsCylinder(); // L: 199
				super.defaultHeight = var3.height; // L: 200
				Model var4;
				Model[] var5;
				if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) { // L:
																											// 201
					var4 = _Junk.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame); // L:
																															// 202
					if (var4 != null) { // L: 203
						var4.offsetBy(0, -super.spotAnimationHeight, 0); // L:
																			// 204
						var5 = new Model[]{var3, var4}; // L: 205
						var3 = new Model(var5, 2); // L: 206
					}
				}
				if (!this.isUnanimated && this.model0 != null) { // L: 209
					if (Client.cycle >= this.animationCycleEnd) { // L: 210
						this.model0 = null;
					}
					if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) { // L:
																												// 211
						var4 = this.model0; // L: 212
						var4.offsetBy(this.field1095 - super.x, this.tileHeight2 - this.tileHeight, this.field1108 - super.y); // L:
																																// 213
						if (super.orientation == 512) { // L: 214
							var4.rotateY90Ccw(); // L: 215
							var4.rotateY90Ccw(); // L: 216
							var4.rotateY90Ccw(); // L: 217
						} else if (super.orientation == 1024) { // L: 219
							var4.rotateY90Ccw(); // L: 220
							var4.rotateY90Ccw(); // L: 221
						} else if (super.orientation == 1536) { // L: 223
							var4.rotateY90Ccw();
						}
						var5 = new Model[]{var3, var4}; // L: 224
						var3 = new Model(var5, 2); // L: 225
						if (super.orientation == 512) { // L: 226
							var4.rotateY90Ccw();
						} else if (super.orientation == 1024) { // L: 227
							var4.rotateY90Ccw(); // L: 228
							var4.rotateY90Ccw(); // L: 229
						} else if (super.orientation == 1536) { // L: 231
							var4.rotateY90Ccw(); // L: 232
							var4.rotateY90Ccw(); // L: 233
							var4.rotateY90Ccw(); // L: 234
						}
						var4.offsetBy(super.x - this.field1095, this.tileHeight - this.tileHeight2, super.y - this.field1108); // L:
																																// 236
					}
				}
				var3.isSingleTile = true; // L: 239
				if (super.field1133 != 0 && Client.cycle >= super.field1189 && Client.cycle < super.field1135) { // L:
					// 240
					var3.overrideHue = super.field1191; // L: 241
					var3.overrideSaturation = super.field1192; // L: 242
					var3.overrideLuminance = super.field1193; // L: 243
					var3.overrideAmount = super.field1133; // L: 244
				} else {
					var3.overrideAmount = 0; // L: 247
				}
				return var3; // L: 249
			}
		}
	}
	
	boolean isFriend() {
		if (this.isFriendTriBool == TriBool.TriBool_unknown) { // L: 134
			this.checkIsFriend(); // L: 135
		}
		return this.isFriendTriBool == TriBool.TriBool_true; // L: 137
	}
	
	void clearIsFriend() {
		this.isFriendTriBool = TriBool.TriBool_unknown; // L: 141
	} // L: 142
	
	void checkIsFriend() {
		this.isFriendTriBool = friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false; // L:
																																// 145
	} // L: 146
	
	boolean isFriendsChatMember() {
		if (this.isInFriendsChat == TriBool.TriBool_unknown) { // L: 149
			this.updateIsInFriendsChat(); // L: 150
		}
		return this.isInFriendsChat == TriBool.TriBool_true; // L: 152
	}
	
	void clearIsInFriendsChat() {
		this.isInFriendsChat = TriBool.TriBool_unknown; // L: 156
	} // L: 157
	
	void updateIsInFriendsChat() {
		this.isInFriendsChat = Huffman.friendsChat != null && Huffman.friendsChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false; // L:
																																							// 160
	} // L: 161
	
	void updateIsInClanChat() {
		for (int var1 = 0; var1 < 4; ++var1) { // L: 164
			if (Client.currentClanSettings[var1] != null && Client.currentClanSettings[var1].method2991(this.username.getName()) != -1 && var1 != 2) { // L:
				// 165
				// 166
				this.isInClanChat = TriBool.TriBool_true; // L: 167
				return; // L: 168
			}
		}
		this.isInClanChat = TriBool.TriBool_false; // L: 172
	} // L: 173
	
	void method2135() {
		this.isInClanChat = TriBool.TriBool_unknown; // L: 176
	} // L: 177
	
	boolean isClanMember() {
		if (this.isInClanChat == TriBool.TriBool_unknown) { // L: 180
			this.updateIsInClanChat(); // L: 181
		}
		return this.isInClanChat == TriBool.TriBool_true; // L: 183
	}
	
	int transformedSize() {
		return this.appearance != null && this.appearance.npcTransformId != -1 ? BuddyRankComparator.getNpcDefinition(this.appearance.npcTransformId).size : 1; // L:
																																								// 187
																																								// 188
																																								// 190
	}
	
	final void method2139(int var1, int var2, class192 var3) {
		if (super.sequence != -1 && Anim_SequenceDefinition.SequenceDefinition_get(super.sequence).field2188 == 1) { // L:
																											// 253
			super.sequence = -1;
		}
		super.field1165 = -1; // L: 254
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) { // L: 255
			if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) { // L:
																												// 256
				if (var3 == class192.field2211) {
					class306.method5765(this, var1, var2, class192.field2211); // L:
																				// 258
				}
				this.method2141(var1, var2, var3); // L: 259
			} else {
				this.resetPath(var1, var2);
			}
		} else {
			this.resetPath(var1, var2);
		}
	} // L: 261
	
	void resetPath(int var1, int var2) {
		super.pathLength = 0; // L: 264
		super.field1203 = 0; // L: 265
		super.field1202 = 0; // L: 266
		super.pathX[0] = var1; // L: 267
		super.pathY[0] = var2; // L: 268
		int var3 = this.transformedSize(); // L: 269
		super.x = var3 * 64 + super.pathX[0] * 128; // L: 270
		super.y = var3 * 64 + super.pathY[0] * 128; // L: 271
	} // L: 272
	
	final void method2141(int var1, int var2, class192 var3) {
		if (super.pathLength < 9) { // L: 275
			++super.pathLength;
		}
		for (int var4 = super.pathLength; var4 > 0; --var4) { // L: 276
			super.pathX[var4] = super.pathX[var4 - 1]; // L: 277
			super.pathY[var4] = super.pathY[var4 - 1]; // L: 278
			super.pathTraversed[var4] = super.pathTraversed[var4 - 1]; // L: 279
		}
		super.pathX[0] = var1; // L: 281
		super.pathY[0] = var2; // L: 282
		super.pathTraversed[0] = var3; // L: 283
	} // L: 284
	
	final boolean isVisible() {
		return this.appearance != null; // L: 287
	}
}
