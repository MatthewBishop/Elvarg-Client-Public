package osrs;
public class Node {
	public long key;
	
	public Node previous;
	
	public Node next;
	public void remove() {
		if (this.next != null) { // L: 9
			this.next.previous = this.previous; // L: 10
			this.previous.next = this.next; // L: 11
			this.previous = null; // L: 12
			this.next = null; // L: 13
		}
	} // L: 14
	public boolean hasNext() {
		return this.next != null; // L: 17
	}
}
