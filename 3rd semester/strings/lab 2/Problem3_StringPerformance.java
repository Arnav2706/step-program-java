import java.util.Scanner;

public class Problem3_StringPerformance {

    public static long testStringConcat(int iterations) {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) s = s + "a";
        long end = System.currentTimeMillis();
        System.out.println("String length: " + s.length());
        return end - start;
    }

    public static long testStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) sb.append("a");
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder length: " + sb.length());
        return end - start;
    }

    public static long testStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) sb.append("a");
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer length: " + sb.length());
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of iterations (e.g., 10000):");
        int n = sc.nextInt();

        long t1 = testStringConcat(n);
        long t2 = testStringBuilder(n);
        long t3 = testStringBuffer(n);

        System.out.println("\n--- Performance Analysis ---");
        System.out.printf("%-15s %-15s\n", "Method", "Time (ms)");
        System.out.printf("%-15s %-15d\n", "String", t1);
        System.out.printf("%-15s %-15d\n", "StringBuilder", t2);
        System.out.printf("%-15s %-15d\n", "StringBuffer", t3);

        sc.close();
    }
}
