package osrs;
public final class WallDecoration {
	
	int z;
	
	int x;
	
	int y;
	
	int orientation;
	
	int orientation2;
	
	int xOffset;
	
	int yOffset;
	
	public Renderable renderable1;
	
	public Renderable renderable2;
	
	public long tag;
	
	int flags;
	WallDecoration() {
		this.tag = 0L; // L: 13
		this.flags = 0; // L: 14
	} // L: 16
	
	public static boolean method4551(int var0) {
		return (var0 >> 22 & 1) != 0; // L: 29
	}
}
