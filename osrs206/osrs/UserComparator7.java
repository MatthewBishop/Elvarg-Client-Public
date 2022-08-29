package osrs;
public class UserComparator7 extends AbstractUserComparator {
	
	final boolean reversed;
	public UserComparator7(boolean var1) {
		this.reversed = var1; // L: 10
	} // L: 11
	
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) { // L: 14
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2; // L:
																					// 15
		} else {
			return this.compareUser(var1, var2); // L: 17
		}
	}
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy) var1, (Buddy) var2); // L: 21
	}
	
	public static EnumComposition getEnum(int var0) {
		EnumComposition var1 = (EnumComposition) EnumComposition.EnumDefinition_cached.get((long) var0); // L:
																											// 29
		if (var1 != null) { // L: 30
			return var1;
		} else {
			byte[] var2 = EnumComposition.EnumDefinition_archive.takeFile(8, var0); // L:
																					// 31
			var1 = new EnumComposition(); // L: 32
			if (var2 != null) { // L: 33
				var1.decode(new Buffer(var2));
			}
			EnumComposition.EnumDefinition_cached.put(var1, (long) var0); // L:
																			// 34
			return var1; // L: 35
		}
	}
	
	static Message Messages_getMessage(int var0) {
		return (Message) Messages.Messages_hashTable.get((long) var0); // L: 40
	}
}
