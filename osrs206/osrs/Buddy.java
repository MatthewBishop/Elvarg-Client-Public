package osrs;
public class Buddy extends User {
	
	public static NetFileRequest NetCache_currentResponse;
	
	public int world;
	
	public int int2;
	
	public int rank;
	Buddy() {
		this.world = -1; // L: 4
	} // L: 8
	
	void set(int var1, int var2) {
		this.world = var1; // L: 11
		this.int2 = var2; // L: 12
	} // L: 13
	
	public int getWorld() {
		return this.world; // L: 16
	}
	
	public boolean hasWorld() {
		return this.world > 0; // L: 20
	}
}
