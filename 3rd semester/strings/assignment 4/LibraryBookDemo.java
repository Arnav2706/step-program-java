class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // 1. Default constructor
    public Book() {
        this("Unknown", "Unknown", "0000", true);
    }

    // 2. Constructor with title & author
    public Book(String title, String author) {
        this(title, author, "0000", true);
    }

    // 3. Full constructor
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " borrowed.");
        } else {
            System.out.println(title + " is not available!");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned.");
    }

    public void displayBookInfo() {
        System.out.println("Book: " + title + " by " + author + 
                           " | ISBN: " + isbn + 
                           " | Available: " + isAvailable);
    }
}

public class LibraryBookDemo {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Basics", "James");
        Book b3 = new Book("Python 101", "Guido", "12345", true);

        b2.borrowBook();
        b2.displayBookInfo();

        b2.returnBook();
        b2.displayBookInfo();

        b3.displayBookInfo();
    }
}
