public class Counter {
    static int count = 0;  // shared among all objects

    // Constructor
    Counter() {
        count++;   // increment whenever an object is created
    }

    // Static method
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        // Create objects
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        // Display how many objects were created
        System.out.println("Total objects created: " + Counter.getCount());
    }
}
