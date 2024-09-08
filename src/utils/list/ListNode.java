package utils.list;

public interface ListNode<T> {
	public T getData();
	public void setData(T data);
	public ListNode<T> getNext();
	public void setNext(ListNode<T> next);
}
