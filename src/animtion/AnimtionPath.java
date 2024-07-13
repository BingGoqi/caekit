package animtion;

import java.util.LinkedList;

public interface AnimtionPath { 
	float getVal(float t); 
	float getValK(float t);
	public LinkedList<TransitionControl> getTClist();
	void addTc(TransitionControl tt);
	void setid(int id);
	int getid();
}
