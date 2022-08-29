package osrs;
final public class class433 implements class428 {
	
	public void vmethod7583(Object var1, Buffer var2) {
		this.method7586((String) var1, var2); // L: 49
	} // L: 50
	
	public Object vmethod7580(Buffer var1) {
		return var1.readStringCp1252NullTerminated(); // L: 45
	}
	
	void method7586(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1); // L: 40
	} // L: 41
}
