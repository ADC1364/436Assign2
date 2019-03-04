package menu;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Menu eatAtJoesMenu = new Menu();
		eatAtJoesMenu.add("Lobster Dinner", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 24.99); 
		eatAtJoesMenu.add("Rice Pudding", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 3.50);
		
		MenuIterator itr1 = eatAtJoesMenu.getAllItemsIterator();
		MenuIterator itr2 = eatAtJoesMenu.getAllItemsIterator();
		
		while(itr1.hasNext()) {
			
			MenuItem item = itr1.next();
			if(item.getName().contentEquals("Rice Pudding"))
				eatAtJoesMenu.delete(item);
			
		}
		
		
		while(itr2.hasNext()) {
			
			System.out.println(itr2.next().getName());
		}
		
		
		
		
	

	}

}
