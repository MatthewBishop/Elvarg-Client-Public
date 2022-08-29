package audioengine;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import adapter.IAudioBridge;
import adapter.ICacheArchive;
import adapter.ISequenceDefinition;

public class StaticSound {
	
	static IAudioBridge bridge;
	
	public static IAudioBridge getBridge() {
		return bridge;
	}

	public static PcmPlayer pcmPlayer0;
	public static PcmPlayer pcmPlayer1;
	
	public static void addSound(int var6, int var4, int var5, int i) {
		if (StaticSound.getBridge().method2262() != 0 && var4 > 0 && StaticSound.soundEffectCount < 50) {
			StaticSound.soundEffectIds[StaticSound.soundEffectCount] = var6; // L:
			// 7558
			StaticSound.queuedSoundEffectLoops[StaticSound.soundEffectCount] = var4; // L:
			// 7559
			StaticSound.queuedSoundEffectDelays[StaticSound.soundEffectCount] = var5; // L:
			// 7560
			StaticSound.soundEffects[StaticSound.soundEffectCount] = null; // L:
			// 7561
			StaticSound.soundLocations[StaticSound.soundEffectCount] = i; // L:
			// 7562
			++StaticSound.soundEffectCount; // L: 7563
		}
	}

	public static void clear() {
		// TODO Auto-generated method stub
	
		StaticSound.musicPlayerStatus = 1; // L: 1307
		StaticSound.musicTrackArchive = null; // L: 1308
		StaticSound.musicTrackGroupId = -1; // L: 1309
		StaticSound.musicTrackFileId = -1; // L: 1310
		StaticSound.musicTrackVolume = 0; // L: 1311
		StaticSound.musicTrackBoolean = false; // L: 1312
		StaticSound.pcmSampleLength = 2; // L: 1313		
	}

	public static void draw() {
		// TODO Auto-generated method stub
		boolean var2;
		label174: {
			try {
				if (StaticSound.musicPlayerStatus == 2) { // L: 1136
					if (StaticSound.musicTrack == null) { // L: 1137
						StaticSound.musicTrack = MusicTrack.readTrack(StaticSound.musicTrackArchive,
								StaticSound.musicTrackGroupId, StaticSound.musicTrackFileId); // L:
																						// 1138
						if (StaticSound.musicTrack == null) { // L: 1139
							var2 = false; // L: 1140
							break label174;
						}
					}
					if (StaticSound.soundCache == null) { // L: 1144
						StaticSound.soundCache = new SoundCache(StaticSound.soundEffectsArchive,
								StaticSound.musicSamplesArchive);
					}
					if (StaticSound.midiPcmStream.loadMusicTrack(StaticSound.musicTrack, StaticSound.musicPatchesArchive,
							StaticSound.soundCache, 22050)) { // L:
															// 1145
						StaticSound.midiPcmStream.clearAll(); // L: 1146
						StaticSound.midiPcmStream.setPcmStreamVolume(StaticSound.musicTrackVolume); // L:
																								// 1147
						StaticSound.midiPcmStream.setMusicTrack(StaticSound.musicTrack, StaticSound.musicTrackBoolean); // L:
																												// 1148
						StaticSound.musicPlayerStatus = 0; // L: 1149
						StaticSound.musicTrack = null; // L: 1150
						StaticSound.soundCache = null; // L: 1151
						StaticSound.musicTrackArchive = null; // L: 1152
						var2 = true; // L: 1153
						break label174;
					}
				}
			} catch (Exception var6) { // L: 1158
				var6.printStackTrace(); // L: 1159
				StaticSound.midiPcmStream.clear(); // L: 1160
				StaticSound.musicPlayerStatus = 0; // L: 1161
				StaticSound.musicTrack = null; // L: 1162
				StaticSound.soundCache = null; // L: 1163
				StaticSound.musicTrackArchive = null; // L: 1164
			}
			var2 = false; // L: 1166
		}
		if (var2 && StaticSound.playingJingle && StaticSound.pcmPlayer0 != null) { // L:
			// 1169
			// 1170
			StaticSound.pcmPlayer0.tryDiscard();
		}
	}

	public static void init(IAudioBridge bridge) {
		StaticSound.method2885(new DevicePcmPlayerProvider()); // L: 95
		StaticSound.bridge = bridge;
	}

