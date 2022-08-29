package osrs;
public class ItemContainer extends Node {
	
	static NodeHashTable itemContainers;
	int[] ids;
	int[] quantities;
	static {
		itemContainers = new NodeHashTable(32); // L: 7
	}
	ItemContainer() {
		this.ids = new int[]{-1}; // L: 8
		this.quantities = new int[]{0}; // L: 9
	} // L: 11
}
