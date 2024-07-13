package animtion;

public interface Section {
	float getVal(float t);
	float getValK(float t);
	float getStart();
	float getEnd();
	int getCompare(float t);
}
