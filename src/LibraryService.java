import java.util.*;

public class LibraryService {

    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public void addBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        library.add(new Book(id, title, author));
        System.out.println("Book added successfully!\n");
    }

    public void displayBooks() {
        ArrayList<Book> books = library.getBooks();

        if (books.isEmpty()) {
            System.out.println("No books available.\n");
            return;
        }

        for (Book b : books) {
            System.out.println("\nID: " + b.id);
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);
            System.out.println("Status: " + (b.isIssued ? "Issued" : "Available"));
            System.out.println("-----------------------");
        }
    }

    public void issueBook(Scanner sc) {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : library.getBooks()) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!\n");
                } else {
                    System.out.println("Book already issued.\n");
                }
                return;
            }
        }
        System.out.println("Book not found.\n");
    }

    public void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book b : library.getBooks()) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!\n");
                } else {
                    System.out.println("This book was not issued.\n");
                }
                return;
            }
        }
        System.out.println("Book not found.\n");
    }

    public void searchBook(Scanner sc) {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();

        for (Book b : library.getBooks()) {
            if (b.id == id) {
                System.out.println("\nBook Found:");
                System.out.println("Title: " + b.title);
                System.out.println("Author: " + b.author);
                System.out.println("Status: " + (b.isIssued ? "Issued" : "Available"));
                return;
            }
        }
        System.out.println("Book not found.\n");
    }
}