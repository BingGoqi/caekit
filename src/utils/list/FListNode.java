package utils.list;

public class FListNode<T> implements ListNode<T>{
	private T data; // 结点的数据
	private ListNode<T> next; // 下一个结点
	public FListNode(){
	}
	public FListNode(T data){
		this.data = data;
		this.next = null;
	}
	public FListNode(T data,FListNode<T> next){
		this.data = data;
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ListNode<T> getNext() {
		return next;
	}
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
}