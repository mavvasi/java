package pr17zad2;

public class View {

    public void showEmployee(String name, double salary, double total) {
        System.out.println("Информация о сотруднике");
        System.out.println("ФИО: " + name);
        System.out.println("Оклад: " + salary + " руб.");
        System.out.println("Итого: " + total + " руб.");
    }

    public void showMessage(String message) {
        System.out.println(">> " + message);
    }

    public void showError(String error) {
        System.out.println("Ошибка: " + error);
    }
}