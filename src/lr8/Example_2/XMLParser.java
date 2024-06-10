package lr8.Example_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class XMLParser {
    private static final String FILE_PATH = "src/lr8/Example_2/birthdays.xml";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Добавить новую запись о дне рождения");
            System.out.println("2. Искать записи по имени или дате");
            System.out.println("3. Удалить запись по имени");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите дату (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    addBirthday(name, date);
                    break;
                case 2:
                    System.out.print("Введите имя или дату для поиска: ");
                    String term = scanner.nextLine();
                    searchBirthdays(term);
                    break;
                case 3:
                    System.out.print("Введите имя для удаления: ");
                    String nameToDelete = scanner.nextLine();
                    deleteBirthday(nameToDelete);
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBirthday(String name, String date) throws Exception {
        Document doc = getDocument();
        Element root = doc.getDocumentElement();

        Element birthday = doc.createElement("birthday");

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(name));
        birthday.appendChild(nameElement);

        Element dateElement = doc.createElement("date");
        dateElement.appendChild(doc.createTextNode(date));
        birthday.appendChild(dateElement);

        root.appendChild(birthday);
        saveDocument(doc);
    }

    private static void searchBirthdays(String term) throws Exception {
        Document doc = getDocument();
        NodeList nodeList = doc.getElementsByTagName("birthday");

        List<Element> birthdays = nodeListToList(nodeList).stream()
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node)
                .filter(element -> {
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String date = element.getElementsByTagName("date").item(0).getTextContent();
                    return name.equalsIgnoreCase(term) || date.equals(term);
                })
                .collect(Collectors.toList());

        for (Element birthday : birthdays) {
            System.out.println("Имя: " + birthday.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Дата: " + birthday.getElementsByTagName("date").item(0).getTextContent());
            System.out.println("----------------------------");
        }
    }

    private static void deleteBirthday(String name) throws Exception {
        Document doc = getDocument();
        NodeList nodeList = doc.getElementsByTagName("birthday");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element birthday = (Element) nodeList.item(i);
            String birthdayName = birthday.getElementsByTagName("name").item(0).getTextContent();
            if (birthdayName.equals(name)) {
                birthday.getParentNode().removeChild(birthday);
                break;
            }
        }
        saveDocument(doc);
    }

    private static Document getDocument() throws Exception {
        File file = new File(FILE_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        if (file.exists()) {
            return builder.parse(file);
        } else {
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("birthdays");
            doc.appendChild(rootElement);
            return doc;
        }
    }

    private static void saveDocument(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static List<Node> nodeListToList(NodeList nodeList) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            nodes.add(nodeList.item(i));
        }
        return nodes;
    }
}

