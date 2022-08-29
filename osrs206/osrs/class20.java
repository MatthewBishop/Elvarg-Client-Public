package osrs;
import java.io.IOException;
import java.util.concurrent.Callable;
public class class20 implements Callable {
	
	public static int clientType;
	
	static MenuAction tempMenuAction;
	
	final class10 field109;
	// $FF: synthetic field
	
	final class14 this$0;
	
	class20(class14 var1, class10 var2) {
		this.this$0 = var1; // L: 46
		this.field109 = var2; // L: 47
	} // L: 48
	public Object call() throws Exception {
		try {
			while (this.field109.method78()) { // L: 53
				DynamicObject.method1991(10L); // L: 54
			}
		} catch (IOException var2) { // L: 57
			return new class21("Error servicing REST query: " + var2.getMessage()); // L:
																					// 58
		}
		return this.field109.method90(); // L: 60
	}
	
	static int method255(int var0) {
		return (int) Math.pow(2.0D, (double) (7.0F + (float) var0 / 256.0F)); // L:
																				// 3847
	}
}
