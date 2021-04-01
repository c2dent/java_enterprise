package lesson04.talk01;

public class Main {
	public static void main(String[] args) {
		CardIndexPets  cardPets= new CardIndexPets();
		
		Pet p1 = new Pet("Buddy", new Person("Max", 23, Sex.MAN), 22);
		Pet p2 = new Pet("Oscarmilo", new Person("Aaron", 25, Sex.MAN), 25);
		Pet p3 = new Pet("Milo", new Person("Clark", 33, Sex.MAN), 30);
		Pet p4 = new Pet("Archie", new Person("Blake", 28, Sex.MAN), 27);
		Pet p6 = new Pet("Barchie", new Person("Blake", 28, Sex.MAN), 27);
		Pet p7 = new Pet("Barchie", new Person("Blake", 28, Sex.MAN), 40);
		Person person1 = new Person("Derric", 32, Sex.MAN);
		
		
		try {
			cardPets.addPet(p1);
			cardPets.addPet(p4);
			cardPets.addPet(p3);
			cardPets.addPet(p2);
			cardPets.addPet(p6);
			cardPets.addPet(p7);
			cardPets.addPet(p1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		cardPets.printSortedListPets();
		
		try {
		cardPets.changePetById(1, a -> a.owner = person1);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("----------------------------------------------------------------------");
		
		
		cardPets.printSortedListPets();
	}
}
