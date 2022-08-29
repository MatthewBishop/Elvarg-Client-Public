package osrs;
public class class147 extends class128 {
	
	public static AbstractArchive SpotAnimationDefinition_modelArchive;
	
	int field1686;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class147(class131 var1) {
		this.this$0 = var1;
		this.field1686 = -1; // L: 144
	} // L: 146
	
	void vmethod3150(Buffer var1) {
		this.field1686 = var1.readUnsignedShort(); // L: 149
	} // L: 150
	
	void vmethod3149(ClanSettings var1) {
		var1.method3016(this.field1686); // L: 153
	} // L: 154
}
