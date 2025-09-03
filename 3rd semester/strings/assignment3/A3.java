class Room {
    String roomNumber;
    String roomType;
    double pricePerNight;
    boolean isAvailable;
    int maxOccupancy;

    Room(String no, String type, double price, int occ) {
        roomNumber = no;
        roomType = type;
        pricePerNight = price;
        isAvailable = true;
        maxOccupancy = occ;
    }
}

class Guest {
    String guestId;
    String guestName;
    String phoneNumber;
    String email;
    String[] bookingHistory = new String[10];
    int idx = 0;

    Guest(String id, String name, String ph, String em) {
        guestId = id;
        guestName = name;
        phoneNumber = ph;
        email = em;
    }

    void addHistory(String b) {
        if (idx < bookingHistory.length) bookingHistory[idx++] = b;
    }
}

class Booking {
    String bookingId;
    Guest guest;
    Room room;
    String checkInDate;
    String checkOutDate;
    double totalAmount;

    static int totalBookings = 0;
    static double hotelRevenue = 0;
    static String hotelName = "City Hotel";

    Booking(String id, Guest g, Room r, String in, String out, double amt) {
        bookingId = id;
        guest = g;
        room = r;
        checkInDate = in;
        checkOutDate = out;
        totalAmount = amt;
        totalBookings++;
        hotelRevenue += amt;
    }
}

class Hotel {
    Room[] rooms;
    Booking[] bookings;
    int bi = 0;

    Hotel(int n) {
        rooms = new Room[n];
        bookings = new Booking[50];
    }

    void addRoom(Room r) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                rooms[i] = r;
                break;
            }
        }
    }

    Room checkAvailability(String type) {
        for (Room r : rooms) {
            if (r != null && r.isAvailable && r.roomType.equals(type)) return r;
        }
        return null;
    }

    Booking makeReservation(Guest g, String type, String in, String out, int nights) {
        Room r = checkAvailability(type);
        if (r == null) return null;
        double amt = r.pricePerNight * nights;
        Booking b = new Booking("B" + System.nanoTime() % 100000, g, r, in, out, amt);
        r.isAvailable = false;
        bookings[bi++] = b;
        g.addHistory(b.bookingId);
        return b;
    }

    void cancelReservation(String bookingId) {
        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i] != null && bookings[i].bookingId.equals(bookingId)) {
                bookings[i].room.isAvailable = true;
                Booking.hotelRevenue -= bookings[i].totalAmount;
                bookings[i] = null;
                break;
            }
        }
    }

    double calculateBill(Booking b) {
        return b.totalAmount;
    }

    static double getOccupancyRate(Hotel h) {
        int total = 0, occ = 0;
        for (Room r : h.rooms) {
            if (r != null) {
                total++;
                if (!r.isAvailable) occ++;
            }
        }
        return total == 0 ? 0 : (occ * 100.0 / total);
    }

    static double getTotalRevenue() {
        return Booking.hotelRevenue;
    }

    static String getMostPopularRoomType(Hotel h) {
        int a = 0, b = 0, c = 0;
        for (Booking bk : h.bookings) {
            if (bk != null) {
                if (bk.room.roomType.equals("Standard")) a++;
                else if (bk.room.roomType.equals("Deluxe")) b++;
                else c++;
            }
        }
        return a >= b && a >= c ? "Standard" : b >= c ? "Deluxe" : "Suite";
    }
}

public class A3 {
    public static void main(String[] args) {
        Hotel h = new Hotel(6);

        h.addRoom(new Room("101", "Standard", 2000, 2));
        h.addRoom(new Room("102", "Standard", 2000, 2));
        h.addRoom(new Room("201", "Deluxe", 3500, 3));
        h.addRoom(new Room("202", "Deluxe", 3500, 3));
        h.addRoom(new Room("301", "Suite", 6000, 4));
        h.addRoom(new Room("302", "Suite", 6000, 4));

        Guest g1 = new Guest("G1", "Aarav", "999", "a@x.com");
        Guest g2 = new Guest("G2", "Diya", "888", "d@x.com");

        Booking b1 = h.makeReservation(g1, "Deluxe", "2025-09-05", "2025-09-07", 2);
        Booking b2 = h.makeReservation(g2, "Standard", "2025-09-06", "2025-09-07", 1);

        System.out.println(Booking.hotelName + " Revenue: " + Hotel.getTotalRevenue());
        System.out.println("Bill for b1: " + h.calculateBill(b1));
        System.out.println("Occupancy: " + Hotel.getOccupancyRate(h) + "%");
        System.out.println("Popular Room: " + Hotel.getMostPopularRoomType(h));

        h.cancelReservation(b2.bookingId);
        System.out.println("Occupancy after cancel: " + Hotel.getOccupancyRate(h) + "%");
    }
}