	public static void LoginButton() {
		// TODO Auto-generated method stub
		StaticSound.getBridge().method2248(!StaticSound.getBridge().method2317()); // L:
		// 312
		if (!StaticSound.getBridge().method2317()) { // L: 313
			ICacheArchive var2 = StaticSound.archive6; // L: 314
			int var3 = var2.getGroupId("scape main"); // L: 316
			int var4 = var2.getFileId(var3, ""); // L: 317
			StaticSound.method2410(var2, var3, var4, 255, false); // L:
// 318
		} else {
			StaticSound.method579(); // L: 321
		}
	}

	public static void logout() {
		// TODO Auto-generated method stub
		StaticSound.musicPlayerStatus = 1; // L: 2908
		StaticSound.musicTrackArchive = null; // L: 2909
		StaticSound.musicTrackGroupId = -1; // L: 2910
		StaticSound.musicTrackFileId = -1; // L: 2911
		StaticSound.musicTrackVolume = 0; // L: 2912
		StaticSound.musicTrackBoolean = false; // L: 2913
		StaticSound.pcmSampleLength = 2; // L: 2914
		currentTrackGroupId = -1; // L: 2916
		playingJingle = false; // L: 2917
		ObjectSound.clearObjectSounds(); // L: 2918
	}

	public static final void method4532() {
		for (int var0 = 0; var0 < StaticSound.soundEffectCount; ++var0) { // L: 3633
			int var10002 = StaticSound.queuedSoundEffectDelays[var0]--; // L: 3634
			if (StaticSound.queuedSoundEffectDelays[var0] >= -10) { // L: 3635
				SoundEffect var1 = StaticSound.soundEffects[var0]; // L: 3647
				if (var1 == null) { // L: 3648
					Object var10000 = null; // L: 3649
					var1 = SoundEffect.readSoundEffect(StaticSound.soundEffectsArchive, StaticSound.soundEffectIds[var0], 0);
					if (var1 == null) { // L: 3650
						continue;
					}
					int[] var13 = StaticSound.queuedSoundEffectDelays; // L: 3651
					var13[var0] += var1.calculateDelay();
					StaticSound.soundEffects[var0] = var1; // L: 3652
				}
				if (StaticSound.queuedSoundEffectDelays[var0] < 0) { // L: 3658
					int var2;
					if (StaticSound.soundLocations[var0] != 0) { // L: 3660
						int var3 = (StaticSound.soundLocations[var0] & 255) * 128; // L:
																				// 3661
						int var4 = StaticSound.soundLocations[var0] >> 16 & 255; // L:
																				// 3662
						int var5 = var4 * 128 + 64 - StaticSound.getBridge().playerX(); // L:
																				// 3663
						if (var5 < 0) { // L: 3664
							var5 = -var5;
						}
						int var6 = StaticSound.soundLocations[var0] >> 8 & 255; // L:
																				// 3665
						int var7 = var6 * 128 + 64 - StaticSound.getBridge().playerY(); // L:
																				// 3666
						if (var7 < 0) { // L: 3667
							var7 = -var7;
						}
						int var8 = var7 + var5 - 128; // L: 3668
						if (var8 > var3) { // L: 3669
							StaticSound.queuedSoundEffectDelays[var0] = -100; // L:
																			// 3670
							continue; // L: 3671
						}
						if (var8 < 0) { // L: 3673
							var8 = 0;
						}
						var2 = (var3 - var8) * StaticSound.getBridge().method2262() / var3; // L:
																								// 3674
					} else {
						var2 = StaticSound.getBridge().method2241(); // L:
																		// 3676
					}
					if (var2 > 0) { // L: 3677
						RawSound var9 = var1.toRawSound().resample(StaticSound.decimator); // L:
																						// 3678
						RawPcmStream var10 = RawPcmStream.createRawPcmStream(var9, 100, var2); // L:
																								// 3679
						var10.setNumLoops(StaticSound.queuedSoundEffectLoops[var0] - 1); // L:
																						// 3680
						StaticSound.pcmStreamMixer.addSubStream(var10); // L: 3681
					}
					StaticSound.queuedSoundEffectDelays[var0] = -100; // L: 3683
				}
			} else {
				--StaticSound.soundEffectCount; // L: 3636
				for (int var11 = var0; var11 < StaticSound.soundEffectCount; ++var11) { // L:
																						// 3637
					StaticSound.soundEffectIds[var11] = StaticSound.soundEffectIds[var11 + 1]; // L:
																							// 3638
					StaticSound.soundEffects[var11] = StaticSound.soundEffects[var11 + 1]; // L:
																						// 3639
					StaticSound.queuedSoundEffectLoops[var11] = StaticSound.queuedSoundEffectLoops[var11 + 1]; // L:
																											// 3640
					StaticSound.queuedSoundEffectDelays[var11] = StaticSound.queuedSoundEffectDelays[var11 + 1]; // L:
																											// 3641
					StaticSound.soundLocations[var11] = StaticSound.soundLocations[var11 + 1]; // L:
																							// 3642
				}
				--var0; // L: 3644
			}
		}
		if (StaticSound.playingJingle) { // L: 3686
			boolean var12;
			if (StaticSound.musicPlayerStatus != 0) { // L: 3689
				var12 = true; // L: 3690
			} else {
				var12 = StaticSound.midiPcmStream.isReady(); // L: 3693
			}
			if (!var12) { // L: 3695
				if (StaticSound.getBridge().method2258() != 0 && StaticSound.currentTrackGroupId != -1) { // L:
																											// 3696
					StaticSound.method2410(StaticSound.archive6, StaticSound.currentTrackGroupId, 0,
							StaticSound.getBridge().method2258(), false);
				}
				StaticSound.playingJingle = false; // L: 3697
			}
		}
	} // L: 3700

