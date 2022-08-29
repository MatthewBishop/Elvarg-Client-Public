package osrs;
public abstract class AbstractByteArrayCopier {
	
	static IndexedSprite[] runesSprite;
	
	static Archive archive13;
	AbstractByteArrayCopier() {
	} // L: 4
	
	abstract byte[] get();
	
	abstract void set(byte[] var1);
}
