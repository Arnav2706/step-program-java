public class LeapYearCheck {
    public static void main(String[] args) {
        System.out.println("Enter a year:");
        int year = Integer.parseInt(System.console().readLine());
        
        if (year >= 1582) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        System.out.println(year + " is a Leap Year");
                    } else {
                        System.out.println(year + " is not a Leap Year");
                    }
                } else {
                    System.out.println(year + " is a Leap Year");
                }
            } else {
                System.out.println(year + " is not a Leap Year");
            }
        } else {
            System.out.println("Year should be 1582 or later.");
        }
    }
}