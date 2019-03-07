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
		eatAtJoesMenu.add("shake", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 10.50);
		
		MenuIterator itr;
		int option = 4;
		
		switch(option) {
		case 1 :
			itr = eatAtJoesMenu.getPriceIterator(10.50);
				while(itr.hasNext()) {
			
					System.out.println(itr.next().getName());
				}
			break;
		
		
		
		case 2:
			itr = eatAtJoesMenu.getHeartHealthyIterator();
				while(itr.hasNext()) {
				
					System.out.println(itr.next().getName());
					}
			break;
		
		case 3:
			itr = eatAtJoesMenu.getItemIterator(Menu.MAIN_DISH);
				while(itr.hasNext()) {
					System.out.println(itr.next().getName());
				}
			break;
		
		case 4:
			itr = eatAtJoesMenu.getAllItemsIterator();
				while(itr.hasNext()) {
				
					System.out.println(itr.next().getName());
					}
			break;
		}
		
		System .out.println("Delete Main dishes");
		itr = eatAtJoesMenu.getAllItemsIterator();
		
		// delete all menu items
		while(itr.hasNext()) {
			
			MenuItem dItem = itr.next();
			if(dItem.getCategory() == Menu.MAIN_DISH)
				eatAtJoesMenu.delete(dItem);
		}
		
		itr = eatAtJoesMenu.getAllItemsIterator();
		
			while(itr.hasNext()) {
			
				System.out.println(itr.next().getName());
				}
		
	}

}
