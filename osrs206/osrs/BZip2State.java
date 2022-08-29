package osrs;
public final class BZip2State {
	final int field4709;
	final int field4704;
	final int field4705;
	final int field4713;
	final int field4707;
	final int field4712;
	byte[] inputArray;
	
	int nextByte;
	
	int nextBit_unused;
	byte[] outputArray;
	
	int next_out;
	
	int outputLength;
	
	int field4715;
	byte out_char;
	
	int su_rNToGo;
	
	int bsBuff;
	
	int bsLive;
	int blockSize100k;
	
	int originalPointer;
	
	int field4722;
	
	int su_ch2;
	int[] unzftab;
	
	int nblocks_used;
	int[] cftab;
	
	int nInUse;
	boolean[] inUse;
	boolean[] inUse16;
	byte[] seqToUnseq;
	byte[] ll8;
	int[] getAndMoveToFrontDecode_yy;
	byte[] selector;
	byte[] selectorMtf;
	byte[][] temp_charArray2d;
	int[][] limit;
	int[][] base;
	int[][] perm;
	int[] minLens;
	
	int field4734;
	BZip2State() {
		this.field4709 = 4096; // L: 4
		this.field4704 = 16; // L: 5
		this.field4705 = 258; // L: 6
		this.field4713 = 6; // L: 7
		this.field4707 = 50; // L: 8
		this.field4712 = 18002; // L: 9
		this.nextByte = 0; // L: 11
		this.next_out = 0; // L: 14
		this.unzftab = new int[256]; // L: 25
		this.cftab = new int[257]; // L: 27
		this.inUse = new boolean[256]; // L: 30
		this.inUse16 = new boolean[16]; // L: 31
		this.seqToUnseq = new byte[256]; // L: 32
		this.ll8 = new byte[4096]; // L: 33
		this.getAndMoveToFrontDecode_yy = new int[16]; // L: 34
		this.selector = new byte[18002]; // L: 35
		this.selectorMtf = new byte[18002]; // L: 36
		this.temp_charArray2d = new byte[6][258]; // L: 37
		this.limit = new int[6][258]; // L: 38
		this.base = new int[6][258]; // L: 39
		this.perm = new int[6][258]; // L: 40
		this.minLens = new int[6]; // L: 41
	} // L: 44
}
