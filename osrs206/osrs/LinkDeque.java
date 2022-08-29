package osrs;
public class LinkDeque {
	
	Link sentinel;
	
	Link current;
	public LinkDeque() {
		this.sentinel = new Link(); // L: 6
		this.sentinel.previous = this.sentinel; // L: 10
		this.sentinel.next = this.sentinel; // L: 11
	} // L: 12
	
	public void addFirst(Link var1) {
		if (var1.next != null) { // L: 15
			var1.remove();
		}
		var1.next = this.sentinel.next; // L: 16
		var1.previous = this.sentinel; // L: 17
		var1.next.previous = var1; // L: 18
		var1.previous.next = var1; // L: 19
	} // L: 20
	
	public Link last() {
		Link var1 = this.sentinel.previous; // L: 24
		if (var1 == this.sentinel) { // L: 25
			this.current = null; // L: 26
			return null; // L: 27
		} else {
			this.current = var1.previous; // L: 29
			return var1; // L: 30
		}
	}
	
	public Link previous() {
		Link var1 = this.current; // L: 35
		if (var1 == this.sentinel) { // L: 36
			this.current = null; // L: 37
			return null; // L: 38
		} else {
			this.current = var1.previous; // L: 40
			return var1; // L: 41
		}
	}
}
