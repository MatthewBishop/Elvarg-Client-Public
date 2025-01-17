package audioengine;
final class _NodeHashTable {
	int size;
	
	_Node[] buckets;
	
	_Node currentGet;
	
	_Node current;
	int index;
	protected _NodeHashTable(int var1) {
		this.index = 0; // L: 10
		this.size = var1; // L: 13
		this.buckets = new _Node[var1]; // L: 14
		for (int var2 = 0; var2 < var1; ++var2) { // L: 15
			_Node var3 = this.buckets[var2] = new _Node(); // L: 16
			var3.previous = var3; // L: 17
			var3.next = var3; // L: 18
		}
	} // L: 20
	
	protected _Node get(long var1) {
		_Node var3 = this.buckets[(int) (var1 & (long) (this.size - 1))]; // L:
																			// 23
		for (this.currentGet = var3.previous; var3 != this.currentGet; this.currentGet = this.currentGet.previous) { // L:
			// 24
			// 25
			// 31
			if (this.currentGet.key == var1) { // L: 26
				_Node var4 = this.currentGet; // L: 27
				this.currentGet = this.currentGet.previous; // L: 28
				return var4; // L: 29
			}
		}
		this.currentGet = null; // L: 33
		return null; // L: 34
	}
	
	protected void put(_Node var1, long var2) {
		if (var1.next != null) { // L: 38
			var1.remove();
		}
		_Node var4 = this.buckets[(int) (var2 & (long) (this.size - 1))]; // L:
																			// 39
		var1.next = var4.next; // L: 40
		var1.previous = var4; // L: 41
		var1.next.previous = var1; // L: 42
		var1.previous.next = var1; // L: 43
		var1.key = var2; // L: 44
	} // L: 45
	
	protected _Node first() {
		this.index = 0; // L: 48
		return this.next(); // L: 49
	}
	
	protected _Node next() {
		_Node var1;
		if (this.index > 0 && this.buckets[this.index - 1] != this.current) { // L:
																				// 53
			var1 = this.current; // L: 54
			this.current = var1.previous; // L: 55
			return var1; // L: 56
		} else {
			do {
				if (this.index >= this.size) { // L: 58
					return null; // L: 65
				}
				var1 = this.buckets[this.index++].previous; // L: 59
			} while (var1 == this.buckets[this.index - 1]); // L: 60
			this.current = var1.previous; // L: 61
			return var1; // L: 62
		}
	}
}
