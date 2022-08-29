package osrs;
public class Message extends DualNode {
	
	public static AbstractRasterProvider rasterProvider;
	
	static AbstractSocket field461;
	
	static SpritePixels[] headIconPkSprites;
	
	int count;
	
	int cycle;
	
	int type;
	String sender;
	
	Username senderUsername;
	
	TriBool isFromFriend0;
	
	TriBool isFromIgnored0;
	String prefix;
	String text;
	Message(int var1, String var2, String var3, String var4) {
		this.isFromFriend0 = TriBool.TriBool_unknown; // L: 13
		this.isFromIgnored0 = TriBool.TriBool_unknown; // L: 14
		this.set(var1, var2, var3, var4); // L: 19
	} // L: 20
	
	void set(int var1, String var2, String var3, String var4) {
		int var5 = ++Messages.Messages_count - 1; // L: 25
		this.count = var5; // L: 27
		this.cycle = Client.cycle; // L: 28
		this.type = var1; // L: 29
		this.sender = var2; // L: 30
		this.fillSenderUsername(); // L: 31
		this.prefix = var3; // L: 32
		this.text = var4; // L: 33
		this.clearIsFromFriend(); // L: 34
		this.clearIsFromIgnored(); // L: 35
	} // L: 36
	
	void clearIsFromFriend() {
		this.isFromFriend0 = TriBool.TriBool_unknown; // L: 39
	} // L: 40
	
	final boolean isFromFriend() {
		if (this.isFromFriend0 == TriBool.TriBool_unknown) { // L: 43
			this.fillIsFromFriend(); // L: 44
		}
		return this.isFromFriend0 == TriBool.TriBool_true; // L: 46
	}
	
	void fillIsFromFriend() {
		this.isFromFriend0 = Player.friendSystem.friendsList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false; // L:
																																			// 50
	} // L: 51
	
	void clearIsFromIgnored() {
		this.isFromIgnored0 = TriBool.TriBool_unknown; // L: 54
	} // L: 55
	
	final boolean isFromIgnored() {
		if (this.isFromIgnored0 == TriBool.TriBool_unknown) { // L: 58
			this.fillIsFromIgnored(); // L: 59
		}
		return this.isFromIgnored0 == TriBool.TriBool_true; // L: 61
	}
	
	void fillIsFromIgnored() {
		this.isFromIgnored0 = Player.friendSystem.ignoreList.contains(this.senderUsername) ? TriBool.TriBool_true : TriBool.TriBool_false; // L:
																																			// 65
	} // L: 66
	
	final void fillSenderUsername() {
		if (this.sender != null) {
			this.senderUsername = new Username(class92.method2388(this.sender), HealthBarDefinition.loginType); // L:
																												// 69
		} else {
			this.senderUsername = null; // L: 70
		}
	} // L: 71
	
	static final boolean method1065(Widget var0) {
		int var1 = var0.contentType; // L: 12043
		if (var1 == 205) { // L: 12044
			Client.logoutTimer = 250; // L: 12045
			return true; // L: 12046
		} else {
			int var2;
			int var3;
			if (var1 >= 300 && var1 <= 313) { // L: 12048
				var2 = (var1 - 300) / 2; // L: 12049
				var3 = var1 & 1; // L: 12050
				Client.playerAppearance.changeAppearance(var2, var3 == 1); // L:
																			// 12051
			}
			if (var1 >= 314 && var1 <= 323) { // L: 12053
				var2 = (var1 - 314) / 2; // L: 12054
				var3 = var1 & 1; // L: 12055
				Client.playerAppearance.method5573(var2, var3 == 1); // L: 12056
			}
			if (var1 == 324) { // L: 12058
				Client.playerAppearance.changeSex(false);
			}
			if (var1 == 325) { // L: 12059
				Client.playerAppearance.changeSex(true);
			}
			if (var1 == 326) { // L: 12060
				PacketBufferNode var4 = EnumComposition.getPacketBufferNode(ClientPacket.field3010, Client.packetWriter.isaacCipher); // L:
																																		// 12062
				Client.playerAppearance.write(var4.packetBuffer); // L: 12063
				Client.packetWriter.addNode(var4); // L: 12064
				return true; // L: 12065
			} else {
				return false; // L: 12067
			}
		}
	}
}
