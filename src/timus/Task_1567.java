package timus;

import java.util.Scanner;

public class Task_1567 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int[] keyboardCost = new int[26];
        for (int i = 0; i < 26; i++) {
            keyboardCost[i] = (i % 3) + 1;
        }

        int cost = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                cost += keyboardCost[Character.toLowerCase(c) - 'a'];
            } else if (c == ' ') {
                cost += 1;
            } else if (c == '.') {
                cost += 1;
            } else if (c == ',') {
                cost += 2;
            } else if (c == '!') {
                cost += 3;
            }
        }

        System.out.println(cost);
    }
}
