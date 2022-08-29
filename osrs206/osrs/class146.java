package osrs;
public class class146 extends class128 {
	
	static int field1682;
	
	int field1683;
	
	int field1679;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class146(class131 var1) {
		this.this$0 = var1; // L: 271
	}
	
	void vmethod3150(Buffer var1) {
		this.field1683 = var1.readInt(); // L: 274
		this.field1679 = var1.readInt(); // L: 275
	} // L: 276
	
	void vmethod3149(ClanSettings var1) {
		var1.method2965(this.field1683, this.field1679); // L: 279
	} // L: 280
	
	public static void method3082(AbstractArchive var0) {
		FloorOverlayDefinition.FloorOverlayDefinition_archive = var0; // L: 26
	} // L: 27
}
