import java.io.PrintStream;
import java.util.*;



public class BstMultiset<T> extends Multiset<T>
{
	protected LinkedNode head;
	protected LinkedNode currentNode;
	protected int size;
	
	public BstMultiset() {
		head = null;
		currentNode = head;
		size = 0;
	} // end of BstMultiset()

	public void add(T item) {
		if(head == null) {
			head = new LinkedNode(item, null, null, null);
			currentNode = head;
			size++;
		}
		else {
			boolean inserted = false;
			LinkedNode tempNode;
			currentNode = head;
			while(!inserted) {
				
				if(item.toString().compareToIgnoreCase(currentNode.getElement().toString()) < 0) { //left child
					
					if(currentNode.getLeftChildNode() == null) {      //if reached the end of the branch
						currentNode.setLeftChildNode(new LinkedNode(item,currentNode, null,null));
						inserted = true;
						size++;
						break;
					}
					else {
						currentNode = currentNode.getLeftChildNode();
					}
					
									
				}
				else if(item.toString().compareToIgnoreCase(currentNode.getElement().toString()) > 0) {
					
					if(currentNode.getRightChildNode() == null) {      //if reached the end of the branch
						currentNode.setRightChildNode(new LinkedNode(item,currentNode, null,null));
						inserted = true;
						size++;
						break;
					}
					else {
						currentNode = currentNode.getRightChildNode();
					}
				}
				else {
					currentNode.aumentCounter();
					inserted = true;
					break;
				}
			}
			
			
		}
	} // end of add()


