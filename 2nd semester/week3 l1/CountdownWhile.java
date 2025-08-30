public class CountdownWhile {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int counter = Integer.parseInt(System.console().readLine());

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
    }
}
