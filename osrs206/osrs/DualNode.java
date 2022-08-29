package osrs;
public class DualNode extends Node {
	public long keyDual;
	
	public DualNode previousDual;
	
	public DualNode nextDual;
	public void removeDual() {
		if (this.nextDual != null) { // L: 9
			this.nextDual.previousDual = this.previousDual; // L: 10
			this.previousDual.nextDual = this.nextDual; // L: 11
			this.previousDual = null; // L: 12
			this.nextDual = null; // L: 13
		}
	} // L: 14
}