	public static final void method5196(int var0) {
		var0 = Math.min(Math.max(var0, 0), 255); // L: 11840
		if (var0 != StaticSound.getBridge().method2258()) { // L: 11841
			if (StaticSound.getBridge().method2258() == 0 && currentTrackGroupId != -1) { // L:
																							// 11842
				StaticSound.method2410(StaticSound.archive6, currentTrackGroupId, 0, var0, false); // L:
																								// 11843
				playingJingle = false; // L: 11844
			} else if (var0 == 0) { // L: 11846
				method579(); // L: 11847
				playingJingle = false; // L: 11848
			} else {
				method1005(var0); // L: 11850
			}
			StaticSound.getBridge().method2297(var0); // L: 11851
		}
	} // L: 11853

	public static void method2761(ISequenceDefinition var0, int var1, int var2, int var3) {
		if (soundEffectCount < 50 && StaticSound.getBridge().method2262() != 0) { // L:
			int[] soundE = var0.getSoundEffects();																		// 3703
			if (soundE != null && var1 < soundE.length) { // L:
																				// 3704
				int range = soundE[var1]; // L: 3705
				if (range != 0) { // L: 3709
					int var7 = range >> 8; // L: 3710
					int var8 = range >> 4 & 7; // L: 3711
					int var9 = range & 15; // L: 3712
					soundEffectIds[soundEffectCount] = var7; // L:
																// 3713
					queuedSoundEffectLoops[soundEffectCount] = var8; // L:
																		// 3714
					queuedSoundEffectDelays[soundEffectCount] = 0; // L:
																	// 3715
					soundEffects[soundEffectCount] = null; // L:
															// 3716
					int var10 = (var2 - 64) / 128; // L: 3717
					int var11 = (var3 - 64) / 128; // L: 3718
					soundLocations[soundEffectCount] = var9 + (var11 << 8) + (var10 << 16); // L:
																							// 3719
					++soundEffectCount; // L: 3720
				}
			}
		}
	} // L: 3722
	
	public static void method5997(ISequenceDefinition var0, int var1, int var2, int var3) {
		if (soundEffectCount < 50 && StaticSound.getBridge().method2262() != 0) { // L:
																					// 3725
			Map skeletalSounds = var0.getSkeletalSounds();
			if (skeletalSounds != null && skeletalSounds.containsKey(var1)) { // L:
																				// 3726
				int range = (Integer) skeletalSounds.get(var1); // L: 3727
				if (range != 0) { // L: 3731
					int var7 = range >> 8; // L: 3732
					int var8 = range >> 4 & 7; // L: 3733
					int var9 = range & 15; // L: 3734
					soundEffectIds[soundEffectCount] = var7; // L:
																// 3735
					queuedSoundEffectLoops[soundEffectCount] = var8; // L:
																		// 3736
					queuedSoundEffectDelays[soundEffectCount] = 0; // L:
																	// 3737
					soundEffects[soundEffectCount] = null; // L:
															// 3738
					int var10 = (var2 - 64) / 128; // L: 3739
					int var11 = (var3 - 64) / 128; // L: 3740
					soundLocations[soundEffectCount] = var9 + (var11 << 8) + (var10 << 16); // L:
																							// 3741
					++soundEffectCount; // L: 3742
				}
			}
		}
	} // L: 3744

