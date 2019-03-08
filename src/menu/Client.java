package menu;

import java.util.Scanner;

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
		int option;
		Scanner input = new Scanner (System.in);
		String delete;
		MenuItem item;
		
		System.out.println("#####################################");
		System.out.println("Option 1: Please select a price and the itmes at or below that price will be displayed.");
		System.out.println("Option 2: Display heart healthy options.");
		System.out.println("Option 3: Please select a category of a dish and the itmes in that category will be displayed.");
		System.out.println("Option 4: Display all items in the list.");
		System.out.println("#####################################");
		
		System.out.println("Please enter an option");
		option =  input.nextInt();
		
		switch(option) {
		case 1 :
			System.out.println("Select a price:");
			double price = input.nextDouble() ;
			itr = eatAtJoesMenu.getPriceIterator(price);
				while(itr.hasNext()) {
			
					item = itr.next();
					System.out.println(item.getName());
					System.out.println("Do you wish to delete this item");
					delete = input.next();
					if(delete.contentEquals("d"))
						eatAtJoesMenu.delete(item);
					
				}
			break;
		
		
		
		case 2:
			itr = eatAtJoesMenu.getHeartHealthyIterator();
				while(itr.hasNext()) {
			
					item = itr.next();
					System.out.println(item.getName());
					System.out.println("Do you wish to delete this item");
					delete = input.next();
					if(delete.contentEquals("d"))
						eatAtJoesMenu.delete(item);
					
				}
			break;
		
		case 3:
			System.out.println("Select a category:");
			int category = input.nextInt();
			itr = eatAtJoesMenu.getItemIterator(category);
				while(itr.hasNext()) {
			
					item = itr.next();
					System.out.println(item.getName());
					System.out.println("Do you wish to delete this item");
					delete = input.next();
					if(delete.contentEquals("d"))
						eatAtJoesMenu.delete(item);
					
				}
			break;
		
		case 4:
			itr = eatAtJoesMenu.getAllItemsIterator();
			while(itr.hasNext()) {
				
				item = itr.next();
				System.out.println(item.getName());
				System.out.println("Do you wish to delete this item");
				delete = input.next();
				if(delete.contentEquals("d"))
					eatAtJoesMenu.delete(item);
				
			}
			break;
		}
		
		System.out.println("Items left in the list are:");
		
		itr = eatAtJoesMenu.getAllItemsIterator();
		
			while(itr.hasNext()) {
			
				System.out.println(itr.next().getName());
				}
		
	}

}
