package osrs;
import java.net.MalformedURLException;
import java.net.URL;
public class class290 {
	
	UrlRequest field3331;
	
	SpritePixels field3332;
	
	class290(String var1, UrlRequester var2) {
		try {
			this.field3331 = var2.request(new URL(var1)); // L: 16
		} catch (MalformedURLException var4) { // L: 18
			this.field3331 = null;
		}
	} // L: 21
	
	class290(UrlRequest var1) {
		this.field3331 = var1; // L: 24
	} // L: 25
	
	SpritePixels method5562() {
		if (this.field3332 == null && this.field3331 != null && this.field3331.isDone()) { // L:
																							// 28
			if (this.field3331.getResponse() != null) { // L: 29
				this.field3332 = ItemLayer.method3920(this.field3331.getResponse()); // L:
																						// 30
			}
			this.field3331 = null; // L: 32
		}
		return this.field3332; // L: 34
	}
	
	static void addGameMessage(int var0, String var1, String var2) {
		SecureRandomFuture.addChatMessage(var0, var1, var2, (String) null); // L:
																			// 19
	} // L: 20
}
