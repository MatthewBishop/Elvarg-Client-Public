package osrs;

public class PacketBufferNode extends Node {
	
	public static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
	
	public static int PacketBufferNode_packetBufferNodeCount;
	
	public static int ItemDefinition_fileCount;
	
	public ClientPacket clientPacket;
	
	public int clientPacketLength;
	
	public PacketBuffer packetBuffer;
	
	public int index;
	static {
		PacketBufferNode_packetBufferNodes = new PacketBufferNode[300]; // L: 13
		PacketBufferNode_packetBufferNodeCount = 0; // L: 14
	}
	
	public void release() {
		if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) { // L:
																									// 61
			PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this; // L:
																										// 62
		}
	} // L: 63
	
	public static void method5202() {
		class33.reflectionChecks = new IterableNodeDeque(); // L: 24
	} // L: 25
	
	public static void method5200(int var0, int var1) {
		VarbitComposition var2 = WorldMapCacheName.method5054(var0); // L: 33
		int var3 = var2.baseVar; // L: 34
		int var4 = var2.startBit; // L: 35
		int var5 = var2.endBit; // L: 36
		int var6 = Varps.Varps_masks[var5 - var4]; // L: 37
		if (var1 < 0 || var1 > var6) { // L: 38
			var1 = 0;
		}
		var6 <<= var4; // L: 39
		Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6; // L:
																						// 40
	} // L: 41
	
	static char method5203(char var0) {
		switch (var0) { // L: 93
			case ' ' :
			case '-' :
			case '_' :
			case ' ' :
				return '_'; // L: 145
			case '#' :
			case '[' :
			case ']' :
				return var0; // L: 157
			case 'À' :
			case 'Á' :
			case 'Â' :
			case 'Ã' :
			case 'Ä' :
			case 'à' :
			case 'á' :
			case 'â' :
			case 'ã' :
			case 'ä' :
				return 'a'; // L: 104
			case 'Ç' :
			case 'ç' :
				return 'c'; // L: 153
			case 'È' :
			case 'É' :
			case 'Ê' :
			case 'Ë' :
			case 'è' :
			case 'é' :
			case 'ê' :
			case 'ë' :
				return 'e'; // L: 129
			case 'Í' :
			case 'Î' :
			case 'Ï' :
			case 'í' :
			case 'î' :
			case 'ï' :
				return 'i'; // L: 120
			case 'Ñ' :
			case 'ñ' :
				return 'n'; // L: 160
			case 'Ò' :
			case 'Ó' :
			case 'Ô' :
			case 'Õ' :
			case 'Ö' :
			case 'ò' :
			case 'ó' :
			case 'ô' :
			case 'õ' :
			case 'ö' :
				return 'o'; // L: 140
			case 'Ù' :
			case 'Ú' :
			case 'Û' :
			case 'Ü' :
			case 'ù' :
			case 'ú' :
			case 'û' :
			case 'ü' :
				return 'u'; // L: 113
			case 'ß' :
				return 'b'; // L: 147
			case 'ÿ' :
			case 'Ÿ' :
				return 'y'; // L: 150
			default :
				return Character.toLowerCase(var0); // L: 162
		}
	}
	
	public static void method5194() {
		NPCComposition.NpcDefinition_cached.clear(); // L: 291
		NPCComposition.NpcDefinition_cachedModels.clear(); // L: 292
	} // L: 293
}
