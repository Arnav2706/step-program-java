public class MultiplicationTableRange {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int num = Integer.parseInt(System.console().readLine());
        int[] multiplicationResult = new int[4];

        for (int i = 0; i < 4; i++) {
            multiplicationResult[i] = num * (i + 6);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(num + " * " + (i + 6) + " = " + multiplicationResult[i]);
        }
    }
}
