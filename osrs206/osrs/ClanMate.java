package osrs;
public class ClanMate extends Buddy {
	
	TriBool friend;
	
	TriBool ignored;
	ClanMate() {
		this.friend = TriBool.TriBool_unknown; // L: 6
		this.ignored = TriBool.TriBool_unknown; // L: 7
	} // L: 9
	
	void clearIsFriend() {
		this.friend = TriBool.TriBool_unknown; // L: 12
	} // L: 13
	
	public final boolean isFriend() {
		if (this.friend == TriBool.TriBool_unknown) { // L: 16
			this.fillIsFriend(); // L: 17
		}
		return this.friend == TriBool.TriBool_true; // L: 19
	}
	
	void fillIsFriend() {
		this.friend = Player.friendSystem.friendsList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false; // L:
																																// 23
	} // L: 24
	
	void clearIsIgnored() {
		this.ignored = TriBool.TriBool_unknown; // L: 27
	}
	
	public final boolean isIgnored() {
		if (this.ignored == TriBool.TriBool_unknown) { // L: 31
			this.fillIsIgnored(); // L: 32
		}
		return this.ignored == TriBool.TriBool_true; // L: 34
	}
	
	void fillIsIgnored() {
		this.ignored = Player.friendSystem.ignoreList.contains(super.username) ? TriBool.TriBool_true : TriBool.TriBool_false; // L:
																																// 38
	} // L: 39
	
	public static int method6650(int var0) {
		return class401.field4442[var0 & 16383]; // L: 28
	}
}
