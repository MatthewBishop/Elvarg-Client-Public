package osrs;
public class Task {
	
	Task next;
	public volatile int status;
	
	int type;
	public int intArgument;
	Object objectArgument;
	public volatile Object result;
	Task() {
		this.status = 0; // L: 10
	} // L: 22
}
