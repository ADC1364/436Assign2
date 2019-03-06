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
	
	
	public MenuIterator getItemIterator(int selectedCategory)   // factory method  
	  {
		
		return new ItemIterator(selectedCategory);  
		  
	  }
	
	
	public MenuIterator getHeartHealthyIterator()   // factory method  
	  {
		
		return new HeartHealthyIterator();  
		  
	  }
	
	
	public MenuIterator getPriceIterator(double selectedPrice)   // factory method  
	  {
		
		return new PriceIterator(selectedPrice);  
		  
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
        numberOfElements --; // not sure if the decrement goes here
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
	
	
	private class ItemIterator implements MenuIterator{
		
		private Node cursor;
		
		private int selectedCat;
		
		private MenuItem item;
		
		public ItemIterator( int selectedCategory) {
			
			cursor = head;
			selectedCat = selectedCategory;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor != null;
		}

		public MenuItem next() {
			// TODO Auto-generated method stub
			if(!hasNext()) {
				return null;
			}
			
			while( (cursor.data.getCategory() != selectedCat) && (cursor.getNext() !=null) ) {
				
					cursor = cursor.getNext();
					item = cursor.getData();
			}
			
		
				
				if(cursor.data.getCategory() == selectedCat) {
					item = cursor.data;
					cursor = cursor.getNext();
					return item;
				}
				else 
					return null;
			
		}
		
	}
	
	
	// heart healthy iterator only return s
	private class HeartHealthyIterator implements MenuIterator{
		
			private Node cursor;
			private MenuItem item;
		
			public HeartHealthyIterator() {
			
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
				
				while( !cursor.data.getHeart() && cursor.getNext() !=null) {
					
						cursor = cursor.getNext();
						item = cursor.getData();
				}
				
			
					
					if(cursor.data.getHeart()) {
						item = cursor.data;
						cursor = cursor.getNext();
						return item;
					}
					else 
						return null;
				
			}
		
	}
	
	
	// price iterator only returns items that are above or equal to a certain price
	private class PriceIterator implements MenuIterator{
		
			private Node cursor;
		
			private double selectedPrice;
			
			private MenuItem item;
		
			public PriceIterator(double Price) {
			
				cursor = head;
				selectedPrice = Price;
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
			
			while( (cursor.data.getPrice() < selectedPrice) && (cursor.getNext() !=null) ) {
				
					cursor = cursor.getNext();
					item = cursor.getData();
			}
			
		
				
				if(cursor.data.getPrice() >= selectedPrice) {
					item = cursor.data;
					cursor = cursor.getNext();
					return item;
				}
				else 
					return null;
			
		}

		
		
	}
	
	
	
	
	

}
