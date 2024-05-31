package timus;

import java.util.*;

public class Task_2002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, String> users = new HashMap<>();
        Map<String, Boolean> loggedInUsers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String username = input[1];

            if (command.equals("register")) {
                String password = input[2];
                if (users.containsKey(username)) {
                    System.out.println("fail: user already exists");
                } else {
                    users.put(username, password);
                    System.out.println("success: new user added");
                }
            } else if (command.equals("login")) {
                String password = input[2];
                if (!users.containsKey(username)) {
                    System.out.println("fail: no such user");
                } else if (!users.get(username).equals(password)) {
                    System.out.println("fail: incorrect password");
                } else if (loggedInUsers.getOrDefault(username, false)) {
                    System.out.println("fail: already logged in");
                } else {
                    loggedInUsers.put(username, true);
                    System.out.println("success: user logged in");
                }
            } else if (command.equals("logout")) {
                if (!users.containsKey(username)) {
                    System.out.println("fail: no such user");
                } else if (!loggedInUsers.getOrDefault(username, false)) {
                    System.out.println("fail: already logged out");
                } else {
                    loggedInUsers.put(username, false);
                    System.out.println("success: user logged out");
                }
            }
        }
        scanner.close();
    }
}