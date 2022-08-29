package osrs;
public class DirectWrapper extends Wrapper {
	Object obj;
	DirectWrapper(Object var1, int var2) {
		super(var2); // L: 7
		this.obj = var1; // L: 8
	} // L: 9
	Object get() {
		return this.obj; // L: 12
	}
	boolean isSoft() {
		return false; // L: 16
	}
}
