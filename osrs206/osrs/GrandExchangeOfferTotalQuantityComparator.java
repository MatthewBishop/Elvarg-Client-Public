package osrs;
import java.util.Comparator;
final public class GrandExchangeOfferTotalQuantityComparator implements Comparator {
	static String field4045;
	
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity ? -1 : (var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity ? 0 : 1); // L:
																																																// 69
	}
	public boolean equals(Object var1) {
		return super.equals(var1); // L: 77
	}
	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2);
	}
	
	static void method5969(int var0) {
		ItemContainer var1 = (ItemContainer) ItemContainer.itemContainers.get((long) var0); // L:
																							// 72
		if (var1 != null) {
			var1.remove(); // L: 74
		}
	} // L: 73 75
	
	static final void method5970(Actor var0) {
		int var1 = Math.max(1, var0.field1184 - Client.cycle); // L: 4162
		int var2 = var0.field1205 * 64 + var0.field1140 * 128; // L: 4163
		int var3 = var0.field1205 * 64 + var0.field1182 * 128; // L: 4164
		var0.x += (var2 - var0.x) / var1; // L: 4165
		var0.y += (var3 - var0.y) / var1; // L: 4166
		var0.field1202 = 0; // L: 4167
		var0.orientation = var0.field1186; // L: 4168
	} // L: 4169
}