	public int search(T item) {
		int count = 0;
		boolean found = false;
		currentNode = head;
		while(!found) {
			try {
				
				if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) > 0) {
					currentNode = currentNode.getLeftChildNode();
				}
				else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0) {
					currentNode = currentNode.getRightChildNode();
				}
				else {
					count = currentNode.getECounter();
					found = true;
					break;
				}
				
			}
			catch(NullPointerException npe) {
				count = 0;
				found = true;
				break;
			}
			
		}
		return count;
	} // end of add()


	public void removeOne(T item) {
		boolean found = false;
		currentNode = head;
		while(!found) {
			try {
				
				if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) > 0) {
					currentNode = currentNode.getLeftChildNode();
				}
				else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0) {
					currentNode = currentNode.getRightChildNode();
				}
				else {
					if(currentNode.getECounter() > 1) {
						currentNode.dementCounter();
						found = true;
						break;
					}
					else {
						if(currentNode.getLeftChildNode() != null && currentNode.getRightChildNode() != null) {
							LinkedNode tempNode = currentNode.getRightChildNode();
							
							while(tempNode.getLeftChildNode() != null) {
								tempNode = tempNode.getLeftChildNode();
							}
							
							if(tempNode.getParentNode().getLeftChildNode().equals(tempNode)){
								tempNode.getParentNode().setLeftChildNode(null);
							}
							else {
								if(tempNode.getRightChildNode() != null) {
									tempNode.getRightChildNode().setParentNode(tempNode.getParentNode());
								}
								else {
									
									tempNode.getParentNode().setRightChildNode(null);
								}
								
							}
							
							currentNode.getLeftChildNode().setParentNode(tempNode);
							if(currentNode.getRightChildNode() != null) {
								
								currentNode.getRightChildNode().setParentNode(tempNode);
							}
							
							if(currentNode.getParentNode() != null) {
								
								if(currentNode.equals(currentNode.getParentNode().getLeftChildNode())) {
									currentNode.getParentNode().setLeftChildNode(tempNode);
								}
								else if(currentNode.equals(currentNode.getParentNode().getRightChildNode())) {
									currentNode.getParentNode().setRightChildNode(tempNode);
									
								}
								tempNode.setParentNode(currentNode.getParentNode());
							}
							else {
								
								
								head = tempNode;
							}
							if(currentNode.getLeftChildNode() != null) {
								
								currentNode.getLeftChildNode().setParentNode(tempNode);
								tempNode.setLeftChildNode(currentNode.leftChildNode);
							}
							if(currentNode.getRightChildNode() != null) {
								currentNode.getRightChildNode().setParentNode(tempNode);
								tempNode.setRightChildNode(currentNode.getRightChildNode());
							}
							found = true;
							size--;
							break;
						}
						if(currentNode.getLeftChildNode() != null) {
							
							currentNode.getParentNode().setLeftChildNode(currentNode.getLeftChildNode());
							currentNode.getLeftChildNode().setParentNode(currentNode.getParentNode());
							
							
						}
						else {
							
							currentNode.getParentNode().setLeftChildNode(null);
							
						}
						
						if(currentNode.getRightChildNode() != null) {
							currentNode.getParentNode().setRightChildNode(currentNode.getRightChildNode());
							currentNode.getRightChildNode().setParentNode(currentNode.getParentNode());
							
						}
						else {
							currentNode.getParentNode().setRightChildNode(null);
						}
					
					found = true;
					size--;
					break;
					}
				
					
				
				}
				
			}
			catch(NullPointerException npe) {
				
				
				found = true;
				break;
			}
			
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		
		boolean found = false;
		currentNode = head;
		while(!found) {
			try {
				
				if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) > 0) {
					currentNode = currentNode.getLeftChildNode();
				}
				else if(currentNode.getElement().toString().compareToIgnoreCase(item.toString()) < 0) {
					currentNode = currentNode.getRightChildNode();
				}
				else {
					
				
					if(currentNode.getLeftChildNode() != null && currentNode.getRightChildNode() != null) {
						LinkedNode tempNode = currentNode.getRightChildNode();
						
						while(tempNode.getLeftChildNode() != null) {
							tempNode = tempNode.getLeftChildNode();
						}
						
						if(tempNode.getParentNode().getLeftChildNode().equals(tempNode)){
							tempNode.getParentNode().setLeftChildNode(null);
						}
						else {
							if(tempNode.getRightChildNode() != null) {
								tempNode.getRightChildNode().setParentNode(tempNode.getParentNode());
							}
							else {
								
								tempNode.getParentNode().setRightChildNode(null);
							}
							
						}
						
						currentNode.getLeftChildNode().setParentNode(tempNode);
						if(currentNode.getRightChildNode() != null) {
							
							currentNode.getRightChildNode().setParentNode(tempNode);
						}
						
						if(currentNode.getParentNode() != null) {
							
							if(currentNode.equals(currentNode.getParentNode().getLeftChildNode())) {
								currentNode.getParentNode().setLeftChildNode(tempNode);
							}
							else if(currentNode.equals(currentNode.getParentNode().getRightChildNode())) {
								currentNode.getParentNode().setRightChildNode(tempNode);
								
							}
							tempNode.setParentNode(currentNode.getParentNode());
						}
						else {
							
							
							head = tempNode;
						}
						if(currentNode.getLeftChildNode() != null) {
							
							currentNode.getLeftChildNode().setParentNode(tempNode);
							tempNode.setLeftChildNode(currentNode.leftChildNode);
						}
						if(currentNode.getRightChildNode() != null) {
							currentNode.getRightChildNode().setParentNode(tempNode);
							tempNode.setRightChildNode(currentNode.getRightChildNode());
						}
						found = true;
						size--;
						break;
					}
					if(currentNode.getLeftChildNode() != null) {
						
						currentNode.getParentNode().setLeftChildNode(currentNode.getLeftChildNode());
						currentNode.getLeftChildNode().setParentNode(currentNode.getParentNode());
						
						
					}
					else {
						
						currentNode.getParentNode().setLeftChildNode(null);
						
					}
					
					if(currentNode.getRightChildNode() != null) {
						currentNode.getParentNode().setRightChildNode(currentNode.getRightChildNode());
						currentNode.getRightChildNode().setParentNode(currentNode.getParentNode());
						
					}
					else {
						currentNode.getParentNode().setRightChildNode(null);
					}
				
				found = true;
				size--;
				break;
				
				}
				
			}
			catch(NullPointerException npe) {
				
				
				found = true;
				break;
			}
			
		}
		
	} // end of removeAll()


	public void print(PrintStream out) {
		
		
		
		boolean printed = false;
		currentNode = head;
		out.println(currentNode.getElement() + " | " + currentNode.getECounter());
		int i = 1;
		boolean checkedLeft = false;
		boolean checkedRight = false;
		
		while(!printed) {
			
			if(currentNode.equals(head) && checkedLeft == true) {
				
				checkedRight = false;
			}
			
			
			while(currentNode.getLeftChildNode() != null) {
				if(checkedLeft) {
					break;
				}
				
				out.println(currentNode.getLeftChildNode().getElement() + " | " + currentNode.getLeftChildNode().getECounter());
				currentNode = currentNode.getLeftChildNode();
				checkedRight = false;
				i++;
				
			}
			if(currentNode.getRightChildNode() != null) {
				
				if(!checkedRight) {
					out.println(currentNode.getRightChildNode().getElement() + " | " + currentNode.getRightChildNode().getECounter());
					i++;
					
					currentNode = currentNode.getRightChildNode();
					checkedLeft = false;
				}
				
				
			}
			if(currentNode.getLeftChildNode() == null || checkedLeft) {
				if(currentNode.getParentNode().getRightChildNode() != null) {
					if(currentNode.equals(currentNode.getParentNode().getRightChildNode())) {
						
						
						checkedRight = true;
						checkedLeft = true;
					}
				}
				if(currentNode.getParentNode().getLeftChildNode() != null) {
					if(currentNode.equals(currentNode.getParentNode().getLeftChildNode())) {
						
						
						checkedRight = false;
						checkedLeft = true;
					}
				}
				
				currentNode = currentNode.getParentNode();
				checkedLeft = true;
				
				
			}
			
			if(i >= size) {
				
				printed = true;
				break;
			}
		}
		
	} // end of print()
	
	public void printCustom() {
		String space = " ";
		
		boolean printed = false;
		currentNode = head;
		System.out.println(currentNode.getElement() + " | " + currentNode.getECounter());
		int i = 1;
		boolean checkedLeft = false;
		boolean checkedRight = false;
		
		while(!printed) {
			
			if(currentNode.equals(head)) {
				
				checkedRight = false;
			}
			
			
			while(currentNode.getLeftChildNode() != null) {
				if(checkedLeft) {
					break;
				}
				
				System.out.println(currentNode.getLeftChildNode().getElement() + " | " + currentNode.getLeftChildNode().getECounter());
				currentNode = currentNode.getLeftChildNode();
				checkedRight = false;
				i++;
				
			}
			if(currentNode.getRightChildNode() != null) {
				
				if(!checkedRight) {
					System.out.println(currentNode.getRightChildNode().getElement() + " | " + currentNode.getRightChildNode().getECounter());
					i++;
					
					currentNode = currentNode.getRightChildNode();
					checkedLeft = false;
				}
				
				
			}
			if(currentNode.getLeftChildNode() == null || checkedLeft) {
				if(currentNode.getParentNode().getRightChildNode() != null) {
					if(currentNode.equals(currentNode.getParentNode().getRightChildNode())) {
						
						
						checkedRight = true;
						checkedLeft = true;
					}
				}
				if(currentNode.getParentNode().getLeftChildNode() != null) {
					if(currentNode.equals(currentNode.getParentNode().getLeftChildNode())) {
						
						
						checkedRight = false;
						checkedLeft = true;
					}
				}
				
				currentNode = currentNode.getParentNode();
				checkedLeft = true;
				
				
			}
			if(i == size) {
				
				printed = true;
				break;
			}
		}
		
		
	}// end of printCustom

	
	
	private class LinkedNode{
		T element;
		int eCounter = 1;
		
		LinkedNode parentNode;
		LinkedNode leftChildNode;
		LinkedNode rightChildNode;
		public LinkedNode(T element, LinkedNode parentNode, LinkedNode leftChildNode, LinkedNode rightChildNode){
			this.element = element;
			this.parentNode = parentNode;
			
			this.leftChildNode = leftChildNode;
			this.rightChildNode = rightChildNode;
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
		
		public void aumentCounter() {
			eCounter++;
		}
		public void setLeftChildNode(LinkedNode leftChildNode) {
			this.leftChildNode = leftChildNode;
		}
		public LinkedNode getLeftChildNode() {
			return leftChildNode;
		}
		public void setRightChildNode(LinkedNode rightChildNode) {
			this.rightChildNode = rightChildNode;
		}
		public LinkedNode getRightChildNode() {
			return rightChildNode;
		}
		public void setParentNode(LinkedNode parentNode) {
			this.parentNode = parentNode;
		}
		public void dementCounter() {
			eCounter--;
		}
	}//end of LinkedNode
	
} // end of class BstMultiset
