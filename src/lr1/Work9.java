package lr1;

import java.util.Scanner;

public class Work9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        int num = scanner.nextInt();

        int prevNum = num - 1;
        int nextNum = num + 1;

        int sum = prevNum + num + nextNum;

        int lastNum = sum * sum;

        System.out.println("Последовательность чисел: " + prevNum + ", " + num + ", " + nextNum + ", " + lastNum);
    }
}
