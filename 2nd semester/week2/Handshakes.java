class Handshakes {
    public static void main(String[] args) {
        System.out.println("Enter number of students:");
        int numberOfStudents = Integer.parseInt(System.console().readLine());
        // Calculate number of possible handshakes using formula: n * (n - 1) / 2
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        // Display result
        System.out.println("The number of possible handshakes is " + handshakes);
    }
}
