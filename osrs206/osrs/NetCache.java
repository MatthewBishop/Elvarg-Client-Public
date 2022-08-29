package osrs;
import java.util.zip.CRC32;
public class NetCache {
	
	public static AbstractSocket NetCache_socket;
	
	public static int NetCache_loadTime;
	
	public static long field4029;
	
	public static NodeHashTable NetCache_pendingPriorityWrites;
	
	public static int NetCache_pendingPriorityWritesCount;
	
	public static NodeHashTable NetCache_pendingPriorityResponses;
	
	public static int NetCache_pendingPriorityResponsesCount;
	
	public static DualNodeDeque NetCache_pendingWritesQueue;
	
	public static NodeHashTable NetCache_pendingWrites;
	
	public static int NetCache_pendingWritesCount;
	
	public static NodeHashTable NetCache_pendingResponses;
	
	public static int NetCache_pendingResponsesCount;
	
	public static Buffer NetCache_responseHeaderBuffer;
	
	public static int field4027;
	public static CRC32 NetCache_crc;
	
	public static Archive[] NetCache_archives;
	
	static int field4031;
	
	static int field4032;
	public static byte field4033;
	
	public static int NetCache_crcMismatches;
	
	public static int NetCache_ioExceptions;
	
	static int selectedSpellWidget;
	static {
		NetCache_loadTime = 0; // L: 13
		NetCache_pendingPriorityWrites = new NodeHashTable(4096); // L: 15
		NetCache_pendingPriorityWritesCount = 0; // L: 16
		NetCache_pendingPriorityResponses = new NodeHashTable(32); // L: 17
		NetCache_pendingPriorityResponsesCount = 0; // L: 18
		NetCache_pendingWritesQueue = new DualNodeDeque(); // L: 19
		NetCache_pendingWrites = new NodeHashTable(4096); // L: 20
		NetCache_pendingWritesCount = 0; // L: 21
		NetCache_pendingResponses = new NodeHashTable(4096); // L: 22
		NetCache_pendingResponsesCount = 0; // L: 23
		NetCache_responseHeaderBuffer = new Buffer(8); // L: 26
		field4027 = 0; // L: 28
		NetCache_crc = new CRC32(); // L: 30
		NetCache_archives = new Archive[256]; // L: 32
		field4031 = -1; // L: 33
		field4032 = 255; // L: 34
		field4033 = 0; // L: 35
		NetCache_crcMismatches = 0; // L: 36
		NetCache_ioExceptions = 0; // L: 37
	}
	
	public static String method5952(CharSequence var0) {
		int var2 = var0.length(); // L: 187
		char[] var3 = new char[var2]; // L: 189
		for (int var4 = 0; var4 < var2; ++var4) { // L: 190
			var3[var4] = '*';
		}
		String var1 = new String(var3); // L: 191
		return var1; // L: 193
	}
}
