package adapter;

public interface IObjectComposition {

	int soundMax();
	int soundMin();
	int soundRange();
	int soundId();
	int sizeY();
	int sizeX();
	
	int[] soundIds();
	Object getTransforms();
	IObjectComposition transform();
	
}
