package zad2pr6;

public class Magazine implements Printable {
    private String title;
    private String publisher;
    private int issueNumber;
    private int year;
    private int month;

    public Magazine(String title, String publisher, int issueNumber, int year, int month) {
        this.title = title;
        this.publisher = publisher;
        this.issueNumber = issueNumber;
        this.year = year;
        this.month = month;
    }

    @Override
    public void print() {
        System.out.println("=== ИНФОРМАЦИЯ О ЖУРНАЛЕ ===");
        System.out.println("Название: " + title);
        System.out.println("Издатель: " + publisher);
        System.out.println("Номер выпуска: " + issueNumber);
        System.out.println("Год: " + year);
        System.out.println("Месяц: " + getMonthName(month));
        System.out.println("============================");
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return String.format("Журнал '%s', выпуск №%d, %s %d года. Издатель: %s",
                title, issueNumber, getMonthName(month), year, publisher);
    }

    private String getMonthName(int month) {
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return (month >= 1 && month <= 12) ? months[month - 1] : "Неизвестный месяц";
    }

    // Геттеры
    public String getPublisher() {
        return publisher;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }
}
