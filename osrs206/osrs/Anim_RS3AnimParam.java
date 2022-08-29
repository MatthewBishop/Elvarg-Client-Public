package osrs;

public class Anim_RS3AnimParam {
	
	int field1420;
	float field1423;
	float field1421;
	float field1422;
	float field1419;
	float field1425;
	
	Anim_RS3AnimParam field1426;
	Anim_RS3AnimParam() {
		this.field1421 = Float.MAX_VALUE; // L: 8
		this.field1422 = Float.MAX_VALUE; // L: 9
		this.field1419 = Float.MAX_VALUE; // L: 10
		this.field1425 = Float.MAX_VALUE; // L: 11
	} // L: 14
	
	void method2630(Buffer var1, int var2) {
		this.field1420 = var1.readShort(); // L: 17
		this.field1423 = var1.method7740(); // L: 18
		this.field1421 = var1.method7740(); // L: 19
		this.field1422 = var1.method7740(); // L: 20
		this.field1419 = var1.method7740(); // L: 21
		this.field1425 = var1.method7740(); // L: 22
	} // L: 23
}
