import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRegister {
    private ArrayList<Book> books = new ArrayList<>();

    public BookRegister(){
        books = listBookFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void allBooksInRegister() {
        for (Book b : books) {
            System.out.println(b.toString());
        }
    }

    public void booksInGenre(Genre genre) {
        for (Book b : books) {
            if (b.getGenre() == genre) {
                System.out.println(b);
            }
        }
    }

    public void specificAuthor(String author) {
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                System.out.println("Book: " + b.getTitle() + " Author: " + b.getAuthor());
            }
        }
    }

    public List<Book> booksByReadingTime(int minutes) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getMinutesPerPage() <= minutes) {
                result.add(b);
            }
        }
        return result;
    }

    public void removeBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                books.remove(b);
                return;
            }
        }
    }

    public void booksOlderThan(LocalDate localDate) {
        for (Book b : books) {
            if (b.getPublished().isBefore(localDate)) {
                System.out.println(b);
            }
        }
    }

    public void writeBooksToFile() throws IOException {
        File file = new File("Books.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        for (Book b : books) {
            writer.write(b.toFile());
        }
        writer.close();
    }

    public ArrayList<Book> listBookFromFile() {
        File file = new File("Books.txt");
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()) {
            String isbn = scanner.nextLine();
            String published = scanner.nextLine();
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            String numberOfPages = scanner.nextLine();
            String genre = scanner.nextLine();
            String minutesPerPage = scanner.nextLine();
            scanner.nextLine();
            Book book = new Book(isbn, LocalDate.parse(published), title,author, Integer.parseInt(numberOfPages), Genre.valueOf(genre),  Integer.parseInt(minutesPerPage));
            books.add(book);
        }
        scanner.close();
        return books;
    }
}