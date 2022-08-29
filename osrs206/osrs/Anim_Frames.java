package osrs;

public class Anim_Frames extends DualNode {
	
	Anim_Animation[] frames;
	
	Anim_Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.getGroupFileCount(var3);
		this.frames = new Anim_Animation[var6]; // L: 37
		int[] var7 = var1.getGroupFileIds(var3); // L: 38
		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.takeFile(var3, var7[var8]); // L: 40
			Anim_Skeleton var10 = null; // L: 41
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255; // L: 42
			for (Anim_Skeleton var12 = (Anim_Skeleton) var5.last(); var12 != null; var12 = (Anim_Skeleton) var5.previous()) { // L:
																												// 43
				// 49
				if (var11 == var12.id) { // L: 45
					var10 = var12; // L: 46
					break;
				}
			}
			if (var10 == null) { // L: 51
				byte[] var13;
				if (var4) { // L: 53
					var13 = var2.getFile(0, var11);
				} else {
					var13 = var2.getFile(var11, 0); // L: 54
				}
				var10 = new Anim_Skeleton(var11, var13); // L: 55
				var5.addFirst(var10); // L: 56
			}
			this.frames[var7[var8]] = new Anim_Animation(var9, var10); // L: 58
		}
	} // L: 60
	
	public boolean hasAlphaTransform(int var1) {
		return this.frames[var1].hasAlphaTransform; // L: 63
	}

	public static Anim_Frames method5499(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
		boolean var4 = true; // L: 11
		int[] var5 = var0.getGroupFileIds(var2); // L: 12
		for (int var6 = 0; var6 < var5.length; ++var6) { // L: 13
			byte[] var7 = var0.getFile(var2, var5[var6]); // L: 14
			if (var7 == null) { // L: 15
				var4 = false; // L: 16
			} else {
				int var8 = (var7[0] & 255) << 8 | var7[1] & 255; // L: 19
				byte[] var9;
				if (var3) {
					var9 = var1.getFile(0, var8);
				} else {
					var9 = var1.getFile(var8, 0);
				}
				if (var9 == null) {
					var4 = false;
				}
			}
		}
		if (!var4) {
			return null;
		} else {
			try {
				return new Anim_Frames(var0, var1, var2, var3);
			} catch (Exception var11) { // L: 29
				return null; // L: 30
			}
		}
	}

	static Anim_Frames getFrames(int var0) {
		Anim_Frames var1 = (Anim_Frames) Anim_SequenceDefinition.SequenceDefinition_cachedFrames.get((long) var0); // L:
																									// 358
		if (var1 != null) { // L: 359
			return var1;
		} else {
			var1 = Anim_Frames.method5499(Anim_SequenceDefinition.SequenceDefinition_animationsArchive, Anim_SequenceDefinition.SequenceDefinition_skeletonsArchive, var0, false); // L:
																																										// 360
			if (var1 != null) { // L: 361
				Anim_SequenceDefinition.SequenceDefinition_cachedFrames.put(var1, (long) var0);
			}
			return var1; // L: 362
		}
	}
}
