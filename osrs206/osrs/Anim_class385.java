package osrs;
public class Anim_class385 {
	float field4383;
	float field4382;
	float field4384;
	static {
		new Anim_class385(0.0F, 0.0F, 0.0F); // L: 5
		new Anim_class385(1.0F, 1.0F, 1.0F); // L: 9
		new Anim_class385(1.0F, 0.0F, 0.0F); // L: 13
		new Anim_class385(0.0F, 1.0F, 0.0F); // L: 17
		new Anim_class385(0.0F, 0.0F, 1.0F); // L: 21
	} // L: 26
	Anim_class385(float var1, float var2, float var3) {
		this.field4383 = var1; // L: 33
		this.field4382 = var2; // L: 34
		this.field4384 = var3; // L: 35
	} // L: 36
	
	final float method6929() {
		return (float) Math.sqrt((double) (this.field4384 * this.field4384 + this.field4383 * this.field4383 + this.field4382 * this.field4382)); // L:
																																					// 39
	}
	public String toString() {
		return this.field4383 + ", " + this.field4382 + ", " + this.field4384; // L:
																				// 44
	}
}
