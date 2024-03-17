package lr2;

import java.util.Scanner;

public class Work3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();
        System.out.println("Введите ключ:");
        int key = scanner.nextInt();

        String encryptedText = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = scanner.next();
        scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Текст после обратного преобразования: " + decryptedText);
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("До свидания!");
        } else {
            System.out.println("Введите корректный ответ.");
        }

        scanner.close();
    }
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    result.append((char) ('A' + (ch - 'A' + key) % 26));
                } else {
                    result.append((char) ('a' + (ch - 'a' + key) % 26));
                }
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }
}
