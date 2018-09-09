import java.io.PrintStream;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
	protected LinkedNode head;
	protected int size;
	protected LinkedNode currentNode;
	public SortedLinkedListMultiset() {
		
		head = null;
		size  = 0;
		currentNode = null;
	} // end of SortedLinkedListMultiset()
	
	
	public void add(T item) {
		
		
		if(head == null) {
			head = new LinkedNode(item, null,size, null);
			currentNode = head;
			size++;
			
			
			
		}
		else {
			
			
			
			int check = 0;
			boolean inserted = false;
			int point = size/2;
			currentNode = head;
			LinkedNode tempNode = new LinkedNode(item, null, 3, null);
			while(!inserted) {
				
				if(point == 0 && (currentNode.getChildNode() == null || currentNode.getParentNode() == null)) {
					if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) == 0) {
						currentNode.aumentCounter();
						
						inserted = true;
						break;
					}
					try {
						if(currentNode.getChildNode().getElement().toString().compareToIgnoreCase(item.toString()) == 0) {
							
							currentNode.getChildNode().aumentCounter();
							inserted = true;
							break;
						}
					}
					catch(Exception e) {
						
					}
					
					if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0) { //item greater than CE
						
						
						
						tempNode.setParentNode(currentNode);
						tempNode.setChildNode(currentNode.getChildNode());
						currentNode.setChildNode(tempNode);
						size++;
						inserted = true;
						break;
					}
					if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) > 0) { //item smaller than CE
						tempNode.setChildNode(head);
						head.setParentNode(tempNode);
						
						head = tempNode;
						
						size++;
						inserted = true;
						break;
					}
				}
				else {
					point = 1;
					if(check == 0) {
						for(int i=0;i<point;i++) {
							currentNode = currentNode.getChildNode();
						}
					}
					
					else if(check == 1) {
						for(int i=0;i<point;i++) {
							currentNode = currentNode.getParentNode();
						}
					}
					
					
					
					
					
					if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0) { //item greater than CE
						
						
						if(currentNode.getChildNode() == null || 
								currentNode.getChildNode().getElement().toString().compareToIgnoreCase(item.toString()) > 0) { //item smaller than child of CE
							
							if(currentNode.getChildNode() != null) {
								tempNode.setChildNode(currentNode.getChildNode());
								currentNode.getChildNode().setParentNode(tempNode);
							}
							
							tempNode.setParentNode(currentNode);														
							currentNode.setChildNode(tempNode);
							
							size++;
							inserted = true;
							break;
							
							
						}
						
						check = 0;
					}
					else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) > 0) { //item smaller than CE
						
						
						if(currentNode.getParentNode() == null || 
								currentNode.getParentNode().getElement().toString().compareToIgnoreCase(item.toString()) < 0) { //item greater than parent of CE
							
							if(currentNode.getParentNode() != null) {
								tempNode.setParentNode(currentNode.getParentNode());
								currentNode.getParentNode().setChildNode(tempNode);
							}
							
							
							tempNode.setChildNode(currentNode);
							
							currentNode.setParentNode(tempNode);
							
							if(tempNode.getParentNode() == null) {
								head = tempNode;
							}
							size++;
							inserted = true;
							break;
							
							
						}
						check = 1;
					}
					else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) == 0) { //item equals than CE
						currentNode.aumentCounter();
						
						
						inserted = true;
						break;
					}
				}
				point = point/2;
				
