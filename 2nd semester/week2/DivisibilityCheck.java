class DivisibilityCheck {
    public static void main(String[] args) {
        System.out.println("number:");
        int num = Integer.parseInt(System.console().readLine());

        if (num % 5 == 0) {
            System.out.println("The number is divisible by 5.");
        } else {
            System.out.println("The number is not divisible by 5.");
        }
    }
}