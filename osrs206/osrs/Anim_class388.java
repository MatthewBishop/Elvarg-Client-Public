package osrs;
public class Anim_class388 {
	float field4405;
	float field4400;
	float field4402;
	float field4409;
	float field4403;
	float field4408;
	float field4401;
	float field4407;
	float field4406;
	float field4404;
	float field4410;
	float field4411;
	static {
		new Anim_class388();
	} // L: 6
	Anim_class388() {
		this.method7022(); // L: 22
	} // L: 23
	
	void method7022() {
		this.field4411 = 0.0F;
		this.field4410 = 0.0F;
		this.field4404 = 0.0F;
		this.field4407 = 0.0F;
		this.field4401 = 0.0F; // L: 30
		this.field4408 = 0.0F; // L: 31
		this.field4409 = 0.0F; // L: 32
		this.field4402 = 0.0F; // L: 33
		this.field4400 = 0.0F; // L: 34
		this.field4406 = 1.0F; // L: 35
		this.field4403 = 1.0F; // L: 36
		this.field4405 = 1.0F; // L: 37
	} // L: 38
	
	void method7029(float var1) {
		float var2 = (float) Math.cos((double) var1); // L: 41
		float var3 = (float) Math.sin((double) var1); // L: 42
		float var4 = this.field4400; // L: 43
		float var5 = this.field4403; // L: 44
		float var6 = this.field4407; // L: 45
		float var7 = this.field4410; // L: 46
		this.field4400 = var4 * var2 - var3 * this.field4402; // L: 47
		this.field4402 = this.field4402 * var2 + var3 * var4; // L: 48
		this.field4403 = var5 * var2 - var3 * this.field4408; // L: 49
		this.field4408 = var3 * var5 + var2 * this.field4408; // L: 50
		this.field4407 = var2 * var6 - this.field4406 * var3; // L: 51
		this.field4406 = var3 * var6 + var2 * this.field4406; // L: 52
		this.field4410 = var2 * var7 - var3 * this.field4411; // L: 53
		this.field4411 = this.field4411 * var2 + var3 * var7; // L: 54
	} // L: 55
	
	void method7027(float var1) {
		float var2 = (float) Math.cos((double) var1); // L: 58
		float var3 = (float) Math.sin((double) var1); // L: 59
		float var4 = this.field4405; // L: 60
		float var5 = this.field4409; // L: 61
		float var6 = this.field4401; // L: 62
		float var7 = this.field4404; // L: 63
		this.field4405 = var4 * var2 + this.field4402 * var3; // L: 64
		this.field4402 = this.field4402 * var2 - var3 * var4; // L: 65
		this.field4409 = var2 * var5 + this.field4408 * var3; // L: 66
		this.field4408 = var2 * this.field4408 - var5 * var3; // L: 67
		this.field4401 = var2 * var6 + this.field4406 * var3; // L: 68
		this.field4406 = var2 * this.field4406 - var6 * var3; // L: 69
		this.field4404 = var7 * var2 + var3 * this.field4411; // L: 70
		this.field4411 = this.field4411 * var2 - var7 * var3; // L: 71
	} // L: 72
	
	void method7039(float var1) {
		float var2 = (float) Math.cos((double) var1); // L: 75
		float var3 = (float) Math.sin((double) var1); // L: 76
		float var4 = this.field4405; // L: 77
		float var5 = this.field4409; // L: 78
		float var6 = this.field4401; // L: 79
		float var7 = this.field4404; // L: 80
		this.field4405 = var4 * var2 - var3 * this.field4400; // L: 81
		this.field4400 = var4 * var3 + var2 * this.field4400; // L: 82
		this.field4409 = var5 * var2 - this.field4403 * var3; // L: 83
		this.field4403 = var3 * var5 + this.field4403 * var2; // L: 84
		this.field4401 = var2 * var6 - this.field4407 * var3; // L: 85
		this.field4407 = var6 * var3 + this.field4407 * var2; // L: 86
		this.field4404 = var7 * var2 - var3 * this.field4410; // L: 87
		this.field4410 = var3 * var7 + var2 * this.field4410; // L: 88
	} // L: 89
	
	void method7026(float var1, float var2, float var3) {
		this.field4404 += var1; // L: 92
		this.field4410 += var2; // L: 93
		this.field4411 += var3; // L: 94
	} // L: 95
	public String toString() {
		return this.field4405 + "," + this.field4409 + "," + this.field4401 + "," + this.field4404 + "\n" + this.field4400 + "," + this.field4403 + "," + this.field4407 + "," + this.field4410 + "\n" + this.field4402 + "," + this.field4408 + "," + this.field4406 + "," + this.field4411; // L:
																																																																								// 99
	}
}
