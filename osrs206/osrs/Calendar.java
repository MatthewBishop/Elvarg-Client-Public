package osrs;
import java.util.TimeZone;
public class Calendar {
	static final String[][] MONTH_NAMES_ENGLISH_GERMAN;
	static final String[] DAYS_OF_THE_WEEK;
	static java.util.Calendar Calendar_calendar;
	static {
		MONTH_NAMES_ENGLISH_GERMAN = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}, {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"}, {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"}, {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}, {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"}}; // L:
																																																																																																																																																																						// 8
		DAYS_OF_THE_WEEK = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; // L:
																							// 18
		java.util.Calendar.getInstance();
		Calendar_calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}
	
	public static InvDefinition getInvDefinition(int var0) {
		InvDefinition var1 = (InvDefinition) InvDefinition.InvDefinition_cached.get((long) var0); // L:
																									// 21
		if (var1 != null) { // L: 22
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0); // L:
																					// 23
			var1 = new InvDefinition(); // L: 24
			if (var2 != null) { // L: 25
				var1.decode(new Buffer(var2));
			}
			InvDefinition.InvDefinition_cached.put(var1, (long) var0); // L: 26
			return var1; // L: 27
		}
	}
	
	protected static final void method5504() {
		class10.clock.mark(); // L: 408
		int var0;
		for (var0 = 0; var0 < 32; ++var0) { // L: 409
			GameEngine.graphicsTickTimes[var0] = 0L;
		}
		for (var0 = 0; var0 < 32; ++var0) { // L: 410
			GameEngine.clientTickTimes[var0] = 0L;
		}
		Messages.gameCyclesToDo = 0; // L: 411
	} // L: 412
}
