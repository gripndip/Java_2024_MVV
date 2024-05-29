package lr7;

import java.io.*;
import java.util.Scanner;

class SerializablePerson implements Serializable {
    private String name;
    private int age;

    public SerializablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Work8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя персонажа:");
        String name = scanner.nextLine();

        System.out.println("Введите возраст персонажа:");
        int age = scanner.nextInt();

        SerializablePerson person = new SerializablePerson(name, age);
        File file = new File("person.ser");

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(person);
            System.out.println("Персонаж сериализован.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            SerializablePerson deserializedPerson = (SerializablePerson) ois.readObject();
            System.out.println("Сериализованный персонаж: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

