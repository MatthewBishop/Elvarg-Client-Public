package osrs;
import java.util.Comparator;
public class class360 implements Comparator {
	public static String javaVendor;
	// $FF: synthetic field
	
	final class361 this$0;
	
	class360(class361 var1) {
		this.this$0 = var1; // L: 7
	}
	
	int method6532(class362 var1, class362 var2) {
		if (var1.field4277 > var2.field4277) {
			return 1; // L: 9
		} else {
			return var1.field4277 < var2.field4277 ? -1 : 0; // L: 10 11
		}
	}
	public int compare(Object var1, Object var2) {
		return this.method6532((class362) var1, (class362) var2); // L: 15
	}
	public boolean equals(Object var1) {
		return super.equals(var1); // L: 19
	}
}
