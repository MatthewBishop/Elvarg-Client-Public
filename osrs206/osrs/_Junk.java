package osrs;

import java.util.Iterator;

import audioengine.StaticSound;
import net.runelite.rs.ScriptOpcodes;

public class _Junk {

	public static final void method743() {
		if (Projectile.ClanChat_inClanChat) { // L: 3785
			if (Huffman.friendsChat != null) { // L: 3786
				Huffman.friendsChat.sort(); // L: 3787
			}
			class161.method3287(); // L: 3789
			Projectile.ClanChat_inClanChat = false; // L: 3790
		}
	} // L: 3792

	public static void method736() {
		Client.packetWriter.clearBuffer(); // L: 2758
		Client.packetWriter.packetBuffer.offset = 0; // L: 2759
		Client.packetWriter.serverPacket = null; // L: 2760
		Client.packetWriter.field1350 = null; // L: 2761
		Client.packetWriter.field1347 = null; // L: 2762
		Client.packetWriter.field1352 = null; // L: 2763
		Client.packetWriter.serverPacketLength = 0; // L: 2764
		Client.packetWriter.field1342 = 0; // L: 2765
		Client.rebootTimer = 0; // L: 2766
		class125.method2824(); // L: 2767
		Client.minimapState = 0; // L: 2768
		Client.destinationX = 0; // L: 2769
		int var0;
		for (var0 = 0; var0 < 2048; ++var0) { // L: 2770
			Client.players[var0] = null;
		}
		class101.localPlayer = null; // L: 2771
		for (var0 = 0; var0 < Client.npcs.length; ++var0) { // L: 2772
			NPC var1 = Client.npcs[var0]; // L: 2773
			if (var1 != null) { // L: 2774
				var1.targetIndex = -1; // L: 2775
				var1.false0 = false; // L: 2776
			}
		}
		class125.method2830(); // L: 2779
		HealthBarUpdate.updateGameState(30); // L: 2780
		for (var0 = 0; var0 < 100; ++var0) { // L: 2781
			Client.field703[var0] = true;
		}
		SpriteMask.method5522(); // L: 2782
	} // L: 2783

	public static final byte[] decompressBytes(byte[] var0) {
		Buffer var1 = new Buffer(var0); // L: 382
		int var2 = var1.readUnsignedByte(); // L: 383
		int var3 = var1.readInt(); // L: 384
		if (var3 < 0 || AbstractArchive.field4012 != 0 && var3 > AbstractArchive.field4012) { // L:
																								// 385
			throw new RuntimeException(); // L: 386
		} else if (var2 == 0) { // L: 388
			byte[] var6 = new byte[var3]; // L: 389
			var1.readBytes(var6, 0, var3); // L: 390
			return var6; // L: 391
		} else {
			int var4 = var1.readInt(); // L: 394
			if (var4 >= 0 && (AbstractArchive.field4012 == 0 || var4 <= AbstractArchive.field4012)) { // L:
																										// 395
				byte[] var5 = new byte[var4]; // L: 398
				if (var2 == 1) { // L: 399
					BZip2Decompressor.BZip2Decompressor_decompress(var5, var4, var0, var3, 9);
				} else {
					AbstractArchive.gzipDecompressor.decompress(var1, var5); // L:
																				// 400
				}
				return var5; // L: 401
			} else {
				throw new RuntimeException(); // L: 396
			}
		}
	}

	public static final int method740(int var0, int var1) {
		int var2 = WorldMapIcon_1.method4594(var0 - 1, var1 - 1) + WorldMapIcon_1.method4594(1 + var0, var1 - 1) + WorldMapIcon_1.method4594(var0 - 1, var1 + 1) + WorldMapIcon_1.method4594(var0 + 1, 1 + var1); // L:
		// 905
		int var3 = WorldMapIcon_1.method4594(var0 - 1, var1) + WorldMapIcon_1.method4594(1 + var0, var1) + WorldMapIcon_1.method4594(var0, var1 - 1) + WorldMapIcon_1.method4594(var0, 1 + var1); // L:
																																																	// 906
		int var4 = WorldMapIcon_1.method4594(var0, var1); // L: 907
		return var2 / 16 + var3 / 8 + var4 / 4; // L: 908
	}

