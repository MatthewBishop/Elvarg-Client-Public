package osrs;
public enum VerticalAlignment implements MouseWheel {
	
	field1963(0, 0), 
	VerticalAlignment_centered(2, 1), 
	field1961(1, 2);
	
	public final int value;
	
	final int id;
	VerticalAlignment(int var3, int var4) {
		this.value = var3; // L: 18
		this.id = var4;
	}
	
	public int rsOrdinal() {
		return this.id;
	}
	
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer) ItemContainer.itemContainers.get((long) var0); // L:
																							// 63
		if (var1 != null) { // L: 64
			for (int var2 = 0; var2 < var1.ids.length; ++var2) { // L: 65
				var1.ids[var2] = -1; // L: 66
				var1.quantities[var2] = 0; // L: 67
			}
		}
	} // L: 69
	
	static RouteStrategy method3533(int var0, int var1) {
		Client.field774.approxDestinationX = var0; // L: 8415
		Client.field774.approxDestinationY = var1; // L: 8416
		Client.field774.approxDestinationSizeX = 1; // L: 8417
		Client.field774.approxDestinationSizeY = 1; // L: 8418
		return Client.field774; // L: 8419
	}
}
