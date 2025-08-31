public class LibrarySystem {
    // Book class
    static class Book {
        private String bookId;
        private String title;
        private String author;
        private boolean isAvailable;
        
        private static int totalBooks = 0;
        private static int availableBooks = 0;
        private static int bookCounter = 1;
        
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
            this.bookId = generateBookId();
            totalBooks++;
            availableBooks++;
        }
        
        public static String generateBookId() {
            return String.format("B%03d", bookCounter++);
        }
        
        public void issueBook() {
            if (isAvailable) {
                isAvailable = false;
                availableBooks--;
                System.out.println("Book issued: " + title);
            } else {
                System.out.println("Book not available: " + title);
            }
        }
        
        public void returnBook() {
            if (!isAvailable) {
                isAvailable = true;
                availableBooks++;
                System.out.println("Book returned: " + title);
            } else {
                System.out.println("Book was not issued: " + title);
            }
        }
        
        public void displayBookInfo() {
            System.out.println("ID: " + bookId + " | Title: " + title + 
                             " | Author: " + author + " | Available: " + isAvailable);
        }
        
        public static int getTotalBooks() { return totalBooks; }
        public static int getAvailableBooks() { return availableBooks; }
        public String getBookId() { return bookId; }
        public boolean isAvailable() { return isAvailable; }
    }
    
    // Member class
    static class Member {
        private String memberId;
        private String memberName;
        private String[] booksIssued;
        private int bookCount;
        private static int memberCounter = 1;
        
        public Member(String memberName, int maxBooks) {
            this.memberName = memberName;
            this.booksIssued = new String[maxBooks];
            this.bookCount = 0;
            this.memberId = generateMemberId();
        }
        
        public static String generateMemberId() {
            return String.format("M%03d", memberCounter++);
        }
        
        public void borrowBook(Book book) {
            if (bookCount >= booksIssued.length) {
                System.out.println("Member " + memberName + " has reached book limit!");
                return;
            }
            
            if (book.isAvailable()) {
                book.issueBook();
                booksIssued[bookCount++] = book.getBookId();
                System.out.println(memberName + " borrowed: " + book.getBookId());
            } else {
                System.out.println("Book " + book.getBookId() + " is not available");
            }
        }
        
        public void returnBook(String bookId, Book[] books) {
            for (int i = 0; i < bookCount; i++) {
                if (booksIssued[i].equals(bookId)) {
                    // Find the book object
                    for (Book book : books) {
                        if (book.getBookId().equals(bookId)) {
                            book.returnBook();
                            // Remove from issued books array
                            for (int j = i; j < bookCount - 1; j++) {
                                booksIssued[j] = booksIssued[j + 1];
                            }
                            booksIssued[--bookCount] = null;
                            System.out.println(memberName + " returned: " + bookId);
                            return;
                        }
                    }
                }
            }
            System.out.println("Book " + bookId + " not found in member's issued books");
        }
        
        public void displayMemberInfo() {
            System.out.println("Member ID: " + memberId + " | Name: " + memberName);
            System.out.print("Books Issued: ");
            if (bookCount == 0) {
                System.out.println("None");
            } else {
                for (int i = 0; i < bookCount; i++) {
                    System.out.print(booksIssued[i] + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        // Create books
        Book[] books = {
            new Book("Java Programming", "James Gosling"),
            new Book("Python Basics", "Guido van Rossum"),
            new Book("C++ Fundamentals", "Bjarne Stroustrup"),
            new Book("Data Structures", "Donald Knuth")
        };
        
        // Create members
        Member[] members = {
            new Member("Alice Johnson", 2),
            new Member("Bob Smith", 3)
        };
        
        System.out.println("=== INITIAL LIBRARY STATUS ===");
        System.out.println("Total Books: " + Book.getTotalBooks());
        System.out.println("Available Books: " + Book.getAvailableBooks());
        
        // Demonstrate borrowing books
        System.out.println("\n=== BORROWING BOOKS ===");
        members[0].borrowBook(books[0]);
        members[0].borrowBook(books[1]);
        members[1].borrowBook(books[2]);
        members[0].borrowBook(books[3]); // Should fail - limit reached
        
        System.out.println("\n=== CURRENT STATUS ===");
        System.out.println("Available Books: " + Book.getAvailableBooks());
        members[0].displayMemberInfo();
        members[1].displayMemberInfo();
        
        // Demonstrate returning books
        System.out.println("\n=== RETURNING BOOKS ===");
        members[0].returnBook("B001", books);
        members[1].returnBook("B003", books);
        
        System.out.println("\n=== FINAL STATUS ===");
        System.out.println("Available Books: " + Book.getAvailableBooks());
        for (Book book : books) {
            book.displayBookInfo();
        }
        for (Member member : members) {
            member.displayMemberInfo();
        }
    }
}