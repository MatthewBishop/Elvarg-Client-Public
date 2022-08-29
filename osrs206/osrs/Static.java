package osrs;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import net.runelite.rs.ScriptOpcodes;

public class Static {

	static int method2682(int var0, Script var1, boolean var2) {
		String var7;
		if (var0 == ScriptOpcodes.MES) { // L: 1480
			var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
																									// 1481
			class290.addGameMessage(0, "", var7); // L: 1482
			return 1; // L: 1483
		} else if (var0 == ScriptOpcodes.ANIM) {
			class446.Interpreter_intStackSize -= 2; // L: 1486
			class65.performPlayerAnimation(class101.localPlayer, Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]); // L:
																																																				// 1487
			return 1; // L: 1488
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field842) { // L: 1491
				Interpreter.field829 = true; // L: 1492
			}
			return 1; // L: 1494
		} else {
			int var15;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
																										// 1497
				var15 = 0; // L: 1498
				if (class114.isNumber(var7)) { // L: 1499
					var15 = FaceNormal.method4344(var7);
				}
				PacketBufferNode var13 = EnumComposition.getPacketBufferNode(ClientPacket.field2946, Client.packetWriter.isaacCipher); // L:
																																		// 1501
				var13.packetBuffer.writeInt(var15); // L: 1502
				Client.packetWriter.addNode(var13); // L: 1503
				return 1; // L: 1504
			} else {
				PacketBufferNode var11;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
																											// 1507
					var11 = EnumComposition.getPacketBufferNode(ClientPacket.field2928, Client.packetWriter.isaacCipher); // L:
																															// 1509
					var11.packetBuffer.writeByte(var7.length() + 1); // L: 1510
					var11.packetBuffer.writeStringCp1252NullTerminated(var7); // L:
																				// 1511
					Client.packetWriter.addNode(var11); // L: 1512
					return 1; // L: 1513
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
																											// 1516
					var11 = EnumComposition.getPacketBufferNode(ClientPacket.field2985, Client.packetWriter.isaacCipher); // L:
																															// 1518
					var11.packetBuffer.writeByte(var7.length() + 1); // L: 1519
					var11.packetBuffer.writeStringCp1252NullTerminated(var7); // L:
																				// 1520
					Client.packetWriter.addNode(var11); // L: 1521
					return 1; // L: 1522
				} else {
					String var4;
					int var10;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var10 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																										// 1525
						var4 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
						// 1526
						Coord.method5549(var10, var4); // L: 1527
						return 1; // L: 1528
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						class446.Interpreter_intStackSize -= 3; // L: 1531
						var10 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																										// 1532
						var15 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																											// 1533
						int var9 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 2]; // L:
																											// 1534
						Widget var14 = class140.getWidget(var9); // L: 1535
						class161.clickWidget(var14, var10, var15); // L: 1536
						return 1; // L: 1537
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						class446.Interpreter_intStackSize -= 2; // L: 1540
						var10 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																										// 1541
						var15 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																											// 1542
						Widget var12 = var2 ? class124.scriptDotWidget : GrandExchangeOfferOwnWorldComparator.scriptActiveWidget; // L:
																																	// 1543
						class161.clickWidget(var12, var10, var15); // L: 1544
						return 1; // L: 1545
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						Static.mouseCam = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
						// 1548
						return 1; // L: 1549
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = class19.clientPreferences.method2245() ? 1 : 0; // L:
																																					// 1552
						return 1; // L: 1553
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						class19.clientPreferences.method2339(Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1); // L:
						// 1556
						return 1; // L: 1557
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
						// 1560
						boolean var8 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
						// 1561
						class258.openURL(var7, var8, false); // L: 1562
						return 1; // L: 1563
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var10 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																										// 1566
						var11 = EnumComposition.getPacketBufferNode(ClientPacket.field2927, Client.packetWriter.isaacCipher); // L:
																																// 1568
						var11.packetBuffer.writeShort(var10); // L: 1569
						Client.packetWriter.addNode(var11); // L: 1570
						return 1; // L: 1571
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var10 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																										// 1574
						Interpreter.Interpreter_stringStackSize -= 2; // L: 1575
						var4 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize]; // L:
																												// 1576
						String var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1]; // L:
						// 1577
						if (var4.length() > 500) { // L: 1578
							return 1;
						} else if (var5.length() > 500) { // L: 1579
							return 1;
						} else {
							PacketBufferNode var6 = EnumComposition.getPacketBufferNode(ClientPacket.field2951, Client.packetWriter.isaacCipher); // L:
																																					// 1580
							var6.packetBuffer.writeShort(1 + ScriptEvent.stringCp1252NullTerminatedByteSize(var4) + ScriptEvent.stringCp1252NullTerminatedByteSize(var5)); // L:
																																											// 1581
							var6.packetBuffer.writeStringCp1252NullTerminated(var5); // L:
																						// 1582
							var6.packetBuffer.method7762(var10); // L: 1583
							var6.packetBuffer.writeStringCp1252NullTerminated(var4); // L:
																						// 1584
							Client.packetWriter.addNode(var6); // L: 1585
							return 1; // L: 1586
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
						// 1589
						return 1; // L: 1590
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
						// 1593
						return 1; // L: 1594
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
						// 1597
						return 1; // L: 1598
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1) { // L:
																											// 1601
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2; // L: 1602
						}
						return 1; // L: 1603
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1) { // L:
																											// 1606
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3; // L: 1607
						}
						return 1; // L: 1608
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1) { // L:
																											// 1611
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5; // L: 1612
						}
						return 1; // L: 1613
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1) { // L:
																											// 1616
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9; // L: 1617
						}
						return 1; // L: 1618
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0; // L: 1621
						return 1; // L: 1622
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
						// 1625
						return 1; // L: 1626
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
						// 1629
						return 1; // L: 1630
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						class9.setTapToDrop(Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1); // L:
						// 1633
						return 1; // L: 1634
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = HorizontalAlignment.getTapToDrop() ? 1 : 0; // L:
																																				// 1637
						return 1; // L: 1638
					} else if (var0 == 3129) {
						class446.Interpreter_intStackSize -= 2; // L: 1641
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
						// 1642
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																																// 1643
						return 1; // L: 1644
					} else if (var0 == 3130) {
						class446.Interpreter_intStackSize -= 2; // L: 1647
						return 1; // L: 1648
					} else if (var0 == 3131) {
						--class446.Interpreter_intStackSize; // L: 1651
						return 1; // L: 1652
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Script.canvasWidth; // L:
						// 1655
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = class78.canvasHeight; // L:
																															// 1656
						return 1; // L: 1657
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--class446.Interpreter_intStackSize; // L: 1660
						return 1; // L: 1661
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1; // L: 1664
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						class446.Interpreter_intStackSize -= 2; // L: 1667
						return 1; // L: 1668
					} else if (var0 == 3136) {
						Client.field656 = 3; // L: 1671
						Client.field657 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
						// 1672
						return 1; // L: 1673
					} else if (var0 == 3137) {
						Client.field656 = 2; // L: 1676
						Client.field657 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
						// 1677
						return 1; // L: 1678
					} else if (var0 == 3138) {
						Client.field656 = 0; // L: 1681
						return 1; // L: 1682
					} else if (var0 == 3139) {
						Client.field656 = 1; // L: 1685
						return 1; // L: 1686
					} else if (var0 == 3140) {
						Client.field656 = 3; // L: 1689
						Client.field657 = var2 ? class124.scriptDotWidget.id * -1598663557 * -1038587213 : GrandExchangeOfferOwnWorldComparator.scriptActiveWidget.id * -1598663557 * -1038587213; // L:
																																																	// 1690
						return 1; // L: 1691
					} else {
						boolean var3;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
							// 1694
							class19.clientPreferences.method2246(var3); // L:
																		// 1695
							return 1; // L: 1696
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = class19.clientPreferences.method2247() ? 1 : 0; // L:
																																						// 1699
							return 1; // L: 1700
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
							// 1703
							Client.Login_isUsernameRemembered = var3; // L: 1704
							if (!var3) { // L: 1705
								class19.clientPreferences.method2260(""); // L:
																			// 1706
							}
							return 1; // L: 1708
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0; // L:
																																					// 1711
							return 1; // L: 1712
						} else if (var0 == ScriptOpcodes.SHOW_IOS_REVIEW) {
							return 1; // L: 1715
						} else if (var0 == 3146) {
							var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize] == 1; // L:
							// 1718
							class19.clientPreferences.method2248(!var3); // L:
																			// 1719
							return 1; // L: 1720
						} else if (var0 == 3147) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = class19.clientPreferences.method2317() ? 0 : 1; // L:
																																						// 1723
							return 1; // L: 1724
						} else if (var0 == 3148) {
							return 1; // L: 1727
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1730
							return 1; // L: 1731
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1734
							return 1; // L: 1735
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1738
							return 1; // L: 1739
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1742
							return 1; // L: 1743
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Login.Login_loadingPercent; // L:
																																	// 1746
							return 1; // L: 1747
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Static.method2719(); // L:
																																// 1750
							return 1; // L: 1751
						} else if (var0 == 3155) {
							--Interpreter.Interpreter_stringStackSize; // L:
																		// 1754
							return 1; // L: 1755
						} else if (var0 == 3156) {
							return 1; // L: 1758
						} else if (var0 == 3157) {
							class446.Interpreter_intStackSize -= 2; // L: 1761
							return 1; // L: 1762
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1765
							return 1; // L: 1766
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1769
							return 1; // L: 1770
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1773
							return 1; // L: 1774
						} else if (var0 == 3161) {
							--class446.Interpreter_intStackSize; // L: 1777
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1778
							return 1; // L: 1779
						} else if (var0 == 3162) {
							--class446.Interpreter_intStackSize; // L: 1782
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1783
							return 1; // L: 1784
						} else if (var0 == 3163) {
							--Interpreter.Interpreter_stringStackSize; // L:
																		// 1787
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1788
							return 1; // L: 1789
						} else if (var0 == 3164) {
							--class446.Interpreter_intStackSize; // L: 1792
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1793
							return 1; // L: 1794
						} else if (var0 == 3165) {
							--class446.Interpreter_intStackSize; // L: 1797
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1798
							return 1; // L: 1799
						} else if (var0 == 3166) {
							class446.Interpreter_intStackSize -= 2; // L: 1802
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1803
							return 1; // L: 1804
						} else if (var0 == 3167) {
							class446.Interpreter_intStackSize -= 2; // L: 1807
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1808
							return 1; // L: 1809
						} else if (var0 == 3168) {
							class446.Interpreter_intStackSize -= 2; // L: 1812
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1813
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1814
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1815
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1816
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1817
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1818
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1819
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1820
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 1821
							return 1; // L: 1822
						} else if (var0 == 3169) {
							return 1; // L: 1825
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1828
							return 1; // L: 1829
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1832
							return 1; // L: 1833
						} else if (var0 == 3172) {
							--class446.Interpreter_intStackSize; // L: 1836
							return 1; // L: 1837
						} else if (var0 == 3173) {
							--class446.Interpreter_intStackSize; // L: 1840
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1841
							return 1; // L: 1842
						} else if (var0 == 3174) {
							--class446.Interpreter_intStackSize; // L: 1845
							return 1; // L: 1846
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 1849
							return 1; // L: 1850
						} else if (var0 == 3176) {
							return 1; // L: 1853
						} else if (var0 == 3177) {
							return 1; // L: 1856
						} else if (var0 == 3178) {
							--Interpreter.Interpreter_stringStackSize; // L:
																		// 1859
							return 1; // L: 1860
						} else if (var0 == 3179) {
							return 1; // L: 1863
						} else if (var0 == 3180) {
							--Interpreter.Interpreter_stringStackSize; // L:
																		// 1866
							return 1; // L: 1867
						} else if (var0 == 3181) {
							WorldMapEvent.method5120(Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]); // L:
							// 1870
							return 1; // L: 1871
						} else if (var0 == 3182) {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = class193.method3919(); // L:
																																// 1874
							return 1; // L: 1875
						} else if (var0 != 3183 && var0 != 3184) {
							if (var0 == 3187) {
								Interpreter.Interpreter_stringStackSize -= 2; // L:
																				// 1882
								return 1; // L: 1883
							} else {
								return var0 == 3188 ? 1 : 2; // L: 1886 1888
							}
						} else {
							--class446.Interpreter_intStackSize; // L: 1878
							return 1; // L: 1879
						}
					}
				}
			}
		}
	}

	static final void doCheat(String var0) {
		if (var0.equalsIgnoreCase("toggleroof")) { // L: 3915
			class19.clientPreferences.method2339(!class19.clientPreferences.method2245()); // L:
																							// 3916
			if (class19.clientPreferences.method2245()) { // L: 3917
				class290.addGameMessage(99, "", "Roofs are now all hidden"); // L:
																				// 3918
			} else {
				class290.addGameMessage(99, "", "Roofs will only be removed selectively"); // L:
																							// 3921
			}
		}
		if (var0.equalsIgnoreCase("displayfps")) { // L: 3924
			class19.clientPreferences.method2251();
		}
		if (var0.equalsIgnoreCase("renderself")) { // L: 3925
			Client.renderSelf = !Client.renderSelf;
		}
		if (var0.equalsIgnoreCase("mouseovertext")) {
			Client.showMouseOverText = !Client.showMouseOverText; // L: 3926
		}
		if (Client.staffModLevel >= 2) { // L: 3927
			if (var0.equalsIgnoreCase("errortest")) { // L: 3928
				throw new RuntimeException();
			}
			if (var0.equalsIgnoreCase("showcoord")) { // L: 3929
				class121.worldMap.showCoord = !class121.worldMap.showCoord;
			}
			if (var0.equalsIgnoreCase("fpson")) { // L: 3930
				class19.clientPreferences.method2250(true);
			}
			if (var0.equalsIgnoreCase("fpsoff")) { // L: 3931
				class19.clientPreferences.method2250(false);
			}
			if (var0.equalsIgnoreCase("gc")) { // L: 3932
				System.gc();
			}
			if (var0.equalsIgnoreCase("clientdrop")) { // L: 3933
				class131.method2877();
			}
		}
		PacketBufferNode var1 = EnumComposition.getPacketBufferNode(ClientPacket.field3013, Client.packetWriter.isaacCipher); // L:
																																// 3936
		var1.packetBuffer.writeByte(var0.length() + 1); // L: 3937
		var1.packetBuffer.writeStringCp1252NullTerminated(var0); // L: 3938
		Client.packetWriter.addNode(var1); // L: 3939
	} // L: 3940

	public static boolean method2691(AbstractArchive var0, AbstractArchive var1) {
		class121.WorldMapElement_archive = var1; // L: 44
		if (!var0.isFullyLoaded()) { // L: 45
			return false; // L: 46
		} else {
			WorldMapElement.WorldMapElement_count = var0.getGroupFileCount(35); // L:
																				// 48
			WorldMapElement.WorldMapElement_cached = new WorldMapElement[WorldMapElement.WorldMapElement_count]; // L:
			// 49
			for (int var2 = 0; var2 < WorldMapElement.WorldMapElement_count; ++var2) { // L:
																						// 50
				byte[] var3 = var0.takeFile(35, var2); // L: 51
				WorldMapElement.WorldMapElement_cached[var2] = new WorldMapElement(var2); // L:
																							// 52
				if (var3 != null) { // L: 53
					WorldMapElement.WorldMapElement_cached[var2].decode(new Buffer(var3)); // L:
																							// 54
					WorldMapElement.WorldMapElement_cached[var2].method3377(); // L:
																				// 55
				}
			}
			return true; // L: 58
		}
	}

	public static void method2693(boolean var0) {
		if (NetCache.NetCache_socket != null) {
			try {
				Buffer var1 = new Buffer(4);
				var1.writeByte(var0 ? 2 : 3); // L: 47
				var1.writeMedium(0);
				NetCache.NetCache_socket.write(var1.array, 0, 4);
			} catch (IOException var4) {
				try {
					NetCache.NetCache_socket.close();
				} catch (Exception var3) {
				}
				++NetCache.NetCache_ioExceptions; // L: 56
				NetCache.NetCache_socket = null; // L: 57
			}
		}
	} // L: 59

	static String operatingSystemName;

	static int method7021(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.VIEWPORT_SETFOV) { // L: 3855
			class446.Interpreter_intStackSize -= 2; // L: 3856
			Client.field748 = (short) class20.method255(Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]); // L:
																																// 3857
			if (Client.field748 <= 0) { // L: 3858
				Client.field748 = 256;
			}
			Client.field749 = (short) class20.method255(Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]); // L:
																																	// 3859
			if (Client.field749 <= 0) { // L: 3860
				Client.field749 = 256;
			}
			return 1; // L: 3861
		} else if (var0 == ScriptOpcodes.VIEWPORT_SETZOOM) { // L: 3863
			class446.Interpreter_intStackSize -= 2; // L: 3864
			Client.zoomHeight = (short) Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																												// 3865
			if (Client.zoomHeight <= 0) { // L: 3866
				Client.zoomHeight = 256;
			}
			Client.zoomWidth = (short) Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
			// 3867
			if (Client.zoomWidth <= 0) { // L: 3868
				Client.zoomWidth = 320;
			}
			return 1; // L: 3869
		} else if (var0 == ScriptOpcodes.VIEWPORT_CLAMPFOV) { // L: 3871
			class446.Interpreter_intStackSize -= 4; // L: 3872
			Client.field752 = (short) Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																											// 3873
			if (Client.field752 <= 0) { // L: 3874
				Client.field752 = 1;
			}
			Client.field753 = (short) Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
			// 3875
			if (Client.field753 <= 0) { // L: 3876
				Client.field753 = 32767;
			} else if (Client.field753 < Client.field752) { // L: 3877
				Client.field753 = Client.field752;
			}
			Client.field754 = (short) Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 2]; // L:
			// 3878
			if (Client.field754 <= 0) { // L: 3879
				Client.field754 = 1;
			}
			Client.field755 = (short) Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 3]; // L:
			// 3880
			if (Client.field755 <= 0) { // L: 3881
				Client.field755 = 32767;
			} else if (Client.field755 < Client.field754) { // L: 3882
				Client.field755 = Client.field754;
			}
			return 1; // L: 3883
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETEFFECTIVESIZE) { // L: 3885
			if (Client.viewportWidget != null) { // L: 3886
				Static.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false); // L:
				// 3887
				Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.viewportWidth; // L:
				// 3888
				Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.viewportHeight; // L:
				// 3889
			} else {
				Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
																								// 3892
				Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
																								// 3893
			}
			return 1; // L: 3895
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETZOOM) { // L: 3897
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.zoomHeight; // L:
																											// 3898
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.zoomWidth; // L:
																											// 3899
			return 1; // L: 3900
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETFOV) { // L: 3902
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Static.method4350(Client.field748); // L:
																															// 3903
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Static.method4350(Client.field749); // L:
																															// 3904
			return 1; // L: 3905
		} else if (var0 == 6220) { // L: 3907
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																							// 3908
			return 1; // L: 3909
		} else if (var0 == 6221) { // L: 3911
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																							// 3912
			return 1; // L: 3913
		} else if (var0 == 6222) { // L: 3915
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Script.canvasWidth; // L:
																											// 3916
			return 1; // L: 3917
		} else if (var0 == 6223) { // L: 3919
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = class78.canvasHeight; // L:
																												// 3920
			return 1; // L: 3921
		} else {
			return 2; // L: 3923
		}
	}

	static int method4350(int var0) {
		return (int) ((Math.log((double) var0) / Interpreter.field845 - 7.0D) * 256.0D); // L:
																							// 3851
	}

	public static int method4349() {
		return ViewportMouse.ViewportMouse_entityCount; // L: 44
	}

	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden; // L: 12305
	}

	static final void setViewportShape(int var0, int var1, int var2, int var3, boolean var4) {
		if (var2 < 1) { // L: 4718
			var2 = 1;
		}
		if (var3 < 1) { // L: 4719
			var3 = 1;
		}
		int var5 = var3 - 334; // L: 4720
		int var6;
		if (var5 < 0) { // L: 4722
			var6 = Client.field748;
		} else if (var5 >= 100) { // L: 4723
			var6 = Client.field749;
		} else {
			var6 = (Client.field749 - Client.field748) * var5 / 100 + Client.field748; // L:
																						// 4724
		}
		int var7 = var3 * var6 * 512 / (var2 * 334); // L: 4725
		int var8;
		int var9;
		short var17;
		if (var7 < Client.field754) { // L: 4726
			var17 = Client.field754; // L: 4727
			var6 = var17 * var2 * 334 / (var3 * 512); // L: 4728
			if (var6 > Client.field753) { // L: 4729
				var6 = Client.field753; // L: 4730
				var8 = var3 * var6 * 512 / (var17 * 334); // L: 4731
				var9 = (var2 - var8) / 2; // L: 4732
				if (var4) { // L: 4733
					Rasterizer2D.Rasterizer2D_resetClip(); // L: 4734
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var9, var3, -16777216); // L:
																								// 4735
					Rasterizer2D.Rasterizer2D_fillRectangle(var0 + var2 - var9, var1, var9, var3, -16777216); // L:
																												// 4736
				}
				var0 += var9; // L: 4738
				var2 -= var9 * 2; // L: 4739
			}
		} else if (var7 > Client.field755) { // L: 4742
			var17 = Client.field755; // L: 4743
			var6 = var17 * var2 * 334 / (var3 * 512); // L: 4744
			if (var6 < Client.field752) { // L: 4745
				var6 = Client.field752; // L: 4746
				var8 = var17 * var2 * 334 / (var6 * 512); // L: 4747
				var9 = (var3 - var8) / 2; // L: 4748
				if (var4) { // L: 4749
					Rasterizer2D.Rasterizer2D_resetClip(); // L: 4750
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var9, -16777216); // L:
																								// 4751
					Rasterizer2D.Rasterizer2D_fillRectangle(var0, var3 + var1 - var9, var2, var9, -16777216); // L:
																												// 4752
				}
				var1 += var9; // L: 4754
				var3 -= var9 * 2; // L: 4755
			}
		}
		Client.viewportZoom = var3 * var6 / 334; // L: 4758
		if (var2 != Client.viewportWidth || var3 != Client.viewportHeight) { // L:
																				// 4759
			int[] var16 = new int[9]; // L: 4761
			for (var9 = 0; var9 < var16.length; ++var9) { // L: 4762
				int var10 = var9 * 32 + 15 + 128; // L: 4763
				int var11 = GZipDecompressor.method8314(var10); // L: 4764
				int var12 = Rasterizer3D.Rasterizer3D_sine[var10]; // L: 4765
				int var14 = var3 - 334; // L: 4768
				if (var14 < 0) { // L: 4769
					var14 = 0;
				} else if (var14 > 100) { // L: 4770
					var14 = 100;
				}
				int var15 = (Client.zoomWidth - Client.zoomHeight) * var14 / 100 + Client.zoomHeight; // L:
																										// 4771
				int var13 = var15 * var11 / 256; // L: 4772
				var16[var9] = var13 * var12 >> 16; // L: 4775
			}
			Scene.Scene_buildVisiblityMap(var16, 500, 800, var2 * 334 / var3, 334); // L:
																					// 4777
		}
		Client.viewportOffsetX = var0; // L: 4780
		Client.viewportOffsetY = var1; // L: 4781
		Client.viewportWidth = var2; // L: 4782
		Client.viewportHeight = var3; // L: 4783
	} // L: 4784

	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		class126.scrollBarSprites[0].drawAt(var0, var1); // L: 10751
		class126.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16); // L: 10752
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field556); // L:
																									// 10753
		int var5 = var3 * (var3 - 32) / var4; // L: 10754
		if (var5 < 8) { // L: 10755
			var5 = 8;
		}
		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3); // L: 10756
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field653); // L:
																									// 10757
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field553); // L:
																									// 10758
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field553); // L:
																										// 10759
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field553); // L:
																									// 10760
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field553); // L:
																									// 10761
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field558); // L:
																										// 10762
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field558); // L:
																											// 10763
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var5 + var6 + var1 + 15, 16, Client.field558); // L:
																											// 10764
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field558); // L:
		// 10765
	} // L: 10766

	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) { // L: 4466
			byte var2 = 4; // L: 4467
			int var3 = var2 + 6; // L: 4468
			int var4 = var2 + 6; // L: 4469
			int var5 = _Junk.fontPlain12.lineWidth(var0, 250); // L:
																					// 4470
			int var6 = _Junk.fontPlain12.lineCount(var0, 250) * 13; // L:
																						// 4471
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0); // L:
																															// 4472
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var6 + var2, 16777215); // L:
																																	// 4473
			_Junk.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0); // L:
			// 4474
			int var7 = var3 - var2; // L: 4475
			int var8 = var4 - var2; // L: 4476
			int var9 = var2 + var5 + var2; // L: 4477
			int var10 = var2 + var2 + var6; // L: 4478
			int var11;
			for (var11 = 0; var11 < Client.rootWidgetCount; ++var11) { // L:
																		// 4480
				if (Client.rootWidgetXs[var11] + Client.rootWidgetWidths[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var8 + var10) { // L:
																																																															// 4481
					Client.field703[var11] = true;
				}
			}
			if (var1) { // L: 4484
				Message.rasterProvider.drawFull(0, 0); // L: 4485
			} else {
				var11 = var3; // L: 4488
				int var12 = var4; // L: 4489
				int var13 = var5; // L: 4490
				int var14 = var6; // L: 4491
				for (int var15 = 0; var15 < Client.rootWidgetCount; ++var15) { // L:
																				// 4493
					if (Client.rootWidgetXs[var15] + Client.rootWidgetWidths[var15] > var11 && Client.rootWidgetXs[var15] < var13 + var11 && Client.rootWidgetYs[var15] + Client.rootWidgetHeights[var15] > var12 && Client.rootWidgetYs[var15] < var14 + var12) { // L:
																																																																	// 4494
						Client.field704[var15] = true;
					}
				}
			}
		}
	} // L: 4498

	static final int method3827(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1; // L:
																						// 900
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16); // L: 901
	}

	static boolean mouseCam;

	public static HitSplatDefinition method2800(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition) HitSplatDefinition.HitSplatDefinition_cached.get((long) var0); // L:
		// 46
		if (var1 != null) { // L: 47
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0); // L:
																							// 48
			var1 = new HitSplatDefinition(); // L: 49
			if (var2 != null) { // L: 50
				var1.decode(new Buffer(var2));
			}
			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long) var0); // L:
																					// 51
			return var1; // L: 52
		}
	}

	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">"; // L: 22
	}

	public static int method2763(int var0, int var1, int var2) {
		var2 &= 3; // L: 9
		if (var2 == 0) { // L: 10
			return var0;
		} else if (var2 == 1) { // L: 11
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 : 7 - var1; // L: 12 13
		}
	}

	static void method2699(SpritePixels var0, int var1, int var2, int var3) {
		DemotingHashTable var4 = WorldMapRegion.WorldMapRegion_cachedSprites; // L:
																				// 47
		long var6 = (long) (var3 << 16 | var1 << 8 | var2); // L: 51
		var4.put(var0, var6, var0.pixels.length * 4); // L: 53
	} // L: 54

	public static void method2700(AbstractArchive var0) {
		class437.field4675 = var0; // L: 20
	} // L: 21

	static final void method2632(String var0) {
		PacketBufferNode var1 = EnumComposition.getPacketBufferNode(ClientPacket.field2944, Client.packetWriter.isaacCipher); // L:
																																// 195
		var1.packetBuffer.writeByte(ScriptEvent.stringCp1252NullTerminatedByteSize(var0)); // L:
																							// 196
		var1.packetBuffer.writeStringCp1252NullTerminated(var0); // L: 197
		Client.packetWriter.addNode(var1); // L: 198
	} // L: 199

	static IndexedSprite field1427;

	public static void method2727(String var0, String var1, int var2, int var3) throws IOException {
		class142.idxCount = var3; // L: 40
		class93.cacheGamebuild = var2; // L: 41
		try {
			operatingSystemName = System.getProperty("os.name"); // L:
																			// 43
		} catch (Exception var15) { // L: 45
			operatingSystemName = "Unknown"; // L: 46
		}
		NetFileRequest.formattedOperatingSystemName = operatingSystemName.toLowerCase(); // L:
																									// 48
		try {
			Static.userHomeDirectory = System.getProperty("user.home"); // L:
																			// 50
			if (Static.userHomeDirectory != null) { // L: 51
				Static.userHomeDirectory = Static.userHomeDirectory + "/";
			}
		} catch (Exception var14) { // L: 53
		}
		try {
			if (NetFileRequest.formattedOperatingSystemName.startsWith("win")) { // L:
																					// 55
				if (Static.userHomeDirectory == null) { // L: 56
					Static.userHomeDirectory = System.getenv("USERPROFILE");
				}
			} else if (Static.userHomeDirectory == null) { // L: 59
				Static.userHomeDirectory = System.getenv("HOME");
			}
			if (Static.userHomeDirectory != null) { // L: 61
				Static.userHomeDirectory = Static.userHomeDirectory + "/";
			}
		} catch (Exception var13) { // L: 63
		}
		if (Static.userHomeDirectory == null) { // L: 64
			Static.userHomeDirectory = "~/";
		}
		Fonts.cacheParentPaths = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Static.userHomeDirectory, "/tmp/", ""}; // L:
																																						// 65
		JagexCache.cacheSubPaths = new String[]{".jagex_cache_" + class93.cacheGamebuild, ".file_store_" + class93.cacheGamebuild}; // L:
																																	// 66
		int var9 = 0;
		label129 : while (var9 < 4) {
			JagexCache.cacheDir = Friend.method6630(var0, var1, var9); // L: 68
			if (!JagexCache.cacheDir.exists()) { // L: 69
				JagexCache.cacheDir.mkdirs();
			}
			File[] var5 = JagexCache.cacheDir.listFiles(); // L: 70
			if (var5 == null) { // L: 71
				break;
			}
			File[] var6 = var5; // L: 73
			int var7 = 0;
			while (true) {
				if (var7 >= var6.length) {
					break label129;
				}
				File var8 = var6[var7]; // L: 75
				if (!Varcs.method2474(var8, false)) { // L: 77
					++var9; // L: 67
					break;
				}
				++var7; // L: 74
			}
		}
		MilliClock.method3309(JagexCache.cacheDir); // L: 84
		try {
			File var4 = new File(Static.userHomeDirectory, "random.dat"); // L:
																			// 87
			int var11;
			if (var4.exists()) { // L: 88
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var4, "rw", 25L), 24, 0); // L:
																											// 89
			} else {
				label111 : for (int var10 = 0; var10 < JagexCache.cacheSubPaths.length; ++var10) { // L:
																									// 92
					for (var11 = 0; var11 < Fonts.cacheParentPaths.length; ++var11) { // L:
																						// 93
						File var12 = new File(Fonts.cacheParentPaths[var11] + JagexCache.cacheSubPaths[var10] + File.separatorChar + "random.dat"); // L:
																																					// 94
						if (var12.exists()) { // L: 95
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var12, "rw", 25L), 24, 0); // L:
							// 96
							break label111; // L: 97
						}
					}
				}
			}
			if (JagexCache.JagexCache_randomDat == null) { // L: 102
				RandomAccessFile var17 = new RandomAccessFile(var4, "rw"); // L:
																			// 103
				var11 = var17.read(); // L: 104
				var17.seek(0L); // L: 105
				var17.write(var11); // L: 106
				var17.seek(0L); // L: 107
				var17.close(); // L: 108
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var4, "rw", 25L), 24, 0); // L:
																											// 109
			}
		} catch (IOException var16) { // L: 112
		}
		JagexCache.JagexCache_dat2File = new BufferedFile(new AccessFile(GameEngine.getFile("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0); // L:
																																					// 114
		JagexCache.JagexCache_idx255File = new BufferedFile(new AccessFile(GameEngine.getFile("main_file_cache.idx255"), "rw", 1048576L), 6000, 0); // L:
																																					// 115
		class359.JagexCache_idxFiles = new BufferedFile[class142.idxCount]; // L:
																			// 116
		for (var9 = 0; var9 < class142.idxCount; ++var9) { // L: 117
			class359.JagexCache_idxFiles[var9] = new BufferedFile(new AccessFile(GameEngine.getFile("main_file_cache.idx" + var9), "rw", 1048576L), 6000, 0); // L:
			// 118
		}
	} // L: 120

	static int method2719() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) { // L:
																											// 1644
			int var0 = 0; // L: 1645
			for (int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) { // L:
																			// 1646
				var0 += ((ArchiveLoader) Client.archiveLoaders.get(var1)).loadedCount; // L:
																						// 1647
			}
			return var0 * 10000 / Client.field626; // L: 1649
		} else {
			return 10000;
		}
	}

	public static int getVarbit(int var0) {
		VarbitComposition var1 = WorldMapCacheName.method5054(var0); // L: 24
		int var2 = var1.baseVar; // L: 25
		int var3 = var1.startBit; // L: 26
		int var4 = var1.endBit; // L: 27
		int var5 = Varps.Varps_masks[var4 - var3]; // L: 28
		return Varps.Varps_main[var2] >> var3 & var5; // L: 29
	}

	static int method2757(int var0, int var1) {
		for (int var2 = 0; var2 < 8; ++var2) { // L: 1153
			if (var1 <= var0 + 30) { // L: 1154
				return var2; // L: 1155
			}
			var0 += 30; // L: 1157
			var0 += var2 != 1 && var2 != 3 ? 5 : 20; // L: 1158
		}
		return 0; // L: 1160
	}

	static void method2738() {
		if (class136.loadWorlds()) { // L: 1924
			Login.worldSelectOpen = true; // L: 1925
			Login.worldSelectPage = 0; // L: 1926
			Login.worldSelectPagesCount = 0; // L: 1927
		}
	} // L: 1929

	static int method2742(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) { // L: 3535
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.publicChatMode; // L:
			// 3536
			return 1; // L: 3537
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) { // L: 3539
			class446.Interpreter_intStackSize -= 3; // L: 3540
			Client.publicChatMode = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																											// 3541
			class339.privateChatMode = Ignored.method6780(Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]); // L:
																																	// 3542
			if (class339.privateChatMode == null) { // L: 3543
				class339.privateChatMode = PrivateChatMode.field4817;
			}
			Client.tradeChatMode = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 2]; // L:
																											// 3544
			PacketBufferNode var13 = EnumComposition.getPacketBufferNode(ClientPacket.field2916, Client.packetWriter.isaacCipher); // L:
																																	// 3546
			var13.packetBuffer.writeByte(Client.publicChatMode); // L: 3547
			var13.packetBuffer.writeByte(class339.privateChatMode.field4820); // L:
																				// 3548
			var13.packetBuffer.writeByte(Client.tradeChatMode); // L: 3549
			Client.packetWriter.addNode(var13); // L: 3550
			return 1; // L: 3551
		} else {
			PacketBufferNode var6;
			int var7;
			String var8;
			int var9;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) { // L: 3553
				var8 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
																										// 3554
				class446.Interpreter_intStackSize -= 2; // L: 3555
				var7 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																							// 3556
				var9 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																								// 3557
				var6 = EnumComposition.getPacketBufferNode(ClientPacket.field2949, Client.packetWriter.isaacCipher); // L:
				// 3559
				var6.packetBuffer.writeByte(ScriptEvent.stringCp1252NullTerminatedByteSize(var8) + 2); // L:
																										// 3560
				var6.packetBuffer.writeStringCp1252NullTerminated(var8); // L:
																			// 3561
				var6.packetBuffer.writeByte(var7 - 1); // L: 3562
				var6.packetBuffer.writeByte(var9); // L: 3563
				Client.packetWriter.addNode(var6); // L: 3564
				return 1; // L: 3565
			} else {
				int var3;
				Message var5;
				if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) { // L:
																			// 3567
					class446.Interpreter_intStackSize -= 2; // L: 3568
					var3 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																								// 3569
					var7 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																									// 3570
					var5 = class18.Messages_getByChannelAndID(var3, var7); // L:
																			// 3571
					if (var5 != null) { // L: 3572
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var5.count; // L:
						// 3573
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var5.cycle; // L:
						// 3574
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.sender != null ? var5.sender : ""; // L:
																																						// 3575
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.prefix != null ? var5.prefix : ""; // L:
																																						// 3576
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.text != null ? var5.text : ""; // L:
																																					// 3577
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var5.isFromFriend() ? 1 : (var5.isFromIgnored() ? 2 : 0); // L:
																																								// 3578
					} else {
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
																										// 3581
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																										// 3582
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
						// 3583
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
						// 3584
						Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
						// 3585
						Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																										// 3586
					}
					return 1; // L: 3588
				} else {
					Message var4;
					if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) { // L:
																		// 3590
						var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																										// 3591
						var4 = UserComparator7.Messages_getMessage(var3); // L:
																			// 3592
						if (var4 != null) { // L: 3593
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var4.type; // L:
							// 3594
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var4.cycle; // L:
							// 3595
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.sender != null ? var4.sender : ""; // L:
																																							// 3596
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.prefix != null ? var4.prefix : ""; // L:
																																							// 3597
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.text != null ? var4.text : ""; // L:
																																						// 3598
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var4.isFromFriend() ? 1 : (var4.isFromIgnored() ? 2 : 0); // L:
																																									// 3599
						} else {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
																											// 3602
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 3603
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 3604
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 3605
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
							// 3606
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																											// 3607
						}
						return 1; // L: 3609
					} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) { // L:
																				// 3611
						if (class339.privateChatMode == null) { // L: 3612
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = class339.privateChatMode.field4820; // L:
																																			// 3613
						}
						return 1; // L: 3614
					} else {
						PacketBufferNode var12;
						if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) { // L: 3616
							var8 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
							// 3617
							var7 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																											// 3618
							var12 = PlayerComposition.method5600(var7, var8, class134.clientLanguage, -1); // L:
																											// 3619
							Client.packetWriter.addNode(var12); // L: 3620
							return 1; // L: 3621
						} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) { // L:
																				// 3623
							Interpreter.Interpreter_stringStackSize -= 2; // L:
																			// 3624
							var8 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize]; // L:
							// 3625
							String var11 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1]; // L:
																																// 3626
							var12 = EnumComposition.getPacketBufferNode(ClientPacket.field2932, Client.packetWriter.isaacCipher); // L:
																																	// 3628
							var12.packetBuffer.writeShort(0); // L: 3629
							int var10 = var12.packetBuffer.offset; // L: 3630
							var12.packetBuffer.writeStringCp1252NullTerminated(var8); // L:
																						// 3631
							_Junk.method720(var12.packetBuffer, var11); // L:
																			// 3632
							var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10); // L:
																									// 3633
							Client.packetWriter.addNode(var12); // L: 3634
							return 1; // L: 3635
						} else if (var0 == ScriptOpcodes.CHAT_SENDCLAN) { // L:
																			// 3637
							var8 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
							// 3638
							class446.Interpreter_intStackSize -= 2; // L: 3639
							var7 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																										// 3640
							var9 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																											// 3641
							var6 = PlayerComposition.method5600(var7, var8, class134.clientLanguage, var9); // L:
																											// 3642
							Client.packetWriter.addNode(var6); // L: 3643
							return 1; // L: 3644
						} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) { // L:
																			// 3646
							if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) { // L:
																				// 3653
								Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.tradeChatMode; // L:
																																	// 3654
								return 1; // L: 3655
							} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) { // L:
																						// 3657
								var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																												// 3658
								Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = ClanChannelMember.Messages_getHistorySize(var3); // L:
																																								// 3659
								return 1; // L: 3660
							} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) { // L:
																				// 3662
								var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																												// 3663
								Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = DirectByteArrayCopier.Messages_getLastChatID(var3); // L:
																																								// 3664
								return 1; // L: 3665
							} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) { // L:
																				// 3667
								var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																												// 3668
								Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = _Junk.method305(var3); // L:
																																						// 3669
								return 1; // L: 3670
							} else if (var0 == ScriptOpcodes.DOCHEAT) { // L:
																		// 3672
								var8 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
								// 3673
								doCheat(var8); // L: 3674
								return 1; // L: 3675
							} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) { // L:
																						// 3677
								Client.field716 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize].toLowerCase().trim(); // L:
																																						// 3678
								return 1; // L: 3679
							} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) { // L:
																						// 3681
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.field716; // L:
																																		// 3682
								return 1; // L: 3683
							} else if (var0 == ScriptOpcodes.WRITECONSOLE) { // L:
																				// 3685
								var8 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
								// 3686
								System.out.println(var8); // L: 3687
								return 1; // L: 3688
							} else if (var0 == 5024) { // L: 3690
								--class446.Interpreter_intStackSize; // L: 3691
								return 1; // L: 3692
							} else if (var0 == 5025) { // L: 3694
								++class446.Interpreter_intStackSize; // L: 3695
								return 1; // L: 3696
							} else if (var0 == 5030) { // L: 3698
								class446.Interpreter_intStackSize -= 2; // L:
																		// 3699
								var3 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																											// 3700
								var7 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
								// 3701
								var5 = class18.Messages_getByChannelAndID(var3, var7); // L:
																						// 3702
								if (var5 != null) { // L: 3703
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var5.count; // L:
																															// 3704
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var5.cycle; // L:
																															// 3705
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.sender != null ? var5.sender : ""; // L:
																																									// 3706
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.prefix != null ? var5.prefix : ""; // L:
																																									// 3707
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.text != null ? var5.text : ""; // L:
																																								// 3708
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var5.isFromFriend() ? 1 : (var5.isFromIgnored() ? 2 : 0); // L:
																																											// 3709
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3710
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3711
								} else {
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
									// 3714
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3715
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3716
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3717
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3718
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3719
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3720
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3721
								}
								return 1; // L: 3723
							} else if (var0 == 5031) { // L: 3725
								var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																												// 3726
								var4 = UserComparator7.Messages_getMessage(var3); // L:
																					// 3727
								if (var4 != null) { // L: 3728
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var4.type; // L:
																															// 3729
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var4.cycle; // L:
																															// 3730
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.sender != null ? var4.sender : ""; // L:
																																									// 3731
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.prefix != null ? var4.prefix : ""; // L:
																																									// 3732
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var4.text != null ? var4.text : ""; // L:
																																								// 3733
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = var4.isFromFriend() ? 1 : (var4.isFromIgnored() ? 2 : 0); // L:
																																											// 3734
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3735
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3736
								} else {
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
									// 3739
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3740
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3741
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3742
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3743
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3744
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																																// 3745
									Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
									// 3746
								}
								return 1; // L: 3748
							} else {
								return 2; // L: 3750
							}
						} else {
							if (class101.localPlayer != null && class101.localPlayer.username != null) { // L:
																											// 3648
								var8 = class101.localPlayer.username.getName();
							} else {
								var8 = ""; // L: 3649
							}
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8; // L:
							// 3650
							return 1; // L: 3651
						}
					}
				}
			}
		}
	}

	static int method2744(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.CAM_FORCEANGLE) { // L: 3799
			class446.Interpreter_intStackSize -= 2; // L: 3800
			var3 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize]; // L:
																						// 3801
			int var4 = Interpreter.Interpreter_intStack[class446.Interpreter_intStackSize + 1]; // L:
																								// 3802
			if (!Client.isCameraLocked) { // L: 3803
				Client.camAngleX = var3; // L: 3804
				Client.camAngleY = var4; // L: 3805
			}
			return 1; // L: 3807
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_XA) { // L: 3809
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.camAngleX; // L:
																											// 3810
			return 1; // L: 3811
		} else if (var0 == ScriptOpcodes.CAM_GETANGLE_YA) { // L: 3813
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.camAngleY; // L:
																											// 3814
			return 1; // L: 3815
		} else if (var0 == ScriptOpcodes.CAM_SETFOLLOWHEIGHT) { // L: 3817
			var3 = Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																							// 3818
			if (var3 < 0) { // L: 3819
				var3 = 0;
			}
			Client.camFollowHeight = var3; // L: 3820
			return 1; // L: 3821
		} else if (var0 == ScriptOpcodes.CAM_GETFOLLOWHEIGHT) { // L: 3823
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = Client.camFollowHeight; // L:
			// 3824
			return 1; // L: 3825
		} else {
			return 2; // L: 3827
		}
	}

	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) { // L: 10669
			Widget var6 = var0[var5]; // L: 10670
			if (var6 != null && var6.parentId == var1) { // L: 10671 10672
				_Junk.alignWidgetSize(var6, var2, var3, var4); // L: 10673
				class240.alignWidgetPosition(var6, var2, var3); // L: 10674
				if (var6.scrollX > var6.scrollWidth - var6.width) { // L: 10675
					var6.scrollX = var6.scrollWidth - var6.width;
				}
				if (var6.scrollX < 0) { // L: 10676
					var6.scrollX = 0;
				}
				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height; // L: 10677
				}
				if (var6.scrollY < 0) { // L: 10678
					var6.scrollY = 0;
				}
				if (var6.type == 0) { // L: 10679
					BufferedNetSocket.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}
	} // L: 10681

	static class436 method2813(int var0) {
		class436 var1 = (class436) Client.Widget_cachedModels.get((long) var0); // L:
																				// 12477
		if (var1 == null) { // L: 12478
			var1 = new class436(class132.field1588, class285.method5516(var0), HealthBarUpdate.method2199(var0)); // L:
			// 12479
			Client.Widget_cachedModels.put(var1, (long) var0); // L: 12480
		}
		return var1; // L: 12482
	}

	static String userHomeDirectory;
	static java.awt.Font fontHelvetica13;

}
