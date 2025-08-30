public class CountdownFor {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int counter = Integer.parseInt(System.console().readLine());

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
