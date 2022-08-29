package osrs;
public enum PlayerType implements MouseWheel {
	
	PlayerType_normal(0, -1, true, false, true), 
	PlayerType_playerModerator(1, 0, true, true, true), 
	PlayerType_jagexModerator(2, 1, true, true, false), 
	PlayerType_ironman(3, 2, false, false, true), 
	PlayerType_ultimateIronman(4, 3, false, false, true), 
	PlayerType_hardcoreIronman(5, 10, false, false, true), 
	field3951(6, 22, false, false, true), 
	field3952(7, 41, false, false, true), 
	field3956(8, 42, false, false, true), 
	field3954(9, 43, false, false, true), 
	field3949(10, 44, false, false, true), 
	field3945(11, 45, false, false, true), 
	field3957(12, 46, false, false, true), 
	field3958(13, 47, false, false, true), 
	field3959(14, 48, false, false, true), 
	field3960(15, 49, false, false, true);
	
	final int id;
	
	public final int modIcon;
	public final boolean isPrivileged;
	public final boolean isUser;
	PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.id = var3; // L: 33
		this.modIcon = var4; // L: 34
		this.isPrivileged = var6; // L: 35
		this.isUser = var7; // L: 36
	} // L: 37
	
	public int rsOrdinal() {
		return this.id; // L: 41
	}
}
