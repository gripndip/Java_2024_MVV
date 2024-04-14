package lr4;

import java.util.Scanner;

public class Work1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число: ");
                scanner.next();
            }
            numbers[i] = scanner.nextInt();
        }

        int positiveCount = 0;
        int positiveSum = 0;
        for (int number : numbers) {
            if (number > 0) {
                positiveCount++;
                positiveSum += number;
            }
        }

        if (positiveCount == 0) {
            System.out.println("В массиве нет положительных элементов.");
        } else {
            double average = (double) positiveSum / positiveCount;
            System.out.println("Среднее значение положительных элементов: " + average);
        }
    }
}
