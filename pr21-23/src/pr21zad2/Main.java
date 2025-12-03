package pr21zad2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Пример 1: GenericArrayHolder (для объектов) ===");
        GenericArrayHolder<String> stringHolder = new GenericArrayHolder<>(String.class, 3);
        stringHolder.set(0, "Hello");
        stringHolder.set(1, "World");
        stringHolder.set(2, "Java");
        System.out.println(stringHolder);

        GenericArrayHolder<Integer> intHolder = new GenericArrayHolder<>(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("Integer array: " + intHolder);

    }
}