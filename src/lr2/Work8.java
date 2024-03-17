package lr2;

class Animal {
    private String name;
    private int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Животное издает звук.");
    }
}
class Dog extends Animal {
    private String breed;
    private String foodType;

    public Dog(String name, int age, String breed, String foodType) {
        super(name, age);
        this.breed = breed;
        this.foodType = foodType;
    }
    public void makeSound() {
        System.out.println("Собака лает.");
    }
    public void fetch() {
        System.out.println("Собака приносит игрушки.");
    }
}
class Cat extends Animal {
    private String breed;
    private String foodType;

    public Cat(String name, int age, String breed, String foodType) {
        super(name, age);
        this.breed = breed;
        this.foodType = foodType;
    }
    public void makeSound() {
        System.out.println("Кот мяукает.");
    }
    public void scratch() {
        System.out.println("Кот держит коготь.");
    }
}
class Bird extends Animal {
    private String breed;
    private boolean canFly;

    public Bird(String name, int age, String breed, boolean canFly) {
        super(name, age);
        this.breed = breed;
        this.canFly = canFly;
    }

    public void makeSound() {
        System.out.println("Птица чирикает.");
    }

    public void fly() {
        if (canFly) {
            System.out.println("Птица летит.");
        } else {
            System.out.println("Птица не умеет летать.");
        }
    }
}
public class Work8 {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 5, "Дворняга", "Сухой корм");
        dog.makeSound();
        dog.fetch();

        Cat cat = new Cat("Мурка", 3, "Шотландская", "Корм для кошек");
        cat.makeSound();
        cat.scratch();

        Bird bird = new Bird("Кеша", 2, "Синичка", true);
        bird.makeSound();
        bird.fly();
    }
}