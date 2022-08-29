package osrs;
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	
	static int selectedItemId;
	
	final int element;
	
	final WorldMapLabel label;
	
	final int subWidth;
	
	final int subHeight;
	
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2); // L: 14
		this.element = var3; // L: 15
		this.label = var4; // L: 16
		WorldMapElement var5 = class432.WorldMapElement_get(this.getElement()); // L:
																				// 17
		SpritePixels var6 = var5.getSpriteBool(false); // L: 18
		if (var6 != null) { // L: 19
			this.subWidth = var6.subWidth; // L: 20
			this.subHeight = var6.subHeight; // L: 21
		} else {
			this.subWidth = 0; // L: 24
			this.subHeight = 0; // L: 25
		}
	} // L: 27
	
	public int getElement() {
		return this.element; // L: 31
	}
	
	WorldMapLabel getLabel() {
		return this.label; // L: 36
	}
	
	int getSubWidth() {
		return this.subWidth; // L: 41
	}
	
	int getSubHeight() {
		return this.subHeight; // L: 46
	}
	
	static String Widget_getSpellActionName(Widget var0) {
		if (WorldMapID.Widget_unpackTargetMask(class124.getWidgetFlags(var0)) == 0) { // L:
																						// 12322
			return null;
		} else {
			return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null; // L:
																															// 12323
																															// 12324
																															// 12326
		}
	}
}
