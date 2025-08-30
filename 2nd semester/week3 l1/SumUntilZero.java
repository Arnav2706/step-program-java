public class SumUntilZero {
    public static void main(String[] args) {
        double total = 0.0;
        System.out.println("Enter numbers (Enter 0 to stop):");

        while (true) {
            double num = Double.parseDouble(System.console().readLine());
            if (num == 0) {
                break;
            }
            total += num;
        }

        System.out.println("Total sum: " + total);
    }
}
