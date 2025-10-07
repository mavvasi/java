package zad1pr6;

public class Book implements Nameable {
    private String name;
    private String author;
    private int year;
    private String genre;

    public Book(String name, String author, int year, String genre) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return String.format("Книга '%s' (автор: %s, %d год, жанр: %s)",
                name, author, year, genre);
    }
}
