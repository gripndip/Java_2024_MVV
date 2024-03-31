package lr3.work9;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        System.out.println("Время выполнения операции добавления arrayList = " + getRunningTime(arrayList));
        System.out.println("Время выполнения операции добавления linkedHashSet = " + getRunningTime(linkedHashSet));
        System.out.println("Время выполнения операции добавления linkedHashMap = " + getRunningTime(linkedHashMap));

    }

    private static long getRunningTime(Collection<Integer> collection){

        // точка начала отсчета времени выполнения программы
        long start = System.currentTimeMillis();

        // блок кода в котором выполняется операция добавления
        for (int i = 0; i < 1000000; i++) {
            collection.add(i);
        }

        // точка окончания отсчета времени выполнения программы
        long end = System.currentTimeMillis();

        // вывод в консоль времени выполнения блока кода содержащего операцию
        return end - start;

    }

    private static long getRunningTime(Map<Integer, Integer> map){

        // точка начала отсчета времени выполнения программы
        long start = System.currentTimeMillis();

        // блок кода в котором выполняется операция добавления
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }

        // точка окончания отсчета времени выполнения программы
        long end = System.currentTimeMillis();

        // вывод в консоль времени выполнения блока кода содержащего операцию
        return end - start;

    }
}
