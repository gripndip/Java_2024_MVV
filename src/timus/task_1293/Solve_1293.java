package timus.task_1293;

import java.util.Scanner;

public class Solve_1293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        long totalWeight = (long) N * A * B * 2;

        System.out.println(totalWeight);
    }
}
