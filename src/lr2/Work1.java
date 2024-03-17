package lr2;

import java.util.Random;

public class Work1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        // Заполняем массив случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println("Массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        // Находим минимальное значение в массиве
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        // Выводим индексы элементов с минимальным значением
        System.out.println("Индексы элементов с минимальным значением (" + minValue + "):");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == minValue) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
