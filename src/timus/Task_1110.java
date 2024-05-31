package timus;

import java.util.Scanner;

public class Task_1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int y = scanner.nextInt();

        boolean found = false;
        for (int x = 0; x < m; x++) {
            if (power(x, n, m) == y) {
                System.out.print(x + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    private static int power(int x, int n, int m) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = (result * x) % m;
        }
        return result;
    }
}
