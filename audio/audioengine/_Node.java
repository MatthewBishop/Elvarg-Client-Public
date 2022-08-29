package audioengine;
class _Node {
	protected long key;
	
	protected _Node previous;
	
	protected _Node next;
	protected void remove() {
		if (this.next != null) { // L: 9
			this.next.previous = this.previous; // L: 10
			this.previous.next = this.next; // L: 11
			this.previous = null; // L: 12
			this.next = null; // L: 13
		}
	} // L: 14
	protected boolean hasNext() {
		return this.next != null; // L: 17
	}
}
