package zad2pr6;

import java.time.LocalDate;

public class Time implements Printable {
    private String title;
    private LocalDate date;
    private int pageCount;
    private String headline;

    public Time(String title, LocalDate date, int pageCount, String headline) {
        this.title = title;
        this.date = date;
        this.pageCount = pageCount;
        this.headline = headline;
    }

    @Override
    public void print() {
        System.out.println("=== ИНФОРМАЦИЯ О ГАЗЕТЕ ===");
        System.out.println("Название: " + title);
        System.out.println("Дата выпуска: " + date);
        System.out.println("Количество страниц: " + pageCount);
        System.out.println("Главный заголовок: " + headline);
        System.out.println("===========================");
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return String.format("Газета '%s' от %s. %d страниц. Главная новость: %s",
                title, date, pageCount, headline);
    }

    // Геттеры
    public LocalDate getDate() {
        return date;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getHeadline() {
        return headline;
    }
}