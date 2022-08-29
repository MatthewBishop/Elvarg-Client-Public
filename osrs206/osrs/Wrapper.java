package osrs;
public abstract class Wrapper extends DualNode {
	final int size;
	Wrapper(int var1) {
		this.size = var1; // L: 9
	} // L: 10
	abstract Object get();
	abstract boolean isSoft();
}
