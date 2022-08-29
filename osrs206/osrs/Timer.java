package osrs;

import misc.Equations;

public class Timer {
	
	static int widgetDragDuration;
	
	long field4229;
	
	long field4222;
	public boolean field4223;
	
	long field4225;
	
	long field4224;
	
	long field4226;
	
	int field4230;
	
	int field4228;
	
	int field4227;
	
	int field4221;
	public Timer() {
		this.field4229 = -1L; // L: 7
		this.field4222 = -1L; // L: 8
		this.field4223 = false; // L: 9
		this.field4225 = 0L; // L: 10
		this.field4224 = 0L; // L: 11
		this.field4226 = 0L; // L: 12
		this.field4230 = 0; // L: 13
		this.field4228 = 0; // L: 14
		this.field4227 = 0; // L: 15
		this.field4221 = 0; // L: 16
	}
	
	public void method6509() {
		this.field4229 = Equations.getCurrentTime(); // L: 19
	} // L: 20
	
	public void method6510() {
		if (-1L != this.field4229) { // L: 23
			this.field4224 = Equations.getCurrentTime() - this.field4229; // L: 24
			this.field4229 = -1L; // L: 25
		}
	} // L: 27
	
	public void method6528(int var1) {
		this.field4222 = Equations.getCurrentTime(); // L: 30
		this.field4230 = var1; // L: 31
	} // L: 32
	
	public void method6511() {
		if (-1L != this.field4222) { // L: 35
			this.field4225 = Equations.getCurrentTime() - this.field4222; // L: 36
			this.field4222 = -1L; // L: 37
		}
		++this.field4227; // L: 39
		this.field4223 = true; // L: 40
	} // L: 41
	
	public void method6513() {
		this.field4223 = false; // L: 44
		this.field4228 = 0; // L: 45
	} // L: 46
	
	public void method6514() {
		this.method6511(); // L: 49
	} // L: 50
	
	public void write(Buffer var1) {
		FloorOverlayDefinition.method3822(var1, this.field4224); // L: 53
		FloorOverlayDefinition.method3822(var1, this.field4225); // L: 54
		FloorOverlayDefinition.method3822(var1, this.field4226); // L: 55
		var1.writeShort(this.field4230); // L: 56
		var1.writeShort(this.field4228); // L: 57
		var1.writeShort(this.field4227); // L: 58
		var1.writeShort(this.field4221); // L: 59
	} // L: 60
}
