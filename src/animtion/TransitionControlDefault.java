package animtion;

import java.util.ArrayList;

public class TransitionControlDefault implements TransitionControl {
	public float min,max,totime,transtime;
	public int toid;
	public int index;
	public int getIndex() {
		return index;
	}
	@Override
	public boolean copm(float t) {
		return t>=min && t<=max;
	}
	@Override
	public boolean getTransSection(ArrayList<Object> list)
	 {
		Object o = list.get(index);
		if(o == null)return false;
		return (int)o>0;
	}
	
	@Override
	public int getTo() {
		return toid;
	}
	@Override
	public float getToTime() {
		return totime;
	}
	@Override
	public float getTransTime() {
		return transtime;
	}
	@Override
	public TransitionControl setVal() {
		return this;
	}
}
