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
			head = new LinkedNode(item, null,size, null);
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
				currentNode = new LinkedNode(item,head,size, null);
				currentNode.getParentNode().setChildNode(currentNode);
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
		
		
		return count;
	} // end of add()
	
	
	public void removeOne(T item) {
		for(int i=size;i>0;i--) {
			if(currentNode.getElement().equals(item)) {
				
				if(currentNode.getECounter() == 1) {
					currentNode.getChildNode().setParentNode(currentNode.getParentNode());
					currentNode = head;
					size--;
					break;
				}
				else {
					currentNode.dementCounter();
					currentNode = head;
					break;
				}
				
			}
			currentNode = currentNode.getParentNode();
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		for(int i=size;i>0;i--) {
			if(currentNode.getElement().equals(item)) {
				currentNode.getChildNode().setParentNode(currentNode.getParentNode());
				currentNode = head;
				size--;
				break;
			}
			currentNode = currentNode.getParentNode();
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		
		for(int i=size;i>0;i--) {
			out.println(currentNode.getElement() + " | " + currentNode.getECounter());
			currentNode = currentNode.getParentNode();
			
		}
		currentNode = head;
	} // end of print()
	
	
	private class LinkedNode{
		T element;
		int eCounter = 1;
		int index;
		LinkedNode parentNode;
		LinkedNode childNode;
		public LinkedNode(T element, LinkedNode parentNode, int index, LinkedNode childNode){
			this.element = element;
			this.parentNode = parentNode;
			this.index = index;
			this.childNode = childNode;
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
		public void setChildNode(LinkedNode childNode) {
			this.childNode = childNode;
		}
		public LinkedNode getChildNode() {
			return childNode;
		}
		public void setParentNode(LinkedNode parentNode) {
			this.parentNode = parentNode;
		}
		public void dementCounter() {
			eCounter--;
		}
	}
} // end of class LinkedListMultiset

