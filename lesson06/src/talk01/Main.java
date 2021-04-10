package talk01;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class FactorialCalc extends Thread{
	int num;
	BigInteger bi;
	
	FactorialCalc(int num) {
		this.num = num;
	}
	
	public void run() {
		bi = BigInteger.valueOf(1);
		for(int i = 1; i < num; i++) {
			bi = bi.multiply(BigInteger.valueOf(i));
		}
	}
}

public class Main {
	private static int generateNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Integer[] arrInt = new Integer[600];
			
		for (int i = 0; i < 600; i++) {
			arrInt[i] = generateNumber(100, 150);
		}
		
		

		
		long beforeNotThread = System.currentTimeMillis();
		
		for (int i = 0; i < arrInt.length; i++) {
			BigInteger bi = BigInteger.valueOf(1);
				for (int j = 1; j < (arrInt[i] + 1); j++) {
					bi = bi.multiply(BigInteger.valueOf(j));
				}
		}
		
		long delteTime = System.currentTimeMillis() - beforeNotThread;
		

		
		
		
		ExecutorService exe = Executors.newFixedThreadPool(3);
		long before = System.currentTimeMillis();
		
		for(int i = 0; i < arrInt.length; i++) {
			exe.execute(new FactorialCalc(arrInt[i]));
		}
	
		exe.shutdown();
		while (!exe.awaitTermination(24L, TimeUnit.HOURS)) {
		    System.out.println("Все еще не закончился");
		}
		
		System.out.println("Время выполнения вычестлении с потоком: " + (System.currentTimeMillis() - before));
		System.out.println("Время выполнения вычестлении без потоком: " + delteTime);
	 
	}
 }