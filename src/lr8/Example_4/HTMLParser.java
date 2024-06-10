package lr8.Example_4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HTMLParser {
    private static final String FILE_PATH = "src/lr8/Example_4/links.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите URL: ");
        String url = scanner.nextLine();

        try {
            Document doc = Jsoup.connect(url).get();
            saveLinksToFile(doc);
        } catch (IOException e) {
            System.out.println("Ошибка при получении URL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void saveLinksToFile(Document doc) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                writer.write("Ссылка: " + link.attr("href") + "\n");
                writer.write("Текст: " + link.text() + "\n");
                writer.write("----------------------------\n");
            }
            System.out.println("Ссылки сохранены в " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}

