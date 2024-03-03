package lr1;

import java.util.Scanner;

public class Work3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название текущего дня недели:");
        String dayOfWeek = scanner.nextLine();

        System.out.println("Введите название текущего месяца:");
        String month = scanner.nextLine();

        System.out.println("Введите номер текущего дня в месяце:");
        int dayOfMonth = scanner.nextInt();

        System.out.println("Сегодня " + dayOfWeek + ", " + dayOfMonth + " " + month + ".");
    }
}
