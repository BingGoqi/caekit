package utils.list;

import java.util.AbstractSequentialList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class BasicList<E extends ListNode<T>, T> extends AbstractSequentialList<T>
implements  Cloneable, java.io.Serializable{
	private static final long serialVersionUID = 7994123643952090270L;
	private ListNode<T> first,last;
	private int size;
	public void addFirst(ListNode<T> e) {
		e.setNext(first);
		first = e;
		size++;
	}
	public void addLast(ListNode<T> e) {
		last.setNext(e);
		size++;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public T removeFirst() {
		var nf = first.getNext();
		first = null;
		first = nf;
		return first.getData();
	}
	@Override
	public T getFirst() {
		return first.getData();
	}
	private ListNode<T> node(int index){
        if(index>size){
            return null;
        }
        ListNode<T> p = first;
        while (index!=0){
            p=p.getNext();
            index--;
        }
        return p;
	}
	@SuppressWarnings("unused")
	private T unlink(ListNode<T> prev) {
		final ListNode<T> node = prev.getNext();
		final T element = node.getData();
        final ListNode<T> next = node.getNext();
        if (prev == null) {
            first = next;
        } else {
            prev.setNext(next);
        }
        if (next == null) {
            last = prev;
        } else {
            node.setNext(null);
        }
        node.setData(null);
        size--;
        modCount++;
        return element;
	}
	private void addBefor(ListNode<T> t,ListNode<T> succ) {
		//ListNode<T> n = new ListNode<T>(t,succ.getNext());
		//		succ.setNext(n);
		t.setNext(succ.getNext());
		succ.setNext(t);
		size++;
	}
	@Override
	public ListIterator<T> listIterator(int index) {
		return new ListItr(index);
	}
	private class ListItr implements ListIterator<T> {
		private ListNode<T> lastReturned,next,prev;
		private int nextIndex;
		private int expectedModCount = modCount;
		ListItr(int index) {
			// assert isPositionIndex(index);
			next = (index == size) ? null : node(index);
			nextIndex = index;
		}
		public boolean hasNext() {
			return nextIndex < size;
		}
		public T next() {
			checkForComodification();
			if (!hasNext())
				throw new NoSuchElementException();
			prev = lastReturned;
			lastReturned = next;
			next = next.getNext();
			nextIndex++;
			return lastReturned.getData();
		}
		public int nextIndex() {
			return nextIndex;
		}
		public void remove() {
			checkForComodification();
			if (lastReturned == null)
				throw new IllegalStateException();
			ListNode<T> lastNext = lastReturned.getNext();
			unlink(prev);
			if (next == lastReturned)
				next = lastNext;
			else
				nextIndex--;
			lastReturned = null;
			expectedModCount++;
		}
		public void set(T e) {
			if (lastReturned == null)
				throw new IllegalStateException();
			checkForComodification();
        	lastReturned.setData(e);
        }
        public void add(T e) {
        	checkForComodification();
        	lastReturned = null;
        	if (next == null)
        		addLast(e);
        	else
        		//addBefor(e,next);//TODO 
        	nextIndex++;
        	expectedModCount++;
        }
        public void forEachRemaining(Consumer<? super T> action) {
        	Objects.requireNonNull(action);
        	while (modCount == expectedModCount && nextIndex < size) {
        		action.accept(next.getData());
        		lastReturned = next;
        		next = next.getNext();
        		nextIndex++;
        	}
        	checkForComodification();
        }
        final void checkForComodification() {
        	if (modCount != expectedModCount)
        		throw new ConcurrentModificationException();
        }
        @Override
        public boolean hasPrevious() {
        	return prev!=null;
        }
        @Override
        public T previous() {
        	return prev.getData();
        }
        @Override
        public int previousIndex() {
        	return nextIndex-1;
        }
	}
}