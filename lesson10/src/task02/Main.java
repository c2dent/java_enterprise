package task02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<MyClassLoader> classList = new ArrayList<>();
    public static void main(String[] args) {

        Main main = new Main();
        while (true){
            main.GenerateArray();
        }
    }

    public void GenerateArray(){
        MyClassLoader loader = new MyClassLoader();
        classList.add(loader);
        System.out.println("Класс загружен");
        try {
            loader.findClass("task02.SomeClass");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
