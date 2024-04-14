package lr4;

import java.util.Scanner;

public class Work3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        byte[] numbers = new byte[size];

        System.out.println("Введите элементы массива (byte): ");
        for (int i = 0; i < size; i++) {
            while (!scanner.hasNextByte()) {
                System.out.println("Ошибка! Введите число типа byte: ");
                scanner.next();
            }
            numbers[i] = scanner.nextByte();
        }

        long sum = 0;
        try {
            for (byte number : numbers) {
                sum += number;
            }
        } catch (ArithmeticException e) {
            System.out.println("Ошибка! Сумма выходит за пределы допустимого значения.");
        }

        System.out.println("Сумма элементов массива: " + sum);
    }
}
