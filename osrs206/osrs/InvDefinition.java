package osrs;
public class InvDefinition extends DualNode {
	
	static AbstractArchive InvDefinition_archive;
	
	static EvictingDualNodeHashTable InvDefinition_cached;
	
	public int size;
	static {
		InvDefinition_cached = new EvictingDualNodeHashTable(64); // L: 11
	}
	InvDefinition() {
		this.size = 0; // L: 12
	} // L: 14
	
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte(); // L: 32
			if (var2 == 0) { // L: 33
				return; // L: 36
			}
			this.decodeNext(var1, var2); // L: 34
		}
	}
	
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 2) { // L: 39
			this.size = var1.readUnsignedShort();
		}
	} // L: 41
	
	static Object method3360(class432 var0) {
		if (var0 == null) { // L: 4996
			throw new IllegalStateException("popValueOfType() failure - null baseVarType"); // L:
																							// 4997
		} else {
			switch (var0.field4660) { // L: 4999
				case 0 :
					return Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]; // L:
																											// 5003
				case 2 :
					return Interpreter.Interpreter_intStack[--class446.Interpreter_intStackSize]; // L:
																									// 5005
				default :
					throw new IllegalStateException("popValueOfType() failure - unsupported type"); // L:
																									// 5001
			}
		}
	}
	
	static final void method3358(int var0, int var1, int var2) {
		if (class18.cameraX < var0) { // L: 3943
			class18.cameraX = (var0 - class18.cameraX) * UserComparator3.field1391 / 1000 + class18.cameraX + PlayerComposition.field3346; // L:
																																			// 3944
			if (class18.cameraX > var0) { // L: 3945
				class18.cameraX = var0;
			}
		}
		if (class18.cameraX > var0) { // L: 3947
			class18.cameraX -= (class18.cameraX - var0) * UserComparator3.field1391 / 1000 + PlayerComposition.field3346; // L:
																															// 3948
			if (class18.cameraX < var0) { // L: 3949
				class18.cameraX = var0;
			}
		}
		if (class16.cameraY < var1) { // L: 3951
			class16.cameraY = (var1 - class16.cameraY) * UserComparator3.field1391 / 1000 + class16.cameraY + PlayerComposition.field3346; // L:
																																			// 3952
			if (class16.cameraY > var1) { // L: 3953
				class16.cameraY = var1;
			}
		}
		if (class16.cameraY > var1) { // L: 3955
			class16.cameraY -= (class16.cameraY - var1) * UserComparator3.field1391 / 1000 + PlayerComposition.field3346; // L:
																															// 3956
			if (class16.cameraY < var1) { // L: 3957
				class16.cameraY = var1;
			}
		}
		if (class228.cameraZ < var2) { // L: 3959
			class228.cameraZ = (var2 - class228.cameraZ) * UserComparator3.field1391 / 1000 + class228.cameraZ + PlayerComposition.field3346; // L:
																																				// 3960
			if (class228.cameraZ > var2) { // L: 3961
				class228.cameraZ = var2;
			}
		}
		if (class228.cameraZ > var2) { // L: 3963
			class228.cameraZ -= (class228.cameraZ - var2) * UserComparator3.field1391 / 1000 + PlayerComposition.field3346; // L:
																															// 3964
			if (class228.cameraZ < var2) { // L: 3965
				class228.cameraZ = var2;
			}
		}
	} // L: 3967
}
