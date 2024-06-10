package lr8.Example_5;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ExcelParser {
    private static final String FILE_PATH = "src/lr8/Example_5/books.xlsx";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Добавить новую книгу");
        System.out.println("2. Искать книги по автору");
        System.out.println("3. Удалить книгу по названию");
        int choice = scanner.nextInt();
        scanner.nextLine();

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
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addBook(String title, String author, int year) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = WorkbookFactory.create(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();

            XSSFRow newRow = sheet.createRow(lastRowNum + 1);
            newRow.createCell(0).setCellValue(title);
            newRow.createCell(1).setCellValue(author);
            newRow.createCell(2).setCellValue(year);

            workbook.write(fileOutputStream);
            System.out.println("Книга добавлена успешно");
        }
    }

    private static void searchBooksByAuthor(String author) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = WorkbookFactory.create(fileInputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            boolean found = false;

            for (XSSFRow row : sheet) {
                XSSFCell authorCell = row.getCell(1);
                if (authorCell != null && author.equalsIgnoreCase(authorCell.getStringCellValue())) {
                    System.out.println("Название: " + row.getCell(0).getStringCellValue());
                    System.out.println("Автор: " + authorCell.getStringCellValue());
                    System.out.println("Год: " + row.getCell(2).getNumericCellValue());
                    System.out.println("----------------------------");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Книги данного автора не найдены");
            }
        }
    }

    private static void deleteBookByTitle(String title) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = WorkbookFactory.create(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            boolean found = false;

            Iterator<org.apache.poi.ss.usermodel.XSSFRow> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                XSSFRow row = rowIterator.next();
                XSSFCell titleCell = row.getCell(0);
                if (titleCell != null && title.equalsIgnoreCase(titleCell.getStringCellValue())) {
                    sheet.removeRow(row); //