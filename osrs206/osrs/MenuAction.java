package osrs;
public class MenuAction {
	
	int param0;
	
	int param1;
	
	int opcode;
	
	int identifier;
	String action;
	MenuAction() {
	} // L: 12524
	
	static final void checkIfMinimapClicked(Widget var0, int var1, int var2) {
		if (Client.minimapState == 0 || Client.minimapState == 3) { // L: 3856
			if (!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !Static.mouseCam && MouseHandler.MouseHandler_lastButton == 4)) { // L:
																																						// 3857
				SpriteMask var3 = var0.getSpriteMask(true); // L: 3858
				if (var3 == null) { // L: 3859
					return;
				}
				int var4 = MouseHandler.MouseHandler_lastPressedX - var1; // L:
																			// 3860
				int var5 = MouseHandler.MouseHandler_lastPressedY - var2; // L:
																			// 3861
				if (var3.contains(var4, var5)) { // L: 3862
					var4 -= var3.width / 2; // L: 3863
					var5 -= var3.height / 2; // L: 3864
					int var6 = Client.camAngleY & 2047; // L: 3865
					int var7 = Rasterizer3D.Rasterizer3D_sine[var6]; // L: 3866
					int var8 = Rasterizer3D.Rasterizer3D_cosine[var6]; // L:
																		// 3867
					int var9 = var8 * var4 + var5 * var7 >> 11; // L: 3868
					int var10 = var5 * var8 - var4 * var7 >> 11; // L: 3869
					int var11 = var9 + class101.localPlayer.x >> 7; // L: 3870
					int var12 = class101.localPlayer.y - var10 >> 7; // L: 3871
					PacketBufferNode var13 = EnumComposition.getPacketBufferNode(ClientPacket.field2913, Client.packetWriter.isaacCipher); // L:
																																			// 3873
					var13.packetBuffer.writeByte(18); // L: 3874
					var13.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? (KeyHandler.KeyHandler_pressedKeys[81] ? 2 : 1) : 0); // L:
																																				// 3875
					var13.packetBuffer.writeShort(var11 + class28.baseX); // L:
																			// 3876
					var13.packetBuffer.writeIntME(var12 + WorldMapLabelSize.baseY); // L:
																					// 3877
					var13.packetBuffer.writeByte(var4); // L: 3878
					var13.packetBuffer.writeByte(var5); // L: 3879
					var13.packetBuffer.writeShort(Client.camAngleY); // L: 3880
					var13.packetBuffer.writeByte(57); // L: 3881
					var13.packetBuffer.writeByte(0); // L: 3882
					var13.packetBuffer.writeByte(0); // L: 3883
					var13.packetBuffer.writeByte(89); // L: 3884
					var13.packetBuffer.writeShort(class101.localPlayer.x); // L:
																			// 3885
					var13.packetBuffer.writeShort(class101.localPlayer.y); // L:
																			// 3886
					var13.packetBuffer.writeByte(63); // L: 3887
					Client.packetWriter.addNode(var13); // L: 3888
					Client.destinationX = var11; // L: 3889
					Client.destinationY = var12; // L: 3890
				}
			}
		}
	} // L: 3893
}
