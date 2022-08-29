package osrs;

public class class132 extends class128 {
	
	static Archive field1588;
	
	int field1590;
	byte field1589;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class132(class131 var1) {
		this.this$0 = var1;
		this.field1590 = -1; // L: 128
	} // L: 131
	
	void vmethod3150(Buffer var1) {
		this.field1590 = var1.readUnsignedShort(); // L: 134
		this.field1589 = var1.readByte(); // L: 135
	} // L: 136
	
	void vmethod3149(ClanSettings var1) {
		var1.method2961(this.field1590, this.field1589); // L: 139
	} // L: 140
	
	static void method2887() {
		if (class121.worldMap != null) { // L: 4337
			class121.worldMap.method7192(PacketWriter.Client_plane, (class101.localPlayer.x >> 7) + class28.baseX, (class101.localPlayer.y >> 7) + WorldMapLabelSize.baseY, false); // L:
																																													// 4338
			class121.worldMap.loadCache(); // L: 4339
		}
	} // L: 4341
}
