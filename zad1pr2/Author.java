package zad1pr2;

public class Author {
    private String name;
    private String email;
    private char gender;

    // Конструктор
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Геттер для email
    public String getEmail() {
        return email;
    }

    // Сеттер для email
    public void setEmail(String email) {
        this.email = email;
    }

    // Геттер для пола
    public char getGender() {
        return gender;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}