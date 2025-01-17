package osrs;
public class WorldMapArchiveLoader {
	String cacheName;
	
	AbstractArchive archive;
	
	int percentLoaded;
	boolean loaded;
	
	WorldMapArchiveLoader(AbstractArchive var1) {
		this.percentLoaded = 0; // L: 13
		this.loaded = false; // L: 14
		this.archive = var1; // L: 17
	} // L: 18
	
	void reset(String var1) {
		if (var1 != null && !var1.isEmpty()) { // L: 21
			if (var1 != this.cacheName) { // L: 24
				this.cacheName = var1; // L: 27
				this.percentLoaded = 0; // L: 28
				this.loaded = false; // L: 29
				this.load(); // L: 30
			}
		}
	} // L: 22 25 31
	
	int load() {
		if (this.percentLoaded < 33) { // L: 34
			if (!this.archive.tryLoadFileByNames(WorldMapCacheName.field2865.name, this.cacheName)) { // L:
																										// 35
				return this.percentLoaded; // L: 36
			}
			this.percentLoaded = 33; // L: 38
		}
		if (this.percentLoaded == 33) { // L: 40
			if (this.archive.isValidFileName(WorldMapCacheName.field2866.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.field2866.name, this.cacheName)) { // L:
																																														// 41
																																														// 42
				return this.percentLoaded; // L: 43
			}
			this.percentLoaded = 66; // L: 46
		}
		if (this.percentLoaded == 66) { // L: 48
			if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.field2868.name)) { // L:
																										// 49
				return this.percentLoaded; // L: 50
			}
			this.percentLoaded = 100; // L: 52
			this.loaded = true; // L: 53
		}
		return this.percentLoaded; // L: 55
	}
	
	boolean isLoaded() {
		return this.loaded; // L: 59
	}
	
	int getPercentLoaded() {
		return this.percentLoaded; // L: 63
	}
}
