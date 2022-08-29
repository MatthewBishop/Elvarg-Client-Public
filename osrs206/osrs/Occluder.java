package osrs;

public final class Occluder {
	
	static PlatformInfo platformInfo;
	
	int minTileX;
	
	int maxTileX;
	
	int minTileY;
	
	int maxTileY;
	
	int type;
	
	int minX;
	
	int maxX;
	
	int minZ;
	
	int maxZ;
	
	int minY;
	
	int maxY;
	
	int field2470;
	
	int field2472;
	
	int field2466;
	
	int field2467;
	
	int field2468;
	
	int field2462;
	
	int field2473;
	Occluder() {
	} // L: 23
	
	static final void method4354() {
		PacketBufferNode var0 = EnumComposition.getPacketBufferNode(ClientPacket.field2987, Client.packetWriter.isaacCipher); // L:
																																// 11980
		Client.packetWriter.addNode(var0); // L: 11981
		Interpreter.field842 = true; // L: 11982
		for (InterfaceParent var1 = (InterfaceParent) Client.interfaceParents.first(); var1 != null; var1 = (InterfaceParent) Client.interfaceParents.next()) { // L:
																																								// 11983
			if (var1.type == 0 || var1.type == 3) { // L: 11984
				_Junk.closeInterface(var1, true);
			}
		}
		if (Client.meslayerContinueWidget != null) { // L: 11986
			ChatChannel.invalidateWidget(Client.meslayerContinueWidget); // L:
																			// 11987
			Client.meslayerContinueWidget = null; // L: 11988
		}
		Interpreter.field842 = false; // L: 11990
	} // L: 11991
}
