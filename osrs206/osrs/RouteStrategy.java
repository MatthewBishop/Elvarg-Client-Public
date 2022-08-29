package osrs;
public abstract class RouteStrategy {
	
	public int approxDestinationX;
	
	public int approxDestinationY;
	
	public int approxDestinationSizeX;
	
	public int approxDestinationSizeY;
	protected RouteStrategy() {
	} // L: 9
	
	public abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);
}
