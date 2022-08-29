package osrs;
import java.lang.ref.SoftReference;
public class SoftWrapper extends Wrapper {
	SoftReference ref;
	SoftWrapper(Object var1, int var2) {
		super(var2); // L: 10
		this.ref = new SoftReference(var1); // L: 11
	} // L: 12
	Object get() {
		return this.ref.get(); // L: 15
	}
	boolean isSoft() {
		return true; // L: 19
	}
}
