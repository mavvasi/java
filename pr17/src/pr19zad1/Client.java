package pr19zad1;

public class Client {
    private String fullName;
    private String inn;

    public Client(String fullName, String inn) {
        this.fullName = fullName;
        this.inn = inn;
    }

    // Геттеры
    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    // Сеттеры
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}