package animtion;

import java.util.ArrayList;

public interface TransitionControl {
	public boolean getTransSection(ArrayList<Object> list);
	public boolean copm(float t);
	public int getTo();
	public float getToTime();
	public float getTransTime();
	public TransitionControl setVal();
}
