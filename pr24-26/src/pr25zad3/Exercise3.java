package pr25zad3;

// Тестирование отдельного итератора
public class Exercise3 {
    public static void main(String[] args) {
        SimpleList<Integer> simpleList = new SimpleList<>();

        // Добавляем элементы
        for (int i = 1; i <= 10; i++) {
            simpleList.add(i * 10);
        }

        System.out.println("Элементы списка через итератор:");
        SimpleList.SimpleListIterator<Integer> iterator = simpleList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("\nПрямой доступ к элементам:");
        for (int i = 0; i < simpleList.size(); i++) {
            System.out.print(simpleList.get(i) + " ");
        }
        System.out.println();

        // Фильтрация через итератор
        System.out.println("\nТолько четные элементы:");
        iterator = simpleList.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value % 20 == 0) {
                System.out.print(value + " ");
            }
        }
    }
}
