package osrs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class class181 extends DualNode {
	
	static int field1992;
	static {
		new EvictingDualNodeHashTable(64); // L: 9
	} // L: 10
	
	static float[] method3566(JSONObject var0, String var1) throws JSONException {
		float[] var2 = new float[4]; // L: 307
		try {
			JSONArray var3 = var0.getJSONArray(var1); // L: 309
			var2[0] = (float) var3.optDouble(0, 0.0D); // L: 310
			var2[1] = (float) var3.optDouble(1, 0.0D); // L: 311
			var2[2] = (float) var3.optDouble(2, 1.0D); // L: 312
			var2[3] = (float) var3.optDouble(3, 1.0D); // L: 313
		} catch (JSONException var4) { // L: 315
			var2[0] = 0.0F; // L: 316
			var2[1] = 0.0F; // L: 317
			var2[2] = 1.0F; // L: 318
			var2[3] = 1.0F; // L: 319
		}
		return var2; // L: 321
	}
}
