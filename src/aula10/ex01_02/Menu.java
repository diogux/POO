package aula10.ex01_02;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.ArrayList;
import utils.*;

public class Menu {
    public static void main(String[] args) {
        TreeMap<String, HashSet<Book>> books = new TreeMap<>();
        int choice = -1;

        Book book1 = new Book("Harry Potter", "J. K. Rowling", 1997);
        Book book2 = new Book("Harry Potter 2", "J. K. Rowling", 1998);
        Book book3 = new Book("Harry Potter 3", "J. K. Rowling", 1999);

        books.put("Fantasia", new HashSet<>());
        books.get("Fantasia").add(book1);
        books.get("Fantasia").add(book2);
        books.put("Aventura", new HashSet<>());
        books.get("Aventura").add(book3);

        HashSet<Book> bookSetx = new HashSet<>();
        bookSetx.add(book1);
        bookSetx.add(book2);
        bookSetx.add(book3);

        while (choice != 0) {
            System.out.println("------MENU------");
            System.out.println("Choose an option.");
            System.out.println("1 - Add book");
            System.out.println("2 - Remove book");
            System.out.println("3 - Modify book");
            System.out.println("4 - List all books");
            System.out.println("5 - List all books by genre");
            System.out.println("6 - List all genres");
            System.out.println("0 - Exit");

            choice = UserInput.intInRange("Option: ", 0, 6);

            switch (choice) {
                case 1:
                    String title = UserInput.newString("Title: ");
                    String author = UserInput.newString("Author: ");
                    String genre = UserInput.newString("Genre: ");
                    int year = UserInput.intInRange("Year: ", 0, 2023);

                    if (!books.containsKey(genre))
                        books.put(genre, new HashSet<>());

                    books.get(genre).add(new Book(title, author, year));
                    break;
                case 2:
                    title = UserInput.newString("Title: ");
                    Book bookR = SearchBook(title, books);
                    if (bookR == null)
                        break;

                    for (String genreName : books.keySet()) {
                        if (books.get(genreName).contains(bookR)) {
                            books.get(genreName).remove(bookR);
                            break;
                        }
                    }

                case 3:
                    title = UserInput.newString("Title: ");
                    Book bookS = SearchBook(title, books);
                    if (bookS == null)
                        break;
                    System.out.println("Choose an option.");
                    System.out.println("1 - Change title");
                    System.out.println("2 - Change author");
                    System.out.println("3 - Change year");
                    System.out.println("4 - Change all");
                    System.out.println("0 - Exit");
                    int option = UserInput.intInRange("Option: ", 0, 3);
                    switch (option) {
                        case 1:
                            String newTitle = UserInput.newString("New title: ");
                            bookS.setTitle(newTitle);
                            break;
                        case 2:
                            String newAuthor = UserInput.newString("New author: ");
                            bookS.setAuthor(newAuthor);
                            break;
                        case 3:
                            int newYear = UserInput.intInRange("New year: ", 0, 2023);
                            bookS.setYear(newYear);
                            break;
                        case 4:
                            newTitle = UserInput.newString("New title: ");
                            newAuthor = UserInput.newString("New author: ");
                            newYear = UserInput.intInRange("New year: ", 0, 2023);
                            bookS.setTitle(newTitle);
                            bookS.setAuthor(newAuthor);
                            bookS.setYear(newYear);
                            break;
                    }
                    break;
                case 4:
                    for (HashSet<Book> bookSet : books.values()) {
                        for (Book book : bookSet) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 5:
                    for (String genreName : books.keySet()) {
                        System.out.println(genreName);
                        for (Book book : books.get(genreName)) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Genres:");
                    for (String genreName : books.keySet()) {
                        System.out.println(genreName);
                    }
                    break;

            }
        }
    }

    public static Book SearchBook(String title, TreeMap<String, HashSet<Book>> books) {
        ArrayList<Book> booksWithTitle = new ArrayList<>();

        for (HashSet<Book> bookSet : books.values()) {
            for (Book book : bookSet) {
                if (book.getTitle().toLowerCase().contains(title)) {
                    booksWithTitle.add(book);
                }
            }
        }

        if (booksWithTitle.size() == 0) {
            System.out.println("No books found with title " + title);
            return null;
        } else if (booksWithTitle.size() == 1) {
            return booksWithTitle.get(0);
        } else {
            System.out.println("Multiple books found with title " + title + ". Choose one by index:");
            for (int i = 0; i < booksWithTitle.size(); i++) {
                System.out.println(i + ": " + booksWithTitle.get(i));
            }
            int bookIndex = UserInput.intInRange("Index: ", 0, booksWithTitle.size() - 1);
            return booksWithTitle.get(bookIndex);
        }
    }

}