	public static void method719(int var0, int var1) {
		if (StaticSound.getBridge().method2258() != 0 && var0 != -1) { // L:
																			// 3778
			StaticSound.method2410(StaticSound.archive11, var0, 0, StaticSound.getBridge().method2258(), false); // L:
			// 3779
			playingJingle = true; // L: 3780
		}
	} // L: 3782

	public static final void playPcmPlayers() {
		if (pcmPlayer1 != null) { // L: 3628
			pcmPlayer1.run();
		}
		if (pcmPlayer0 != null) { // L: 3629
			pcmPlayer0.run();
		}
	} // L: 3630

	public static void playSong(int var0) {
		if (var0 == -1 && !playingJingle) { // L: 3758
			method579(); // L: 3759
		} else if (var0 != -1 && var0 != currentTrackGroupId && StaticSound.getBridge().method2258() != 0
				&& !playingJingle) { // L:
										// 3761
			ICacheArchive var1 = StaticSound.archive6; // L: 3762
			int var2 = StaticSound.getBridge().method2258(); // L: 3763
			StaticSound.musicPlayerStatus = 1; // L: 3765
			StaticSound.musicTrackArchive = var1; // L: 3766
			StaticSound.musicTrackGroupId = var0; // L: 3767
			StaticSound.musicTrackFileId = 0; // L: 3768
			StaticSound.musicTrackVolume = var2; // L: 3769
			StaticSound.musicTrackBoolean = false; // L: 3770
			StaticSound.pcmSampleLength = 2; // L: 3771
		}
		currentTrackGroupId = var0; // L: 3774
	} // L: 3775

	/**
	 * Added
	 */
	public static void pulse() {
		// TODO Auto-generated method stub
		int var6;
		try {
			if (StaticSound.musicPlayerStatus == 1) { // L: 1027
				var6 = StaticSound.midiPcmStream.method5254(); // L: 1028
				if (var6 > 0 && StaticSound.midiPcmStream.isReady()) { // L:
																	// 1029
					var6 -= StaticSound.pcmSampleLength; // L: 1030
					if (var6 < 0) { // L: 1031
						var6 = 0;
					}
					StaticSound.midiPcmStream.setPcmStreamVolume(var6); // L:
																		// 1032
				} else {
					StaticSound.midiPcmStream.clear(); // L: 1035
					StaticSound.midiPcmStream.removeAll(); // L: 1036
					if (StaticSound.musicTrackArchive != null) { // L: 1037
						StaticSound.musicPlayerStatus = 2;
					} else {
						StaticSound.musicPlayerStatus = 0; // L: 1038
					}
					StaticSound.musicTrack = null; // L: 1039
					StaticSound.soundCache = null; // L: 1040
				}
			}
		} catch (Exception var11) { // L: 1043
			var11.printStackTrace(); // L: 1044
			StaticSound.midiPcmStream.clear(); // L: 1045
			StaticSound.musicPlayerStatus = 0; // L: 1046
			StaticSound.musicTrack = null; // L: 1047
			StaticSound.soundCache = null; // L: 1048
			StaticSound.musicTrackArchive = null; // L: 1049
		}
		StaticSound.playPcmPlayers(); // L: 1052
	}

	public static void queueSoundEffect(int var0, int var1, int var2) {
		if (StaticSound.getBridge().method2241() != 0 && var1 != 0 && soundEffectCount < 50) { // L:
																									// 3747
			soundEffectIds[soundEffectCount] = var0; // L: 3748
			queuedSoundEffectLoops[soundEffectCount] = var1; // L:
																// 3749
			queuedSoundEffectDelays[soundEffectCount] = var2; // L:
																// 3750
			soundEffects[soundEffectCount] = null; // L: 3751
			soundLocations[soundEffectCount] = 0; // L: 3752
			++soundEffectCount; // L: 3753
		}
	} // L: 3755

	public static void resetSoundCount() {
		// TODO Auto-generated method stub
		StaticSound.soundEffectCount = 0; // L: 5695
	}

	public static void setup(boolean highDetail, ICacheArchive archive4, ICacheArchive archive6, ICacheArchive archive11, ICacheArchive archive14,
			ICacheArchive archive15) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		StaticSound.method3438(22050, highDetail, 2); // L:
		// 1748
		MidiPcmStream var25 = new MidiPcmStream(); // L: 1749
		var25.method5304(9, 128); // L: 1750
		StaticSound.pcmPlayer0 = StaticSound.method6849(0, 22050); // L:
		// 1751
		StaticSound.pcmPlayer0.setStream(var25); // L: 1752
		
