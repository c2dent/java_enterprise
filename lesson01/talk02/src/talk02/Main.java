package talk02;


public class Main {
	
	public static int calcSqrt(int num) throws ArithmeticException{
		if (num < 0) {
			throw new ArithmeticException();
		}
		
		return (int)Math.sqrt(num);
	}
	
	
	public static void main(String[] args) {
		final int N = 10;
		int k;
		int q;
		for (int i = 0; i < N; i++) {
			k = (int)(Math.random() * 99 - 49);
			System.out.println(k);
			try {
				q = calcSqrt(k);
				if (Math.pow(q, 2) == k) {
					System.out.println(k + " ---- " + q);
				}
			} catch (ArithmeticException e) {
				continue;
			}
		}
	}
}
