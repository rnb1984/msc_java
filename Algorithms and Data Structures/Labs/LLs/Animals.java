// simple program to test linked list classes
public class Animals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// testing the heterogeneous SLL
		System.out.println("Farm animals:\n ");
		SLL farm = new SLL();
		farm.insert("horse");
		farm.insert("cow");
		farm.insert("sheep");
		farm.insert("pig");
		
		farm.printFirstToLast();
		System.out.println("\n");
		farm.reverse();
		System.out.println("Reversed list is: ");
		farm.printFirstToLast();
		System.out.println("\n");
		farm.reverse();
		farm.deleteFirst();
		farm.printFirstToLast();
		System.out.println("\n");
		System.out.print("Linked list does ");
		if(farm.search("horse")==null) System.out.print("not ");
		System.out.print("contain the string \"horse\", and does ");
		if(farm.search("goat")==null) System.out.print("not ");
		System.out.print("contain the string \"goat\".");
		System.out.println("------------------------------\n");
		// testing the homogeneous SLL
		System.out.println("zoo animals: \n");
		SLL2<String> zoo = new SLL2<String>();
		zoo.insert("tiger");
		zoo.insert("elephant");
		zoo.insert("zebra");
		zoo.insert("ape");
		zoo.printFirstToLast();
		System.out.println("\n");
		zoo.deleteFirst();
		zoo.printFirstToLast();
		System.out.println("\n");
		System.out.print("Linked list does ");
		if(zoo.search("elephant")==null) System.out.print("not ");
		System.out.print("contain the string \"elephant\", and does ");
		if(zoo.search("rhino")==null) System.out.print("not ");
		System.out.print("contain the string \"rhino\".");
		System.out.println("------------------------------\n");
		
		//testing the heterogeneous DLL
		System.out.println("petshop: \n");
		DLL petShop = new DLL();
		petShop.insert("cat");
		petShop.insert("dog");
		petShop.insert("dog");
		petShop.insert("mouse");
		petShop.printFirstToLast();
		System.out.println("\n");
		petShop.delete("dog");
		petShop.printFirstToLast();
		System.out.println("------------------------------\n");
		
		//testing the homogeneous DLL
		System.out.println("aquarium: \n");
		DLL2<String> aquarium = new DLL2<String>();
		aquarium.insert("guppy");
		aquarium.insert("angelfish");
		aquarium.insert("swordfish");
		aquarium.insert("rainbow");
		aquarium.insert("catfish");
		aquarium.printFirstToLast();
		System.out.println("\n");
		aquarium.delete("rainbow");
		aquarium.printFirstToLast();
		
	}

}
