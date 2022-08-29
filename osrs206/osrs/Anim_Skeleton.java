package osrs;

public class Anim_Skeleton extends Node {
	
	int id;
	
	int count;
	int[] transformTypes;
	int[][] labels;
	
	Anim_class201 field2376;
	public Anim_Skeleton(int var1, byte[] var2) {
		this.id = var1; // L: 19
		Buffer buf = new Buffer(var2); // L: 20
		this.count = buf.readUnsignedByte(); // L: 21
		this.transformTypes = new int[this.count]; // L: 22
		this.labels = new int[this.count][]; // L: 23
		int var4;
		for (var4 = 0; var4 < this.count; ++var4) { // L: 24
			this.transformTypes[var4] = buf.readUnsignedByte();
		}
		for (var4 = 0; var4 < this.count; ++var4) { // L: 25
			this.labels[var4] = new int[buf.readUnsignedByte()];
		}
		for (var4 = 0; var4 < this.count; ++var4) { // L: 26
			for (int var5 = 0; var5 < this.labels[var4].length; ++var5) { // L:
																			// 27
				this.labels[var4][var5] = buf.readUnsignedByte();
			}
		}
		if (buf.offset < buf.array.length) { // L: 29
			var4 = buf.readUnsignedShort(); // L: 30
			if (var4 > 0) { // L: 31
				this.field2376 = new Anim_class201(buf, var4); // L: 32
			}
		}
	} // L: 35
	
	public int method4148() {
		return this.count; // L: 38
	}
	
	public Anim_class201 method4150() {
		return this.field2376; // L: 42
	}
}
