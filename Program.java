
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private BookRegister bookRegister;
    private String userName;


    public void setBookRegister(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 9) {
            System.out.println("Hello " + userName + ", please pick a number between (1-8)");
            System.out.println(("1: Add book:"));
            System.out.println(("2: Show all books"));
            System.out.println(("3: Show all books by genre"));
            System.out.println(("4: Show all books by maximum reading time"));
            System.out.println(("5: Remove book"));
            System.out.println(("6: Show all books by author"));
            System.out.println("7: Show books published after a certain date:");
            System.out.println(("8: Print to file"));
            System.out.println("9: Quit");
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
        Book book = new Book();

        System.out.println("Add a book:");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an isbn for the book (xxxx): ");
        String isbn = input.nextLine();
        book.setIsbn(isbn);
        System.out.println("Enter the publish date (YYYY-MM-DD): ");
        String publicationDate = input.nextLine();
        LocalDate published = LocalDate.parse(publicationDate);
        book.setPublished(published);
        System.out.println("Enter a title: ");
        String title = input.nextLine();
        book.setTitle(title);
        System.out.println("Enter the name of the author: ");
        String author = input.nextLine();
        book.setAuthor(author);
        System.out.println("Enter number of pages:");
        int numberOfPages = input.nextInt();
        book.setNumberOfPages(numberOfPages);
        System.out.println("Enter genre (CRIME, ACTION, FANTASY, CLASSIC, SCI_FI, OTHER): ");
        input.nextLine();  //Removing line break
        String genreAsTxt = input.nextLine().toUpperCase();
        Genre genre = Genre.valueOf(genreAsTxt);
        book.setGenre(genre);
        System.out.println("Enter reading time per page in minutes:");
        int minutesPerPage = input.nextInt();
        book.setMinutesPerPage(minutesPerPage);
        input.nextLine(); //Removing line break
        ArrayList<Chapter> chapters = new ArrayList<>();
        boolean addMoreChapters = true;
        while (addMoreChapters) {
            Chapter chapter = new Chapter();
            System.out.println("Enter a chapter title:");
            String chapterTitle = input.nextLine();
            chapter.setTittle(chapterTitle);
            System.out.println("Enter number of pages in the chapter:");
            int chapterNumberOfPages = input.nextInt();
            chapter.setTotalPages(chapterNumberOfPages);
            input.nextLine();
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
        System.out.println("Choose one of the following genres:  CRIME, ACTION, FANTASY, CLASSIC, SCI_FI, OTHER");
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
        System.out.println("Enter isb:");
        Scanner input = new Scanner(System.in);
        String isbn = input.nextLine();
        bookRegister.removeBook(isbn);
    }


    public void booksByAuthor() {
        System.out.println("Write an author:");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        bookRegister.specificAuthor(s);
    }

    private void booksOlderThan() {
        System.out.println("Write a date (YYYY-MM-DD):");
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