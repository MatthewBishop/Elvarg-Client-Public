package osrs;
import java.io.IOException;
public abstract class AbstractSocket {
	AbstractSocket() {
	} // L: 7
	
	public abstract boolean isAvailable(int var1) throws IOException;
	
	public abstract int available() throws IOException;
	
	public abstract int readUnsignedByte() throws IOException;
	
	public abstract int read(byte[] var1, int var2, int var3) throws IOException;
	
	public abstract void write(byte[] var1, int var2, int var3) throws IOException;
	
	public abstract void close();
	
	public static IndexedSprite method6819(AbstractArchive var0, int var1) {
		return !class431.method7559(var0, var1) ? null : class390.method7053(); // L:
																				// 131
																				// 132
	}
}
