package lr8.Example_3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class JSONBookParser {
    private static final String FILE_PATH = "src/lr8/Example_3/books.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Добавить новую книгу");
        System.out.println("2. Искать книги по автору");
        System.out.println("3. Удалить книгу по названию");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Потребление символа новой строки

        try {
            switch (choice) {
                case 1:
                    System.out.print("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите год: ");
                    int year = scanner.nextInt();
                    addBook(title, author, year);
                    break;
                case 2:
                    System.out.print("Введите автора для поиска: ");
                    String searchAuthor = scanner.nextLine();
                    searchBooksByAuthor(searchAuthor);
                    break;
                case 3:
                    System.out.print("Введите название книги для удаления: ");
                    String deleteTitle = scanner.nextLine();
                    deleteBookByTitle(deleteTitle);
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        } catch (IOException | ParseException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addBook(String title, String author, int year) throws IOException, ParseException {
        JSONObject newBook = new JSONObject();
        newBook.put("title", title);
        newBook.put("author", author);
        newBook.put("year", year);

        JSONArray books = getBooksArray();
        books.add(newBook);
        saveBooksArray(books);

        System.out.println("Книга добавлена успешно");
    }

    private static void searchBooksByAuthor(String author) throws IOException, ParseException {
        JSONArray books = getBooksArray();
        boolean found = false;

        for (Object obj : books) {
            JSONObject book = (JSONObject) obj;
            if (author.equalsIgnoreCase((String) book.get("author"))) {
                System.out.println("Название: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год: " + book.get("year"));
                System.out.println("----------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Книги данного автора не найдены");
        }
    }

    private static void deleteBookByTitle(String title) throws IOException, ParseException {
        JSONArray books = getBooksArray();
        Iterator<Object> iterator = books.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            JSONObject book = (JSONObject) iterator.next();
            if (title.equalsIgnoreCase((String) book.get("title"))) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            saveBooksArray(books);
            System.out.println("Книга успешно удалена");
        } else {
            System.out.println("Книга с данным названием не найдена");
        }
    }

    private static JSONArray getBooksArray() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(FILE_PATH);
        Object obj = parser.parse(reader);
        reader.close();
        return (JSONArray) obj;
    }

    private static void saveBooksArray(JSONArray books) throws IOException {
        FileWriter file = new FileWriter(FILE_PATH);
        file.write(books.toJSONString());
        file.flush();
        file.close();
    }
}
