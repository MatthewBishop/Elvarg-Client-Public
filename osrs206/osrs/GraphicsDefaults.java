package osrs;
public class GraphicsDefaults {
	
	public int compass;
	
	public int field4367;
	
	public int mapScenes;
	
	public int headIconsPk;
	
	public int field4374;
	
	public int field4373;
	
	public int field4372;
	
	public int field4368;
	
	public int field4371;
	
	public int field4375;
	
	public int field4376;
	public GraphicsDefaults() {
		this.compass = -1; // L: 7
		this.field4367 = -1; // L: 8
		this.mapScenes = -1; // L: 9
		this.headIconsPk = -1; // L: 10
		this.field4374 = -1; // L: 11
		this.field4373 = -1; // L: 12
		this.field4372 = -1; // L: 13
		this.field4368 = -1; // L: 14
		this.field4371 = -1; // L: 15
		this.field4375 = -1; // L: 16
		this.field4376 = -1; // L: 17
	}
	
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field4363.group); // L: 20
		Buffer var3 = new Buffer(var2); // L: 21
		while (true) {
			int var4 = var3.readUnsignedByte(); // L: 23
			if (var4 == 0) { // L: 24
				return; // L: 51
			}
			switch (var4) { // L: 25
				case 1 :
					var3.readMedium(); // L: 46
					break;
				case 2 :
					this.compass = var3.method7752(); // L: 31
					this.field4367 = var3.method7752(); // L: 32
					this.mapScenes = var3.method7752(); // L: 33
					this.headIconsPk = var3.method7752(); // L: 34
					this.field4374 = var3.method7752(); // L: 35
					this.field4373 = var3.method7752(); // L: 36
					this.field4372 = var3.method7752(); // L: 37
					this.field4368 = var3.method7752(); // L: 38
					this.field4371 = var3.method7752(); // L: 39
					this.field4375 = var3.method7752(); // L: 40
					this.field4376 = var3.method7752(); // L: 41
			}
		}
	}
}
