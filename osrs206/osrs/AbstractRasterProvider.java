package osrs;
public abstract class AbstractRasterProvider {
	public int[] pixels;
	
	public int width;
	
	public int height;
	protected AbstractRasterProvider() {
	} // L: 8
	
	public abstract void drawFull(int var1, int var2);
	
	public abstract void draw(int var1, int var2, int var3, int var4);
	
	public final void apply() {
		Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height); // L:
																					// 11
	} // L: 12
}
