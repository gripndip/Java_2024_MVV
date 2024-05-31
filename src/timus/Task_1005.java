package timus;

import java.util.Scanner;

public class Task_1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWeights = scanner.nextInt();
        int[] weights = new int[numberOfWeights];

        for (int i = 0; i < numberOfWeights; i++) {
            weights[i] = scanner.nextInt();
        }

        int minDifference = Integer.MAX_VALUE;
        for (int combination = 0; combination < 1 << numberOfWeights; combination++) {
            int heap1Weight = 0;
            int heap2Weight = 0;
            int tempCombination = combination;

            for (int i = 0; i < numberOfWeights; i++) {
                if ((tempCombination & 1) > 0) {
                    heap1Weight += weights[i];
                } else {
                    heap2Weight += weights[i];
                }
                tempCombination >>= 1;
            }

            minDifference = Math.min(minDifference, Math.abs(heap1Weight - heap2Weight));
        }

        System.out.println(minDifference);
    }
}
