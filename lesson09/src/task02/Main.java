package task02;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
        System.out.println("Пожалуйста, введите свое ден рождения в виде ДД-ММ-ГГГГ");
        String input = scanner.nextLine();
        try {
            dateOfBirth = LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            System.out.println("Вы неправильно ввели дату");
            System.exit(0);
        }
        switch (dateOfBirth.getDayOfWeek()) {
            case MONDAY, THURSDAY, WEDNESDAY, TUESDAY, FRIDAY -> System.out.println("Вы родились в будний день");
            case SATURDAY, SUNDAY -> System.out.println("Вы родились в выходной день");
        }
    }
}
