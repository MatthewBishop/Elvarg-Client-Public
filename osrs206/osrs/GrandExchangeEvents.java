package osrs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class GrandExchangeEvents {
	public static Comparator GrandExchangeEvents_ageComparator;
	public static Comparator GrandExchangeEvents_priceComparator;
	public static Comparator GrandExchangeEvents_nameComparator;
	public static Comparator GrandExchangeEvents_quantityComparator;
	public final List events;
	static {
		GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator(); // L:
																					// 11
		new GrandExchangeOfferWorldComparator();
		GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator(); // L:
																							// 41
		GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator(); // L:
																						// 54
		GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
	} // L: 67
	
	public GrandExchangeEvents(Buffer var1, boolean var2) {
		int var3 = var1.readUnsignedShort(); // L: 82
		boolean var4 = var1.readUnsignedByte() == 1; // L: 83
		byte var5;
		if (var4) { // L: 85
			var5 = 1;
		} else {
			var5 = 0; // L: 86
		}
		int var6 = var1.readUnsignedShort(); // L: 87
		this.events = new ArrayList(var6); // L: 88
		for (int var7 = 0; var7 < var6; ++var7) { // L: 89
			this.events.add(new GrandExchangeEvent(var1, var5, var3)); // L: 90
		}
	} // L: 92
	
	public void sort(Comparator var1, boolean var2) {
		if (var2) { // L: 95
			Collections.sort(this.events, var1); // L: 96
		} else {
			Collections.sort(this.events, Collections.reverseOrder(var1)); // L:
																			// 99
		}
	} // L: 101
}
