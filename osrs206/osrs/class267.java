package osrs;
import java.io.File;
import java.util.HashMap;
import java.util.TimeZone;
public final class class267 {
	static final HashMap field3162;
	static File JagexCache_locationFile;
	
	static Archive archive12;
	
	static SpritePixels compass;
	static {
		field3162 = new HashMap(); // L: 11
		TimeZone var0;
		synchronized (field3162) { // L: 16
			TimeZone var2 = (TimeZone) field3162.get("Europe/London"); // L: 17
			if (var2 == null) { // L: 18
				var2 = TimeZone.getTimeZone("Europe/London"); // L: 19
				field3162.put("Europe/London", var2); // L: 20
			}
			var0 = var2; // L: 22
		}
		java.util.Calendar.getInstance(var0); // L: 25
	} // L: 26
}
