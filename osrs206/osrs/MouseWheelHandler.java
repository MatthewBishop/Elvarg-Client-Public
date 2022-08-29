package osrs;
import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
public final class MouseWheelHandler implements class158, MouseWheelListener {
	
	int rotation;
	MouseWheelHandler() {
		this.rotation = 0; // L: 8
	} // L: 10
	
	void addTo(Component var1) {
		var1.addMouseWheelListener(this); // L: 13
	} // L: 14
	
	void removeFrom(Component var1) {
		var1.removeMouseWheelListener(this); // L: 17
	} // L: 18
	
	public synchronized int useRotation() {
		int var1 = this.rotation; // L: 26
		this.rotation = 0; // L: 27
		return var1; // L: 28
	}
	public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
		this.rotation += var1.getWheelRotation(); // L: 22
	} // L: 23
}
