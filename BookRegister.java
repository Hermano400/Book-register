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
                System.out.println(b.toString());
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
    //    public List<Book> returnBooksReadLessThan(int maxMinutes) {
//        return books.stream().filter(b -> b.getChapters().stream().mapToInt(Chapter::getReadingTime).sum() < maxMinutes).peek(b -> System.out.println(b.getTitle())).toList();
//}

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
                System.out.println(b.toString());
            }
        }
    }
    public List<Book> books() {
        books = listBookFromFile();
        return books;
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

    public  ArrayList<Book> listBookFromFile() {
        File file = new File("Books.txt");
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);}

        while (scanner.hasNextLine()) {
            Book book = new Book();
            String isbn = scanner.nextLine();
            book.setIsbn(isbn);
            String publishedAsString = scanner.nextLine();
            book.setPublished(LocalDate.parse(publishedAsString));
            String title = scanner.nextLine();
            book.setTitle(title);
            String author = scanner.nextLine();
            book.setAuthor(author);
            String numberOfPages = scanner.nextLine();
            book.setNumberOfPages(Integer.parseInt(numberOfPages));
            String genre = scanner.nextLine();
            book.setGenre(Genre.valueOf(genre));
            String minutesPerPage = scanner.nextLine();
            book.setMinutesPerPage(Integer.parseInt(minutesPerPage));
            scanner.nextLine();
            books.add(book);
        }
        scanner.close();

        return books;
    }
}