package timus;

import java.util.Scanner;

public class Task_1313 {

    private static int size;
    private static int[][] matrix;
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < size; i++) {
            getDiag(i, 0, false);
        }

        for (int i = 1; i < size; i++) {
            getDiag(size - 1, i, true);
        }

        System.out.print(output.toString().trim());
    }

    private static void getDiag(int row, int col, boolean bottom) {
        if (!bottom) {
            while (row >= 0 && col < size) {
                output.append(matrix[row][col]).append(" ");
                row--;
                col++;
            }
        } else {
            while (row >= 0 && col < size) {
                output.append(matrix[row][col]).append(" ");
                row--;
                col++;
            }
        }
    }
}
