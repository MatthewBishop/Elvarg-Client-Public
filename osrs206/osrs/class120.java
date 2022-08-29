package osrs;

import audioengine.StaticSound;

public class class120 implements class112 {
	
	static Task socketTask;
	
	public static boolean method2759(int var0) {
		return (var0 >> 30 & 1) != 0; // L: 33
	}
	
	static final int method2758() {
		return ViewportMouse.ViewportMouse_x; // L: 103
	}
	
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		StaticSound.playPcmPlayers(); // L: 12071
		SpriteMask var4 = var0.getSpriteMask(false); // L: 12072
		if (var4 != null) { // L: 12073
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height); // L:
																									// 12074
			if (Client.minimapState != 2 && Client.minimapState != 5) { // L:
																		// 12075
				int var5 = Client.camAngleY & 2047; // L: 12076
				int var6 = class101.localPlayer.x / 32 + 48; // L: 12077
				int var7 = 464 - class101.localPlayer.y / 32; // L: 12078
				FloorUnderlayDefinition.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths); // L:
																																													// 12079
				int var8;
				int var10;
				int var16;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) { // L: 12080
					var16 = Client.mapIconXs[var8] * 4 + 2 - class101.localPlayer.x / 32; // L:
																							// 12081
					var10 = Client.mapIconYs[var8] * 4 + 2 - class101.localPlayer.y / 32; // L:
																							// 12082
					ParamComposition.drawSpriteOnMinimap(var1, var2, var16, var10, Client.mapIcons[var8], var4); // L:
					// 12083
				}
				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) { // L: 12085
					for (var16 = 0; var16 < 104; ++var16) { // L: 12086
						NodeDeque var14 = Client.groundItems[PacketWriter.Client_plane][var8][var16]; // L:
																										// 12087
						if (var14 != null) { // L: 12088
							var11 = var8 * 4 + 2 - class101.localPlayer.x / 32; // L:
																				// 12089
							var12 = var16 * 4 + 2 - class101.localPlayer.y / 32; // L:
																					// 12090
							ParamComposition.drawSpriteOnMinimap(var1, var2, var11, var12, class9.mapDotSprites[0], var4); // L:
																															// 12091
						}
					}
				}
				for (var8 = 0; var8 < Client.npcCount; ++var8) { // L: 12095
					NPC var9 = Client.npcs[Client.npcIndices[var8]]; // L: 12096
					if (var9 != null && var9.isVisible()) { // L: 12097
						NPCComposition var18 = var9.definition; // L: 12098
						if (var18 != null && var18.transforms != null) { // L:
																			// 12099
							var18 = var18.transform();
						}
						if (var18 != null && var18.drawMapDot && var18.isInteractable) { // L:
																							// 12100
							var11 = var9.x / 32 - class101.localPlayer.x / 32; // L:
																				// 12101
							var12 = var9.y / 32 - class101.localPlayer.y / 32; // L:
																				// 12102
							ParamComposition.drawSpriteOnMinimap(var1, var2, var11, var12, class9.mapDotSprites[1], var4); // L:
																															// 12103
						}
					}
				}
				var8 = Players.Players_count; // L: 12107
				int[] var17 = Players.Players_indices; // L: 12108
				for (var10 = 0; var10 < var8; ++var10) { // L: 12109
					Player var15 = Client.players[var17[var10]]; // L: 12110
					if (var15 != null && var15.isVisible() && !var15.isHidden && var15 != class101.localPlayer) { // L:
						// 12111
						var12 = var15.x / 32 - class101.localPlayer.x / 32; // L:
																			// 12112
						int var13 = var15.y / 32 - class101.localPlayer.y / 32; // L:
																				// 12113
						if (var15.isFriend()) { // L: 12114
							ParamComposition.drawSpriteOnMinimap(var1, var2, var12, var13, class9.mapDotSprites[3], var4);
						} else if (class101.localPlayer.team != 0 && var15.team != 0 && var15.team == class101.localPlayer.team) { // L:
																																	// 12115
							ParamComposition.drawSpriteOnMinimap(var1, var2, var12, var13, class9.mapDotSprites[4], var4);
						} else if (var15.isFriendsChatMember()) { // L: 12116
							ParamComposition.drawSpriteOnMinimap(var1, var2, var12, var13, class9.mapDotSprites[5], var4);
						} else if (var15.isClanMember()) { // L: 12117
							ParamComposition.drawSpriteOnMinimap(var1, var2, var12, var13, class9.mapDotSprites[6], var4);
						} else {
							ParamComposition.drawSpriteOnMinimap(var1, var2, var12, var13, class9.mapDotSprites[2], var4); // L:
																															// 12118
						}
					}
				}
				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) { // L:
																			// 12121
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) { // L:
																																		// 12122
						NPC var19 = Client.npcs[Client.hintArrowNpcIndex]; // L:
																			// 12123
						if (var19 != null) { // L: 12124
							var11 = var19.x / 32 - class101.localPlayer.x / 32; // L:
																				// 12125
							var12 = var19.y / 32 - class101.localPlayer.y / 32; // L:
																				// 12126
							UserComparator10.worldToMinimap(var1, var2, var11, var12, DynamicObject.mapMarkerSprites[1], var4); // L:
																																// 12127
						}
					}
					if (Client.hintArrowType == 2) { // L: 12130
						var10 = Client.hintArrowX * 4 - class28.baseX * 4 + 2 - class101.localPlayer.x / 32; // L:
																												// 12131
						var11 = Client.hintArrowY * 4 - WorldMapLabelSize.baseY * 4 + 2 - class101.localPlayer.y / 32; // L:
						// 12132
						UserComparator10.worldToMinimap(var1, var2, var10, var11, DynamicObject.mapMarkerSprites[1], var4); // L:
																															// 12133
					}
					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) { // L:
																																					// 12135
						Player var20 = Client.players[Client.hintArrowPlayerIndex]; // L:
																					// 12136
						if (var20 != null) { // L: 12137
							var11 = var20.x / 32 - class101.localPlayer.x / 32; // L:
																				// 12138
							var12 = var20.y / 32 - class101.localPlayer.y / 32; // L:
																				// 12139
							UserComparator10.worldToMinimap(var1, var2, var11, var12, DynamicObject.mapMarkerSprites[1], var4); // L:
																																// 12140
						}
					}
				}
				if (Client.destinationX != 0) { // L: 12144
					var10 = Client.destinationX * 4 + 2 - class101.localPlayer.x / 32; // L:
																						// 12145
					var11 = Client.destinationY * 4 + 2 - class101.localPlayer.y / 32; // L:
																						// 12146
					ParamComposition.drawSpriteOnMinimap(var1, var2, var10, var11, DynamicObject.mapMarkerSprites[0], var4); // L:
																																// 12147
				}
				if (!class101.localPlayer.isHidden) { // L: 12149
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths); // L:
																											// 12151
			}
			Client.field704[var3] = true; // L: 12152
		}
	} // L: 12153
}