		StaticSound.soundEffectsArchive = archive4;
		StaticSound.archive6 = archive6;
		StaticSound.archive11 = archive11;
		StaticSound.musicSamplesArchive = archive14;
		StaticSound.musicPatchesArchive = archive15;
		
		StaticSound.midiPcmStream = var25; // L: 1760
		StaticSound.pcmPlayer1 = StaticSound.method6849(1, 2048); // L:
		// 1762
		StaticSound.pcmStreamMixer = new PcmStreamMixer(); // L: 1763
		StaticSound.pcmPlayer1.setStream(StaticSound.pcmStreamMixer); // L:
		// 1764
		StaticSound.decimator = new Decimator(22050, StaticSound.field287); // L:
		// 1765
	}

	public static void update() {
		// TODO Auto-generated method stub
		if (!StaticSound.getBridge().method2317()) {
			ICacheArchive var11 = StaticSound.archive6;
			int var8 = var11.getGroupId("scape main");
			int var9 = var11.getFileId(var8, "");
			StaticSound.musicPlayerStatus = 1;
			StaticSound.musicTrackArchive = var11;
			StaticSound.musicTrackGroupId = var8;
			StaticSound.musicTrackFileId = var9; // L: 245
			StaticSound.musicTrackVolume = 255;
			StaticSound.musicTrackBoolean = false;
			StaticSound.pcmSampleLength = 2;
		} else {
			StaticSound.musicPlayerStatus = 1; // L: 253
			StaticSound.musicTrackArchive = null;
			StaticSound.musicTrackGroupId = -1;
			StaticSound.musicTrackFileId = -1;
			StaticSound.musicTrackVolume = 0;
			StaticSound.musicTrackBoolean = false;
			StaticSound.pcmSampleLength = 2;
		}
	}

	protected static ICacheArchive archive11;
	protected static ICacheArchive archive6;
	protected static int currentTrackGroupId;
	protected static Decimator decimator;
	protected static int field1212;
	protected static int field287;
	protected static MidiPcmStream midiPcmStream;
	protected static ICacheArchive musicPatchesArchive;
	protected static int musicPlayerStatus = 0; // L: 11
	protected static ICacheArchive musicSamplesArchive;
	protected static MusicTrack musicTrack;
	protected static ICacheArchive musicTrackArchive;
	protected static boolean musicTrackBoolean;
	protected static int musicTrackFileId;
	protected static int musicTrackGroupId;
	protected static int musicTrackVolume;
	protected static boolean PcmPlayer_stereo;
	protected static PcmPlayerProvider pcmPlayerProvider;
	protected static int pcmSampleLength;

	
	protected static PcmStreamMixer pcmStreamMixer;
	protected static boolean playingJingle;
	protected static int[] queuedSoundEffectDelays;
	protected static int[] queuedSoundEffectLoops;

	protected static SoundCache soundCache;

	protected static int soundEffectCount;
	protected static int[] soundEffectIds;
	protected static SoundEffect[] soundEffects;
	
	protected static ICacheArchive soundEffectsArchive;

	protected static int[] soundLocations;

	static {
		StaticSound.currentTrackGroupId = -1; // L: 639
		StaticSound.playingJingle = false; // L: 640
		StaticSound.soundEffectCount = 0; // L: 646
		StaticSound.soundEffectIds = new int[50]; // L: 647
		StaticSound.queuedSoundEffectLoops = new int[50]; // L: 648
		StaticSound.queuedSoundEffectDelays = new int[50]; // L: 649
		StaticSound.soundLocations = new int[50]; // L: 650
		StaticSound.soundEffects = new SoundEffect[50]; // L: 651
	}

	protected static void clearIntArray(int[] var0, int var1, int var2) {
		for (var2 = var2 + var1 - 7; var1 < var2; var0[var1++] = 0) { // L: 364
																		// 365
																		// 373
			var0[var1++] = 0; // L: 366
			var0[var1++] = 0; // L: 367
			var0[var1++] = 0; // L: 368
			var0[var1++] = 0; // L: 369
			var0[var1++] = 0; // L: 370
			var0[var1++] = 0; // L: 371
			var0[var1++] = 0; // L: 372
		}
		for (var2 += 7; var1 < var2; var0[var1++] = 0) { // L: 375 376
		}
	} // L: 377

	protected static int iLog(int var0) {
		int var1 = 0; // L: 60
		if (var0 < 0 || var0 >= 65536) { // L: 61
			var0 >>>= 16; // L: 62
			var1 += 16; // L: 63
		}
		if (var0 >= 256) { // L: 65
			var0 >>>= 8; // L: 66
			var1 += 8; // L: 67
		}
		if (var0 >= 16) { // L: 69
			var0 >>>= 4; // L: 70
			var1 += 4; // L: 71
		}
		if (var0 >= 4) { // L: 73
			var0 >>>= 2; // L: 74
			var1 += 2; // L: 75
		}
		if (var0 >= 1) { // L: 77
			var0 >>>= 1; // L: 78
			++var1; // L: 79
		}
		return var0 + var1; // L: 81
	}

	protected static void method1005(int var0) {
		if (StaticSound.musicPlayerStatus != 0) { // L: 36
			StaticSound.musicTrackVolume = var0;
		} else {
			StaticSound.midiPcmStream.setPcmStreamVolume(var0); // L: 37
		}
	} // L: 38
	protected static void method2410(ICacheArchive var0, int var1, int var2, int var3, boolean var4) {
		StaticSound.musicPlayerStatus = 1; // L: 26
		StaticSound.musicTrackArchive = var0; // L: 27
		StaticSound.musicTrackGroupId = var1; // L: 28
		StaticSound.musicTrackFileId = var2; // L: 29
		StaticSound.musicTrackVolume = var3; // L: 30
		StaticSound.musicTrackBoolean = var4; // L: 31
		StaticSound.pcmSampleLength = 10000; // L: 32
	} // L: 33

	protected static final void method2885(PcmPlayerProvider var0) {
		pcmPlayerProvider = var0; // L: 45
	} // L: 46

	protected static int method302(int var0, int var1) {
		int var2;
		for (var2 = 0; var1 > 0; --var1) { // L: 85 86 89
			var2 = var2 << 1 | var0 & 1; // L: 87
			var0 >>>= 1; // L: 88
		}
		return var2; // L: 91
	}

	protected static final void method3438(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) { // L: 49
			field287 = var0; // L: 50
			StaticSound.PcmPlayer_stereo = var1; // L: 51
			StaticSound.field1212 = var2; // L: 52
		} else {
			throw new IllegalArgumentException();
		}
	} // L: 53

	protected static void method579() {
		StaticSound.midiPcmStream.clear();
		StaticSound.musicPlayerStatus = 1;
		StaticSound.musicTrackArchive = null; // L: 43
	}

	protected static final PcmPlayer method6849(int var1, int var2) {
		if (var1 >= 0 && var1 < 2) { // L: 57
			if (var2 < 256) { // L: 58
				var2 = 256;
			}
			try {
				PcmPlayer var3 = StaticSound.pcmPlayerProvider.player(); // L: 60
				var3.samples = new int[256 * (StaticSound.PcmPlayer_stereo ? 2 : 1)]; // L:
																					// 61
				var3.field282 = var2; // L: 62
				var3.init(); // L: 63
				var3.capacity = (var2 & -1024) + 1024; // L: 64
				if (var3.capacity > 16384) { // L: 65
					var3.capacity = 16384;
				}
				var3.open(var3.capacity); // L: 66
				if (field1212 > 0 && PcmPlayer.soundSystem == null) { // L:
																		// 67
					PcmPlayer.soundSystem = new SoundSystem(); // L: 68
					PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1); // L:
																							// 69
					PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(PcmPlayer.soundSystem, 0L, 10L,
							TimeUnit.MILLISECONDS); // L:
													// 70
				}
				if (PcmPlayer.soundSystem != null) { // L: 72
					if (PcmPlayer.soundSystem.players[var1] != null) { // L: 73
						throw new IllegalArgumentException();
					}
					PcmPlayer.soundSystem.players[var1] = var3; // L: 74
				}
				return var3; // L: 76
			} catch (Throwable var4) { // L: 78
				return new PcmPlayer(); // L: 79
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	protected static final void PcmStream_disable(PcmStream var0) {
		var0.active = false; // L: 270
		if (var0.sound != null) { // L: 271
			var0.sound.position = 0;
		}
		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1); // L: 272
		}
	} // L: 273

}
