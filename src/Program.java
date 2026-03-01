
import sidebiz.Genre;
import sidebiz.Utility;
import static sidebiz.Constants.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private BookRegister bookRegister;;

    public Program() {
        bookRegister = new BookRegister();
    }


    public void run() {
        System.out.println(WELCOME);
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 9) {
            System.out.println(OPTIONS);
            System.out.println((ADD_BOOK));
            System.out.println((SHOW_ALL_BOOKS));
            System.out.println((SHOW_ALL_BOOKS_BY_GENRE));
            System.out.println((SHOW_ALL_BOOKS_BY_MAX_READING_TIME));
            System.out.println((REMOVE_BOOK));
            System.out.println((SHOW_ALL_BOOKS_BY_AUTHOR));
            System.out.println(SHOW_BOOKS_AFTER_DATE);
            System.out.println((PRINT_TO_FILE));
            System.out.println(QUIT);
            choice = input.nextInt();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> allBooks();
                case 3 -> booksByGenre();
                case 4 -> booksByMaximumReadingTime();
                case 5 -> removeBook();
                case 6 -> booksByAuthor();
                case 7 -> booksOlderThan();
                case 8 -> printToFile();
                case 9 -> quit();
                default -> System.out.println("Pick a number between (1-9)");
            }
        }
    }


    public void addBook() {
        System.out.println("Add a book:");
        Scanner input = new Scanner(System.in);
        boolean validIsbn = false;
        String isbn = null;
        while (!validIsbn) {
            System.out.println(ENTER_ISBN);
            isbn = input.nextLine();
            validIsbn = Utility.validISBN(isbn);
            if (validIsbn == false){
                System.out.println("The ISBN must have four characters.");
            }
        }
        System.out.println(ENTER_PUBLISHING_DATE);
        String publicationDate = input.nextLine();
        LocalDate published = LocalDate.parse(publicationDate);
        System.out.println("Enter a title: ");
        String title = input.nextLine();
        System.out.println(ENTER_AUTHOR);
        String author = input.nextLine();
        System.out.println("Enter number of pages:");
        int numberOfPages = input.nextInt();
        System.out.println(ENTER_GENRE);
        input.nextLine();  //Removing line break
        String genreAsTxt = input.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreAsTxt);
        System.out.println(ENTER_READING_TIME);
        int minutesPerPage = input.nextInt();
        Book book = new Book(isbn, published, title, author, numberOfPages, genre, minutesPerPage);
        input.nextLine(); //Removing line break
        ArrayList<Chapter> chapters = new ArrayList<>();
        boolean addMoreChapters = true;
        while (addMoreChapters) {
            System.out.println("Enter a chapter title:");
            String chapterTitle = input.nextLine();
            System.out.println("Enter number of pages in the chapter:");
            int chapterNumberOfPages = input.nextInt();
            input.nextLine(); //Removing line break
            Chapter chapter = new Chapter(chapterTitle, chapterNumberOfPages);
            chapters.add(chapter);
            System.out.println("Add more chapters? (y/n)");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                addMoreChapters = false;
            }
        }
        book.setChapters(chapters);
        bookRegister.addBook(book);
    }

    public void allBooks() {
        bookRegister.allBooksInRegister();
    }

    public void booksByGenre() {
        System.out.println(ENTER_GENRE);
        Scanner input = new Scanner(System.in);
        String s = input.nextLine().toUpperCase();
        Genre g = Genre.valueOf(s);
        bookRegister.booksInGenre(g);
    }

    public void booksByMaximumReadingTime() {
        System.out.println("Enter max reading time in minutes:");
        Scanner input = new Scanner(System.in);
        int minutes = input.nextInt();
        List<Book> books = bookRegister.booksByReadingTime(minutes);
        for (Book b : books) {
            System.out.println(b);
        }
    }


    public void removeBook() {
        System.out.println(ENTER_ISBN);
        Scanner input = new Scanner(System.in);
        String isbn = input.nextLine();
        bookRegister.removeBook(isbn);
    }


    public void booksByAuthor() {
        System.out.println(ENTER_AUTHOR);
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        bookRegister.specificAuthor(s);
    }

    private void booksOlderThan() {
        System.out.println(ENTER_PUBLISHING_DATE);
        Scanner input = new Scanner(System.in);
        String publicationDate = input.nextLine();
        LocalDate published = LocalDate.parse(publicationDate);
        bookRegister.booksOlderThan(published);
    }

    public void printToFile() {
        System.out.println("Printing books to file");
        try {
            bookRegister.writeBooksToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void quit(){
        System.out.println("Shutting down");
    }
}