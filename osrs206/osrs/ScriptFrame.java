package osrs;

public class ScriptFrame {
	
	static SpritePixels[] worldSelectBackSprites;
	
	Script script;
	
	int pc;
	int[] intLocals;
	String[] stringLocals;
	ScriptFrame() {
		this.pc = -1; // L: 5
	} // L: 9
	
	public static Widget getWidgetChild(int var0, int var1) {
		Widget var2 = class140.getWidget(var0); // L: 230
		if (var1 == -1) { // L: 231
			return var2;
		} else {
			return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null; // L:
			// 232
			// 233
		}
	}
}
