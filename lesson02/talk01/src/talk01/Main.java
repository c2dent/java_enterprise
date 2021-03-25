package talk01;

public class Main {
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1,2,3, 3};
		MathBox<Integer> math = new MathBox<>(arr);
		System.out.println(math.summator());
		if(math.remove(0)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		System.out.println(math);
	}
}
