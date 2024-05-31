package timus;

import java.io.PrintWriter;
import java.util.Scanner;

public class Task_1197 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int test = in.nextInt();
        for (int q = 0; q < test; q++) {
            String position = in.next();
            int x = position.charAt(0) - 'a' + 1;
            int y = position.charAt(1) - '0';

            int bingo = 0;
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (i != 0 && j != 0 && i != j && Math.abs(i) != Math.abs(j)) {
                        int newX = x + i;
                        int newY = y + j;
                        if (newX > 0 && newX <= 8 && newY > 0 && newY <= 8) {
                            bingo++;
                        }
                    }
                }
            }
            out.println(bingo);
        }
        out.flush();
    }
}
