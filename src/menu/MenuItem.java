/**
 * 
 */
package menu;

/**
 * @author aviel
 *
 */
public class MenuItem {

	/**
	 * 
	 */
	
	private String name;
	private int category;
	private  boolean heartHealthy;
	private double price;
	
	
	public MenuItem(String Name, int Category, boolean Healthy, double Price) {
		// TODO Auto-generated constructor stub
		
		name = Name;
		category = Category;
		heartHealthy = Healthy;
		price = Price;
	}
	
	
	
	// getter and setter methods for name field
	public String getName () {
		
		return this.name;
		
	}
	
	public void setName (String newName) {
		
		name = newName;
	}
	
	
	
	
	// getter and setter methods for category field
		public int getCategory () {
			
			return this.category;
			
		}
		
		public void setCategory (int newCategory) {
			
			category = newCategory;
		}
		
		
		
		
		// getter and setter methods for heartHealthy field
		public boolean getHeart () {
			
			return this.heartHealthy;
			
		}
		
		public void setName (boolean newHeart) {
			
			heartHealthy = newHeart;
		}
		
		
		
		
		// getter and setter methods for price field
		public double getPrice () {
			
			return this.price;
			
		}
		
		public void setName (double newPrice) {
			
			price = newPrice;
		}
}
