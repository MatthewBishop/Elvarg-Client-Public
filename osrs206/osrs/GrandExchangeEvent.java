package osrs;
@Deprecated
public class GrandExchangeEvent {
	
	public final int world;
	
	public final long age;
	
	public final GrandExchangeOffer grandExchangeOffer;
	String offerName;
	String previousOfferName;
	
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated(); // L: 111
		this.previousOfferName = var1.readStringCp1252NullTerminated(); // L:
																		// 112
		this.world = var1.readUnsignedShort(); // L: 113
		this.age = var1.readLong(); // L: 114
		int var4 = var1.readInt(); // L: 115
		int var5 = var1.readInt(); // L: 116
		this.grandExchangeOffer = new GrandExchangeOffer(); // L: 117
		this.grandExchangeOffer.method6007(2); // L: 118
		this.grandExchangeOffer.method6005(var2); // L: 119
		this.grandExchangeOffer.unitPrice = var4; // L: 120
		this.grandExchangeOffer.totalQuantity = var5; // L: 121
		this.grandExchangeOffer.currentQuantity = 0; // L: 122
		this.grandExchangeOffer.currentPrice = 0; // L: 123
		this.grandExchangeOffer.id = var3; // L: 124
	} // L: 125
	
	public String getOfferName() {
		return this.offerName; // L: 128
	}
	
	public String getPreviousOfferName() {
		return this.previousOfferName; // L: 132
	}
}
