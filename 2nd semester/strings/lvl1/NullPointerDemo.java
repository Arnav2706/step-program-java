public class NullPointerDemo {

    public static void generateException() {
        String text = null;
        System.out.println("Text length: " + text.length()); // This throws NullPointerException
    }

    public static void handleException() {
        try {
            String text = null;
            System.out.println("Text length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e);
        }
    }

    public static void main(String[] args) {
        // a. Method that generates exception
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception caught in main: " + e);
        }

        // b. Properly handled method
        handleException();
    }
}

