package osrs;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
public class BufferedNetSocket extends AbstractSocket {
	Socket socket;
	
	BufferedSource source;
	
	BufferedSink sink;
	BufferedNetSocket(Socket var1, int var2, int var3) throws IOException {
		this.socket = var1; // L: 12
		this.socket.setSoTimeout(30000); // L: 13
		this.socket.setTcpNoDelay(true); // L: 14
		this.socket.setReceiveBufferSize(65536); // L: 15
		this.socket.setSendBufferSize(65536); // L: 16
		this.source = new BufferedSource(this.socket.getInputStream(), var2); // L:
																				// 17
		this.sink = new BufferedSink(this.socket.getOutputStream(), var3); // L:
																			// 18
	} // L: 19
	
	public boolean isAvailable(int var1) throws IOException {
		return this.source.isAvailable(var1); // L: 23
	}
	
	public int available() throws IOException {
		return this.source.available(); // L: 28
	}
	
	public int readUnsignedByte() throws IOException {
		return this.source.readUnsignedByte(); // L: 33
	}
	
	public int read(byte[] var1, int var2, int var3) throws IOException {
		return this.source.read(var1, var2, var3); // L: 38
	}
	
	public void write(byte[] var1, int var2, int var3) throws IOException {
		this.sink.write(var1, var2, var3); // L: 43
	} // L: 44
	
	public void close() {
		this.sink.close(); // L: 48
		try {
			this.socket.close(); // L: 50
		} catch (IOException var2) { // L: 52
		}
		this.source.close(); // L: 53
	} // L: 54
	protected void finalize() {
		this.close();
	} // L: 59
	
	static Date method6835() {
		java.util.Calendar var0 = java.util.Calendar.getInstance(); // L: 1119
		var0.set(2, 0); // L: 1120
		var0.set(5, 1); // L: 1121
		var0.set(1, 1900); // L: 1122
		return var0.getTime(); // L: 1123
	}
	
	static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
		int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * 1710798627 * 1791635595 : var1.width * 1623184389 * 2092161229; // L:
																																// 10653
		int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * -1042306339 * -1548911243 : var1.height * 514298127 * 236010991; // L:
																																	// 10654
		Static.resizeInterface(var0, var1.id, var3, var4, var2); // L: 10655
		if (var1.children != null) { // L: 10656
			Static.resizeInterface(var1.children, var1.id, var3, var4, var2);
		}
		InterfaceParent var5 = (InterfaceParent) Client.interfaceParents.get((long) var1.id); // L:
																								// 10657
		if (var5 != null) { // L: 10658
			int var6 = var5.group; // L: 10659
			if (WorldMapSection2.loadInterface(var6)) { // L: 10661
				Static.resizeInterface(_Junk.Widget_interfaceComponents[var6], -1, var3, var4, var2); // L:
																												// 10662
			}
		}
		if (var1.contentType == 1337) { // L: 10665
		}
	} // L: 10666
}
