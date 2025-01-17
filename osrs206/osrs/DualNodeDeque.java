package osrs;
public final class DualNodeDeque {
	
	DualNode sentinel;
	public DualNodeDeque() {
		this.sentinel = new DualNode(); // L: 6
		this.sentinel.previousDual = this.sentinel; // L: 9
		this.sentinel.nextDual = this.sentinel; // L: 10
	} // L: 11
	
	public void addFirst(DualNode var1) {
		if (var1.nextDual != null) { // L: 14
			var1.removeDual();
		}
		var1.nextDual = this.sentinel.nextDual; // L: 15
		var1.previousDual = this.sentinel; // L: 16
		var1.nextDual.previousDual = var1; // L: 17
		var1.previousDual.nextDual = var1; // L: 18
	} // L: 19
	
	public void addLast(DualNode var1) {
		if (var1.nextDual != null) { // L: 22
			var1.removeDual();
		}
		var1.nextDual = this.sentinel; // L: 23
		var1.previousDual = this.sentinel.previousDual; // L: 24
		var1.nextDual.previousDual = var1; // L: 25
		var1.previousDual.nextDual = var1; // L: 26
	} // L: 27
	
	public DualNode removeLast() {
		DualNode var1 = this.sentinel.previousDual; // L: 30
		return var1 == this.sentinel ? null : var1; // L: 31 32
	}
}
