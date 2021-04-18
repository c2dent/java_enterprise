package task04;

import javax.tools.Tool;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> bodyMethod = new ArrayList<>();
        Path pathJava = Paths.get("/home/c2dent/practic/java/lesson07/src/task04/SomeClass.java");
        String line = "";

        try (Scanner scan = new Scanner(System.in)){
            while (!(line = scan.nextLine()).equals("")) {
                bodyMethod.add(line);
            }
        }

        List<String> lines = Files.readAllLines(pathJava);

        for (int i = 0; i < bodyMethod.size(); i++) {
            lines.add(i+5, bodyMethod.get(i));
        }
        Files.write(pathJava, lines);

        Tool compiler = ToolProvider.getSystemJavaCompiler();

        compiler.run(null, null, null, pathJava.toString());

        MyClassLoader loader = new MyClassLoader();
        Class cl = loader.findClass("/home/c2dent/practic/java/lesson07/src/task04/SomeClass.class");

        Method method = cl.getMethod("doWorker", new Class[] {});
        method.invoke(cl.newInstance(), new Object[]{});
    }
}
