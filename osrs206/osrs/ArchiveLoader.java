package osrs;
public class ArchiveLoader {
	
	static Bounds field1022;
	
	final Archive archive;
	
	final int groupCount;
	
	int loadedCount;
	
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0; // L: 9
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	} // L: 14
	
	boolean isLoaded() {
		this.loadedCount = 0; // L: 17
		for (int var1 = 0; var1 < this.groupCount; ++var1) { // L: 18
			if (!this.archive.method5806(var1) || this.archive.method5805(var1)) {
				++this.loadedCount; // L: 19
			}
		}
		return this.loadedCount >= this.groupCount; // L: 21
	}
	
	public static int method2075(int var0) {
		return var0 != 0 && var0 != 1 ? -1 : 0; // L: 12 13 15
	}
	
	static int method2073(int var0, Script var1, boolean var2) {
		if (var0 != 3700 && var0 != 3701) { // L: 2707
			if (var0 == 3702) { // L: 2712
				++class446.Interpreter_intStackSize; // L: 2713
				return 1; // L: 2714
			} else {
				return 2; // L: 2716
			}
		} else {
			--class446.Interpreter_intStackSize; // L: 2708
			--Interpreter.Interpreter_stringStackSize; // L: 2709
			return 1; // L: 2710
		}
	}
	
	static final void clanKickUser(String var0) {
		if (Huffman.friendsChat != null) { // L: 12225
			PacketBufferNode var1 = EnumComposition.getPacketBufferNode(ClientPacket.field2923, Client.packetWriter.isaacCipher); // L:
																																	// 12226
			var1.packetBuffer.writeByte(ScriptEvent.stringCp1252NullTerminatedByteSize(var0)); // L:
																								// 12227
			var1.packetBuffer.writeStringCp1252NullTerminated(var0); // L: 12228
			Client.packetWriter.addNode(var1); // L: 12229
		}
	} // L: 12230
}
