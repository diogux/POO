package aula10.ex01_02;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title == null || author == null || year < 0 || year > 2023)
            throw new IllegalArgumentException("Invalid arguments");
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        if (year < 0 || year > 2023)
            throw new IllegalArgumentException("Invalid year");
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Year: %d", title, author, year);
    }

}
