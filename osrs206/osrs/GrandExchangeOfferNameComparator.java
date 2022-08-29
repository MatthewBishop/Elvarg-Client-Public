package osrs;
import java.util.Comparator;
final public class GrandExchangeOfferNameComparator implements Comparator {
	
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.getOfferName().compareTo(var2.getOfferName()); // L: 56
	}
	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent) var1, (GrandExchangeEvent) var2); // L:
																							// 60
	}
	public boolean equals(Object var1) {
		return super.equals(var1); // L: 64
	}
	
	public static void method5979(AbstractArchive var0) {
		StructComposition.StructDefinition_archive = var0; // L: 19
	} // L: 20
}
