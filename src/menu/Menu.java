/**
 * 
 */
package menu;

import java.util.*;

/**
 * @author aviel
 *
 */
public class Menu {

	/**
	 * 
	 */
	
	public static final int APPETIZERS = 1;
	public static final int MAIN_DISH = 2;
	public static final int DESSERT = 3;
	
	public static final boolean HEART_HEALTHY = true;
	public static final boolean NOT_HEART_HEALTHY = false;
	
	
	
	
	private Node head;
	private Node tail;
	private int numberOfElements;
	
	private class Node{
		
		private MenuItem data;
		private Node next;
		
		private Node(MenuItem item, Node next) {
			
			this.data = item;
			this.next = next;
		}
		
		public MenuItem getData () {
			
			return data;
		}
		
		public void setNext(Node next) {
			
			this.next = next;
			
		}
		
		public Node getNext() {
			return next;
		}
	}
	
	
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public boolean add(MenuItem item) {
		// TODO Auto-generated method stub
		
		Node node = new Node(item,null);
		
		if(tail == null) {
			tail = head = node;
		}
		else {
			tail.setNext(node);
			tail = node;
		}
		numberOfElements ++;
		return true;
	}

	
	public void delete(AllItemsIterator iterator) {
		// TODO Auto-generated method stub
		
		
		AllItemsIterator tempItr = new AllItemsIterator();
		
		// start at the begining of the linked list to find the previous node to the one that stores the menu item to be deleted.
		while( (! tempItr.cursor.getNext().equals(iterator)) && (tempItr.hasNext())) {
			tempItr.next();
			
		}
		
		// remove the node, that stores the menu item to be removed, by setting the previous node's next field, previous to the node to be removed, 
		//to the next node past the node to be removed.
		
		Node temp = head; 
		while (temp != null && temp != tempItr.cursor) 
        {  
            temp = temp.next; 
        }
		
		temp.next = iterator.cursor.getNext();
	}
	
	
	
	private class AllItemsIterator implements MenuIterator{
		
		private Node cursor;
		
		public AllItemsIterator() {
			
			cursor = head;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor != null;
		}

		@Override
		public MenuItem next() {
			// TODO Auto-generated method stub
			
			if(!hasNext()) {
				return null;
			}
			
			MenuItem item = cursor.getData();
			cursor = cursor.getNext();
			return item;
		}
		
		public Node getCursor() {
			
			return cursor;
		}
			
	}

}
