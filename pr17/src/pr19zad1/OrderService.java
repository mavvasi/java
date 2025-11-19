package pr19zad1;

public class OrderService {

    public void processOrder(Client client) throws InvalidInn {
        System.out.println("Обработка заказа для: " + client.getFullName());

        // Проверяем ИНН
        Inn.validateInn(client.getInn());

        // Если ИНН валиден, продолжаем обработку заказа
        System.out.println("ИНН проверен успешно. Заказ обрабатывается...");
        System.out.println("Заказ для " + client.getFullName() + " оформлен!");
    }
}