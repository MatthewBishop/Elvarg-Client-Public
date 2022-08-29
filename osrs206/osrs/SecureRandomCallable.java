package osrs;
import java.util.concurrent.Callable;
public class SecureRandomCallable implements Callable {
	SecureRandomCallable() {
	} // L: 36
	public Object call() {
		return NetFileRequest.method5843(); // L: 46
	}
	
	static String method2066(int var0) {
		return "<img=" + var0 + ">"; // L: 18
	}
}
