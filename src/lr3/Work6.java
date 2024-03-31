package lr3;

import java.util.*;

public class Work6 {
    public static void main(String[] args) {
        int N = 10; // количество людей в кругу
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("ArrayList: " + josephus(arrayList, 2));
        System.out.println("LinkedList: " + josephus(linkedList, 2));
    }

    public static <T> T josephus(List<T> items, int step) {
        if (items.isEmpty()) return null;

        int i = 0;
        while (items.size() > 1) {
            i = (i + step - 1) % items.size();
            items.remove(i);
        }
        return items.get(0);
    }
}

