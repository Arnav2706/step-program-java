class MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    // 1. Default constructor
    public MovieTicket() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // 2. Constructor with movie name
    public MovieTicket(String movieName) {
        this(movieName, "Unknown", 0, 200.0);
    }

    // 3. Constructor with movie name and seat number
    public MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 250.0);
    }

    // 4. Full constructor
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void printTicket() {
        System.out.println("Movie: " + movieName + 
                           ", Theatre: " + theatreName + 
                           ", Seat: " + seatNumber + 
                           ", Price: " + price);
    }
}

public class MovieTicketDemo {
    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Inception");
        MovieTicket t3 = new MovieTicket("Avengers", 12);
        MovieTicket t4 = new MovieTicket("Interstellar", "IMAX", 45, 500);

        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
