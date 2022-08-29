package osrs;

public final class Projectile extends Renderable {
	static boolean ClanChat_inClanChat;
	
	int id;
	
	int plane;
	
	int sourceX;
	
	int sourceY;
	
	int sourceZ;
	
	int endHeight;
	
	int cycleStart;
	
	int cycleEnd;
	
	int slope;
	
	int startHeight;
	
	int targetIndex;
	boolean isMoving;
	double x;
	double y;
	double z;
	double speedX;
	double speedY;
	double speed;
	double speedZ;
	double accelerationZ;
	
	int yaw;
	
	int pitch;
	
	Anim_SequenceDefinition sequenceDefinition;
	
	int frame;
	
	int frameCycle;
	Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
		this.isMoving = false; // L: 20
		this.frame = 0; // L: 32
		this.frameCycle = 0; // L: 33
		this.id = var1; // L: 36
		this.plane = var2; // L: 37
		this.sourceX = var3; // L: 38
		this.sourceY = var4; // L: 39
		this.sourceZ = var5; // L: 40
		this.cycleStart = var6; // L: 41
		this.cycleEnd = var7; // L: 42
		this.slope = var8; // L: 43
		this.startHeight = var9; // L: 44
		this.targetIndex = var10; // L: 45
		this.endHeight = var11; // L: 46
		this.isMoving = false; // L: 47
		int var12 = _Junk.SpotAnimationDefinition_get(this.id).sequence; // L:
																				// 48
		if (var12 != -1) { // L: 49
			this.sequenceDefinition = Anim_SequenceDefinition.SequenceDefinition_get(var12);
		} else {
			this.sequenceDefinition = null; // L: 50
		}
	} // L: 51
	
	final void setDestination(int var1, int var2, int var3, int var4) {
		double var5;
		if (!this.isMoving) { // L: 54
			var5 = (double) (var1 - this.sourceX); // L: 55
			double var7 = (double) (var2 - this.sourceY); // L: 56
			double var9 = Math.sqrt(var5 * var5 + var7 * var7); // L: 57
			this.x = (double) this.startHeight * var5 / var9 + (double) this.sourceX; // L:
																						// 58
			this.y = var7 * (double) this.startHeight / var9 + (double) this.sourceY; // L:
																						// 59
			this.z = (double) this.sourceZ; // L: 60
		}
		var5 = (double) (this.cycleEnd + 1 - var4); // L: 62
		this.speedX = ((double) var1 - this.x) / var5; // L: 63
		this.speedY = ((double) var2 - this.y) / var5; // L: 64
		this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY); // L:
																						// 65
		if (!this.isMoving) { // L: 66
			this.speedZ = -this.speed * Math.tan((double) this.slope * 0.02454369D);
		}
		this.accelerationZ = 2.0D * ((double) var3 - this.z - var5 * this.speedZ) / (var5 * var5); // L:
																									// 67
	} // L: 68
	
	protected final Model getModel() {
		SpotAnimationDefinition var1 = _Junk.SpotAnimationDefinition_get(this.id); // L:
																							// 101
		Model var2 = var1.getModel(this.frame); // L: 102
		if (var2 == null) { // L: 103
			return null;
		} else {
			var2.rotateZ(this.pitch); // L: 104
			return var2; // L: 105
		}
	}
	
	final void advance(int var1) {
		this.isMoving = true; // L: 71
		this.x += this.speedX * (double) var1; // L: 72
		this.y += (double) var1 * this.speedY; // L: 73
		this.z += (double) var1 * this.speedZ + (double) var1 * this.accelerationZ * 0.5D * (double) var1; // L:
																											// 74
		this.speedZ += this.accelerationZ * (double) var1; // L: 75
		this.yaw = (int) (Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047; // L:
																							// 76
		this.pitch = (int) (Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047; // L:
																					// 77
		if (this.sequenceDefinition != null) { // L: 78
			if (!this.sequenceDefinition.isCachedModelIdSet()) { // L: 79
				this.frameCycle += var1; // L: 80
				while (true) {
					do {
						do {
							if (this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) { // L:
																										// 81
								return; // L: 98
							}
							this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame]; // L:
																									// 82
							++this.frame; // L: 83
						} while (this.frame < this.sequenceDefinition.frameIds.length); // L:
																						// 84
						this.frame -= this.sequenceDefinition.frameCount; // L:
																			// 85
					} while (this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length); // L:
																										// 86
					this.frame = 0;
				}
			} else {
				this.frame += var1; // L: 91
				int var2 = this.sequenceDefinition.skeletalFrameCount(); // L: 92
				if (this.frame >= var2) { // L: 93
					this.frame = var2 - this.sequenceDefinition.frameCount; // L:
																			// 94
				}
			}
		}
	}
	
	public static int method1950(CharSequence var0) {
		int var1 = var0.length(); // L: 148
		int var2 = 0; // L: 149
		for (int var3 = 0; var3 < var1; ++var3) { // L: 150
			var2 = (var2 << 5) - var2 + var0.charAt(var3);
		}
		return var2; // L: 151
	}
	
	public static void method1959() {
		ItemComposition.ItemDefinition_cachedSprites.clear(); // L: 569
	} // L: 570
	
	static final void method1961() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear(); // L: 2950
		NPC.method2379(); // L: 2952
		Widget.method5711(); // L: 2953
		class141.method3047(); // L: 2954
		PacketBufferNode.method5194(); // L: 2955
		_Junk.method1702(); // L: 2956
		Anim_SequenceDefinition.SequenceDefinition_cached.clear(); // L: 2958
		Anim_SequenceDefinition.SequenceDefinition_cachedFrames.clear(); // L: 2959
		Anim_SequenceDefinition.SequenceDefinition_cachedModel.clear(); // L: 2960
		FileSystem.method3282(); // L: 2962
		VarbitComposition.VarbitDefinition_cached.clear(); // L: 2964
		VarpDefinition.VarpDefinition_cached.clear(); // L: 2967
		AbstractWorldMapData.HitSplatDefinition_cachedSprites.method7525(); // L:
																			// 2969
		ModeWhere.HitSplatDefinition_cached.method7525(); // L: 2970
		HitSplatDefinition.HitSplatDefinition_cached.clear(); // L: 2972
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear(); // L: 2973
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear(); // L: 2974
		class92.method2389(); // L: 2976
		Interpreter.method1868(); // L: 2977
		class67.method1886(); // L: 2978
		_Junk.method763(); // L: 2979
		MilliClock.method3301(); // L: 2980
		class67.method1887(); // L: 2981
		Client.Widget_cachedModels.clear(); // L: 2982
		Client.Widget_cachedFonts.clear(); // L: 2983
		class14.method148(); // L: 2984
		Widget.Widget_cachedSprites.clear(); // L: 2986
		Widget.Widget_cachedModels.clear(); // L: 2987
		Widget.Widget_cachedFonts.clear(); // L: 2988
		Widget.Widget_cachedSpriteMasks.clear(); // L: 2989
		((TextureProvider) Rasterizer3D.Rasterizer3D_textureLoader).clear(); // L:
																				// 2991
		Script.Script_cached.clear(); // L: 2992
		Varcs.archive5.clearFiles(); // L: 2993
		WorldMapEvent.field2882.clearFiles(); // L: 2994
		class341.archive7.clearFiles(); // L: 2995
		Archives.archive4.clearFiles(); // L: 2996
		WorldMapSectionType.archive9.clearFiles(); // L: 2997
		Archives.archive6.clearFiles(); // L: 2998
		class10.archive7.clearFiles(); // L: 2999
		class304.archive8.clearFiles(); // L: 3000
		Language.field4098.clearFiles(); // L: 3001
		ApproximateRouteStrategy.archive10.clearFiles(); // L: 3002
		Archives.archive11.clearFiles(); // L: 3003
		class267.archive12.clearFiles(); // L: 3004
		class132.field1588.clearFiles(); // L: 3005
	} // L: 3006
}
