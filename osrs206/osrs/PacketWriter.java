package osrs;
import java.io.IOException;
public class PacketWriter {
	
	static int Client_plane;
	
	AbstractSocket socket;
	
	IterableNodeDeque packetBufferNodes;
	
	int bufferSize;
	
	Buffer buffer;
	
	public IsaacCipher isaacCipher;
	
	PacketBuffer packetBuffer;
	
	ServerPacket serverPacket;
	
	int serverPacketLength;
	boolean field1341;
	
	int field1342;
	
	int pendingWrites;
	
	ServerPacket field1350;
	
	ServerPacket field1347;
	
	ServerPacket field1352;
	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque(); // L: 15
		this.bufferSize = 0; // L: 16
		this.buffer = new Buffer(5000); // L: 17
		this.packetBuffer = new PacketBuffer(40000); // L: 19
		this.serverPacket = null; // L: 20
		this.serverPacketLength = 0; // L: 21
		this.field1341 = true; // L: 22
		this.field1342 = 0; // L: 23
		this.pendingWrites = 0; // L: 24
	} // L: 29
	
	final void clearBuffer() {
		this.packetBufferNodes.rsClear(); // L: 32
		this.bufferSize = 0; // L: 33
	} // L: 34
	
	final void flush() throws IOException {
		if (this.socket != null && this.bufferSize > 0) { // L: 37
			this.buffer.offset = 0; // L: 38
			while (true) {
				PacketBufferNode var1 = (PacketBufferNode) this.packetBufferNodes.last(); // L:
																							// 40
				if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) { // L:
																									// 41
																									// 42
					this.socket.write(this.buffer.array, 0, this.buffer.offset); // L:
																					// 49
					this.pendingWrites = 0; // L: 50
					break;
				}
				this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index); // L:
																				// 43
				this.bufferSize -= var1.index; // L: 44
				var1.remove(); // L: 45
				var1.packetBuffer.releaseArray(); // L: 46
				var1.release(); // L: 47
			}
		}
	} // L: 52
	
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1); // L: 55
		var1.index = var1.packetBuffer.offset; // L: 56
		var1.packetBuffer.offset = 0; // L: 57
		this.bufferSize += var1.index; // L: 58
	} // L: 59
	
	void setSocket(AbstractSocket var1) {
		this.socket = var1; // L: 62
	} // L: 63
	
	void close() {
		if (this.socket != null) { // L: 66
			this.socket.close(); // L: 67
			this.socket = null; // L: 68
		}
	} // L: 70
	
	void removeSocket() {
		this.socket = null;
	}
	
	AbstractSocket getSocket() {
		return this.socket; // L: 77
	}
	
	public static void method2517(AbstractArchive var0, AbstractArchive var1, boolean var2) {
		class328.ObjectDefinition_archive = var0; // L: 73
		ObjectComposition.ObjectDefinition_modelsArchive = var1; // L: 74
		ObjectComposition.ObjectDefinition_isLowDetail = var2; // L: 75
	} // L: 76
}
