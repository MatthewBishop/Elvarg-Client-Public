package osrs;
public class TriBool {
	
	static int foundItemIndex;
	
	public static final TriBool TriBool_unknown;
	
	public static final TriBool TriBool_true;
	
	public static final TriBool TriBool_false;
	static {
		TriBool_unknown = new TriBool(); // L: 4
		TriBool_true = new TriBool(); // L: 5
		TriBool_false = new TriBool(); // L: 6
	}
	TriBool() {
	} // L: 8
	
	static final void method6791(boolean var0) {
		if (var0) { // L: 3020
			Client.field515 = Login.field895 ? class124.field1544 : class124.field1550; // L:
																						// 3021
		} else {
			Client.field515 = class19.clientPreferences.parameters.containsKey(Projectile.method1950(Login.Login_username)) ? class124.field1546 : class124.field1543; // L:
			// 3024
		}
	} // L: 3026
}
