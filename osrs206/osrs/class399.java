package osrs;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class class399 implements class398 {
	JSONObject field4436;
	public class399(byte[] var1) throws UnsupportedEncodingException {
		this.method7098(var1); // L: 17
	} // L: 18
	public class399(String var1) throws UnsupportedEncodingException {
		this.method7099(var1); // L: 13
	} // L: 14
	
	public byte[] vmethod7114() throws UnsupportedEncodingException {
		return this.field4436 == null ? new byte[0] : this.field4436.toString().getBytes("UTF-8"); // L:
																									// 50
																									// 51
																									// 53
	}
	
	void method7098(byte[] var1) throws UnsupportedEncodingException {
		String var2 = new String(var1, "UTF-8"); // L: 21
		this.method7099(var2); // L: 22
	} // L: 23
	
	void method7099(String var1) throws UnsupportedEncodingException {
		try {
			if (var1.charAt(0) == '{') { // L: 27
				this.field4436 = new JSONObject(var1); // L: 28
			} else {
				if (var1.charAt(0) != '[') { // L: 30
					throw new UnsupportedEncodingException("Invalid JSON passed to the JSON content builder."); // L:
																												// 36
				}
				JSONArray var2 = new JSONArray(var1); // L: 31
				this.field4436 = new JSONObject(); // L: 32
				this.field4436.put("arrayValues", var2); // L: 33
			}
		} catch (JSONException var3) { // L: 39
			throw new UnsupportedEncodingException(var3.getMessage()); // L: 40
		}
	} // L: 42
	
	public JSONObject method7100() {
		return this.field4436; // L: 45
	}
}
