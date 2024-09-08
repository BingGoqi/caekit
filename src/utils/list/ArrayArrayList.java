package utils.list;

/**  
 * @ClassName: ArrayArrayList
 * @Description: 低成扩容的本动态数组
 * @author BingGoqi
 * @date 2024-06-10 10:08:14 
*/

import java.util.ArrayList;

public class ArrayArrayList <T> {
	private int size;
	private int length;
	private final int offset;
	private final int bitMask;
	//private final int max = 1<<20;
	private ArrayList<T[]> list;
	public ArrayArrayList(int length) {
		this.length = length;
		offset = 10;
		bitMask = (1<<10)-1;
		list = new ArrayList<T[]>((length-1>>offset)+1);
		size = list.size()<<offset;
	}
	public ArrayArrayList(int ditOffset,int length) {
		this.length = length;
		offset = ditOffset;
		bitMask = (1<<ditOffset)-1;
		list = new ArrayList<T[]>(((length-1)>>offset)+1);
		size = list.size()<<offset;
	}
	public T[] getSubArray(int index) {
		return list.get(index>>offset);
	}
	public int supIndex(int index) {
		return index>>offset;
	}
	public int subIndex(int index) {
		return index&bitMask;
	}
	public void setVal(int index,T val) {
		T[] l = list.get(index>>offset);
		if(l == null)l = (T[]) new Object[1<<offset];
		l[index&bitMask] = val;
	}
	public T get(int index) {
		if(index < size)
		return list.get(index>>offset)[index&bitMask];
		return null;
	}
	public int size() {
		return size;
	}
	public int length() {
		return length;
	}
	public int block() {
		return 1<<offset;
	}
	public void add(T val) {
		length++;
		setVal(length-1,val);
	}
}
