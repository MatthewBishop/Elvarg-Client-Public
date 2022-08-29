package osrs;
import java.net.URL;
import java.util.List;
public class UrlRequest {
	static List field1373;
	final URL url;
	volatile boolean isDone0;
	volatile byte[] response0;
	UrlRequest(URL var1) {
		this.url = var1; // L: 118
	} // L: 119
	
	public boolean isDone() {
		return this.isDone0; // L: 122
	}
	
	public byte[] getResponse() {
		return this.response0; // L: 126
	}
	
	public String method2553() {
		return this.url.toString(); // L: 130
	}
	
	public static int method2557(boolean var0, boolean var1) {
		byte var2 = 0; // L: 143
		int var3 = var2 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount; // L:
																															// 144
		return var3; // L: 145
	}
}
