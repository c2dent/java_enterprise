package talk01;

public class Main {
	
	public static void method() throws NullPointerException, ArrayIndexOutOfBoundsException, MyException {
		throw  new MyException();
	}
	
	public static void main(String[] args) throws MyException {
		System.out.println("Hello World!!!");
		
		try {
			method();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.print("Конец программый");
		}
	}
}
