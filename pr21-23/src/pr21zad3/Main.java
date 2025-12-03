package pr21zad3;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Анна", "Борис", "Владимир", "Дарья"};

        String name = ArrayElementGetter.getElement(names, 2);
        System.out.println("Элемент с индексом 2: " + name);

    }
}