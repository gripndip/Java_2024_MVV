package timus;

import java.util.Scanner;

public class Task_1639 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCardsM = scanner.nextInt();
        int numberOfCardsN = scanner.nextInt();

        boolean firstPlayerWins = (numberOfCardsM * numberOfCardsN) % 2 == 0;

        System.out.println(firstPlayerWins ? "[:=[first]" : "[second]=:]");
    }
}