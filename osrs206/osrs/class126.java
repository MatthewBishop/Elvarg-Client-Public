package osrs;
import java.util.Iterator;
public class class126 extends class128 {
	
	public static AbstractArchive Widget_modelsArchive;
	
	static IndexedSprite[] worldSelectFlagSprites;
	
	static IndexedSprite[] scrollBarSprites;
	
	long field1562;
	String field1559;
	// $FF: synthetic field
	
	final class131 this$0;
	
	class126(class131 var1) {
		this.this$0 = var1;
		this.field1562 = -1L; // L: 74
		this.field1559 = null; // L: 75
	} // L: 77
	
	void vmethod3150(Buffer var1) {
		if (var1.readUnsignedByte() != 255) { // L: 80
			--var1.offset; // L: 81
			this.field1562 = var1.readLong(); // L: 82
		}
		this.field1559 = var1.readStringCp1252NullTerminatedOrNull(); // L: 84
	} // L: 85
	
	void vmethod3149(ClanSettings var1) {
		var1.method2956(this.field1562, this.field1559, 0); // L: 88
	} // L: 89
	
	static final void FriendSystem_invalidateIgnoreds() {
		Iterator var0 = Messages.Messages_hashTable.iterator(); // L: 12195
		while (var0.hasNext()) {
			Message var1 = (Message) var0.next(); // L: 12196
			var1.clearIsFromIgnored(); // L: 12198
		}
		if (Huffman.friendsChat != null) { // L: 12202
			Huffman.friendsChat.invalidateIgnoreds(); // L: 12203
		}
	} // L: 12205
}
