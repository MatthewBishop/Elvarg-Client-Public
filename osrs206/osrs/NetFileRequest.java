package osrs;
import java.security.SecureRandom;
public class NetFileRequest extends DualNode {
	public static String formattedOperatingSystemName;
	
	public Archive archive;
	
	public int crc;
	public byte padding;
	NetFileRequest() {
	} // L: 10
	
	static SecureRandom method5843() {
		SecureRandom var0 = new SecureRandom(); // L: 39
		var0.nextInt(); // L: 40
		return var0; // L: 41
	}
}
