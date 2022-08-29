package osrs;
public final class TileItem extends Renderable {
	protected static String field1301;
	static String field1299;
	
	static Font fontBold12;
	
	int id;
	
	int quantity;
	TileItem() {
	} // L: 11
	
	protected final Model getModel() {
		return EnumComposition.ItemDefinition_get(this.id).getModel(this.quantity); // L:
																					// 14
	}
	
	public static int method2414(int var0) {
		return class7.method51(ViewportMouse.ViewportMouse_entityTags[var0]); // L:
																				// 73
	}
}
