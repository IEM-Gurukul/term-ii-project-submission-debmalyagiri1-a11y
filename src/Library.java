import java.util.*;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void add(Book book) {
        books.add(book);
    }
}