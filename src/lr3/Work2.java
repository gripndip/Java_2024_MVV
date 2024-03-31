package lr3;

import java.util.Scanner;

public class Work2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int number = scanner.nextInt();
        System.out.println("Двоичное представление: " + convertToBinary(number));
    }

    public static String convertToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        if (n == 1) {
            return "1";
        }
        return convertToBinary(n / 2) + n % 2;
    }
}

