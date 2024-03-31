package lr3;

import java.util.Scanner;

public class Work3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] array = new int[size];
        fillArray(array, 0, scanner);
        printArray(array, 0);
    }

    public static void fillArray(int[] array, int index, Scanner scanner) {
        if (index < array.length) {
            System.out.println("Введите элемент массива под индексом " + index + ":");
            array[index] = scanner.nextInt();
            fillArray(array, index + 1, scanner);
        }
    }

    public static void printArray(int[] array, int index) {
        if (index < array.length) {
            System.out.println("Элемент массива под индексом " + index + ": " + array[index]);
            printArray(array, index + 1);
        }
    }
}

