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
	
	
	
	
	
	
	
	public MenuIterator getAllItemsIterator()   // factory method  
	  {
		
		return new AllItemsIterator();  
		  
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public boolean add(String Name, int Category, boolean Heart, double Price) {
		// TODO Auto-generated method stub
		
		MenuItem item = new MenuItem(Name, Category, Heart, Price);
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

	
	public void delete(MenuItem item) {
		// TODO Auto-generated method stub}
		
		// Store head node 
        Node temp = head, prev = null; 
  
        // If head node itself holds the key to be deleted 
        if (temp != null && temp.data.getName().contentEquals(item.getName())) 
        { 
            head = temp.next; // Changed head 
            return; 
        } 
  
        // Search for the key to be deleted, keep track of the 
        // previous node as we need to change temp.next 
        while (temp != null && !temp.data.getName().contentEquals(item.getName())) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
  
        // If key was not present in linked list 
        if (temp == null) return; 
  
        // Unlink the node from linked list 
        prev.next = temp.next;
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
			
	}

}
