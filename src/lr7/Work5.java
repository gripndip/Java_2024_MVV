package lr7;

import java.io.File;
import java.util.Scanner;

public class Work5 {
    public static void main(String[] args) {
        String myPath = "src/lr7";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название файла с расширением: ");
        String fileName = in.nextLine();
        String finalFileName = myPath + File.separator + fileName;
        File file = new File(finalFileName);
        if (file.exists()) {
            long fileSize = file.length();
            System.out.println("Размер файла " + fileName + " составляет " + fileSize + " байт.");
        } else {
            System.out.println("Файл не найден.");
        }
    }
}
