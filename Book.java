import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private String isbn;
    private LocalDate published;
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;
    private ArrayList<Chapter> chapters = new ArrayList<>();
    private int minutesPerPage;



//    public Book (String isbn, LocalDate published, String title, String author, int numberOfPages, Genre genre, ArrayList<Chapter> chapters, int minutesPerPage) {
//        this.isbn = isbn;
//        this.published = published;
//        this.title = title;
//        this.author = author;
//        this.numberOfPages = numberOfPages;
//        this.genre = genre;
//        this.chapters = chapters;
//        this.minutesPerPage = minutesPerPage;
//    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }

    public void setMinutesPerPage(int minutesPerPage) {
        this.minutesPerPage = minutesPerPage;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    public int getTimePerPage() {
        return numberOfPages * minutesPerPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", published=" + published +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", genre=" + genre +
                ", chapters=" + chapters +
                ", minutesPerPage=" + minutesPerPage +
                '}';
    }

    public String toFile() {
        StringBuilder s = new StringBuilder(isbn + '\n' +
                published + '\n' +
                title + '\n' +
                author + '\n' +
                numberOfPages + '\n' +
                genre + '\n' +
                minutesPerPage + '\n' +
                "---" + '\n');
        return s.toString();
    }

}

