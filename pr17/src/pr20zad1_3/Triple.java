package pr20zad1_3;

import java.io.Serializable;

public class Triple<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T first;
    private V second;
    private K third;
// T - реализует Comparable, V - реализует Serializable и расширяет Animal, K - любой тип

    // Конструктор
    public Triple(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // Геттеры
    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }

    // Сеттеры
    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public void setThird(K third) {
        this.third = third;
    }

    // Метод для вывода имен классов переменных
    public void printClassNames() {
        System.out.println("Тип T: " + first.getClass().getSimpleName());
        System.out.println("Тип V: " + second.getClass().getSimpleName());
        System.out.println("Тип K: " + third.getClass().getSimpleName());
    }

    // Доп метод
    public void compareWith(T other) {
        int result = first.compareTo(other);
        if (result < 0) {
            System.out.println(first + " меньше чем " + other);
        } else if (result > 0) {
            System.out.println(first + " больше чем " + other);
        } else {
            System.out.println(first + " равно " + other);
        }
    }

    // Метод для Animal
    public void printAnimalInfo() {
        System.out.println("Информация о животном: " + second);
        System.out.println("Имя: " + second.getName());
        System.out.println("Возраст: " + second.getAge() + " лет");
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}