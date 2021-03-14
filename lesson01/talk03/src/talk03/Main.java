package talk03;

public class Main {
	
	public static String[] listNameForPersonMan = new String[] {"Liam", "Noah", "Oliver", "William", "Elijah", "James", "Jack", "Aiden",
			"Benjamin", "Lucas", "Mason", "Ethan", "Alexander", "Henry", "Jacob", "Michael", "Daniel", "Logan", "Jackson", "Sebastian"};
	public static String[] listNameForPersonWoman = new String[] {"Olivia", "Emma", "Ava", "Sophia", "Isabella", "Charlotte", "Amelia", 
			"Mia", "Harper", "Evelyn", "Abigail", "Emily", "Ella", "Elizabeth", "Camila", "Luna", "Sofia", "Avery", "Mila", "Aria"};
	
	private static Person[] generatePersons(int n) {
		Person[] persons = new Person[n];
		for (int i = 0; i < persons.length; i++) {
			String name;
			int age;
			
			int random_sex = (int)(Math.random() * (2));
			
			if (random_sex == 0) {
				name = listNameForPersonWoman[(int)(Math.random() * 20)] + i;
				age = (int)(Math.random() * 101);
				persons[i] = new Person(name, age, Sex.WOMEN);
			} else {
				name = listNameForPersonMan[(int)(Math.random() * 20)] + i;
				age = (int)(Math.random() * 101);
				persons[i] = new Person(name, age, Sex.MAN);
			}
		}
		return persons;
	}
	
	
	public static void main(String[] agrs) {
		
		Person[] persons1 = generatePersons(1000);
		Person[] persons2 = generatePersons(1000);
		
		SortingPerson01 sp1 = new SortingPerson01();
		SortingPerson02 sp2 = new SortingPerson02();
		

		long timeBefore = System.currentTimeMillis();
		
		
		try {
			sp1.sortPerson(persons1);
		} catch (CoincidenceNameAgeException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		
		long deltaTimeFirstAlgoritm = System.currentTimeMillis() - timeBefore;
		
		timeBefore = System.currentTimeMillis();
		try {
			sp2.sortPerson(persons2);
		} catch (CoincidenceNameAgeException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		long deltaTimeSecondAlgoritm = System.currentTimeMillis() - timeBefore;
		
		for (int i = 0; i < persons1.length; i++) {
			System.out.println(persons1[i].name + "------" + persons1[i].age + "------" + persons1[i].sex + "        |        " + persons1[i].name + "------" + persons1[i].age + "------" + persons1[i].sex);
		}
		
		System.out.println("\n\nВремя выполнения 1-го алгоритма " + deltaTimeFirstAlgoritm + " мс" + " | Время выполнения 2-го алгоритма " + deltaTimeSecondAlgoritm + " мс");
		
	}
}
