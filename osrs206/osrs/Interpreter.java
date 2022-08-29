package osrs;
import java.util.ArrayList;
public class Interpreter {
	
	static int field846;
	static int[] Interpreter_intLocals;
	static int[] Interpreter_arrayLengths;
	static int[][] Interpreter_arrays;
	static int[] Interpreter_intStack;
	static String[] Interpreter_stringStack;
	
	static int Interpreter_stringStackSize;
	
	static int Interpreter_frameDepth;
	
	static ScriptFrame[] Interpreter_frames;
	
	static int field838;
	static java.util.Calendar Interpreter_calendar;
	static final String[] Interpreter_MONTHS;
	static boolean field829;
	static boolean field842;
	static ArrayList field843;
	
	static int field850;
	static final double field845;
	
	static Widget dragInventoryWidget;
	static {
		Interpreter_arrayLengths = new int[5]; // L: 83
		Interpreter_arrays = new int[5][5000]; // L: 84
		Interpreter_intStack = new int[1000]; // L: 85
		Interpreter_stringStack = new String[1000]; // L: 87
		Interpreter_frameDepth = 0; // L: 89
		Interpreter_frames = new ScriptFrame[50]; // L: 90
		Interpreter_calendar = java.util.Calendar.getInstance(); // L: 96
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}; // L:
																																// 99
		field829 = false; // L: 102
		field842 = false; // L: 103
		field843 = new ArrayList(); // L: 104
		field850 = 0; // L: 105
		field845 = Math.log(2.0D); // L: 109
	}
	
	public static void method1868() {
		StructComposition.StructDefinition_cached.clear(); // L: 71
	} // L: 72
	
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? class362.World_worlds[++World.World_listCount - 1] : null; // L:
		// 242
		// 243
	}
}
