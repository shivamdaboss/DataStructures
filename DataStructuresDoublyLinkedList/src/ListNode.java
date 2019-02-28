public class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>> {
	ListNode<T> next, previous; 
	T value;
	ListNode(T value){
		this.value = value;
		next = null;
		previous = null;
	}
	public T getValue() {
		return value;
	}
	
	public ListNode<T> getNext() {
		return next;
	}
	
	public ListNode<T> getPrev() {
		return previous;
	}
	
	public void setValue(T val) {
		 value = val;
	}
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
	public void setPrev(ListNode<T> prev) {
		previous = prev;
	}
	
	public boolean hasNext() {
		if(next != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean hasPrev() {
		if(previous != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public String toString() {
		return value.toString();
	}
	@Override
	public int compareTo(ListNode<T> o) {
		return value.compareTo(o.getValue());
	}
}
