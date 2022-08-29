package osrs;

public final class BoundaryObject {
	
	static int field2622;
	
	int z;
	
	int x;
	
	int y;
	
	int orientationA;
	
	int orientationB;
	
	public Renderable renderable1;
	
	public Renderable renderable2;
	
	public long tag;
	
	int flags;
	BoundaryObject() {
		this.tag = 0L; // L: 11
		this.flags = 0; // L: 12
	} // L: 14
	
	public static void runScriptEvent(ScriptEvent var0) {
		class135.runScript(var0, 500000, 475000);
	}
	
	static long method4536() {
		return Client.field612; // L: 2945
	}
}
