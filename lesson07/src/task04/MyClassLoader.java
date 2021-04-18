package task04;

import java.io.*;

public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String path) throws ClassNotFoundException {
        File f = new File(path);
        if(!f.isFile()) {
            throw new ClassNotFoundException("Нет такого файла");
        }

        try(InputStream ins = new BufferedInputStream(new FileInputStream(f))) {
            byte[] b = new byte[(int)f.length()];
            ins.read(b);
            Class c = defineClass("task04.SomeClass", b, 0, b.length);
            return c;
        } catch (Exception e) {
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }
    }
}
