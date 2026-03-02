import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method 1: Using reverse string
    public static boolean methodReverse(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }

    // Method 2: Two-pointer approach (better performance)
    public static boolean methodTwoPointer(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // USER INPUT
        System.out.print("Input : ");
        String input = sc.nextLine();

        // -------- Method 1 Timing --------
        long start1 = System.nanoTime();
        boolean result1 = methodReverse(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // -------- Method 2 Timing --------
        long start2 = System.nanoTime();
        boolean result2 = methodTwoPointer(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // OUTPUT
        System.out.println("Is Palindrome? : " + result1);
        System.out.println("Execution Time (Reverse Method): " + time1 + " ns");
        System.out.println("Execution Time (Two Pointer Method): " + time2 + " ns");

        // Performance Comparison
        if (time1 < time2) {
            System.out.println("Reverse Method is faster.");
        } else if (time2 < time1) {
            System.out.println("Two Pointer Method is faster.");
        } else {
            System.out.println("Both methods have similar performance.");
        }

        sc.close();
    }
}