package lr1;

import java.util.Scanner;
import java.time.LocalDate;

public class Work7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш возраст:");
        int age = scanner.nextInt();

        int currentYear = LocalDate.now().getYear();

        int birthYear = currentYear - age;

        System.out.println("Вы родились в " + birthYear + " году.");
    }
}
