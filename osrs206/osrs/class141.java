package osrs;
public class class141 extends class144 {
	
	static int oculusOrbFocalPointY;
	
	int field1659;
	byte field1660;
	
	int field1658;
	String field1656;
	// $FF: synthetic field
	
	final class145 this$0;
	
	class141(class145 var1) {
		this.this$0 = var1;
		this.field1659 = -1; // L: 125
	} // L: 130
	
	void vmethod3137(Buffer var1) {
		var1.readUnsignedByte(); // L: 133
		this.field1659 = var1.readUnsignedShort(); // L: 134
		this.field1660 = var1.readByte(); // L: 135
		this.field1658 = var1.readUnsignedShort(); // L: 136
		var1.readLong(); // L: 137
		this.field1656 = var1.readStringCp1252NullTerminated(); // L: 138
		var1.readUnsignedByte(); // L: 139
	} // L: 140
	
	void vmethod3138(ClanChannel var1) {
		ClanChannelMember var2 = (ClanChannelMember) var1.members.get(this.field1659); // L:
																						// 143
		var2.rank = this.field1660; // L: 144
		var2.world = this.field1658; // L: 145
		var2.username = new Username(this.field1656); // L: 146
	} // L: 147
	
	public static int method3048(int var0) {
		return (var0 & class438.field4680) - 1; // L: 26
	}
	
	public static int method3044(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) { // L: 38
			int var6 = var3; // L: 39
			var3 = var4; // L: 40
			var4 = var6; // L: 41
		}
		var2 &= 3; // L: 43
		if (var2 == 0) { // L: 44
			return var1;
		} else if (var2 == 1) { // L: 45
			return 7 - var0 - (var3 - 1);
		} else {
			return var2 == 2 ? 7 - var1 - (var4 - 1) : var0; // L: 46
		}
	}
	
	public static void method3047() {
		ObjectComposition.ObjectDefinition_cached.clear(); // L: 429
		ObjectComposition.ObjectDefinition_cachedModelData.clear(); // L: 430
		ObjectComposition.ObjectDefinition_cachedEntities.clear(); // L: 431
		ObjectComposition.ObjectDefinition_cachedModels.clear(); // L: 432
	} // L: 433
}
