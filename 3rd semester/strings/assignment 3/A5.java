class Book {
    String bookId;
    String title;
    String author;
    String isbn;
    String category;
    boolean isIssued;
    String issueDate;
    String dueDate;

    Book(String id, String t, String a, String isbnVal, String cat) {
        bookId = id;
        title = t;
        author = a;
        isbn = isbnVal;
        category = cat;
        isIssued = false;
        issueDate = "";
        dueDate = "";
    }
}

class Member {
    String memberId;
    String memberName;
    String memberType;
    Book[] booksIssued;
    double totalFines;
    String membershipDate;

    Member(String id, String name, String type, String memDate, int maxBooks) {
        memberId = id;
        memberName = name;
        memberType = type;
        membershipDate = memDate;
        booksIssued = new Book[maxBooks];
        totalFines = 0;
    }

    int getIssuedCount() {
        int c = 0;
        for (Book b : booksIssued) if (b != null) c++;
        return c;
    }
}

class Library {
    Book[] catalog;
    Member[] members;
    static int totalBooks = 0;
    static int totalMembers = 0;
    static String libraryName = "City Library";
    static double finePerDay = 5.0;
    static int maxBooksAllowed = 3;

    Library(int bookCap, int memCap) {
        catalog = new Book[bookCap];
        members = new Member[memCap];
    }

    void addBook(Book b) {
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i] == null) {
                catalog[i] = b;
                totalBooks++;
                break;
            }
        }
    }

    void addMember(Member m) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                members[i] = m;
                totalMembers++;
                break;
            }
        }
    }

    Book findBookById(String id) {
        for (Book b : catalog) if (b != null && b.bookId.equals(id)) return b;
        return null;
    }

    Member findMemberById(String id) {
        for (Member m : members) if (m != null && m.memberId.equals(id)) return m;
        return null;
    }

    boolean issueBook(String memberId, String bookId, String issueDate, String dueDate) {
        Member m = findMemberById(memberId);
        Book b = findBookById(bookId);
        if (m == null || b == null || b.isIssued || m.getIssuedCount() >= maxBooksAllowed) return false;
        for (int i = 0; i < m.booksIssued.length; i++) {
            if (m.booksIssued[i] == null) {
                m.booksIssued[i] = b;
                b.isIssued = true;
                b.issueDate = issueDate;
                b.dueDate = dueDate;
                return true;
            }
        }
        return false;
    }

    boolean returnBook(String memberId, String bookId, int overdueDays) {
        Member m = findMemberById(memberId);
        if (m == null) return false;
        for (int i = 0; i < m.booksIssued.length; i++) {
            Book b = m.booksIssued[i];
            if (b != null && b.bookId.equals(bookId)) {
                b.isIssued = false;
                b.issueDate = "";
                b.dueDate = "";
                m.booksIssued[i] = null;
                double fine = calculateFine(overdueDays);
                m.totalFines += fine;
                return true;
            }
        }
        return false;
    }

    double calculateFine(int overdueDays) {
        if (overdueDays <= 0) return 0;
        return overdueDays * finePerDay;
    }

    Book[] searchBooks(String titleOrAuthor) {
        Book[] res = new Book[catalog.length];
        int k = 0;
        for (Book b : catalog) {
            if (b != null && (b.title.contains(titleOrAuthor) || b.author.contains(titleOrAuthor))) res[k++] = b;
        }
        return res;
    }

    String[] getOverdueBooks() {
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        for (Book b : catalog) if (b != null && b.isIssued && b.dueDate.compareTo("2025-09-01") < 0) list.add(b.bookId);
        return list.toArray(new String[0]);
    }

    String getMostPopularBooks() {
        return "Feature requires tracking borrow counts";
    }

    static void generateLibraryReport(Library lib) {
        System.out.println(libraryName + " Books:" + totalBooks + " Members:" + totalMembers);
    }
}

public class A5 {
    public static void main(String[] args) {
        Library lib = new Library(20, 10);
        lib.addBook(new Book("B1", "Data Structures", "Srinivasan", "ISBN001", "CS"));
        lib.addBook(new Book("B2", "Java Basics", "Herbert", "ISBN002", "CS"));
        lib.addMember(new Member("M1", "Riya", "Student", "2024-01-01", Library.maxBooksAllowed));
        lib.addMember(new Member("M2", "Karan", "Faculty", "2023-06-10", 5));
        lib.issueBook("M1", "B1", "2025-08-01", "2025-08-15");
        lib.returnBook("M1", "B1", 3);
        Book[] r = lib.searchBooks("Java");
        for (Book b : r) if (b != null) System.out.println(b.title + " by " + b.author);
        Library.generateLibraryReport(lib);
    }
}
