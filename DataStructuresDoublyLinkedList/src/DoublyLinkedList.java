
public class DoublyLinkedList<T extends Comparable<T>>{
	private ListNode<T> root;
	private ListNode<T> tail;
	private int size;
	
	DoublyLinkedList(ListNode<T> root){
		this.root = root;
		tail = root;
		size = 1;
	}
	
	DoublyLinkedList(){
		this.root = null;
		this.tail = null;
		size = 0;
	}
	
	
	
	public ListNode<T> get(int index) throws IndexOutOfBoundsException{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Ur Bad");
		}
		ListNode<T> temp = root;
		for(int i = 0; i <= index; i++) {
			if(temp.hasNext())
				temp = temp.getNext();
		}
		
		return temp;
	}
	
	public void add(T val) {
		//add a node to the list
		ListNode<T> node = new ListNode<T>(val);
		if(size == 0) {
			root = node;
			tail = node;
			size++;
		}
		else{
			ListNode<T> temp = tail;
		
			tail = node;
			tail.setPrev(temp);
			temp.setNext(tail);
			size++;
		}
	}
	
	public void add(int index, T val) throws IndexOutOfBoundsException{
		ListNode<T> node = new ListNode<T>(val);
		if(size == 0) {
			root = node;
			tail = node;
			size++;
		}
		else if(index == 0) {
			ListNode<T> temp = root;
			root = node;
			root.setNext(temp);
			temp.setPrev(root);
			size++;

		}
		else if(index == 1) {
			ListNode<T> before = root;
			ListNode<T> after = root.getNext();
			before.setNext(node);
			node.setPrev(before);
			node.setNext(after);
			after.setPrev(node);
			size++;
			
		}
		else if(index == size - 1) {
			this.add(val);
			
		}
		else {
			ListNode<T> before = this.get(index - 2);
			ListNode<T> after = this.get(index - 1) ;

			before.setNext(node);
			node.setPrev(before);
			node.setNext(after);
			after.setPrev(node);
			size++;
		}
		
	}
	
	public ListNode<T> remove(int index) {
		ListNode<T> temp = this.get(index);
		if(index == 0) {
			this.getNext();
		}
		else if(index == this.getSize() - 1) {
			tail = tail.getPrev();
			tail.setNext(null);
		}
		else {
			ListNode<T> before = this.get(index - 1);
			ListNode<T> after = this.get(index + 1);
			before.setNext(after);
			after.setPrev(before);
			size--;
		}
		return temp;
	}

	public void clear() {
		//remove all list nodes from the method
		root.setNext(null);
		root = null;
		size = 0;
	}
	
	public boolean contains(T val) {
		//contains specific list node
		ListNode<T> node = new ListNode<T>(val);
		ListNode<T> temp = root;
		for(int i = 0; i < size; i ++) {
			temp = this.get(i);
			if(temp.getValue().compareTo(node.getValue()) == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	public String toString() {
		String output = "[";
		ListNode<T> temp = root;
		for(int i = 0; i < size; i++) {
			output += temp.toString();
			if(i+1 < size) {
				output += ", ";
			}
			temp = temp.getNext();
		}
		
		output += "]";
		return output;
	}
	
	public String toReversedString() {
		String output = "[";
		ListNode<T> temp = tail;
		for(int i = size - 1; i >= 0; i--) {
			output += temp.toString();
			if(i!= 0) {
				output += ", ";
			}
			temp = temp.getPrev();
		}
		
		output += "]";
		return output;
	}

	public int getSize() {
		return size;
	}
	
	public ListNode<T> getEnd( ) {
		return tail;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void getNext() {
		root = root.getNext();
		size --;
	}
	
	public ListNode<T> getRoot() {
		return root;
	}
	
	public DoublyLinkedList<T> sort(){
		DoublyLinkedList<T> sortedList = new DoublyLinkedList<T>();
		T min;
		int index = 0;
		while(this.getSize() != 0) {
			index = 0;
			min = this.get(0).getValue();
			for(int i = 0; i < this.getSize(); i++) {
				if(this.get(i).compareTo(new ListNode(min)) == -1) {
					min = this.get(i).getValue();
					index = i;
				}
			}
			sortedList.add(min);
			this.remove(index);
		}
		return sortedList;
	}
	
	
}
