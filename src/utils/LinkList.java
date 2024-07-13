package utils;

import java.util.AbstractSequentialList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**  
 * @ClassName: LinkList
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-11 10:24:40 
*/

public class LinkList <T> extends AbstractSequentialList<T>
implements List<T>, Deque<T>, Cloneable, java.io.Serializable {
	/**  
	 * @Fields serialVersionUID : TODO
	 * @author BingGoqi
	 * @date 2024-07-03 09:36:19 
	 */  
	 
	
	private static final long serialVersionUID = -6940976809570572771L;
	Node<T> front,end;
	int length;
	/**  
	 * @Constructor: LinkList
	 * @Description: LinkList构造函数
	 * @author BingGoqi
	 * @date 2024-06-11 10:47:24 
	 */
	/**
	 * length==0:
	 * front=end=null
	 * length==1:
	 * front=end=obj1
	 * end.next=front
	 * length>1:
	 * 
	 */
	public LinkList() {
		front = null;
		end = front;
		length = 0;
	}
	/**  
	 * @MethodName: removeLast
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.List#removeLast()
	 * @date 2024-07-03 09:27:04 
	 */  
	
	
	@Override
	public T removeLast() {
		// TODO 自动生成的方法存根
		return super.removeLast();
	}
	/**  
	 * @MethodName: addFirst
	 * @Description: TODO
	 * @author BingGoqi
	 * @param e
	 * @see java.util.Deque#addFirst(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public void addFirst(T e) {
		// TODO 自动生成的方法存根
		
	}
	/**  
	 * @MethodName: addLast
	 * @Description: TODO
	 * @author BingGoqi
	 * @param e
	 * @see java.util.Deque#addLast(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public void addLast(T e) {
		// TODO 自动生成的方法存根
		
	}
	/**  
	 * @MethodName: offerFirst
	 * @Description: TODO
	 * @author BingGoqi
	 * @param e
	 * @return
	 * @see java.util.Deque#offerFirst(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public boolean offerFirst(T e) {
		// TODO 自动生成的方法存根
		return false;
	}
	/**  
	 * @MethodName: offerLast
	 * @Description: TODO
	 * @author BingGoqi
	 * @param e
	 * @return
	 * @see java.util.Deque#offerLast(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public boolean offerLast(T e) {
		// TODO 自动生成的方法存根
		return false;
	}
	/**  
	 * @MethodName: pollFirst
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#pollFirst()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T pollFirst() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: pollLast
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#pollLast()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T pollLast() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: peekFirst
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#peekFirst()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T peekFirst() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: peekLast
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#peekLast()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T peekLast() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: removeFirstOccurrence
	 * @Description: TODO
	 * @author BingGoqi
	 * @param o
	 * @return
	 * @see java.util.Deque#removeFirstOccurrence(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO 自动生成的方法存根
		return false;
	}
	/**  
	 * @MethodName: removeLastOccurrence
	 * @Description: TODO
	 * @author BingGoqi
	 * @param o
	 * @return
	 * @see java.util.Deque#removeLastOccurrence(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO 自动生成的方法存根
		return false;
	}
	/**  
	 * @MethodName: offer
	 * @Description: TODO
	 * @author BingGoqi
	 * @param e
	 * @return
	 * @see java.util.Deque#offer(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public boolean offer(T e) {
		// TODO 自动生成的方法存根
		return false;
	}
	/**  
	 * @MethodName: remove
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#remove()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T remove() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: poll
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#poll()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T poll() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: element
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#element()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T element() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: peek
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#peek()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T peek() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: push
	 * @Description: TODO
	 * @author BingGoqi
	 * @param e
	 * @see java.util.Deque#push(java.lang.Object)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public void push(T e) {
		// TODO 自动生成的方法存根
		
	}
	/**  
	 * @MethodName: pop
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#pop()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public T pop() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: descendingIterator
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.Deque#descendingIterator()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public Iterator<T> descendingIterator() {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: size
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.List#size()
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public int size() {
		// TODO 自动生成的方法存根
		return 0;
	}
	/**  
	 * @MethodName: listIterator
	 * @Description: TODO
	 * @author BingGoqi
	 * @param index
	 * @return
	 * @see java.util.AbstractSequentialList#listIterator(int)
	 * @date 2024-07-03 09:27:30 
	 */  
	
	
	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO 自动生成的方法存根
		return null;
	}
	/**  
	 * @MethodName: reversed
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.List#reversed()
	 * @date 2024-07-03 09:27:36 
	 */  
	
	
	@Override
	public LinkList<T> reversed() {
		//TODO 需重写
		return null;
	}
	/**  
	 * @MethodName: removeFirst
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.List#removeFirst()
	 * @date 2024-07-03 09:35:20 
	 */  
	
	
	@Override
	public T removeFirst() {
		// TODO 自动生成的方法存根
		return super.removeFirst();
	}
	/**  
	 * @MethodName: getFirst
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.List#getFirst()
	 * @date 2024-07-03 09:35:49 
	 */  
	
	
	@Override
	public T getFirst() {
		// TODO 自动生成的方法存根
		return super.getFirst();
	}
	/**  
	 * @MethodName: getLast
	 * @Description: TODO
	 * @author BingGoqi
	 * @return
	 * @see java.util.List#getLast()
	 * @date 2024-07-03 09:36:01 
	 */  
	
	
	@Override
	public T getLast() {
		// TODO 自动生成的方法存根
		return super.getLast();
	}
}
class Node<T> {
	public T obj;
	public Node<T> next;
	
	public Node() {
	}
	public Node(T obj,Node<T> next) {
		this.obj = obj;
		this.next = next;
	}
	public Node<T> fInsert(Node<T> node,T obj) {
		Node<T> n = new Node<T>(obj, node.next);
		node.next = n;
		return node;
	}
	public Node<T> bInsert(Node<T> node,T obj) {
		Node<T> n = new Node<T>(obj, node.next);
		node.next = n;
		return n;
	}
}
