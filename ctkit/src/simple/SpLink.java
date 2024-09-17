package simple;

public interface SpLink<T> {
	T next();
	T getnext();
	void setnext(T next);
}
