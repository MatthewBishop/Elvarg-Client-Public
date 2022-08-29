package osrs;
import java.util.Iterator;
public class IterableNodeDequeDescendingIterator implements Iterator {
	
	IterableNodeDeque deque;
	
	Node field4125;
	
	Node last;
	
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null; // L: 9
		this.setDeque(var1); // L: 12
	} // L: 13
	
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1; // L: 16
		this.start(); // L: 17
	} // L: 18
	void start() {
		this.field4125 = this.deque != null ? this.deque.sentinel.previous : null; // L:
																					// 21
		this.last = null; // L: 22
	} // L: 23
	public Object next() {
		Node var1 = this.field4125; // L: 27
		if (var1 == this.deque.sentinel) { // L: 28
			var1 = null; // L: 29
			this.field4125 = null; // L: 30
		} else {
			this.field4125 = var1.previous; // L: 32
		}
		this.last = var1; // L: 33
		return var1; // L: 34
	}
	public boolean hasNext() {
		return this.deque.sentinel != this.field4125 && this.field4125 != null; // L:
																				// 38
	}
	public void remove() {
		if (this.last == null) { // L: 42
			throw new IllegalStateException();
		} else {
			this.last.remove(); // L: 43
			this.last = null; // L: 44
		}
	} // L: 45
}
