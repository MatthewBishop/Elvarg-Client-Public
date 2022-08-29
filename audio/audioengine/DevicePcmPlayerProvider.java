package audioengine;

public class DevicePcmPlayerProvider implements PcmPlayerProvider {
	public DevicePcmPlayerProvider() {
	} // L: 7
	
	public PcmPlayer player() {
		return new DevicePcmPlayer(); // L: 11
	}
}
