package sidebiz;

import java.util.Arrays;

public class Constants {
public static final String WELCOME = "Welcome to the book register.";
public static final String OPTIONS = "Please pick a number between (1-9)";
public static final String ADD_BOOK = "1: Add book";
public static final String SHOW_ALL_BOOKS = "2: Show all books";
public static final String SHOW_ALL_BOOKS_BY_GENRE = "3: Show all books by genre";
public static final String SHOW_ALL_BOOKS_BY_MAX_READING_TIME = "4: Show all books by maximum reading time";
public static final String REMOVE_BOOK = "5: Remove book:";
public static final String SHOW_ALL_BOOKS_BY_AUTHOR = "6: Show all books by author";
public static final String SHOW_BOOKS_AFTER_DATE = "7: Show books published after a certain date";
public static final String PRINT_TO_FILE= "8: Print to file";
public static final String QUIT= "9: Quit";

    public static String ENTER_ISBN;
    public static String ENTER_PUBLISHING_DATE;
    public static String ENTER_AUTHOR;
    public static String ENTER_GENRE;
    public static String ENTER_READING_TIME;

    static{
        ENTER_ISBN= "Enter an isbn (xxxx):";
        ENTER_PUBLISHING_DATE= "Enter the publish date (YYYY-MM-DD)";
        ENTER_AUTHOR = "Enter the name of an author:";
        ENTER_GENRE= String.format("Enter a genre %s", Arrays.toString(Genre.values()));
        ENTER_READING_TIME= "Enter reading time per page in minutes: ";
    }
}
