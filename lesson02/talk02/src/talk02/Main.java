package talk02;

public class Main {
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1,2,3, 3};
		MathBox<Integer> mathbox = new MathBox<>(arr);
		ObjectBox<String> objbox = new ObjectBox<>();
		System.out.println("Сумма коллекции = " + mathbox.summator());
		
		if(mathbox.deleteObject(2)) {
			System.out.println("Объект удален");
		} else {
			System.out.println("Объект не найден");
		}
		
		mathbox.addObject(6);
		objbox.addObject("A");
		objbox.deleteObject("B");
		
		System.out.println(mathbox);
		System.out.println(objbox);
	}
}
