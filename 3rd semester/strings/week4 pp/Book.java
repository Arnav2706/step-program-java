public class Book {
    String title;
    String author;
    double price;

    // Default constructor
    public Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display method
    public void display() {
        System.out.println("Book: " + title + " | Author: " + author + " | Price: " + price);
    }

    public static void main(String[] args) {
        // Using default constructor
        Book book1 = new Book();

        // Using parameterized constructor
        Book book2 = new Book("Java Programming", "James Gosling", 499.99);

        // Display both books
        book1.display();
        book2.display();
    }
}
