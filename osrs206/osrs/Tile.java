package osrs;
public final class Tile extends Node {
	
	int plane;
	
	int x;
	
	int y;
	
	int originalPlane;
	
	SceneTilePaint paint;
	
	SceneTileModel model;
	
	BoundaryObject boundaryObject;
	
	WallDecoration wallDecoration;
	
	FloorDecoration floorDecoration;
	
	ItemLayer itemLayer;
	
	int gameObjectsCount;
	
	GameObject[] gameObjects;
	int[] gameObjectEdgeMasks;
	
	int gameObjectsEdgeMask;
	
	int minPlane;
	boolean drawPrimary;
	boolean drawSecondary;
	boolean drawGameObjects;
	
	int drawGameObjectEdges;
	
	int field2333;
	
	int field2334;
	
	int field2326;
	
	Tile linkedBelowTile;
	Tile(int var1, int var2, int var3) {
		this.gameObjects = new GameObject[5]; // L: 17
		this.gameObjectEdgeMasks = new int[5]; // L: 18
		this.gameObjectsEdgeMask = 0; // L: 19
		this.originalPlane = this.plane = var1; // L: 31
		this.x = var2; // L: 32
		this.y = var3; // L: 33
	} // L: 34
	
	public static String intToString(int var0, boolean var1) {
		return var1 && var0 >= 0 ? class140.method3038(var0, 10, var1) : Integer.toString(var0); // L:
																									// 115
																									// 116
	}
	
	public static int method4019(int var0) {
		if (var0 > 0) { // L: 204
			return 1;
		} else {
			return var0 < 0 ? -1 : 0; // L: 205 206
		}
	}
}
