package osrs;
import java.applet.Applet;
public class RunException extends RuntimeException {
	public static Applet RunException_applet;
	public static String localPlayerName;
	
	public static int RunException_revision;
	
	public static int field4839;
	String message;
	Throwable throwable;
	RunException(Throwable var1, String var2) {
		this.message = var2; // L: 28
		this.throwable = var1; // L: 29
	} // L: 30
}