	public static void method739(AbstractArchive var0, int var1) {
		if ((var1 & 536870912) != 0) { // L: 286
			Login.logoSprite = class421.SpriteBuffer_getIndexedSpriteByName(var0, "logo_deadman_mode", ""); // L:
																											// 287
		} else if ((var1 & 1073741824) != 0) { // L: 289
			Login.logoSprite = class421.SpriteBuffer_getIndexedSpriteByName(var0, "logo_seasonal_mode", ""); // L:
																												// 290
		} else {
			Login.logoSprite = class421.SpriteBuffer_getIndexedSpriteByName(var0, "logo", ""); // L:
																								// 293
		}
	} // L: 295

	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.PlayerType_playerModerator, PlayerType.PlayerType_ironman, PlayerType.field3959, PlayerType.PlayerType_jagexModerator, PlayerType.field3949, PlayerType.PlayerType_ultimateIronman, PlayerType.field3952, PlayerType.PlayerType_hardcoreIronman, PlayerType.field3958, PlayerType.field3951, PlayerType.field3954, PlayerType.field3957, PlayerType.field3956, PlayerType.PlayerType_normal, PlayerType.field3960, PlayerType.field3945}; // L:
		// 29
	}

	public static Widget field313;
	public static Iterator field312;
	public static final void method765(PacketBuffer var0) {
		for (int var1 = 0; var1 < Client.field538; ++var1) { // L: 8067
			int var2 = Client.field539[var1]; // L: 8068
			NPC var3 = Client.npcs[var2]; // L: 8069
			int var4 = var0.readUnsignedByte(); // L: 8070
			int var5;
			if (class101.field1366 && (var4 & 64) != 0) { // L: 8071
				var5 = var0.readUnsignedByte(); // L: 8072
				var4 += var5 << 8; // L: 8073
			}
			if ((var4 & 1024) != 0) { // L: 8075
				var3.field1189 = Client.cycle + var0.method7775(); // L: 8076
				var3.field1135 = Client.cycle + var0.method7774(); // L: 8077
				var3.field1191 = var0.readByte(); // L: 8078
				var3.field1192 = var0.method7769(); // L: 8079
				var3.field1193 = var0.method7952(); // L: 8080
				var3.field1133 = (byte) var0.method7767(); // L: 8081
			}
			int var6;
			int var7;
			if ((var4 & 16) != 0) { // L: 8083
				var5 = var0.method7774(); // L: 8084
				if (var5 == 65535) { // L: 8085
					var5 = -1; // L: 8086
				}
				var6 = var0.method7766(); // L: 8088
				if (var5 == var3.sequence && var5 != -1) { // L: 8089
					var7 = Anim_SequenceDefinition.SequenceDefinition_get(var5).field2174; // L:
																				// 8090
					if (var7 == 1) { // L: 8091
						var3.sequenceFrame = 0; // L: 8092
						var3.sequenceFrameCycle = 0; // L: 8093
						var3.sequenceDelay = var6; // L: 8094
						var3.field1190 = 0; // L: 8095
					}
					if (var7 == 2) { // L: 8097
						var3.field1190 = 0; // L: 8098
					}
				} else if (var5 == -1 || var3.sequence == -1 || Anim_SequenceDefinition.SequenceDefinition_get(var5).field2183 >= Anim_SequenceDefinition.SequenceDefinition_get(var3.sequence).field2183) { // L:
																																														// 8101
					var3.sequence = var5; // L: 8102
					var3.sequenceFrame = 0; // L: 8103
					var3.sequenceFrameCycle = 0; // L: 8104
					var3.sequenceDelay = var6; // L: 8105
					var3.field1190 = 0; // L: 8106
					var3.field1203 = var3.pathLength; // L: 8107
				}
			}
			if ((var4 & 2) != 0) { // L: 8111
				var3.spotAnimation = var0.method7775(); // L: 8112
				var5 = var0.method7785(); // L: 8113
				var3.spotAnimationHeight = var5 >> 16; // L: 8114
				var3.field1178 = (var5 & 65535) + Client.cycle; // L: 8115
				var3.spotAnimationFrame = 0; // L: 8116
				var3.spotAnimationFrameCycle = 0; // L: 8117
				if (var3.field1178 > Client.cycle) { // L: 8118
					var3.spotAnimationFrame = -1;
				}
				if (var3.spotAnimation == 65535) { // L: 8119
					var3.spotAnimation = -1;
				}
			}
			int var8;
			if ((var4 & 32) != 0) { // L: 8121
				var5 = var0.readUnsignedByte(); // L: 8122
				int var9;
				int var10;
				int var11;
				if (var5 > 0) { // L: 8123
					for (var6 = 0; var6 < var5; ++var6) { // L: 8124
						var8 = -1; // L: 8126
						var9 = -1; // L: 8127
						var10 = -1; // L: 8128
						var7 = var0.readUShortSmart(); // L: 8129
						if (var7 == 32767) { // L: 8130
							var7 = var0.readUShortSmart(); // L: 8131
							var9 = var0.readUShortSmart(); // L: 8132
							var8 = var0.readUShortSmart(); // L: 8133
							var10 = var0.readUShortSmart(); // L: 8134
						} else if (var7 != 32766) { // L: 8136
							var9 = var0.readUShortSmart(); // L: 8137
						} else {
							var7 = -1; // L: 8139
						}
						var11 = var0.readUShortSmart(); // L: 8140
						var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11); // L:
																						// 8141
					}
				}
				var6 = var0.readUnsignedByte(); // L: 8144
				if (var6 > 0) { // L: 8145
					for (var7 = 0; var7 < var6; ++var7) { // L: 8146
						var8 = var0.readUShortSmart(); // L: 8147
						var9 = var0.readUShortSmart(); // L: 8148
						if (var9 != 32767) { // L: 8149
							var10 = var0.readUShortSmart(); // L: 8150
							var11 = var0.method7767(); // L: 8151
							int var12 = var9 > 0 ? var0.method7767() : var11; // L:
																				// 8152
							var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12); // L:
																								// 8153
						} else {
							var3.removeHealthBar(var8); // L: 8155
						}
					}
				}
			}
			if ((var4 & 512) != 0) { // L: 8159
				var3.method2373(var0.readStringCp1252NullTerminated()); // L:
																		// 8160
			}
			if ((var4 & 2048) != 0) { // L: 8162
				var3.field1204 = var0.method7787(); // L: 8163
			}
			if ((var4 & 8) != 0) { // L: 8165
				var3.definition = BuddyRankComparator.getNpcDefinition(var0.method7776()); // L:
																							// 8166
				var3.field1205 = var3.definition.size; // L: 8167
				var3.field1129 = var3.definition.rotation; // L: 8168
				var3.walkSequence = var3.definition.walkSequence; // L: 8169
				var3.walkBackSequence = var3.definition.walkBackSequence; // L:
																			// 8170
				var3.walkLeftSequence = var3.definition.walkLeftSequence; // L:
																			// 8171
				var3.walkRightSequence = var3.definition.walkRightSequence; // L:
																			// 8172
				var3.idleSequence = var3.definition.idleSequence; // L: 8173
				var3.turnLeftSequence = var3.definition.turnLeftSequence; // L:
																			// 8174
				var3.turnRightSequence = var3.definition.turnRightSequence; // L:
																			// 8175
			}
			if ((var4 & 128) != 0) { // L: 8177
				var3.targetIndex = var0.method7776(); // L: 8178
				if (var3.targetIndex == 65535) { // L: 8179
					var3.targetIndex = -1;
				}
			}
			if (class101.field1366 && (var4 & 256) != 0 || !class101.field1366 && (var4 & 64) != 0) { // L:
																										// 8181
				var3.field1140 = var0.method7952(); // L: 8182
				var3.field1182 = var0.method7769(); // L: 8183
				var3.field1181 = var0.method7768(); // L: 8184
				var3.field1183 = var0.method7768(); // L: 8185
				var3.field1184 = var0.method7776() + Client.cycle; // L: 8186
				var3.field1194 = var0.method7775() + Client.cycle; // L: 8187
				var3.field1186 = var0.method7776(); // L: 8188
				var3.pathLength = 1; // L: 8189
				var3.field1203 = 0; // L: 8190
				var3.field1140 += var3.pathX[0]; // L: 8191
				var3.field1182 += var3.pathY[0]; // L: 8192
				var3.field1181 += var3.pathX[0]; // L: 8193
				var3.field1183 += var3.pathY[0]; // L: 8194
			}
			if ((var4 & 1) != 0) { // L: 8196
				var5 = var0.method7776(); // L: 8197
				var6 = var0.method7775(); // L: 8198
				if (class101.field1366) { // L: 8199
					var3.field1161 = var0.method7766() == 1; // L: 8200
				}
				var7 = var3.x - (var5 - class28.baseX - class28.baseX) * 64; // L:
																				// 8202
				var8 = var3.y - (var6 - WorldMapLabelSize.baseY - WorldMapLabelSize.baseY) * 64; // L:
																									// 8203
				if (var7 != 0 || var8 != 0) { // L: 8204
					var3.field1165 = (int) (Math.atan2((double) var7, (double) var8) * 325.949D) & 2047;
				}
			}
			if ((var4 & 4) != 0) { // L: 8206
				var3.overheadText = var0.readStringCp1252NullTerminated(); // L:
																			// 8207
				var3.overheadTextCyclesRemaining = 100; // L: 8208
			}
		}
	} // L: 8211

	public static void method766() {
		class426.SpriteBuffer_xOffsets = null; // L: 234
		class142.SpriteBuffer_yOffsets = null; // L: 235
		class359.SpriteBuffer_spriteWidths = null; // L: 236
		class456.SpriteBuffer_spriteHeights = null; // L: 237
		class13.SpriteBuffer_spritePalette = null; // L: 238
		class421.SpriteBuffer_pixels = null; // L: 239
	} // L: 240

	public static void method763() {
		WorldMapElement.WorldMapElement_cachedSprites.clear(); // L: 173
	} // L: 174

	public static boolean method764(int var0) {
		return var0 >= 0 && var0 < 112 ? KeyHandler.KeyHandler_pressedKeys[var0] : false; // L:
																							// 247
																							// 248
	}

	public static boolean method753(int var0) {
		return var0 >= 0 && var0 < 112 ? KeyHandler.field141[var0] : false; // L:
																			// 252
																			// 253
	}

	public static int cameraYaw;
	public static Widget[][] Widget_interfaceComponents;
	public static int method720(Buffer var0, String var1) {
		int var2 = var0.offset; // L: 14
		int var4 = var1.length(); // L: 17
		byte[] var5 = new byte[var4]; // L: 18
		for (int var6 = 0; var6 < var4; ++var6) { // L: 19
			char var7 = var1.charAt(var6); // L: 20
			if (var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) { // L: 21
				var5[var6] = (byte) var7;
			} else if (var7 == 8364) { // L: 22
				var5[var6] = -128;
			} else if (var7 == 8218) { // L: 23
				var5[var6] = -126;
			} else if (var7 == 402) { // L: 24
				var5[var6] = -125;
			} else if (var7 == 8222) { // L: 25
				var5[var6] = -124;
			} else if (var7 == 8230) { // L: 26
				var5[var6] = -123;
			} else if (var7 == 8224) { // L: 27
				var5[var6] = -122;
			} else if (var7 == 8225) { // L: 28
				var5[var6] = -121;
			} else if (var7 == 710) { // L: 29
				var5[var6] = -120;
			} else if (var7 == 8240) { // L: 30
				var5[var6] = -119;
			} else if (var7 == 352) { // L: 31
				var5[var6] = -118;
			} else if (var7 == 8249) { // L: 32
				var5[var6] = -117;
			} else if (var7 == 338) { // L: 33
				var5[var6] = -116;
			} else if (var7 == 381) { // L: 34
				var5[var6] = -114;
			} else if (var7 == 8216) { // L: 35
				var5[var6] = -111;
			} else if (var7 == 8217) { // L: 36
				var5[var6] = -110;
			} else if (var7 == 8220) { // L: 37
				var5[var6] = -109;
			} else if (var7 == 8221) { // L: 38
				var5[var6] = -108;
			} else if (var7 == 8226) { // L: 39
				var5[var6] = -107;
			} else if (var7 == 8211) { // L: 40
				var5[var6] = -106;
			} else if (var7 == 8212) { // L: 41
				var5[var6] = -105;
			} else if (var7 == 732) { // L: 42
				var5[var6] = -104;
			} else if (var7 == 8482) { // L: 43
				var5[var6] = -103;
			} else if (var7 == 353) { // L: 44
				var5[var6] = -102;
			} else if (var7 == 8250) { // L: 45
				var5[var6] = -101;
			} else if (var7 == 339) { // L: 46
				var5[var6] = -100;
			} else if (var7 == 382) { // L: 47
				var5[var6] = -98;
			} else if (var7 == 376) { // L: 48
				var5[var6] = -97;
			} else {
				var5[var6] = 63; // L: 49
			}
		}
		var0.writeSmartByteShort(var5.length); // L: 54
		var0.offset += class281.huffman.compress(var5, 0, var5.length, var0.array, var0.offset); // L:
																									// 55
		return var0.offset - var2; // L: 56
	}

	public static AbstractArchive Widget_archive;
	public static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group; // L: 12012
		int var3 = (int) var0.key; // L: 12013
		var0.remove(); // L: 12014
		if (var1 && var2 != -1 && class228.Widget_loadedInterfaces[var2]) { // L:
																			// 12015
																			// 12016
																			// 12017
			Widget_archive.clearFilesGroup(var2); // L: 12018
			if (Widget_interfaceComponents[var2] != null) { // L:
																		// 12019
				boolean var4 = true; // L: 12020
				for (int var5 = 0; var5 < Widget_interfaceComponents[var2].length; ++var5) { // L:
																										// 12021
					if (Widget_interfaceComponents[var2][var5] != null) { // L:
																						// 12022
						if (Widget_interfaceComponents[var2][var5].type != 2) { // L:
																							// 12023
							Widget_interfaceComponents[var2][var5] = null;
						} else {
							var4 = false; // L: 12024
						}
					}
				}
				if (var4) { // L: 12027
					Widget_interfaceComponents[var2] = null;
				}
				class228.Widget_loadedInterfaces[var2] = false; // L: 12028
			}
		}
		for (IntegerNode var6 = (IntegerNode) Client.widgetFlags.first(); var6 != null; var6 = (IntegerNode) Client.widgetFlags.next()) { // L:
																																			// 12031
			if ((long) var2 == (var6.key >> 48 & 65535L)) { // L: 12032
				var6.remove(); // L: 12033
			}
		}
		Widget var7 = class140.getWidget(var3); // L: 12037
		if (var7 != null) { // L: 12038
			ChatChannel.invalidateWidget(var7);
		}
		if (Client.rootInterface != -1) { // L: 12039
			class7.runIntfCloseListeners(Client.rootInterface, 1);
		}
	} // L: 12040

	public static int method5445(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
		int var6 = class133.compareWorlds(var0, var1, var2, var3); // L: 199
		if (var6 != 0) { // L: 200
			return var3 ? -var6 : var6; // L: 201
		} else if (var4 == -1) { // L: 204
			return 0;
		} else {
			int var7 = class133.compareWorlds(var0, var1, var4, var5); // L: 205
			return var5 ? -var7 : var7; // L: 206
		}
	}

	public static boolean method5243(char var0) {
		if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) { // L: 45
			if (var0 != 0) { // L: 46
				char[] var1 = class340.cp1252AsciiExtension; // L: 48
				for (int var2 = 0; var2 < var1.length; ++var2) { // L: 49
					char var3 = var1[var2]; // L: 50
					if (var0 == var3) { // L: 52
						return true;
					}
				}
			}
			return false; // L: 57
		} else {
			return true;
		}
	}

	public static HealthBarDefinition method5244(int var0) {
		HealthBarDefinition var1 = (HealthBarDefinition) HealthBarDefinition.HealthBarDefinition_cached.get((long) var0); // L:
																															// 32
		if (var1 != null) { // L: 33
			return var1;
		} else {
			byte[] var2 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var0); // L:
																								// 34
			var1 = new HealthBarDefinition(); // L: 35
			if (var2 != null) { // L: 36
				var1.decode(new Buffer(var2));
			}
			HealthBarDefinition.HealthBarDefinition_cached.put(var1, (long) var0); // L:
																					// 37
			return var1; // L: 38
		}
	}

	public static int[] Tiles_hue;
	public static PacketBufferNode method5473() {
		PacketBufferNode var0;
		if (PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) { // L:
																			// 47
			var0 = new PacketBufferNode(); // L: 48
		} else {
			var0 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount]; // L:
			// 51
		}
		var0.clientPacket = null; // L: 54
		var0.clientPacketLength = 0; // L: 55
		var0.packetBuffer = new PacketBuffer(5000); // L: 56
		return var0; // L: 57
	}

	public static class432 method5472(int var0) {
		int var1 = class430.field4652[var0]; // L: 19
		if (var1 == 1) { // L: 20
			return class432.field4658; // L: 21
		} else if (var1 == 2) { // L: 23
			return class432.field4657; // L: 24
		} else {
			return var1 == 3 ? class432.field4656 : null; // L: 26 27 29
		}
	}

	public static int[] regionMapArchiveIds;
	public static Bounds field294;
	public static byte[] method5432(byte[] var0) {
		int var1 = var0.length; // L: 35
		byte[] var2 = new byte[var1]; // L: 36
		System.arraycopy(var0, 0, var2, 0, var1); // L: 37
		return var2; // L: 38
	}

	public static GameBuild[] method5433() {
		return new GameBuild[]{GameBuild.WIP, GameBuild.RC, GameBuild.BUILDLIVE, GameBuild.LIVE}; // L:
																									// 13
	}

	public static int field3231;
	public static void findItemDefinitions(String var0, boolean var1) {
		var0 = var0.toLowerCase(); // L: 12361
		short[] var2 = new short[16]; // L: 12362
		int var3 = 0; // L: 12363
		for (int var4 = 0; var4 < PacketBufferNode.ItemDefinition_fileCount; ++var4) { // L:
																						// 12364
			ItemComposition var9 = EnumComposition.ItemDefinition_get(var4); // L:
																				// 12365
			if ((!var1 || var9.isTradable) && var9.noteTemplate == -1 && var9.name.toLowerCase().indexOf(var0) != -1) { // L:
				// 12366
				// 12367
				// 12368
				if (var3 >= 250) { // L: 12369
					HealthBarUpdate.foundItemIdCount = -1; // L: 12370
					class10.foundItemIds = null; // L: 12371
					return; // L: 12372
				}
				if (var3 >= var2.length) { // L: 12374
					short[] var6 = new short[var2.length * 2]; // L: 12375
					for (int var7 = 0; var7 < var3; ++var7) { // L: 12376
						var6[var7] = var2[var7];
					}
					var2 = var6; // L: 12377
				}
				var2[var3++] = (short) var4; // L: 12379
			}
		}
		class10.foundItemIds = var2; // L: 12381
		TriBool.foundItemIndex = 0; // L: 12382
		HealthBarUpdate.foundItemIdCount = var3; // L: 12383
		String[] var8 = new String[HealthBarUpdate.foundItemIdCount]; // L:
																		// 12384
		for (int var5 = 0; var5 < HealthBarUpdate.foundItemIdCount; ++var5) { // L:
																				// 12385
			var8[var5] = EnumComposition.ItemDefinition_get(var2[var5]).name;
		}
		short[] var10 = class10.foundItemIds; // L: 12386
		_Junk.sortItemsByName(var8, var10, 0, var8.length - 1); // L:
																		// 12388
	} // L: 12390

	public static final void method309(String var0, int var1) {
		PacketBufferNode var2 = EnumComposition.getPacketBufferNode(ClientPacket.field2971, Client.packetWriter.isaacCipher); // L:
																																// 260
		var2.packetBuffer.writeByte(ScriptEvent.stringCp1252NullTerminatedByteSize(var0) + 1); // L:
																								// 261
		var2.packetBuffer.method7762(var1); // L: 262
		var2.packetBuffer.writeStringCp1252NullTerminated(var0); // L: 263
		Client.packetWriter.addNode(var2); // L: 264
	} // L: 265

	public static int method305(int var0) {
		Message var1 = (Message) Messages.Messages_hashTable.get((long) var0); // L:
																				// 50
		if (var1 == null) { // L: 51
			return -1;
		} else {
			return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message) var1.nextDual).count; // L:
																												// 52
																												// 53
		}
	}

	public static Font fontPlain12;
	public static boolean ItemDefinition_inMembersWorld;
	public static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width; // L: 10684
		int var5 = var0.height; // L: 10685
		if (var0.widthAlignment == 0) { // L: 10686
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) { // L: 10687
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) { // L: 10688
			var0.width = var0.rawWidth * var1 >> 14;
		}
		if (var0.heightAlignment == 0) { // L: 10689
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) { // L: 10690
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) { // L: 10691
			var0.height = var2 * var0.rawHeight >> 14;
		}
		if (var0.widthAlignment == 4) { // L: 10692
			var0.width = var0.height * var0.field3385 / var0.field3386;
		}
		if (var0.heightAlignment == 4) { // L: 10693
			var0.height = var0.field3386 * var0.width / var0.field3385;
		}
		if (var0.contentType == 1337) { // L: 10694
			Client.viewportWidget = var0;
		}
		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) { // L:
																							// 10695
			ScriptEvent var6 = new ScriptEvent(); // L: 10696
			var6.widget = var0; // L: 10697
			var6.args = var0.onResize; // L: 10698
			Client.scriptEvents.addFirst(var6); // L: 10699
		}
	} // L: 10701

	public static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = class356.scene.getBoundaryObjectTag(var0, var1, var2); // L:
																			// 5921
		int var7;
		int var8;
		int var9;
		int var10;
		int var12;
		int var13;
		if (0L != var5) { // L: 5922
			var7 = class356.scene.getObjectFlags(var0, var1, var2, var5); // L:
																			// 5923
			var8 = var7 >> 6 & 3; // L: 5924
			var9 = var7 & 31; // L: 5925
			var10 = var3; // L: 5926
			if (Canvas.method322(var5)) { // L: 5927
				var10 = var4;
			}
			int[] var11 = FloorUnderlayDefinition.sceneMinimapSprite.pixels; // L:
																				// 5928
			var12 = var1 * 4 + (103 - var2) * 2048 + 24624; // L: 5929
			var13 = _Junk.Entity_unpackID(var5); // L: 5930
			ObjectComposition var14 = class162.getObjectDefinition(var13); // L:
																			// 5931
			if (var14.mapSceneId != -1) { // L: 5932
				IndexedSprite var15 = class13.mapSceneSprites[var14.mapSceneId]; // L:
																					// 5933
				if (var15 != null) { // L: 5934
					int var16 = (var14.sizeX * 4 - var15.subWidth) / 2; // L:
																		// 5935
					int var17 = (var14.sizeY * 4 - var15.subHeight) / 2; // L:
																			// 5936
					var15.drawAt(var1 * 4 + var16 + 48, (104 - var2 - var14.sizeY) * 4 + var17 + 48); // L:
																										// 5937
				}
			} else {
				if (var9 == 0 || var9 == 2) { // L: 5941
					if (var8 == 0) { // L: 5942
						var11[var12] = var10; // L: 5943
						var11[var12 + 512] = var10; // L: 5944
						var11[var12 + 1024] = var10; // L: 5945
						var11[var12 + 1536] = var10; // L: 5946
					} else if (var8 == 1) { // L: 5948
						var11[var12] = var10; // L: 5949
						var11[var12 + 1] = var10; // L: 5950
						var11[var12 + 2] = var10; // L: 5951
						var11[var12 + 3] = var10; // L: 5952
					} else if (var8 == 2) { // L: 5954
						var11[var12 + 3] = var10; // L: 5955
						var11[var12 + 512 + 3] = var10; // L: 5956
						var11[var12 + 1024 + 3] = var10; // L: 5957
						var11[var12 + 1536 + 3] = var10; // L: 5958
					} else if (var8 == 3) { // L: 5960
						var11[var12 + 1536] = var10; // L: 5961
						var11[var12 + 1536 + 1] = var10; // L: 5962
						var11[var12 + 1536 + 2] = var10; // L: 5963
						var11[var12 + 1536 + 3] = var10; // L: 5964
					}
				}
				if (var9 == 3) { // L: 5967
					if (var8 == 0) { // L: 5968
						var11[var12] = var10;
					} else if (var8 == 1) { // L: 5969
						var11[var12 + 3] = var10;
					} else if (var8 == 2) { // L: 5970
						var11[var12 + 1536 + 3] = var10;
					} else if (var8 == 3) { // L: 5971
						var11[var12 + 1536] = var10;
					}
				}
				if (var9 == 2) { // L: 5973
					if (var8 == 3) { // L: 5974
						var11[var12] = var10; // L: 5975
						var11[var12 + 512] = var10; // L: 5976
						var11[var12 + 1024] = var10; // L: 5977
						var11[var12 + 1536] = var10; // L: 5978
					} else if (var8 == 0) { // L: 5980
						var11[var12] = var10; // L: 5981
						var11[var12 + 1] = var10; // L: 5982
						var11[var12 + 2] = var10; // L: 5983
						var11[var12 + 3] = var10; // L: 5984
					} else if (var8 == 1) { // L: 5986
						var11[var12 + 3] = var10; // L: 5987
						var11[var12 + 512 + 3] = var10; // L: 5988
						var11[var12 + 1024 + 3] = var10; // L: 5989
						var11[var12 + 1536 + 3] = var10; // L: 5990
					} else if (var8 == 2) { // L: 5992
						var11[var12 + 1536] = var10; // L: 5993
						var11[var12 + 1536 + 1] = var10; // L: 5994
						var11[var12 + 1536 + 2] = var10; // L: 5995
						var11[var12 + 1536 + 3] = var10; // L: 5996
					}
				}
			}
		}
		var5 = class356.scene.getGameObjectTag(var0, var1, var2); // L: 6001
		if (0L != var5) { // L: 6002
			var7 = class356.scene.getObjectFlags(var0, var1, var2, var5); // L:
																			// 6003
			var8 = var7 >> 6 & 3; // L: 6004
			var9 = var7 & 31; // L: 6005
			var10 = _Junk.Entity_unpackID(var5); // L: 6006
			ObjectComposition var24 = class162.getObjectDefinition(var10); // L:
																			// 6007
			int var19;
			if (var24.mapSceneId != -1) { // L: 6008
				IndexedSprite var20 = class13.mapSceneSprites[var24.mapSceneId]; // L:
																					// 6009
				if (var20 != null) { // L: 6010
					var13 = (var24.sizeX * 4 - var20.subWidth) / 2; // L: 6011
					var19 = (var24.sizeY * 4 - var20.subHeight) / 2; // L: 6012
					var20.drawAt(var1 * 4 + var13 + 48, var19 + (104 - var2 - var24.sizeY) * 4 + 48); // L:
																										// 6013
				}
			} else if (var9 == 9) { // L: 6016
				var12 = 15658734; // L: 6017
				if (Canvas.method322(var5)) { // L: 6018
					var12 = 15597568;
				}
				int[] var18 = FloorUnderlayDefinition.sceneMinimapSprite.pixels; // L:
																					// 6019
				var19 = var1 * 4 + (103 - var2) * 2048 + 24624; // L: 6020
				if (var8 != 0 && var8 != 2) { // L: 6021
					var18[var19] = var12; // L: 6028
					var18[var19 + 1 + 512] = var12; // L: 6029
					var18[var19 + 1024 + 2] = var12; // L: 6030
					var18[var19 + 1536 + 3] = var12; // L: 6031
				} else {
					var18[var19 + 1536] = var12; // L: 6022
					var18[var19 + 1 + 1024] = var12; // L: 6023
					var18[var19 + 512 + 2] = var12; // L: 6024
					var18[var19 + 3] = var12; // L: 6025
				}
			}
		}
		var5 = class356.scene.getFloorDecorationTag(var0, var1, var2); // L:
																		// 6035
		if (var5 != 0L) { // L: 6036
			var7 = _Junk.Entity_unpackID(var5); // L: 6037
			ObjectComposition var21 = class162.getObjectDefinition(var7); // L:
																			// 6038
			if (var21.mapSceneId != -1) { // L: 6039
				IndexedSprite var22 = class13.mapSceneSprites[var21.mapSceneId]; // L:
																					// 6040
				if (var22 != null) { // L: 6041
					var10 = (var21.sizeX * 4 - var22.subWidth) / 2; // L: 6042
					int var23 = (var21.sizeY * 4 - var22.subHeight) / 2; // L:
																			// 6043
					var22.drawAt(var10 + var1 * 4 + 48, var23 + (104 - var2 - var21.sizeY) * 4 + 48); // L:
																										// 6044
				}
			}
		}
	} // L: 6048

	public static int Entity_unpackID(long var0) {
		return (int) (var0 >>> 17 & 4294967295L); // L: 85
	}

	public static int method1019(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.SOUND_SYNTH) { // L: 1892
			class446.Interpreter_intStackSize -= 3; // L: 1893
			StaticSound.queueSoundEffect(Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 2]); // L:
																																																																	// 1894
			return 1; // L: 1895
		} else if (var0 == ScriptOpcodes.SOUND_SONG) { // L: 1897
			StaticSound.playSong(Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]); // L:
																										// 1898
			return 1; // L: 1899
		} else if (var0 == ScriptOpcodes.SOUND_JINGLE) { // L: 1901
			class446.Interpreter_intStackSize -= 2; // L: 1902
			StaticSound.playJingle(Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]); // L:
																																												// 1903
			return 1; // L: 1904
		} else {
			class83 var3;
			class82 var4;
			int var5;
			int var6;
			String var7;
			if (var0 != 3212 && var0 != 3213 && var0 != 3209 && var0 != 3181 && var0 != 3203 && var0 != 3205 && var0 != 3207) { // L:
																																// 1906
				if (var0 != 3214 && var0 != 3215 && var0 != 3210 && var0 != 3182 && var0 != 3204 && var0 != 3206 && var0 != 3208) { // L:
																																	// 2018
					return var0 == 3211 ? 1 : 2; // L: 2127 2128 2130
				} else {
					var3 = class83.field1074; // L: 2019
					var4 = class82.field1069; // L: 2020
					boolean var8 = false; // L: 2021
					if (var0 == 3214) { // L: 2022
						var6 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																										// 2023
						var3 = (class83) Actor.findEnumerated(MilliClock.method3310(), var6); // L:
																								// 2024
						if (var3 == null) { // L: 2025
							throw new RuntimeException(String.format("Unrecognized device option %d", var6)); // L:
																												// 2026
						}
					}
					if (var0 == 3215) { // L: 2029
						var6 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																										// 2030
						var4 = (class82) Actor.findEnumerated(WorldMapData_1.method4867(), var6); // L:
																									// 2031
						if (var4 == null) { // L: 2032
							throw new RuntimeException(String.format("Unrecognized game option %d", var6)); // L:
																											// 2033
						}
					}
					if (var0 == 3210) { // L: 2036
						var6 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																										// 2037
						var3 = (class83) Actor.findEnumerated(MilliClock.method3310(), var6); // L:
																								// 2038
						if (var3 == null) { // L: 2039
							var4 = (class82) Actor.findEnumerated(WorldMapData_1.method4867(), var6); // L:
																										// 2040
							if (var4 == null) { // L: 2041
								throw new RuntimeException(String.format("Unrecognized client option %d", var6)); // L:
								// 2042
							}
						}
					} else if (var0 == 3182) { // L: 2046
						var3 = class83.field1079; // L: 2047
					} else if (var0 == 3204) { // L: 2049
						var4 = class82.field1067; // L: 2050
					} else if (var0 == 3206) { // L: 2052
						var4 = class82.field1068; // L: 2053
					} else if (var0 == 3208) { // L: 2055
						var4 = class82.field1073; // L: 2056
					}
					if (var4 == class82.field1069) { // L: 2058
						switch (var3.field1080) { // L: 2059
							case 1 :
								var5 = class19.clientPreferences.method2247() ? 1 : 0; // L:
																						// 2087
								break; // L: 2088
							case 2 :
								var5 = class19.clientPreferences.method2317() ? 1 : 0; // L:
																						// 2082
								break; // L: 2083
							case 3 :
								var5 = class19.clientPreferences.method2252() ? 1 : 0; // L:
																						// 2067
								break; // L: 2068
							case 4 :
								var5 = class19.clientPreferences.method2243(); // L:
																				// 2062
								break;
							case 5 :
								var5 = class193.method3919(); // L: 2072
								break; // L: 2073
							default :
								var7 = String.format("Unkown device option: %s.", var3.toString()); // L:
																									// 2077
								throw new RuntimeException(var7); // L: 2078
						}
					} else {
						switch (var4.field1065) { // L: 2093
							case 1 :
								var5 = class19.clientPreferences.method2245() ? 1 : 0; // L:
																						// 2096
								break; // L: 2097
							case 2 :
								var6 = class19.clientPreferences.method2258(); // L:
																				// 2118
								var5 = Math.round((float) (var6 * 100) / 255.0F); // L:
																					// 2119
								break; // L: 2120
							case 3 :
								var6 = class19.clientPreferences.method2241(); // L:
																				// 2112
								var5 = Math.round((float) (var6 * 100) / 127.0F); // L:
																					// 2113
								break; // L: 2114
							case 4 :
								var6 = class19.clientPreferences.method2262(); // L:
																				// 2106
								var5 = Math.round((float) (var6 * 100) / 127.0F); // L:
																					// 2107
								break; // L: 2108
							default :
								var7 = String.format("Unkown game option: %s.", var4.toString()); // L:
																									// 2101
								throw new RuntimeException(var7); // L: 2102
						}
					}
					Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var5; // L:
																										// 2124
					return 1; // L: 2125
				}
			} else {
				var3 = class83.field1074; // L: 1907
				var4 = class82.field1069; // L: 1908
				var5 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																								// 1909
				if (var0 == 3212) { // L: 1910
					var6 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																									// 1911
					var3 = (class83) Actor.findEnumerated(MilliClock.method3310(), var6); // L:
																							// 1912
					if (var3 == null) { // L: 1913
						throw new RuntimeException(String.format("Unrecognized device option %d", var6)); // L:
																											// 1914
					}
				}
				if (var0 == 3213) { // L: 1917
					var6 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																									// 1918
					var4 = (class82) Actor.findEnumerated(WorldMapData_1.method4867(), var6); // L:
																								// 1919
					if (var4 == null) { // L: 1920
						throw new RuntimeException(String.format("Unrecognized game option %d", var6)); // L:
																										// 1921
					}
				}
				if (var0 == 3209) { // L: 1924
					var6 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																									// 1925
					var3 = (class83) Actor.findEnumerated(MilliClock.method3310(), var6); // L:
																							// 1926
					if (var3 == null) { // L: 1927
						var4 = (class82) Actor.findEnumerated(WorldMapData_1.method4867(), var6); // L:
																									// 1928
						if (var4 == null) { // L: 1929
							throw new RuntimeException(String.format("Unrecognized client option %d", var6)); // L:
																												// 1930
						}
					}
				} else if (var0 == 3181) { // L: 1934
					var3 = class83.field1079; // L: 1935
				} else if (var0 == 3203) { // L: 1937
					var4 = class82.field1067; // L: 1938
				} else if (var0 == 3205) { // L: 1940
					var4 = class82.field1068; // L: 1941
				} else if (var0 == 3207) { // L: 1943
					var4 = class82.field1073; // L: 1944
				}
				if (var4 == class82.field1069) { // L: 1946
					switch (var3.field1080) { // L: 1947
						case 1 :
							class19.clientPreferences.method2246(var5 == 1); // L:
																				// 1971
							break; // L: 1972
						case 2 :
							class19.clientPreferences.method2248(var5 == 1); // L:
																				// 1950
							break;
						case 3 :
							class19.clientPreferences.method2250(var5 == 1); // L:
																				// 1966
							break; // L: 1967
						case 4 :
							if (var5 < 0) { // L: 1960
								var5 = 0;
							}
							class19.clientPreferences.method2330(var5); // L:
																		// 1961
							break; // L: 1962
						case 5 :
							WorldMapEvent.method5120(var5); // L: 1955
							break; // L: 1956
						default :
							var7 = String.format("Unkown device option: %s.", var3.toString()); // L:
																								// 1976
							throw new RuntimeException(var7); // L: 1977
					}
				} else {
					switch (var4.field1065) { // L: 1982
						case 1 :
							class19.clientPreferences.method2339(var5 == 1); // L:
																				// 1992
							break; // L: 1993
						case 2 :
							var5 = Math.min(Math.max(var5, 0), 100); // L: 1997
							var6 = Math.round((float) (var5 * 255) / 100.0F); // L:
																				// 1998
							StaticSound.updateMusicVolume(var6); // L: 1999
							break; // L: 2000
						case 3 :
							var5 = Math.min(Math.max(var5, 0), 100); // L: 2004
							var6 = Math.round((float) (var5 * 127) / 100.0F); // L:
																				// 2005
							WorldMapData_0.updateSoundEffectVolume(var6); // L: 2006
							break; // L: 2007
						case 4 :
							var5 = Math.min(Math.max(var5, 0), 100); // L: 1985
							var6 = Math.round((float) (var5 * 127) / 100.0F); // L:
																				// 1986
							WorldMapEvent.method5121(var6); // L: 1987
							break; // L: 1988
						default :
							var7 = String.format("Unkown game option: %s.", var4.toString()); // L:
																								// 2011
							throw new RuntimeException(var7); // L: 2012
					}
				}
				return 1; // L: 2016
			}
		}
	}

	public static int field3196;
	public static Fonts WorldMapElement_fonts;
	public static int field402;
	public static SpotAnimationDefinition SpotAnimationDefinition_get(int var0) {
		SpotAnimationDefinition var1 = (SpotAnimationDefinition) SpotAnimationDefinition.SpotAnimationDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = SpotAnimationDefinition.SpotAnimationDefinition_archive.takeFile(13, var0);
			var1 = new SpotAnimationDefinition(); // L: 35
			var1.id = var0;
			if (var2 != null) { // L: 37
				var1.decode(new Buffer(var2));
			}
			SpotAnimationDefinition.SpotAnimationDefinition_cached.put(var1, (long) var0); // L:
																							// 38
			return var1; // L: 39
		}
	}

	public static void sortItemsByName(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) { // L: 9
			int var4 = (var3 + var2) / 2; // L: 10
			int var5 = var2; // L: 11
			String var6 = var0[var4]; // L: 12
			var0[var4] = var0[var3]; // L: 13
			var0[var3] = var6; // L: 14
			short var7 = var1[var4]; // L: 15
			var1[var4] = var1[var3]; // L: 16
			var1[var3] = var7; // L: 17
			for (int var8 = var2; var8 < var3; ++var8) { // L: 18
				if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) { // L:
																										// 19
					String var9 = var0[var8]; // L: 20
					var0[var8] = var0[var5]; // L: 21
					var0[var5] = var9; // L: 22
					short var10 = var1[var8]; // L: 23
					var1[var8] = var1[var5]; // L: 24
					var1[var5++] = var10; // L: 25
				}
			}
			var0[var3] = var0[var5]; // L: 29
			var0[var5] = var6; // L: 30
			var1[var3] = var1[var5]; // L: 31
			var1[var5] = var7; // L: 32
			sortItemsByName(var0, var1, var2, var5 - 1); // L: 33
			sortItemsByName(var0, var1, var5 + 1, var3); // L: 34
		}
	} // L: 36

	static final boolean runCs1(Widget var0) {
		if (var0.cs1Comparisons == null) { // L: 10769
			return false;
		} else {
			for (int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) { // L:
																			// 10770
				int var2 = Canvas.method319(var0, var1); // L: 10771
				int var3 = var0.cs1ComparisonValues[var1]; // L: 10772
				if (var0.cs1Comparisons[var1] == 2) { // L: 10773
					if (var2 >= var3) { // L: 10774
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 3) { // L: 10776
					if (var2 <= var3) { // L: 10777
						return false;
					}
				} else if (var0.cs1Comparisons[var1] == 4) { // L: 10779
					if (var2 == var3) { // L: 10780
						return false;
					}
				} else if (var2 != var3) { // L: 10782
					return false;
				}
			}
			return true; // L: 10784
		}
	}

	public static void method1702() {
		ItemComposition.ItemDefinition_cached.clear(); // L: 563
		ItemComposition.ItemDefinition_cachedModels.clear(); // L: 564
		ItemComposition.ItemDefinition_cachedSprites.clear(); // L: 565
	} // L: 566

	static int[] regionLandArchiveIds;
	public static Buffer NetCache_responseArchiveBuffer;

}
