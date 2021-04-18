package task02;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class SortProxy implements InvocationHandler {
    private Sorts sorts;

    public SortProxy(Sorts sorts) { this.sorts = sorts; }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long n = System.currentTimeMillis();
        Object o = method.invoke(sorts, args);
        try (FileOutputStream fos = new FileOutputStream("/home/c2dent/practic/java/lesson07/src/task02/deltaFile.txt")) {
            fos.write(("Время выполнения программы " + method.getName() + ": " + (System.currentTimeMillis() - n)).getBytes(StandardCharsets.UTF_8));
        }
        return o;
    }
}
