package osrs;
public class UserComparator9 extends AbstractUserComparator {
	final boolean reversed;
	public UserComparator9(boolean var1) {
		this.reversed = var1; // L: 11
	} // L: 12
	
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) { // L:
																			// 15
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername()); // L:
																																					// 16
		} else {
			return this.compareUser(var1, var2); // L: 18
		}
	}
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy) var1, (Buddy) var2); // L: 22
	}
}
