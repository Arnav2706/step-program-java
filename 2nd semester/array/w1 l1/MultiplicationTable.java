public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int num = Integer.parseInt(System.console().readLine());
        int[] table = new int[10];

        for (int i = 0; i < 10; i++) {
            table[i] = num * (i + 1);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(num + " * " + (i + 1) + " = " + table[i]);
        }
    }
}
