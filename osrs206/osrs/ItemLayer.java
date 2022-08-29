package osrs;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
public final class ItemLayer {
	
	static MouseRecorder mouseRecorder;
	
	int z;
	
	int x;
	
	int y;
	
	Renderable first;
	
	Renderable second;
	
	Renderable third;
	
	long tag;
	
	int height;
	ItemLayer() {
	} // L: 13
	
	public static final SpritePixels method3920(byte[] var0) {
		BufferedImage var1 = null; // L: 20
		try {
			Class var2 = ImageIO.class; // L: 22
			synchronized (ImageIO.class) {
				var1 = ImageIO.read(new ByteArrayInputStream(var0)); // L: 23
			} // L: 24
			int var6 = var1.getWidth(); // L: 25
			int var7 = var1.getHeight(); // L: 26
			int[] var4 = new int[var6 * var7]; // L: 27
			PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var6, var7, var4, 0, var6); // L:
																							// 28
			var5.grabPixels(); // L: 29
			return new SpritePixels(var4, var6, var7); // L: 30
		} catch (IOException var9) { // L: 32
		} catch (InterruptedException var10) { // L: 33
		}
		return new SpritePixels(0, 0); // L: 34
	}
}
