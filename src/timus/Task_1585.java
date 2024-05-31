package timus;

import java.util.Scanner;
import java.util.*;

public class Task_1585 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, Integer> penguins = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.nextLine();
            penguins.put(type, penguins.getOrDefault(type, 0) + 1);
        }
        String maxType = "";
        int maxCount = 0;
        for (String type : penguins.keySet()) {
            int count = penguins.get(type);
            if (count > maxCount) {
                maxType = type;
                maxCount = count;
            }
        }
        System.out.println(maxType);
    }
}
