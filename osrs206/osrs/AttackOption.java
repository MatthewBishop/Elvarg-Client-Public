package osrs;

public enum AttackOption implements MouseWheel {
	
	AttackOption_dependsOnCombatLevels(0), 
	AttackOption_alwaysRightClick(1), 
	field1288(2), 
	AttackOption_hidden(3), 
	field1294(4);
	
	final int id;
	AttackOption(int var3) {
		this.id = var3; // L: 12508
	} // L: 12509
	
	public int rsOrdinal() {
		return this.id; // L: 12513
	}
}
