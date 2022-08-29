package osrs;
public enum StudioGame implements MouseWheel {
	
	runescape("runescape", "RuneScape", 0), 
	stellardawn("stellardawn", "Stellar Dawn", 1), 
	game3("game3", "Game 3", 2), 
	game4("game4", "Game 4", 3), 
	game5("game5", "Game 5", 4), 
	oldscape("oldscape", "RuneScape 2007", 5);
	public final String name;
	
	final int id;
	StudioGame(String var3, String var4, int var5) {
		this.name = var3; // L: 17
		this.id = var5; // L: 18
	} // L: 19
	
	public int rsOrdinal() {
		return this.id; // L: 22
	}
	
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.SOLID, FillMode.field4778, FillMode.field4783}; // L:
																						// 15
	}
	
	public static boolean isCharPrintable(char var0) {
		if (var0 >= ' ' && var0 <= '~') { // L: 197
			return true;
		} else if (var0 >= 160 && var0 <= 255) { // L: 198
			return true;
		} else {
			return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376; // L:
																								// 199
		}
	}
}
