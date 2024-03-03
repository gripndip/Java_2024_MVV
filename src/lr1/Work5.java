package lr1;

import java.time.LocalDate;
import java.util.Scanner;

public class Work5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш год рождения:");
        int birthYear = scanner.nextInt();

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        int age = currentYear - birthYear;

        System.out.println("Ваш возраст: " + age);
    }
}
