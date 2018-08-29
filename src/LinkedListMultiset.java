import java.io.PrintStream;
import java.util.*;



public class LinkedListMultiset<T> extends Multiset<T>
{
	protected LinkedNode head;
	protected int size;
	protected LinkedNode currentNode;
	public LinkedListMultiset() {
		
		head = null;
		size  = 0;
		currentNode = null;
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		if(head == null) {
			head = new LinkedNode(item, null,size);
			currentNode = head;
			size++;
			
			
		}
		else {
			int check = 0;
			for(int i=size;i>0;i--) {
				
				if(currentNode.getElement().equals(item)) {
					
					currentNode.aumentCounter();
					
					check = 1;
					currentNode = head;
					break;
				}
				currentNode = currentNode.getParentNode();
			}
			if(check == 0) {
				currentNode = new LinkedNode(item,head,size);
				head = currentNode;
				size++;
			}
			
		}
		
	} // end of add()
	
	
	public int search(T item) {
		
		
		int count = 0;
		for(int i=size;i>0;i--) {
			
			if(currentNode.getElement().equals(item)) {
				
				count = currentNode.getECounter();
				currentNode = head;
				break;
			}
			currentNode = currentNode.getParentNode();
			
		}
		
		// default return, please override when you implement this method
		return count;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
	
	private class LinkedNode{
		T element;
		int eCounter = 1;
		int index;
		LinkedNode parentNode;
		public LinkedNode(T element, LinkedNode parentNode, int index){
			this.element = element;
			this.parentNode = parentNode;
			this.index = index;
		}
		
		public T getElement() {
			return element;
		}
		public int getECounter() {
			return eCounter;
		}
		
		public LinkedNode getParentNode() {
			return parentNode;
		}
		public int getIndex() {
			return index;
		}
		public void aumentCounter() {
			eCounter++;
		}
	}
} // end of class LinkedListMultiset

