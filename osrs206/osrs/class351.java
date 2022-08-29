package osrs;
public class class351 {
	public static boolean field4198;
	
	int field4197;
	
	int field4193;
	
	int field4195;
	
	int field4196;
	public String toString() {
		boolean var1 = true; // L: 15
		int var2 = 10 - Integer.toString(this.field4197).length(); // L: 16
		int var3 = 10 - Integer.toString(this.field4195).length(); // L: 17
		int var4 = 10 - Integer.toString(this.field4193).length(); // L: 18
		String var5 = "          ".substring(10 - var2); // L: 19
		String var6 = "          ".substring(10 - var3); // L: 20
		String var7 = "          ".substring(10 - var4); // L: 21
		return "    Size: " + this.field4197 + var5 + "Created: " + this.field4193 + var7 + "Total used: " + this.field4195 + var6 + "Max-In-Use: " + this.field4196; // L:
																																										// 22
	}
}
