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
		eatAtJoesMenu.add("burger", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 24.99); 
		eatAtJoesMenu.add("fries", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, 3.50);
		eatAtJoesMenu.add("shake", Menu.DESSERT, Menu.HEART_HEALTHY, 3.50);
		
		MenuIterator itr1 = eatAtJoesMenu.getPriceIterator(24.99);
		
		MenuIterator itr2 = eatAtJoesMenu.getHeartHealthyIterator();
		
		MenuIterator itr3 = eatAtJoesMenu.getItemIterator(Menu.MAIN_DISH);
		
		MenuIterator itr4 = eatAtJoesMenu.getAllItemsIterator();
		
		MenuIterator itr5 = eatAtJoesMenu.getAllItemsIterator();
		
		MenuIterator itr6 = eatAtJoesMenu.getAllItemsIterator();
		
		int option = 4;
		
		switch(option) {
		case 1 :
			try {
				while(itr1.hasNext()) {
			
					System.out.println(itr1.next().getName());
				}
			}
			catch(NullPointerException e) {
				System.out.println("There are no items left under that price.");
			}
			break;
		
		
		
		case 2: 
			try {
				while(itr2.hasNext()) {
				
					System.out.println(itr2.next().getName());
					}
				}
				catch(NullPointerException e) {
					System.out.println("There are no healthy items left.");
				}
			break;
		
		case 3:
			try {
				while(itr3.hasNext()) {
				
					System.out.println(itr3.next().getName());
					}
				}
				catch(NullPointerException e) {
					System.out.println("There are no items left in that category.");
				}
			break;
		
		case 4:
			try {
				while(itr4.hasNext()) {
				
					System.out.println(itr4.next().getName());
					}
				}
				catch(NullPointerException e) {
					System.out.println("There are no more items left.");
				}
			break;
		}
		
		System .out.println("Delete heart healthy Item");
		// delete all menu items
		while(itr5.hasNext()) {
			
			MenuItem dItem = itr5.next();
			if(dItem.getHeart())
				eatAtJoesMenu.delete(dItem);
		}
		
		try {
			while(itr6.hasNext()) {
			
				System.out.println(itr6.next().getName());
				}
			}
			catch(NullPointerException e) {
				System.out.println("There are no more items left.");
			}
		
	}

}
