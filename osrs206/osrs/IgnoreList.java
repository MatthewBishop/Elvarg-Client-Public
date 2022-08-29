package osrs;
public class IgnoreList extends UserList {
	
	static IndexedSprite field4284;
	
	final LoginType loginType;
	
	public IgnoreList(LoginType var1) {
		super(400); // L: 13
		this.loginType = var1; // L: 14
	} // L: 15
	
	User newInstance() {
		return new Ignored(); // L: 19
	}
	
	User[] newTypedArray(int var1) {
		return new Ignored[var1]; // L: 24
	}
	
	public void read(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) { // L: 28
				int var3 = var1.readUnsignedByte(); // L: 29
				boolean var4 = (var3 & 1) == 1; // L: 30
				Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType); // L:
																										// 31
				Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.loginType); // L:
																										// 32
				var1.readStringCp1252NullTerminated(); // L: 33
				if (var5 != null && var5.hasCleanName()) { // L: 34
					Ignored var7 = (Ignored) this.getByCurrentUsername(var5); // L:
																				// 35
					if (var4) { // L: 36
						Ignored var8 = (Ignored) this.getByCurrentUsername(var6); // L:
																					// 37
						if (var8 != null && var7 != var8) { // L: 38
							if (var7 != null) { // L: 39
								this.remove(var8); // L: 40
							} else {
								var7 = var8; // L: 43
							}
						}
					}
					if (var7 != null) { // L: 47
						this.changeName(var7, var5, var6); // L: 48
						continue;
					}
					if (this.getSize() < 400) { // L: 50
						int var9 = this.getSize(); // L: 51
						var7 = (Ignored) this.addLast(var5, var6); // L: 52
						var7.id = var9; // L: 53
					}
					continue;
				}
				throw new IllegalStateException(); // L: 56
			}
			return; // L: 57
		}
	}
}
