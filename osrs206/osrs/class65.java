package osrs;
import java.math.BigInteger;
public class class65 {
	static final BigInteger field865;
	static final BigInteger field868;
	static {
		field865 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049"); // L:
		// 20
		field868 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683"); // L:
		// 21
	}
	
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) { // L: 4344
			int var3 = Anim_SequenceDefinition.SequenceDefinition_get(var1).field2174; // L:
																			// 4345
			if (var3 == 1) { // L: 4346
				var0.sequenceFrame = 0; // L: 4347
				var0.sequenceFrameCycle = 0; // L: 4348
				var0.sequenceDelay = var2; // L: 4349
				var0.field1190 = 0; // L: 4350
			}
			if (var3 == 2) { // L: 4352
				var0.field1190 = 0; // L: 4353
			}
		} else if (var1 == -1 || var0.sequence == -1 || Anim_SequenceDefinition.SequenceDefinition_get(var1).field2183 >= Anim_SequenceDefinition.SequenceDefinition_get(var0.sequence).field2183) { // L:
																																												// 4356
			var0.sequence = var1; // L: 4357
			var0.sequenceFrame = 0; // L: 4358
			var0.sequenceFrameCycle = 0; // L: 4359
			var0.sequenceDelay = var2; // L: 4360
			var0.field1190 = 0; // L: 4361
			var0.field1203 = var0.pathLength; // L: 4362
		}
	} // L: 4364
}
