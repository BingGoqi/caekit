package simple;

public interface GLElement<T> extends SpLink<T>{
	public int getPrt();
	public void free();
	public void use();
	public void link();
}
