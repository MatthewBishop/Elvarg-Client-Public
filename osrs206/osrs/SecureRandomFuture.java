package osrs;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class SecureRandomFuture {
	
	static int field960;
	ExecutorService executor;
	Future future;
	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor(); // L: 10
		this.future = this.executor.submit(new SecureRandomCallable()); // L: 14
	} // L: 15
	
	void shutdown() {
		this.executor.shutdown(); // L: 18
		this.executor = null; // L: 19
	} // L: 20
	
	boolean isDone() {
		return this.future.isDone();
	}
	
	SecureRandom get() {
		try {
			return (SecureRandom) this.future.get();
		} catch (Exception var2) {
			return NetFileRequest.method5843();
		}
	}
	
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = (KitDefinition) KitDefinition.KitDefinition_cached.get((long) var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}
			KitDefinition.KitDefinition_cached.put(var1, (long) var0);
			return var1;
		}
	}
	
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel) Messages.Messages_channels.get(var0); // L:
																				// 23
		if (var4 == null) { // L: 24
			var4 = new ChatChannel(); // L: 25
			Messages.Messages_channels.put(var0, var4); // L: 26
		}
		Message var5 = var4.addMessage(var0, var1, var2, var3); // L: 28
		Messages.Messages_hashTable.put(var5, (long) var5.count); // L: 29
		Messages.Messages_queue.add(var5); // L: 30
		Client.chatCycle = Client.cycleCntr; // L: 31
	} // L: 32
	
	static final void method1967() {
		Scene.Scene_isLowDetail = false; // L: 877
		Client.isLowDetail = false; // L: 878
	} // L: 879
}
