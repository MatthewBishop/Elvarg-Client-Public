package osrs;

public class Anim_class115 {
	public final int field1448;
	
	public Anim_class115 field1440;
	float[][] field1435;
	
	final Anim_class387[] field1433;
	
	Anim_class387[] field1437;
	
	Anim_class387[] field1438;
	
	Anim_class387 field1449;
	boolean field1441;
	
	Anim_class387 field1434;
	boolean field1442;
	
	Anim_class387 field1443;
	float[][] field1444;
	float[][] field1439;
	float[][] field1446;
	
	public Anim_class115(int var1, Buffer var2, boolean var3) {
		this.field1449 = new Anim_class387(); // L: 13
		this.field1441 = true;
		this.field1434 = new Anim_class387();
		this.field1442 = true;
		this.field1443 = new Anim_class387(); // L: 17
		this.field1448 = var2.readShort(); // L: 23
		this.field1433 = new Anim_class387[var1]; // L: 24
		this.field1437 = new Anim_class387[this.field1433.length]; // L: 25
		this.field1438 = new Anim_class387[this.field1433.length]; // L: 26
		this.field1435 = new float[this.field1433.length][3]; // L: 27
		for (int var4 = 0; var4 < this.field1433.length; ++var4) { // L: 28
			this.field1433[var4] = new Anim_class387(var2, var3); // L: 29
			this.field1435[var4][0] = var2.method7740(); // L: 30
			this.field1435[var4][1] = var2.method7740(); // L: 31
			this.field1435[var4][2] = var2.method7740(); // L: 32
		}
		this.method2652(); // L: 34
	} // L: 35
	
	void method2652() {
		this.field1444 = new float[this.field1433.length][3]; // L: 38
		this.field1439 = new float[this.field1433.length][3]; // L: 39
		this.field1446 = new float[this.field1433.length][3]; // L: 40
		Anim_class387 var1 = Anim_class387.method1884(); // L: 41
		for (int var2 = 0; var2 < this.field1433.length; ++var2) { // L: 42
			Anim_class387 var3 = this.method2653(var2); // L: 43
			var1.method6973(var3);
			var1.method6970();
			this.field1444[var2] = var1.method6959();
			this.field1439[var2][0] = var3.field4394[12];
			this.field1439[var2][1] = var3.field4394[13];
			this.field1439[var2][2] = var3.field4394[14];
			this.field1446[var2] = var3.method6992();
		}
		var1.method6968();
	}
	
	Anim_class387 method2653(int var1) {
		return this.field1433[var1];
	}
	
	Anim_class387 method2658(int var1) {
		if (this.field1437[var1] == null) { // L: 60
			this.field1437[var1] = new Anim_class387(this.method2653(var1)); // L: 61
			if (this.field1440 != null) { // L: 62
				this.field1437[var1].method6962(this.field1440.method2658(var1)); // L:
																					// 63
			} else {
				this.field1437[var1].method6962(Anim_class387.field4397); // L: 66
			}
		}
		return this.field1437[var1]; // L: 69
	}
	
	Anim_class387 method2655(int var1) {
		if (this.field1438[var1] == null) { // L: 73
			this.field1438[var1] = new Anim_class387(this.method2658(var1)); // L: 74
			this.field1438[var1].method6970(); // L: 75
		}
		return this.field1438[var1]; // L: 77
	}
	
	void method2656(Anim_class387 var1) {
		this.field1449.method6973(var1); // L: 81
		this.field1441 = true; // L: 82
		this.field1442 = true; // L: 83
	} // L: 84
	
	Anim_class387 method2657() {
		return this.field1449; // L: 87
	}
	
	Anim_class387 method2681() {
		if (this.field1441) { // L: 91
			this.field1434.method6973(this.method2657()); // L: 92
			if (this.field1440 != null) { // L: 93
				this.field1434.method6962(this.field1440.method2681()); // L: 94
			}
			this.field1441 = false; // L: 96
		}
		return this.field1434; // L: 98
	}
	
	public Anim_class387 method2651(int var1) {
		if (this.field1442) { // L: 102
			this.field1443.method6973(this.method2655(var1)); // L: 103
			this.field1443.method6962(this.method2681()); // L: 104
			this.field1442 = false; // L: 105
		}
		return this.field1443; // L: 107
	}
	
	float[] method2660(int var1) {
		return this.field1444[var1]; // L: 111
	}
	
	float[] method2661(int var1) {
		return this.field1439[var1]; // L: 115
	}
	
	float[] method2679(int var1) {
		return this.field1446[var1]; // L: 119
	}
}
