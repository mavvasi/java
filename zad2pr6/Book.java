package zad2pr6;

public class Book implements Printable {
    private String title;
    private String author;
    private int year;
    private String genre;
    private int pageCount;
    private String isbn;

    // Конструкторы
    public Book(String title, String author, int year, String genre, int pageCount, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.pageCount = pageCount;
        this.isbn = isbn;
    }

    public Book(String title, String author, int year) {
        this(title, author, year, "Не указан", 0, "Не указан");
    }

    // Реализация методов интерфейса Printable
    @Override
    public void print() {
        System.out.println("=== ИНФОРМАЦИЯ О КНИГЕ ===");
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год издания: " + year);
        System.out.println("Жанр: " + genre);
        System.out.println("Количество страниц: " + pageCount);
        System.out.println("ISBN: " + isbn);
        System.out.println("==========================");
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return String.format("Книга '%s' автора %s, %d год. Жанр: %s, %d страниц. ISBN: %s",
                title, author, year, genre, pageCount, isbn);
    }

    // Геттеры
    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    // Сеттеры
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Переопределение методов Object
    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', year=%d, genre='%s', pages=%d, ISBN='%s'}",
                title, author, year, genre, pageCount, isbn);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return year == book.year &&
                pageCount == book.pageCount &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                genre.equals(book.genre) &&
                isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + year;
        result = 31 * result + genre.hashCode();
        result = 31 * result + pageCount;
        result = 31 * result + isbn.hashCode();
        return result;
    }
}
