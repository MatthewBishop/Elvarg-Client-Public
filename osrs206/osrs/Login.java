package osrs;
import java.text.DecimalFormat;
public class Login {
	static boolean clearLoginScreen;
	
	static int xPadding;
	
	static IndexedSprite field914;
	
	static SpritePixels rightTitleSprite;
	
	static IndexedSprite logoSprite;
	
	static LoginScreenAnimation loginScreenRunesAnimation;
	
	static int loginBoxX;
	
	static int Login_loadingPercent;
	static String Login_loadingText;
	
	static int field897;
	
	static int field902;
	
	static int loginIndex;
	static String Login_response0;
	static String Login_response1;
	static String Login_response2;
	static String Login_response3;
	static String Login_username;
	static String Login_password;
	
	static int field910;
	static String[] field911;
	static boolean field912;
	static boolean field913;
	static boolean field895;
	
	static int currentLoginField;
	static boolean worldSelectOpen;
	
	static int hoveredWorldIndex;
	
	static int worldSelectPage;
	
	static int worldSelectPagesCount;
	
	static long field923;
	
	static long field925;
	static String[] field924;
	static String[] field916;
	static {
		xPadding = 0; // L: 47
		loginBoxX = xPadding + 202; // L: 66
		Login_loadingPercent = 10; // L: 68
		Login_loadingText = ""; // L: 69
		field897 = -1; // L: 88
		field902 = 1; // L: 91
		loginIndex = 0; // L: 95
		Login_response0 = ""; // L: 96
		Login_response1 = ""; // L: 97
		Login_response2 = ""; // L: 98
		Login_response3 = ""; // L: 99
		Login_username = ""; // L: 100
		Login_password = ""; // L: 101
		field910 = 0; // L: 103
		field911 = new String[8]; // L: 104
		field912 = false; // L: 115
		field913 = false; // L: 116
		field895 = true; // L: 119
		currentLoginField = 0; // L: 120
		worldSelectOpen = false; // L: 124
		hoveredWorldIndex = -1; // L: 132
		worldSelectPage = 0; // L: 133
		worldSelectPagesCount = 0; // L: 134
		new DecimalFormat("##0.00"); // L: 137
		new class120();
		field923 = -1L; // L: 145
		field925 = -1L; // L: 146
		field924 = new String[]{"title.jpg"}; // L: 149
		field916 = new String[]{"logo", "logo_deadman_mode", "logo_seasonal_mode", "titlebox", "titlebutton", "titlebutton_large", "play_now_text", "titlebutton_wide42,1", "runes", "title_mute", "options_radio_buttons,0", "options_radio_buttons,2", "options_radio_buttons,4", "options_radio_buttons,6", "sl_back", "sl_flags", "sl_arrows", "sl_stars", "sl_button"}; // L:
																																																																																												// 152
	}
}
