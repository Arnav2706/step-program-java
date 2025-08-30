public class LeapYearLogical {
    public static void main(String[] args) {
        System.out.println("Enter a year:");
        int year = Integer.parseInt(System.console().readLine());
        
        if (year >= 1582 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is not a Leap Year");
        }
    }
}