//				if(size>1) {
//						if(point < 1) {
//							point  = 1;
//						}
//						for(int i=0;i<point;i++) {
//							
//							if(check1 == 0) {
//								if(currentNode.getChildNode()==null) {
//									LinkedNode tempNode = new LinkedNode(item,currentNode,3,null);
//									currentNode.setChildNode(tempNode);
//									size++;
//									inserted = true;
//									break;
//								}
//								currentNode = currentNode.getChildNode();
//							}
//							else {
//								
//								if(currentNode.getParentNode()==null) {
//									LinkedNode tempNode = new LinkedNode(item,null,3,currentNode);
//									currentNode.setParentNode(tempNode);
//									head = tempNode;
//									size++;
//									inserted = true;
//									break;
//								}
//								currentNode = currentNode.getParentNode();
//							}
//							
//						}
//						if((currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0)&&(currentNode.getChildNode().getElement().toString().compareToIgnoreCase(item.toString()) < 0)) {
//							
//							point = point/2;
//							check1 = 0;
//							
//						}
//						else if((currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0)&&((currentNode.getChildNode().getElement().toString().compareToIgnoreCase(item.toString()) > 0)
//								||(currentNode.getChildNode()==null))) {
//							
//							LinkedNode tempNode = new LinkedNode(item, currentNode, 3, currentNode.getChildNode());
//							currentNode.getChildNode().setParentNode(tempNode);
//							currentNode.setChildNode(tempNode);
//							currentNode = head;
//							inserted = true;
//							size++;
//							break;
//						}
//						else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) == 0) {
//							
//							currentNode.aumentCounter();
//							inserted = true;
//							break;
//						}
//						else {
//							
//							point = point/2;
//							check1 = 1;
//						}
//					
//					
//				}
//				else {
//					if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0) {
//						
//						LinkedNode tempNode = new LinkedNode(item,currentNode,3,null);
//						currentNode.setChildNode(tempNode);
//						inserted = true;
//						size++;
//						currentNode = head;
//						break;
//					}
//					
//					else {
//						
//						LinkedNode tempNode = new LinkedNode(item,null,3,currentNode);
//						currentNode.setParentNode(tempNode);
//						inserted = true;
//						size++;
//						currentNode = head;
//						break;
//					}
//				}
			}
				
			

			
		}
		System.out.println("size: " + size);

	} // end of add()
	
	
	public int search(T item) {
		
		int count = 0;
//		currentNode = head;
//		for(int i=0;i<size;i++) {
//			
//			if(currentNode.getElement().equals(item)) {
//				
//				count = currentNode.getECounter();
//				currentNode = head;
//				break;
//			}
//			currentNode = currentNode.getChildNode();
//			
//		}
		
		
		boolean found = false;
		int point = size/2;
		currentNode = head;
		int check = 0;
		while(!found) {
			
			if(point == 0 && (currentNode.getChildNode() == null || currentNode.getParentNode() == null)) {
				if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) == 0) {
					count = currentNode.getECounter();
					found = true;
					break;
				}
				else {
					count = 0;
					found = true;
					break;
				}
			}
			point = 1;
			if(check == 0) {
				for(int i=0;i<point;i++) {
					currentNode = currentNode.getChildNode();
				}
			}
			else {
				for(int i=0;i<point;i++) {
					currentNode = currentNode.getParentNode();
				}
			}
			if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0) { //item greater than CE(current element)
				if(currentNode.getChildNode() == null 
						|| currentNode.getChildNode().getElement().toString().compareToIgnoreCase(item.toString()) > 0) {//item smaller than CE child
					count = 0;
					found = true;
					break;
				}
				check = 0;
				point = point/2;
			}
			else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) > 0) { //item smaller than CE
				if(currentNode.getParentNode() == null 
						|| currentNode.getParentNode().getElement().toString().compareToIgnoreCase(item.toString()) < 0) {//item larger than CE parent
					count = 0;
					found = true;
					break;
				}
				check = 1;
				point = point/2;
			}
			else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) == 0) { //item equals CE
				count = currentNode.getECounter();
				found = true;
				break;
			}
			
			
		}
		
		
		return count;
		
		
		
	} // end of add()
	
	
	public void removeOne(T item) {
		
		currentNode = head;
		for(int i=0;i<size;i++) {
			if(currentNode.getElement().equals(item)) {
				
				if(currentNode.getECounter() == 1) {
					if(currentNode.getChildNode()!=null) {
						
						currentNode.getChildNode().setParentNode(currentNode.getParentNode());
						
						if(currentNode.getParentNode() != null) {
							currentNode.getParentNode().setChildNode(currentNode.getChildNode());
						}
						else {
							
							currentNode.getChildNode().setParentNode(null);
							head = currentNode.getChildNode();
							
							
						}
						
						
						
						
					}
					else {
						if(currentNode.getParentNode() != null) {
							currentNode.getParentNode().setChildNode(null);
						}
						else {
							head = null;
						}
						
						
					}
					
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
			currentNode = currentNode.getChildNode();
		}
		
		
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		currentNode = head;
		for(int i=0;i<size;i++) {
			
			if(currentNode.getElement().equals(item)) {
				if(currentNode.getChildNode()!=null) {
					
					currentNode.getChildNode().setParentNode(currentNode.getParentNode());
					
					if(currentNode.getParentNode() != null) {
						currentNode.getParentNode().setChildNode(currentNode.getChildNode());
					}
					else {
						
						currentNode.getChildNode().setParentNode(null);
						head = currentNode.getChildNode();
						
						
					}
					
					
					
					
				}
				else {
					if(currentNode.getParentNode() != null) {
						currentNode.getParentNode().setChildNode(null);
					}
					else {
						head = null;
					}
					
					
				}
				
				currentNode = head;
				size--;
				break;
			}
			
			currentNode = currentNode.getChildNode();
		}
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		currentNode = head;
		for(int i=0;i<size;i++) {
			out.println(currentNode.getElement() + " | " + currentNode.getECounter());
			currentNode = currentNode.getChildNode();
			
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
	
} // end of class SortedLinkedListMultiset