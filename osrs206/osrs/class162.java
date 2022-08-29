package osrs;
import java.awt.Image;
import java.lang.management.GarbageCollectorMXBean;
public class class162 extends class165 {
	static Image field1781;
	static GarbageCollectorMXBean garbageCollector;
	
	int field1784;
	// $FF: synthetic field
	
	final class155 this$0;
	
	class162(class155 var1, String var2, int var3) {
		super(var1, var2); // L: 372
		this.this$0 = var1; // L: 371
		this.field1784 = var3; // L: 373
	} // L: 374
	
	public int vmethod3314() {
		return 0; // L: 377
	}
	
	public int vmethod3318() {
		return this.field1784; // L: 382
	}
	
	public static ObjectComposition getObjectDefinition(int var0) {
		ObjectComposition var1 = (ObjectComposition) ObjectComposition.ObjectDefinition_cached.get((long) var0); // L:
		// 79
		if (var1 != null) { // L: 80
			return var1;
		} else {
			byte[] var2 = class328.ObjectDefinition_archive.takeFile(6, var0); // L:
																				// 81
			var1 = new ObjectComposition(); // L: 82
			var1.id = var0; // L: 83
			if (var2 != null) { // L: 84
				var1.decode(new Buffer(var2));
			}
			var1.postDecode(); // L: 85
			if (var1.isSolid) { // L: 86
				var1.interactType = 0; // L: 87
				var1.boolean1 = false; // L: 88
			}
			ObjectComposition.ObjectDefinition_cached.put(var1, (long) var0); // L:
																				// 90
			return var1; // L: 91
		}
	}
	
	static int method3298(int var0, Script var1, boolean var2) {
		if (var0 == 6800) { // L: 4521
			Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																										// 4522
			return 1; // L: 4523
		} else if (var0 != 6801 && var0 != 6802) { // L: 4525
			if (var0 == 6850) { // L: 4529
				Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ""; // L:
																											// 4530
				return 1; // L: 4531
			} else if (var0 != 6851 && var0 != 6852) { // L: 4533
				if (var0 == 6853) { // L: 4537
					Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = 0; // L:
																									// 4538
					return 1; // L: 4539
				} else {
					return 2; // L: 4541
				}
			} else {
				Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
																								// 4534
				return 1; // L: 4535
			}
		} else {
			Interpreter.Interpreter_intStack[++class446.Interpreter_intStackSize - 1] = -1; // L:
																							// 4526
			return 1; // L: 4527
		}
	}
}
