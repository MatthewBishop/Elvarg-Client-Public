package osrs;

public class GraphicsObject extends Renderable {
	
	int id;
	
	int cycleStart;
	
	int plane;
	
	int x;
	
	int y;
	
	int z;
	
	Anim_SequenceDefinition sequenceDefinition;
	
	int frame;
	
	int frameCycle;
	boolean isFinished;
	GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.frame = 0; // L: 16
		this.frameCycle = 0; // L: 17
		this.isFinished = false; // L: 18
		this.id = var1; // L: 21
		this.plane = var2; // L: 22
		this.x = var3; // L: 23
		this.y = var4; // L: 24
		this.z = var5; // L: 25
		this.cycleStart = var7 + var6; // L: 26
		int var8 = _Junk.SpotAnimationDefinition_get(this.id).sequence; // L:
																				// 27
		if (var8 != -1) { // L: 28
			this.isFinished = false; // L: 29
			this.sequenceDefinition = Anim_SequenceDefinition.SequenceDefinition_get(var8); // L:
																				// 30
		} else {
			this.isFinished = true; // L: 32
		}
	} // L: 33
	
	final void advance(int var1) {
		if (!this.isFinished) { // L: 36
			this.frameCycle += var1; // L: 37
			if (!this.sequenceDefinition.isCachedModelIdSet()) { // L: 38
				while (this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) { // L:
																								// 39
					this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame]; // L:
																							// 40
					++this.frame; // L: 41
					if (this.frame >= this.sequenceDefinition.frameIds.length) { // L:
																					// 42
						this.isFinished = true; // L: 43
						break;
					}
				}
			} else {
				this.frame += var1; // L: 49
				if (this.frame >= this.sequenceDefinition.skeletalFrameCount()) { // L:
																			// 50
					this.isFinished = true;
				}
			}
		}
	} // L: 52
	
	protected final Model getModel() {
		SpotAnimationDefinition var1 = _Junk.SpotAnimationDefinition_get(this.id); // L:
																							// 55
		Model var2;
		if (!this.isFinished) { // L: 57
			var2 = var1.getModel(this.frame);
		} else {
			var2 = var1.getModel(-1); // L: 58
		}
		return var2 == null ? null : var2; // L: 59
	}
	
	static void method1877(String var0, String var1, String var2) {
		WorldMapData_1.method4872(7); // L: 1127
		class101.setLoginResponseString(var0, var1, var2); // L: 1128
	} // L: 1129
	
	static void method1870() {
		for (InterfaceParent var0 = (InterfaceParent) Client.interfaceParents.first(); var0 != null; var0 = (InterfaceParent) Client.interfaceParents.next()) { // L:
																																								// 11739
			int var1 = var0.group; // L: 11740
			if (WorldMapSection2.loadInterface(var1)) { // L: 11741
				boolean var2 = true; // L: 11742
				Widget[] var3 = _Junk.Widget_interfaceComponents[var1]; // L:
																				// 11743
				int var4;
				for (var4 = 0; var4 < var3.length; ++var4) { // L: 11744
					if (var3[var4] != null) { // L: 11745
						var2 = var3[var4].isIf3; // L: 11746
						break;
					}
				}
				if (!var2) { // L: 11750
					var4 = (int) var0.key; // L: 11751
					Widget var5 = class140.getWidget(var4); // L: 11752
					if (var5 != null) { // L: 11753
						ChatChannel.invalidateWidget(var5);
					}
				}
			}
		}
	} // L: 11757
	public GraphicsObject() {
	}
}
