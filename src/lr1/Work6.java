package lr1;

import java.util.Scanner;
import java.time.LocalDate;

public class Work6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();

        System.out.println("Введите ваш год рождения:");
        int birthYear = scanner.nextInt();

        int currentYear = LocalDate.now().getYear();

        int age = currentYear - birthYear;

        System.out.println("Вас зовут " + name + " и вам " + age + " лет.");
    }
}