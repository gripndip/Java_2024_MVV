package lr4;

import java.util.Scanner;

public class Work2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк матрицы: ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов матрицы: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Ошибка! Введите целое число: ");
                    scanner.next();
                }
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Введите номер столбца: ");
        int columnNumber = scanner.nextInt();

        if (columnNumber < 0 || columnNumber >= cols) {
            System.out.println("Ошибка! Нет столбца с таким номером.");
        } else {
            System.out.println("Столбец " + columnNumber + ":");
            for (int[] row : matrix) {
                System.out.print(row[columnNumber] + " ");
            }
        }
    }
}
