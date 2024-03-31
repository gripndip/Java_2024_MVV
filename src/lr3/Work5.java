package lr3;

import java.util.HashMap;

public class Work5 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        // Заполнение HashMap
        for (int i = 0; i < 10; i++) {
            map.put(i, "Строка " + i);
        }

        System.out.println("Строки с ключами больше 5:");
        map.entrySet().stream()
                .filter(entry -> entry.getKey() > 5)
                .forEach(entry -> System.out.println(entry.getValue()));

        System.out.println("Строки с ключом 0:");
        System.out.println(map.get(0));

        int product = map.entrySet().stream()
                .filter(entry -> entry.getValue().length() > 5)
                .mapToInt(HashMap.Entry::getKey)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Произведение ключей, где длина строки больше 5: " + product);
    }
}
