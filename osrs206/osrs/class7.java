package osrs;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class class7 {
	ExecutorService field25;
	Future field22;
	
	final Buffer field21;
	
	final class3 field24;
	
	public class7(Buffer var1, class3 var2) {
		this.field25 = Executors.newSingleThreadExecutor(); // L: 10
		this.field21 = var1; // L: 16
		this.field24 = var2; // L: 17
		this.method43(); // L: 18
	} // L: 19
	
	public boolean method46() {
		return this.field22.isDone(); // L: 22
	}
	
	public void method41() {
		this.field25.shutdown(); // L: 26
		this.field25 = null; // L: 27
	} // L: 28
	
	public Buffer method42() {
		try {
			return (Buffer) this.field22.get(); // L: 32
		} catch (Exception var2) { // L: 34
			return null; // L: 35
		}
	}
	
	void method43() {
		this.field22 = this.field25.submit(new class1(this, this.field21, this.field24)); // L:
																							// 40
	} // L: 41
	
	public static SpritePixels SpriteBuffer_getSprite(AbstractArchive var0, int var1, int var2) {
		if (!Ignored.method6774(var0, var1, var2)) { // L: 57
			return null;
		} else {
			SpritePixels var4 = new SpritePixels(); // L: 60
			var4.width = ModelData0.SpriteBuffer_spriteWidth; // L: 61
			var4.height = class456.SpriteBuffer_spriteHeight; // L: 62
			var4.xOffset = class426.SpriteBuffer_xOffsets[0]; // L: 63
			var4.yOffset = class142.SpriteBuffer_yOffsets[0]; // L: 64
			var4.subWidth = class359.SpriteBuffer_spriteWidths[0]; // L: 65
			var4.subHeight = class456.SpriteBuffer_spriteHeights[0]; // L: 66
			int var5 = var4.subWidth * var4.subHeight; // L: 67
			byte[] var6 = class421.SpriteBuffer_pixels[0]; // L: 68
			var4.pixels = new int[var5]; // L: 69
			for (int var7 = 0; var7 < var5; ++var7) { // L: 70
				var4.pixels[var7] = class13.SpriteBuffer_spritePalette[var6[var7] & 255];
			}
			class426.SpriteBuffer_xOffsets = null; // L: 72
			class142.SpriteBuffer_yOffsets = null; // L: 73
			class359.SpriteBuffer_spriteWidths = null; // L: 74
			class456.SpriteBuffer_spriteHeights = null; // L: 75
			class13.SpriteBuffer_spritePalette = null; // L: 76
			class421.SpriteBuffer_pixels = null;
			return var4; // L: 81
		}
	}
	
	static AttackOption[] method52() {
		return new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.field1294, AttackOption.AttackOption_hidden, AttackOption.field1288}; // L:
																																																					// 12504
	}
	static int method51(long var0) {
		return (int) (var0 >>> 14 & 3L); // L: 77
	}
	
	static final void runIntfCloseListeners(int var0, int var1) {
		if (WorldMapSection2.loadInterface(var0)) { // L: 11581
			TaskHandler.runComponentCloseListeners(_Junk.Widget_interfaceComponents[var0], var1); // L:
																										// 11582
		}
	} // L: 11583
}
