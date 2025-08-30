public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = Integer.parseInt(System.console().readLine());
        
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }
}