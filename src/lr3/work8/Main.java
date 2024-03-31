package lr3.work8;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.createHead(3);
        list.createHead(2);
        list.createHead(1);

        System.out.println("Список: " + list.toString());

        list.addLast(4);

        System.out.println("Список после добавления элемента в конец: " + list.toString());

        list.insert(5, 2);

        System.out.println("Список после добавления элемента в индекс 2: " + list.toString());

        list.removeFirst();

        System.out.println("Список после удаления первого элемента: " + list.toString());

        list.removeLast();

        System.out.println("Список после удаления последнего элемента: " + list.toString());

        list.remove(1);

        System.out.println("Список после удаления элемента с индексом 1: " + list.toString());


        list.createHeadRec(5);

        System.out.println("Список после добавления элемента через рекурсию с головы: " + list.toStringRec());

        list.createTailRec(6);

        System.out.println("Список после добавления элемента через рекурсию с хвоста: " + list.toStringRec());
    }
}