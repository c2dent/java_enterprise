package task01;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Vlad", 26, null);

        System.out.println(person.cat().getName());
    }
}
