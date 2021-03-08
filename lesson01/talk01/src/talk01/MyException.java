package talk01;
import java.lang.Exception;

public class MyException extends Exception {
	MyException() {
		super("Мое исключения");
	}
}
