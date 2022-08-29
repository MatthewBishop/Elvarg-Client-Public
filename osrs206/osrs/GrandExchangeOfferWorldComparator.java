package osrs;
import java.util.Comparator;
final public class GrandExchangeOfferWorldComparator implements Comparator {
	
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1); // L:
																					// 28
	}
	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2); // L:
																							// 32
	}
	public boolean equals(Object var1) {
		return super.equals(var1); // L: 36
	}
}
