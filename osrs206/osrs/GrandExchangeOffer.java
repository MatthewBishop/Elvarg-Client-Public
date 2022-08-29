package osrs;
public class GrandExchangeOffer {
	
	static int field4070;
	byte state;
	
	public int id;
	
	public int unitPrice;
	
	public int totalQuantity;
	
	public int currentQuantity;
	
	public int currentPrice;
	public GrandExchangeOffer() {
	} // L: 13
	
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte(); // L: 16
		this.id = var1.readUnsignedShort(); // L: 17
		this.unitPrice = var1.readInt(); // L: 18
		this.totalQuantity = var1.readInt(); // L: 19
		this.currentQuantity = var1.readInt(); // L: 20
		this.currentPrice = var1.readInt(); // L: 21
	} // L: 22
	
	public int status() {
		return this.state & 7; // L: 50
	}
	
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0; // L: 54
	}
	
	void method6007(int var1) {
		this.state &= -8; // L: 58
		this.state = (byte) (this.state | var1 & 7); // L: 59
	} // L: 60
	
	void method6005(int var1) {
		this.state &= -9; // L: 63
		if (var1 == 1) {
			this.state = (byte) (this.state | 8); // L: 64
		}
	} // L: 65
}
