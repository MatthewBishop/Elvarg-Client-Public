package osrs;
public class LoginType {
	
	public static final LoginType oldscape;
	
	static final LoginType field4611;
	
	static final LoginType field4615;
	
	static final LoginType field4612;
	
	static final LoginType field4609;
	
	static final LoginType field4614;
	
	static final LoginType field4613;
	
	static final LoginType field4617;
	
	public static final LoginType field4620;
	
	final int field4618;
	final String field4619;
	static {
		oldscape = new LoginType(7, 0, "", ""); // L: 5
		field4611 = new LoginType(5, 1, "", ""); // L: 6
		field4615 = new LoginType(8, 2, "", ""); // L: 7
		field4612 = new LoginType(0, 3, "", ""); // L: 8
		field4609 = new LoginType(2, 4, "", ""); // L: 9
		field4614 = new LoginType(4, 5, "", ""); // L: 10
		field4613 = new LoginType(6, 6, "", ""); // L: 11
		field4617 = new LoginType(1, 7, "", ""); // L: 12
		field4620 = new LoginType(3, -1, "", "", true, new LoginType[]{oldscape, field4611, field4615, field4609, field4612}); // L:
																																// 13
	}
	LoginType(int var1, int var2, String var3, String var4) {
		this.field4618 = var1; // L: 18
		this.field4619 = var4; // L: 19
	} // L: 20
	
	LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
		this.field4618 = var1; // L: 23
		this.field4619 = var4; // L: 24
	} // L: 25
	public String toString() {
		return this.field4619; // L: 29
	}
}
