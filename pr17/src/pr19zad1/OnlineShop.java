package pr19zad1;

import java.util.Scanner;
public class OnlineShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = new OrderService();

        System.out.println("=== ОНЛАЙН МАГАЗИН ===");

        try {
            // Запрашиваем данные у пользователя
            System.out.print("Введите ФИО: ");
            String fullName = scanner.nextLine();

            System.out.print("Введите ИНН: ");
            String inn = scanner.nextLine();

            // Создаем клиента
            Client client = new Client(fullName, inn);

            // Обрабатываем заказ
            orderService.processOrder(client);

        } catch (InvalidInn e) {
            System.out.println("Ошибка при оформлении заказа: " + e.getMessage());
            System.out.println("Пожалуйста, проверьте правильность введенного ИНН.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Спасибо за обращение!");
        }
    }
}