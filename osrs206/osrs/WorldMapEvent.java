package osrs;
public class WorldMapEvent {
	
	static Archive field2882;
	
	public int mapElement;
	
	public Coord coord1;
	
	public Coord coord2;
	
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1; // L: 11
		this.coord1 = var2; // L: 12
		this.coord2 = var3; // L: 13
	} // L: 14
	
	public static double[] method5119(double var0, double var2, int var4) {
		int var5 = var4 * 2 + 1; // L: 18
		double[] var6 = new double[var5]; // L: 19
		int var7 = -var4;
		for (int var8 = 0; var7 <= var4; ++var8) {
			var6[var8] = class357.method6530((double) var7, var0, var2); // L:
																			// 21
			++var7; // L: 20
		}
		return var6; // L: 23
	}
	
	static final void method5120(int var0) {
		var0 = Math.max(Math.min(var0, 100), 0); // L: 11823
		var0 = 100 - var0; // L: 11824
		float var1 = (float) var0 / 200.0F + 0.5F; // L: 11825
		Rasterizer3D.Rasterizer3D_setBrightness((double) var1); // L: 11827
		((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).setBrightness((double) var1); // L:
																									// 11828
		Projectile.method1959(); // L: 11829
		class19.clientPreferences.method2255((double) var1); // L: 11830
	} // L: 11832
	
	static final void method5121(int var0) {
		var0 = Math.min(Math.max(var0, 0), 127); // L: 11861
		class19.clientPreferences.method2341(var0); // L: 11862
	} // L: 11863
}
