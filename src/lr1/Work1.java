package lr1;

import java.util.Scanner;

public class Work1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();

        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите отчество:");
        String patronymic = scanner.nextLine();

        System.out.println("Hello " + surname + " " + name + " " + patronymic);
    }
}
