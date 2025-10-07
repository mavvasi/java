package zad1pr2;

public class TestAuthor {
    public static void main(String[] args) {
        // Создание объекта Author
        Author author = new Author("Mr M.", "maria@yandex.ru", 'W');

        // Тестирование методов
        System.out.println("Информация об авторе:");
        System.out.println(author.toString());

        System.out.println("\nТестирование геттеров:");
        System.out.println("Имя: " + author.getName());
        System.out.println("Email: " + author.getEmail());
        System.out.println("Пол: " + author.getGender());

    }
}