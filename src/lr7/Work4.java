package lr7;

import java.io.*;
import java.util.Scanner;

public class Work4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter source file name:");
        String sourceFile = scanner.nextLine();

        System.out.println("Enter destination file name:");
        String destFile = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

